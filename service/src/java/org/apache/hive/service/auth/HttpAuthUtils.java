/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hive.service.auth;

import java.security.PrivilegedExceptionAction;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.security.auth.Subject;

import org.apache.hadoop.hive.metastore.security.HadoopThriftAuthBridge;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility functions for HTTP mode authentication.
 */
public final class HttpAuthUtils {
  public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
  public static final String AUTHORIZATION = "Authorization";
  public static final String BASIC = "Basic";
  public static final String BEARER = "Bearer";
  public static final String NEGOTIATE = "Negotiate";
  private static final Logger LOG = LoggerFactory.getLogger(HttpAuthUtils.class);
  private static final String COOKIE_ATTR_SEPARATOR = "&";
  private static final String COOKIE_CLIENT_USER_NAME = "cu";
  private static final String COOKIE_CLIENT_RAND_NUMBER = "rn";
  private static final String COOKIE_KEY_VALUE_SEPARATOR = "=";
  private final static Set<String> COOKIE_ATTRIBUTES =
    new HashSet<String>(Arrays.asList(COOKIE_CLIENT_USER_NAME, COOKIE_CLIENT_RAND_NUMBER));

  /**
   * @return Stringified Base64 encoded kerberosAuthHeader on success
   * @throws Exception
   */
  public static String getKerberosServiceTicket(String principal, String host, String serverHttpUrl,
      Subject loggedInSubject) throws Exception {
    String serverPrincipal = HadoopThriftAuthBridge.getBridge().getServerPrincipal(principal, host);
    if (loggedInSubject != null) {
      return Subject.doAs(loggedInSubject, new HttpKerberosClientAction(serverPrincipal, serverHttpUrl));
    } else {
      // JAAS login from ticket cache to setup the client UserGroupInformation
      UserGroupInformation clientUGI = HadoopThriftAuthBridge.getBridge().getCurrentUGIWithConf("kerberos");
      return clientUGI.doAs(new HttpKerberosClientAction(serverPrincipal, serverHttpUrl));
    }
  }

  /**
   * Creates and returns a HS2 cookie token.
   * @param clientUserName Client User name.
   * @return An unsigned cookie token generated from input parameters.
   * The final cookie generated is of the following format :
   * cu=&lt;username&gt;&amp;rn=&lt;randomNumber&gt;&amp;s=&lt;cookieSignature&gt;
   */
  public static String createCookieToken(String clientUserName) {
    StringBuilder sb = new StringBuilder();
    sb.append(COOKIE_CLIENT_USER_NAME).append(COOKIE_KEY_VALUE_SEPARATOR).append(clientUserName).
    append(COOKIE_ATTR_SEPARATOR);
    sb.append(COOKIE_CLIENT_RAND_NUMBER).append(COOKIE_KEY_VALUE_SEPARATOR).
    append((new SecureRandom()).nextLong());
    return sb.toString();
  }

  /**
   * Parses a cookie token to retrieve client user name.
   * @param tokenStr Token String.
   * @return A valid user name if input is of valid format, else returns null.
   */
  public static String getUserNameFromCookieToken(String tokenStr) {
    Map<String, String> map = splitCookieToken(tokenStr);

    if (!map.keySet().equals(COOKIE_ATTRIBUTES)) {
      LOG.error("Invalid token with missing attributes " + tokenStr);
      return null;
    }
    return map.get(COOKIE_CLIENT_USER_NAME);
  }

  /**
   * Splits the cookie token into attributes pairs.
   * @param str input token.
   * @return a map with the attribute pairs of the token if the input is valid.
   * Else, returns null.
   */
  private static Map<String, String> splitCookieToken(String tokenStr) {
    Map<String, String> map = new HashMap<String, String>();
    StringTokenizer st = new StringTokenizer(tokenStr, COOKIE_ATTR_SEPARATOR);

    while (st.hasMoreTokens()) {
      String part = st.nextToken();
      int separator = part.indexOf(COOKIE_KEY_VALUE_SEPARATOR);
      if (separator == -1) {
        LOG.error("Invalid token string " + tokenStr);
        return null;
      }
      String key = part.substring(0, separator);
      String value = part.substring(separator + 1);
      map.put(key, value);
    }
    return map;
  }


  private HttpAuthUtils() {
    throw new UnsupportedOperationException("Can't initialize class");
  }

  /**
   * We'll create an instance of this class within a doAs block so that the client's TGT credentials
   * can be read from the Subject
   */
  public static class HttpKerberosClientAction implements PrivilegedExceptionAction<String> {
    public static final String HTTP_RESPONSE = "HTTP_RESPONSE";
    public static final String SERVER_HTTP_URL = "SERVER_HTTP_URL";
    private final String serverPrincipal;
    private final String serverHttpUrl;
    private final HttpContext httpContext;

    public HttpKerberosClientAction(String serverPrincipal, String serverHttpUrl) {
      this.serverPrincipal = serverPrincipal;
      this.serverHttpUrl = serverHttpUrl;
      httpContext = new BasicHttpContext();
      httpContext.setAttribute(SERVER_HTTP_URL, serverHttpUrl);
    }

    @Override
    public String run() throws Exception {
      // This Oid for Kerberos GSS-API mechanism.
      Oid mechOid = new Oid("1.2.840.113554.1.2.2");
      // Oid for kerberos principal name
      Oid krb5PrincipalOid = new Oid("1.2.840.113554.1.2.2.1");
      GSSManager manager = GSSManager.getInstance();
      // GSS name for server
      GSSName serverName = manager.createName(serverPrincipal, krb5PrincipalOid);
      // Create a GSSContext for authentication with the service.
      // We're passing client credentials as null since we want them to be read from the Subject.
      GSSContext gssContext =
          manager.createContext(serverName, mechOid, null, GSSContext.DEFAULT_LIFETIME);
      gssContext.requestMutualAuth(false);
      // Establish context
      byte[] inToken = new byte[0];
      byte[] outToken = gssContext.initSecContext(inToken, 0, inToken.length);
      gssContext.dispose();
      // Base64 encoded and stringified token for server
      return Base64.getEncoder().encodeToString(outToken);
    }
  }
}

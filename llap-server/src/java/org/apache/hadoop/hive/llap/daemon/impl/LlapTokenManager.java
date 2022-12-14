/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hive.llap.daemon.impl;

import java.io.IOException;

import org.apache.hadoop.hive.llap.daemon.rpc.LlapDaemonProtocolProtos.GetTokenRequestProto;
import org.apache.hadoop.hive.llap.security.LlapTokenIdentifier;
import org.apache.hadoop.security.token.Token;

/**
 * LlapTokenManager is for renewing and recreating LLAP tokens on a cluster.
 * See further details in implementations.
 */
public interface LlapTokenManager {
  long LLAP_TOKEN_CHECK_INTERVAL_IN_DAEMON_SECONDS = 300;

  Token<LlapTokenIdentifier> getToken(GetTokenRequestProto request, boolean isSigningRequired) throws IOException;

  void close();
}

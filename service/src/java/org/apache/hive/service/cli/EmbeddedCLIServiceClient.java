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

package org.apache.hive.service.cli;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hive.service.auth.HiveAuthFactory;
import org.apache.hive.service.rpc.thrift.TOperationHandle;


/**
 * EmbeddedCLIServiceClient.
 *
 */
public class EmbeddedCLIServiceClient extends CLIServiceClient {
  private final ICLIService cliService;

  // TODO: this doesn't appear to be used anywhere.
  public EmbeddedCLIServiceClient(ICLIService cliService, Configuration conf) {
    super(conf);
    this.cliService = cliService;
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#openSession(java.lang.String, java.lang.String, java.util.Map)
   */
  @Override
  public SessionHandle openSession(String username, String password,
      Map<String, String> configuration) throws HiveSQLException {
    return cliService.openSession(username, password, configuration);
  }

  @Override
  public SessionHandle openSessionWithImpersonation(String username, String password,
      Map<String, String> configuration, String delegationToken) throws HiveSQLException {
    throw new HiveSQLException("Impersonated session is not supported in the embedded mode");
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#closeSession(org.apache.hive.service.cli.SessionHandle)
   */
  @Override
  public void closeSession(SessionHandle sessionHandle) throws HiveSQLException {
    cliService.closeSession(sessionHandle);
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#getInfo(org.apache.hive.service.cli.SessionHandle, java.util.List)
   */
  @Override
  public GetInfoValue getInfo(SessionHandle sessionHandle, GetInfoType getInfoType)
      throws HiveSQLException {
    return cliService.getInfo(sessionHandle, getInfoType);
  }

  @Override
  public OperationHandle executeStatement(SessionHandle sessionHandle, String statement,
      Map<String, String> confOverlay) throws HiveSQLException {
    return cliService.executeStatement(sessionHandle, statement, confOverlay);
  }

  @Override
  public OperationHandle executeStatement(SessionHandle sessionHandle, String statement,
      Map<String, String> confOverlay, long queryTimeout) throws HiveSQLException {
    return cliService.executeStatement(sessionHandle, statement, confOverlay, queryTimeout);
  }

  @Override
  public OperationHandle executeStatementAsync(SessionHandle sessionHandle, String statement,
      Map<String, String> confOverlay) throws HiveSQLException {
    return cliService.executeStatementAsync(sessionHandle, statement, confOverlay);
  }

  @Override
  public OperationHandle executeStatementAsync(SessionHandle sessionHandle, String statement,
      Map<String, String> confOverlay, long queryTimeout) throws HiveSQLException {
    return cliService.executeStatementAsync(sessionHandle, statement, confOverlay, queryTimeout);
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#getTypeInfo(org.apache.hive.service.cli.SessionHandle)
   */
  @Override
  public OperationHandle getTypeInfo(SessionHandle sessionHandle) throws HiveSQLException {
    return cliService.getTypeInfo(sessionHandle);
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#getCatalogs(org.apache.hive.service.cli.SessionHandle)
   */
  @Override
  public OperationHandle getCatalogs(SessionHandle sessionHandle) throws HiveSQLException {
    return cliService.getCatalogs(sessionHandle);
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#getSchemas(org.apache.hive.service.cli.SessionHandle, java.lang.String, java.lang.String)
   */
  @Override
  public OperationHandle getSchemas(SessionHandle sessionHandle, String catalogName,
      String schemaName) throws HiveSQLException {
    return cliService.getSchemas(sessionHandle, catalogName, schemaName);
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#getTables(org.apache.hive.service.cli.SessionHandle, java.lang.String, java.lang.String, java.lang.String, java.util.List)
   */
  @Override
  public OperationHandle getTables(SessionHandle sessionHandle, String catalogName,
      String schemaName, String tableName, List<String> tableTypes) throws HiveSQLException {
    return cliService.getTables(sessionHandle, catalogName, schemaName, tableName, tableTypes);
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#getTableTypes(org.apache.hive.service.cli.SessionHandle)
   */
  @Override
  public OperationHandle getTableTypes(SessionHandle sessionHandle) throws HiveSQLException {
    return cliService.getTableTypes(sessionHandle);
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#getColumns(org.apache.hive.service.cli.SessionHandle, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
   */
  @Override
  public OperationHandle getColumns(SessionHandle sessionHandle, String catalogName,
      String schemaName, String tableName, String columnName) throws HiveSQLException {
    return cliService.getColumns(sessionHandle, catalogName, schemaName, tableName, columnName);
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#getFunctions(org.apache.hive.service.cli.SessionHandle, java.lang.String)
   */
  @Override
  public OperationHandle getFunctions(SessionHandle sessionHandle,
      String catalogName, String schemaName, String functionName)
          throws HiveSQLException {
    return cliService.getFunctions(sessionHandle, catalogName, schemaName, functionName);
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#getOperationStatus(org.apache.hive.service.cli.OperationHandle)
   */
  @Override
  public OperationStatus getOperationStatus(OperationHandle opHandle, boolean getProgressUpdate) throws HiveSQLException {
    return cliService.getOperationStatus(opHandle, getProgressUpdate);
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#cancelOperation(org.apache.hive.service.cli.OperationHandle)
   */
  @Override
  public void cancelOperation(OperationHandle opHandle) throws HiveSQLException {
    cliService.cancelOperation(opHandle);
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#closeOperation(org.apache.hive.service.cli.OperationHandle)
   */
  @Override
  public void closeOperation(OperationHandle opHandle) throws HiveSQLException {
    cliService.closeOperation(opHandle);
  }

  /* (non-Javadoc)
   * @see org.apache.hive.service.cli.CLIServiceClient#getResultSetMetadata(org.apache.hive.service.cli.OperationHandle)
   */
  @Override
  public TableSchema getResultSetMetadata(OperationHandle opHandle) throws HiveSQLException {
    return cliService.getResultSetMetadata(opHandle);
  }

  @Override
  public RowSet fetchResults(OperationHandle opHandle, FetchOrientation orientation,
      long maxRows,  FetchType fetchType) throws HiveSQLException {
    return cliService.fetchResults(opHandle, orientation, maxRows, fetchType);
  }


  @Override
  public String getDelegationToken(SessionHandle sessionHandle, HiveAuthFactory authFactory,
         String owner, String renewer) throws HiveSQLException {
    return cliService.getDelegationToken(sessionHandle, authFactory, owner, renewer);
  }

  @Override
  public void cancelDelegationToken(SessionHandle sessionHandle, HiveAuthFactory authFactory,
      String tokenStr) throws HiveSQLException {
    cliService.cancelDelegationToken(sessionHandle, authFactory, tokenStr);
  }

  @Override
  public void renewDelegationToken(SessionHandle sessionHandle, HiveAuthFactory authFactory,
      String tokenStr) throws HiveSQLException {
    cliService.renewDelegationToken(sessionHandle, authFactory, tokenStr);
  }

  @Override
  public OperationHandle getPrimaryKeys(SessionHandle sessionHandle,
		String catalog, String schema, String table) throws HiveSQLException {
	return cliService.getPrimaryKeys(sessionHandle, catalog, schema, table);
  }

  @Override
  public OperationHandle getCrossReference(SessionHandle sessionHandle,
		String primaryCatalog, String primarySchema, String primaryTable,
		String foreignCatalog, String foreignSchema, String foreignTable)
		throws HiveSQLException {
    return cliService.getCrossReference(sessionHandle, primaryCatalog, primarySchema,
      primaryTable, foreignCatalog, foreignSchema, foreignTable);
  }

  @Override
  public String getQueryId(TOperationHandle operationHandle) throws HiveSQLException {
    return cliService.getQueryId(operationHandle);
  }

  @Override
  public void setApplicationName(SessionHandle sh, String value) throws HiveSQLException {
    cliService.setApplicationName(sh, value);
  }

  @Override
  public OperationHandle uploadData(
      SessionHandle sessionHandle,
      ByteBuffer values,
      String tableName,
      String path) throws HiveSQLException {
    return cliService.uploadData(sessionHandle, values, tableName, path);
  }

  @Override
  public OperationHandle downloadData(
      SessionHandle sessionHandle,
      String tableName,
      String query,
      String format,
      Map<String, String> options) throws HiveSQLException {
    return cliService.downloadData(sessionHandle, tableName, query, format, options);
  }
}

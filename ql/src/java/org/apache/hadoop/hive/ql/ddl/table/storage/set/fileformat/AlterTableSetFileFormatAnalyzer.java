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

package org.apache.hadoop.hive.ql.ddl.table.storage.set.fileformat;

import java.util.Map;

import org.apache.hadoop.hive.common.TableName;
import org.apache.hadoop.hive.ql.QueryState;
import org.apache.hadoop.hive.ql.ddl.DDLWork;
import org.apache.hadoop.hive.ql.ddl.DDLSemanticAnalyzerFactory.DDLType;
import org.apache.hadoop.hive.ql.ddl.table.AbstractAlterTableAnalyzer;
import org.apache.hadoop.hive.ql.ddl.table.AlterTableType;
import org.apache.hadoop.hive.ql.exec.TaskFactory;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.HiveParser;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.parse.StorageFormat;

/**
 * Analyzer for set file format commands.
 */
@DDLType(types = {HiveParser.TOK_ALTERTABLE_FILEFORMAT, HiveParser.TOK_ALTERPARTITION_FILEFORMAT})
public class AlterTableSetFileFormatAnalyzer extends AbstractAlterTableAnalyzer {
  public AlterTableSetFileFormatAnalyzer(QueryState queryState) throws SemanticException {
    super(queryState);
  }

  @Override
  protected void analyzeCommand(TableName tableName, Map<String, String> partitionSpec, ASTNode command)
      throws SemanticException {
    StorageFormat format = new StorageFormat(conf);
    ASTNode child = (ASTNode) command.getChild(0);
    if (!format.fillStorageFormat(child)) {
      throw new AssertionError("Unknown token " + child.getText());
    }

    AlterTableSetFileFormatDesc desc = new AlterTableSetFileFormatDesc(tableName, partitionSpec,
        format.getInputFormat(), format.getOutputFormat(), format.getSerde());
    addInputsOutputsAlterTable(tableName, partitionSpec, desc, AlterTableType.SET_FILE_FORMAT, false);
    rootTasks.add(TaskFactory.get(new DDLWork(getInputs(), getOutputs(), desc)));
    setAcidDdlDesc(getTable(tableName), desc);
  }
}

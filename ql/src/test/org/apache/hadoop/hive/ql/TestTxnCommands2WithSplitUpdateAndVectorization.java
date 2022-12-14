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

package org.apache.hadoop.hive.ql;

import org.apache.hadoop.hive.conf.HiveConf;
import org.junit.Before;
import org.junit.Test;

/**
 * Same as TestTxnCommands2 but tests ACID tables with vectorization turned on by
 * default, and having 'transactional_properties' set to 'default'. This specifically tests the
 * fast VectorizedOrcAcidRowBatchReader for ACID tables with split-update turned on.
 */
public class TestTxnCommands2WithSplitUpdateAndVectorization extends TestTxnCommands2 {

  public TestTxnCommands2WithSplitUpdateAndVectorization() {
    super();
  }

  @Override
  void initHiveConf() {
    super.initHiveConf();
    hiveConf.setBoolVar(HiveConf.ConfVars.HIVE_VECTORIZATION_ENABLED, true);
  }

  @Override
  @Test
  public void testFailureOnAlteringTransactionalProperties() throws Exception {
    // Override to do nothing, as the this test is not related with vectorization.
    // The parent class creates a temporary table in this test and alters its properties.
    // To not override this test, that temporary table needs to be renamed. However, as
    // mentioned this does not serve any purpose, as this test does not relate to vectorization.
  }

}

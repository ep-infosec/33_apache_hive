package org.apache.hadoop.hive.metastore;
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.conf.MetastoreConf;
import org.apache.hadoop.hive.ql.optimizer.ppr.PartitionExpressionForMetastore;
import org.junit.Assert;
import org.junit.Test;

/**
 * Make sure that when HiveMetaStore is instantiated, the default proper PartitionExpressionProxy
 * instance is instantiated.
 */
public class TestPartitionExpressionProxyDefault {

  @Test
  public void checkPartitionExpressionProxy() throws MetaException {
    Configuration conf = MetastoreConf.newMetastoreConf();
    HMSHandler hms = new HMSHandler("for testing", conf);
    hms.init();
    Assert.assertEquals(PartitionExpressionForMetastore.class,
        hms.getExpressionProxy().getClass());
  }
}

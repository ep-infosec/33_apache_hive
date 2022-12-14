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

package org.apache.hadoop.hive.ql.exec.vector.ptf;

import org.apache.hadoop.hive.ql.exec.vector.ColumnVector.Type;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.ptf.WindowFrameDef;
import org.apache.hadoop.hive.ql.udf.ptf.Range;

public class VectorPTFEvaluatorLag extends VectorPTFEvaluatorAbstractLeadLag {

  public VectorPTFEvaluatorLag(WindowFrameDef windowFrameDef, VectorExpression inputVecExpr,
      int outputColumnNum, Type type, int amt, VectorExpression defaultValueExpression) {
    super(windowFrameDef, inputVecExpr, outputColumnNum, type, amt, defaultValueExpression);
  }

  @Override
  public Object runOnRange(int rowNum, Range range, VectorPTFGroupBatches batches)
      throws HiveException {
    int lagRow = rowNum - amt;
    if (lagRow < 0 || lagRow >= batches.size()) {
      return getDefaultValue(rowNum, batches);
    } else {
      return batches.getValueAndEvaluateInputExpression(this, lagRow, inputColumnNum);
    }
  }
}

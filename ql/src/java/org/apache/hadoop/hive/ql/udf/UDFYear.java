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

package org.apache.hadoop.hive.ql.udf;

import org.apache.hadoop.hive.common.type.Date;
import org.apache.hadoop.hive.common.type.HiveIntervalYearMonth;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentTypeException;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedExpressions;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorUDFYearDate;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorUDFYearString;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorUDFYearTimestamp;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.ql.udf.generic.NDV;
import org.apache.hadoop.hive.ql.util.DateTimeMath;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorConverters;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.io.IntWritable;

import java.util.Calendar;

/**
 * UDFYear.
 *
 */
@Description(name = "year",
    value = "_FUNC_(param) - Returns the year component of the date/timestamp/interval",
    extended = "param can be one of:\n"
    + "1. A string in the format of 'yyyy-MM-dd HH:mm:ss' or 'yyyy-MM-dd'.\n"
    + "2. A date value\n"
    + "3. A timestamp value\n"
    + "4. A year-month interval value"
    + "Example:\n "
    + "  > SELECT _FUNC_('2009-07-30') FROM src LIMIT 1;\n" + "  2009")
@VectorizedExpressions({VectorUDFYearDate.class, VectorUDFYearString.class, VectorUDFYearTimestamp.class})
@NDV(maxNdv = 20) // although technically its unbounded, its unlikely we will ever see ndv > 20
public class UDFYear extends GenericUDF {

  private transient ObjectInspectorConverters.Converter[] converters = new ObjectInspectorConverters.Converter[1];
  private transient PrimitiveObjectInspector.PrimitiveCategory[] inputTypes = new PrimitiveObjectInspector.PrimitiveCategory[1];
  private final IntWritable output = new IntWritable();

  private final Calendar calendar = DateTimeMath.getProlepticGregorianCalendarUTC();


  @Override
  public ObjectInspector initialize(ObjectInspector[] arguments) throws UDFArgumentException {
    checkArgsSize(arguments, 1, 1);
    checkArgPrimitive(arguments, 0);
    switch (((PrimitiveObjectInspector) arguments[0]).getPrimitiveCategory()) {
      case INTERVAL_YEAR_MONTH:
        inputTypes[0] = PrimitiveObjectInspector.PrimitiveCategory.INTERVAL_YEAR_MONTH;
        converters[0] = ObjectInspectorConverters.getConverter(
            arguments[0], PrimitiveObjectInspectorFactory.writableHiveIntervalYearMonthObjectInspector);
        break;
      case STRING:
      case CHAR:
      case VARCHAR:
      case DATE:
      case TIMESTAMP:
      case TIMESTAMPLOCALTZ:
      case VOID:
        obtainDateConverter(arguments, 0, inputTypes, converters);
        break;
      default:
        // build error message
        StringBuilder sb = new StringBuilder();
        sb.append(getFuncName());
        sb.append(" does not take ");
        sb.append(((PrimitiveObjectInspector) arguments[0]).getPrimitiveCategory());
        sb.append(" type");
        throw new UDFArgumentTypeException(0, sb.toString());
    }

    ObjectInspector outputOI = PrimitiveObjectInspectorFactory.writableIntObjectInspector;
    return outputOI;
  }

  @Override
  public Object evaluate(DeferredObject[] arguments) throws HiveException {
    switch (inputTypes[0]) {
      case INTERVAL_YEAR_MONTH:
        HiveIntervalYearMonth intervalYearMonth = getIntervalYearMonthValue(arguments, 0, inputTypes, converters);
        if (intervalYearMonth == null) {
          return null;
        }
        output.set(intervalYearMonth.getYears());
        break;
      case STRING:
      case CHAR:
      case VARCHAR:
      case DATE:
      case TIMESTAMP:
      case TIMESTAMPLOCALTZ:
      case VOID:
        Date date = getDateValue(arguments, 0, converters);
        if (date == null) {
          return null;
        }
        calendar.setTimeInMillis(date.toEpochMilli());
        output.set(calendar.get(Calendar.YEAR));
    }
    return output;
  }

  @Override
  protected String getFuncName() {
    return "year";
  }

  @Override
  public String getDisplayString(String[] children) {
    return getStandardDisplayString(getFuncName(), children);
  }
}

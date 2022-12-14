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
package org.apache.hadoop.hive.llap.io.encoded;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.hadoop.hive.llap.io.api.impl.LlapIoImpl;
import org.apache.hadoop.hive.llap.io.encoded.SerDeEncodedDataReader.ReaderWithOffsets;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.LineRecordReader;

final class LineRrOffsetReader extends PassThruOffsetReader {
  private static final Method isCompressedMethod;
  private final LineRecordReader lrReader;
  private final LongWritable posKey;

  static {
    Method isCompressedMethodTmp;
    try {
      isCompressedMethodTmp = LineRecordReader.class.getDeclaredMethod("isCompressedInput");
      isCompressedMethodTmp.setAccessible(true);
    } catch (Throwable t) {
      isCompressedMethodTmp = null;
      LlapIoImpl.LOG.warn("Cannot get LineRecordReader isCompressedInput method", t);
    }
    isCompressedMethod = isCompressedMethodTmp;
  }

  static ReaderWithOffsets create(LineRecordReader sourceReader, JobConf jobConf,
      int skipHeaderCnt, int skipFooterCnt, FileSplit split) {
    // File not compressed, skipping is already done as part of SkippingTextInputFormat
    if (isCompressedMethod == null) {
      return new PassThruOffsetReader(sourceReader, jobConf, 0, 0);
    }
    Boolean isCompressed = null;
    try {
      isCompressed = (Boolean)isCompressedMethod.invoke(sourceReader);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
      LlapIoImpl.LOG.error("Cannot check the reader for compression; offsets not supported", e);
      return new PassThruOffsetReader(sourceReader, jobConf, 0, 0);
    }
    if (isCompressed) {
      // Cannot slice compressed files - do header/footer skipping within the Reader
      LlapIoImpl.LOG.info("Reader is compressed; offsets not supported");
      return new PassThruOffsetReader(sourceReader, jobConf, skipHeaderCnt, skipFooterCnt);
    }
    if (skipHeaderCnt > 0 && split.getStart() == 0) {
      // Skipping empty/null lines leading to Split start -1 being zero
      LlapIoImpl.LOG.info("Reader with blank head line(s)");
      return new PassThruOffsetReader(sourceReader, jobConf, skipHeaderCnt, skipFooterCnt);
    }
    // For non-compressed Text Files Header/Footer Skipping is already done as part of SkippingTextInputFormat
    return new LineRrOffsetReader(sourceReader, jobConf);
  }

  private LineRrOffsetReader(LineRecordReader sourceReader, JobConf jobConf) {
    super(sourceReader, jobConf, 0, 0);
    this.lrReader = sourceReader;
    this.posKey = (LongWritable)key;
  }

  @Override
  public long getCurrentRowStartOffset() {
    return posKey.get();
  }

  @Override
  public long getCurrentRowEndOffset() {
    try {
      return lrReader.getPos();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean hasOffsets() {
    return true;
  }
}
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

package org.apache.hadoop.hive.ql.plan;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.parse.ImportSemanticAnalyzer;
import org.apache.hadoop.hive.ql.parse.repl.metric.ReplicationMetricCollector;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.DeferredWorkContext;
import org.apache.hadoop.hive.ql.plan.Explain.Level;

/**
 * Marker work for Replication - behaves similar to CopyWork, but maps to ReplCopyTask,
 * which will have mechanics to list the files in source to write to the destination,
 * instead of copying them, if specified, falling back to copying if needed.
 */
@Explain(displayName = "Repl Copy", explainLevels = { Level.USER, Level.DEFAULT, Level.EXTENDED })
public class ReplCopyWork extends CopyWork {
  /**
   * TODO : Refactor
   *
   * There is an upcoming patch that refactors this bit of code. Currently, the idea is the following:
   *
   * By default, ReplCopyWork will behave similarly to CopyWork, and simply copy
   * along data from the source to destination.
   * If the flag readSrcAsFilesList is set, changes the source behaviour of this CopyTask, and
   * instead of copying explicit files, this will then fall back to a behaviour wherein an _files is
   * read from the source, and the files specified by the _files are then copied to the destination.
   *
   * This allows us a lazy-copy-on-source and a pull-from destination semantic that we want
   * to use from replication.
   */

  // Governs remote-fetch-input behaviour
  // If set to true, we'll assume that the input has a _files file present which lists
  //   the actual input files to copy, and we'll pull each of those on read.
  // If set to false, it'll behave as a traditional CopyTask.
  protected boolean readSrcAsFilesList = false;

  private boolean deleteDestIfExist = false;

  private boolean isAutoPurge = false;

  private boolean needRecycle = false;

  private String distCpDoAsUser = null;

  private boolean checkDuplicateCopy = false;

  private boolean overWrite = false;

  private String dumpDirectory;

  private transient ReplicationMetricCollector metricCollector;

  public ReplCopyWork(final Path srcPath, final Path destPath, boolean errorOnSrcEmpty) {
    super(srcPath, destPath, errorOnSrcEmpty);
  }

  public ReplCopyWork(final Path srcPath, final Path destPath, boolean errorOnSrcEmpty, boolean overWrite) {
    this(srcPath, destPath, errorOnSrcEmpty);
    this.overWrite = overWrite;
  }

  public ReplCopyWork(final Path srcPath, final Path destPath, boolean errorOnSrcEmpty, boolean overWrite,
                      String dumpDirectory, ReplicationMetricCollector metricCollector) {
    this(srcPath, destPath, errorOnSrcEmpty);
    this.overWrite = overWrite;
    this.dumpDirectory = dumpDirectory;
    this.metricCollector = metricCollector;
  }
  public void setReadSrcAsFilesList(boolean readSrcAsFilesList) {
    this.readSrcAsFilesList = readSrcAsFilesList;
  }

  public boolean readSrcAsFilesList() {
    return this.readSrcAsFilesList;
  }

  public void setDistCpDoAsUser(String distCpDoAsUser) {
    this.distCpDoAsUser = distCpDoAsUser;
  }

  public String distCpDoAsUser() {
    return distCpDoAsUser;
  }

  public boolean getDeleteDestIfExist() {
    return deleteDestIfExist;
  }

  public void setDeleteDestIfExist(boolean deleteDestIfExist) {
    this.deleteDestIfExist = deleteDestIfExist;
  }

  public boolean getNeedRecycle() {
    return needRecycle;
  }

  public void setNeedRecycle(boolean needRecycle) {
    this.needRecycle = needRecycle;
  }

  public boolean getIsAutoPurge() {
    return isAutoPurge;
  }

  public void setAutoPurge(boolean isAutoPurge) {
    this.isAutoPurge = isAutoPurge;
  }

  public boolean isNeedCheckDuplicateCopy() {
    return checkDuplicateCopy;
  }

  public void setCheckDuplicateCopy(boolean flag) {
    checkDuplicateCopy = flag;
  }

  public ReplicationMetricCollector getMetricCollector() { return metricCollector; }

  public String getDumpDirectory() { return dumpDirectory; }

  public boolean isOverWrite() {
    return overWrite;
  }

  public void initializeFromDeferredContext(DeferredWorkContext deferredContext) throws HiveException {
    if (!deferredContext.isCalculated()) {
      // Read metadata from metastore and populate the members of the context
      ImportSemanticAnalyzer.setupDeferredContextFromMetadata(deferredContext);
    }

    setToPath(new Path[] { deferredContext.destPath });
    if (deferredContext.replace) {
      setDeleteDestIfExist(true);
      setAutoPurge(deferredContext.isSkipTrash);
      setNeedRecycle(deferredContext.needRecycle);
    }
  }

}

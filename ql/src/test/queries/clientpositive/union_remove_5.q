set hive.mapred.mode=nonstrict;
set hive.stats.autogather=false;
set hive.optimize.union.remove=true;

set hive.merge.mapfiles=true;
set hive.merge.mapredfiles=true;
set hive.merge.smallfiles.avgsize=1;

-- SORT_QUERY_RESULTS
-- This is to test the union->selectstar->filesink optimization
-- Union of 3 subqueries is performed (exactly one of which requires a map-reduce job)
-- followed by select star and a file sink.
-- There is no need to write the temporary results of the sub-queries, and then read them 
-- again to process the union. The union can be removed completely.
-- It does not matter, whether the output is merged or not. In this case, merging is turned
-- on

-- Since this test creates sub-directories for the output table outputTbl1_n6, it might be easier
-- to run the test only on hadoop 23

create table inputTbl1_n4(key string, val string) stored as textfile;
create table outputTbl1_n6(key string, `values` bigint) stored as textfile;

load data local inpath '../../data/files/T1.txt' into table inputTbl1_n4;

explain
insert overwrite table outputTbl1_n6
SELECT *
FROM (
  SELECT key, count(1) as `values` from inputTbl1_n4 group by key
  UNION ALL
  SELECT key, 1 as `values` from inputTbl1_n4
  UNION ALL
  SELECT key, 2 as `values` from inputTbl1_n4
) a;

insert overwrite table outputTbl1_n6
SELECT *
FROM (
  SELECT key, count(1) as `values` from inputTbl1_n4 group by key
  UNION ALL
  SELECT key, 1 as `values` from inputTbl1_n4
  UNION ALL
  SELECT key, 2 as `values` from inputTbl1_n4
) a;

desc formatted outputTbl1_n6;

set hive.input.format=org.apache.hadoop.hive.ql.io.HiveInputFormat;
select * from outputTbl1_n6;

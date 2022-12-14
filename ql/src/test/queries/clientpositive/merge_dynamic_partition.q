--! qt:dataset:srcpart
SET hive.vectorized.execution.enabled=false;
set hive.strict.checks.bucketing=false;

set hive.mapred.mode=nonstrict;
set hive.exec.dynamic.partition=true;

-- SORT_QUERY_RESULTS

create table srcpart_merge_dp_n1 like srcpart;

create table merge_dynamic_part_n1 like srcpart;

load data local inpath '../../data/files/srcbucket20.txt' INTO TABLE srcpart_merge_dp_n1 partition(ds='2008-04-08', hr=11);
load data local inpath '../../data/files/srcbucket21.txt' INTO TABLE srcpart_merge_dp_n1 partition(ds='2008-04-08', hr=11);
load data local inpath '../../data/files/srcbucket22.txt' INTO TABLE srcpart_merge_dp_n1 partition(ds='2008-04-08', hr=11);
load data local inpath '../../data/files/srcbucket23.txt' INTO TABLE srcpart_merge_dp_n1 partition(ds='2008-04-08', hr=11);

set hive.input.format=org.apache.hadoop.hive.ql.io.BucketizedHiveInputFormat; 
set hive.merge.mapfiles=false;
set hive.merge.mapredfiles=false;
set hive.merge.smallfiles.avgsize=1000000000;
explain
insert overwrite table merge_dynamic_part_n1 partition (ds='2008-04-08', hr) select key, value, hr from srcpart_merge_dp_n1 where ds='2008-04-08';
insert overwrite table merge_dynamic_part_n1 partition (ds='2008-04-08', hr) select key, value, hr from srcpart_merge_dp_n1 where ds='2008-04-08';

select * from merge_dynamic_part_n1;
show table extended like `merge_dynamic_part_n1`;


set hive.input.format=org.apache.hadoop.hive.ql.io.CombineHiveInputFormat;
set hive.merge.mapfiles=true;
set hive.merge.mapredfiles=true;
set hive.merge.smallfiles.avgsize=1000000000;
explain
insert overwrite table merge_dynamic_part_n1 partition (ds='2008-04-08', hr=11) select key, value from srcpart_merge_dp_n1 where ds='2008-04-08';
insert overwrite table merge_dynamic_part_n1 partition (ds='2008-04-08', hr=11) select key, value from srcpart_merge_dp_n1 where ds='2008-04-08';

select * from merge_dynamic_part_n1;
show table extended like `merge_dynamic_part_n1`;

set hive.input.format=org.apache.hadoop.hive.ql.io.CombineHiveInputFormat;
set hive.merge.mapfiles=true;
set hive.merge.mapredfiles=true;
set hive.merge.smallfiles.avgsize=1000000000;
explain
insert overwrite table merge_dynamic_part_n1 partition (ds, hr) select key, value, ds, hr from srcpart_merge_dp_n1 where ds='2008-04-08' and hr=11;
insert overwrite table merge_dynamic_part_n1 partition (ds, hr) select key, value, ds, hr from srcpart_merge_dp_n1 where ds='2008-04-08' and hr=11;;

select * from merge_dynamic_part_n1;
show table extended like `merge_dynamic_part_n1`;


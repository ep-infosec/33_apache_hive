set hive.mapred.mode=nonstrict;
set hive.fetch.task.conversion=more;

DESCRIBE FUNCTION unix_timestamp;
DESCRIBE FUNCTION EXTENDED unix_timestamp;

create table oneline(key int, value string);
load data local inpath '../../data/files/things.txt' into table oneline;

SELECT
  '2009-03-20 11:30:01',
  unix_timestamp('2009-03-20 11:30:01')
FROM oneline;

SELECT
  '2009-03-20',
  unix_timestamp('2009-03-20', 'yyyy-MM-dd')
FROM oneline;

SELECT
  '2009 Mar 20 11:30:01 am',
  unix_timestamp('2009 Mar 20 11:30:01 AM', 'yyyy MMM dd h:mm:ss a')
FROM oneline;

create table foo_n3 as SELECT
  'deprecated' as a,
  unix_timestamp() as b
FROM oneline;
drop table foo_n3;

SELECT
  'random_string',
  unix_timestamp('random_string')
FROM oneline;

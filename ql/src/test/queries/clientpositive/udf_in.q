--! qt:dataset:src
set hive.fetch.task.conversion=more;

SELECT 1 IN (1, 2, 3),
       4 IN (1, 2, 3),
       array(1,2,3) IN (array(1,2,3)),
       "bee" IN("aee", "bee", "cee", 1),
       "dee" IN("aee", "bee", "cee"),
       (1 = 1) IN(true, false),
       true IN (true, false) = true,
       1 IN (1, 2, 3) OR false IN(false),
       NULL IN (1, 2, 3),
       4 IN (1, 2, 3, NULL),
       (1+3) IN (5, 6, (1+2) + 1) FROM src tablesample (1 rows);

SELECT key FROM src WHERE key IN ("238", 86);

-- test case(s) for HIVE-26320
CREATE EXTERNAL TABLE hive26230_parq_in(kob varchar(2), code int) STORED AS PARQUET;
INSERT INTO hive26230_parq_in VALUES('BB',18),('BC',18),('AB',18);
SELECT (kob, code) IN ((cast('BB' as varchar(2)), 18), (cast('BC' as varchar(2)), 18)) FROM hive26230_parq_in;
DROP TABLE hive26230_parq_in;

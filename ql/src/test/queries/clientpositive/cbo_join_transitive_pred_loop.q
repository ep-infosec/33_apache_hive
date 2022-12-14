CREATE TABLE A (`value_date` date) STORED AS ORC;
CREATE TABLE B (`business_date` date) STORED AS ORC;

EXPLAIN SELECT A.VALUE_DATE
FROM A, B
WHERE A.VALUE_DATE = BUSINESS_DATE
  AND A.VALUE_DATE = TRUNC(BUSINESS_DATE, 'MONTH');
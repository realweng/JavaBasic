/*show DATABASES;*/
show create database testdb;
USE student_db;

/*创建学生信息表*/
/*
CREATE TABLE test(
	sid INT(4),
	sname VARCHAR(20),
	gender char(1),
	age TINYINT(2) UNSIGNED,
	score FLOAT(4,1),
	birthday date,
	createtime datetime,
	updatetime datetime
);
*/
SELECT
	*
FROM
	student_db;

/*新增字段*/
/*ALTER TABLE test add sage TINYINT(2) UNSIGNED;*/
/*删除字段*/
/*ALTER TABLE test DROP sage;*/
/*修改字段名称*/
/*ALTER TABLE test CHANGE age sage TINYINT(2) UNSIGNED;*/
/*修改字段的数据类型*/
/*
ALTER table test CHANGE sage age int(2) UNSIGNED;
ALTER TABLE test MODIFY score INT(2) UNSIGNED;
SHOW DATABASE testdb;
*/
/*修改表名*/
ALTER TABLE student_db RENAME to student;
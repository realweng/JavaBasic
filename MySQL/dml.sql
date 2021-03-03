USE testdb;
CREATE TABLE student(
	sid INT(4) PRIMARY KEY auto_increment,
	sname VARCHAR(20),
	gender char(1),
	age TINYINT(2) UNSIGNED,
	score FLOAT(4,1),
	birthday date,
	createtime datetime,
	updatetime datetime
);

SELECT * from student;
/*插入操作*/
/*
INSERT into student(sid,sname,gender,score,createtime) VALUES(2,'tom','m',100,now());
*/
/*删除操作*/
/*DELETE FROM student where sid = 2;*/


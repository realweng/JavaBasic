use db_homework;
-- 创建学生表
create table student(
		stu_id int(10) not null PRIMARY key auto_increment, -- 学生自增id
		stu_name VARCHAR(20) not NULL, -- 学生姓名
		stu_sex varchar(4), -- 学生性别
		stu_birth year, -- 学生出生年份
		stu_depart varchar(20), -- 学生所在院系
		stu_addr varchar(50) -- 家庭住址
);
-- 创建分数表
create table score(
		score_id int(10) not null PRIMARY key auto_increment, -- 自增id
		stu_id int(10) not null, -- 学生id ,外键创建可有可无
		c_name VARCHAR(20), -- 学科名称
		grade int(10) -- 分数
);

-- 向student表插入记录的INSERT语句如下
insert into student values(901,'张老大','男',1985,'计算机系','北京市海淀区');
insert into student values(902,'张老二','男',1986,'中文系','北京市昌平区');
insert into student values(903,'张三','女',1990,'中文系','湖南省永州市');
insert into student values(904,'李四','男',1990,'英语系','辽宁省阜新市');
insert into student values(905,'王五', '女',1991,'英语系', '福建省厦门市');
insert into student values(906,'王六', '男',1988,'计算机系', '湖南省衡阳市');
-- 向score表插入记录的INSERT语句如下：
INSERT INTO score VALUES(NULL,901, '计算机',98); 
INSERT INTO score VALUES(NULL,901, '英语', 80); 
INSERT INTO score VALUES(NULL,902, '计算机',65); 
INSERT INTO score VALUES(NULL,902, '中文',88); 
INSERT INTO score VALUES(NULL,903, '中文',95); 
INSERT INTO score VALUES(NULL,904, '计算机',70); 
INSERT INTO score VALUES(NULL,904, '英语',92); 
INSERT INTO score VALUES(NULL,905, '英语',94); 
INSERT INTO score VALUES(NULL,906, '计算机',90); 
INSERT INTO score VALUES(NULL,906, '英语',85);

-- 3.查询student表的所有记录
select * from student;
-- 4.查询student表的第2条到4条记录
select * from student limit 1,3;
-- 5.从student表查询所有学生的学号（id）、姓名（name）和院系（department）的信息
select stu_id,stu_name,stu_depart from student;
-- 6.从student表中查询计算机系和英语系的学生的信息
select * from student where stu_depart = '计算机系' or stu_depart = '英语系';
-- 7.从student表中查询年龄1985~1990年份的学生信息
select * from student where stu_birth >= '1985' and stu_birth <= '1990';
-- 8.从student表中查询每个院系有多少人
select stu_depart as '院系名称', count(*) as '院系人数' from student group by stu_depart;
-- 9.从score表中查询每个科目的最高分
select c_name as '学科名称',max(grade) as '最高分' from score group by c_name;
-- 10.查询李四的考试科目（c_name）和考试成绩（grade）
select c_name,grade from score where stu_id = (
select stu_id from student where stu_name = '李四');
-- 11.用连接的方式查询所有学生的信息和考试信息
select a.*,b.score_id,b.c_name,b.grade from student a,score b where a.stu_id = b.stu_id;
-- 12.计算每个学生的总成绩
select a.*,sum(b.grade) as '总成绩' from student a,score b where a.stu_id = b.stu_id group by a.stu_id;
-- 13.计算每个考试科目的平均成绩
select b.c_name as '科目',avg(b.grade) as '平均成绩' from student a,score b where a.stu_id = b.stu_id group by b.c_name;
-- 14.查询计算机成绩低于95的学生信息
select a.* from student a,score b where a.stu_id = b.stu_id and b.c_name = '计算机' and b.grade < 95;
-- 15.将计算机考试成绩按从高到低进行排序
select a.*,b.grade as '计算机考试成绩' from student a,score b where a.stu_id = b.stu_id and b.c_name = '计算机' order by b.grade desc;
-- 16.查询姓张或者姓王的同学的姓名、院系和考试科目及成绩
select a.stu_name,a.stu_depart,b.c_name,b.grade from student a,score b where a.stu_id = b.stu_id and (a.stu_name like '张%' or a.stu_name like '王%');
-- 17.查询都是北京的学生的姓名、年龄、院系和考试科目及成绩
select a.*,b.c_name,b.grade from student a,score b where a.stu_id = b.stu_id and a.stu_addr like '%北京%';

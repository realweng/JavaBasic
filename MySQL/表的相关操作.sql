-- 使用数据库
use mydb;
/*
创建（create） 表（tables）
注意：在创建表的时候，表中一定要有列
			表名：t_ tb_ 或者全名
			在写列名的时候，同一张表中列名不允许重复，每一列结束之后以逗号隔开

create table 表名(
		列名1 数据类型 [属性] [约束],
		列名2 数据类型 [属性] [约束],
		列名3 数据类型 [属性] [约束],
		列名4 数据类型 [属性] [约束],
		......
);

数据类型：分为数组【整数和浮点数】、字符串、日期类型
数值：
整数-->int:最多的位数是11位。
浮点数/小数：float(总个数,小数点保留的位数) 当小数点后的位数超过了保留的位数会自动截取
字符串：varchar(字符个数) 
日期类型：date

删除表：
drop table 表名;
*/
-- 删除表
-- drop table tb_user;
-- 创建表
create table tb_user(
	userId int,
	userName varchar(30),
	userGender varchar(3),
	userAge int
);

drop table tb_student;
create table tb_student(
		stuId int primary key,
		stuName varchar(30) not null unique,
		stuSex varchar(3) default '保密',
		stuAge int check(stuAge >=18 and stuAge <=60)
);

create table tb_score(
sid int primary key auto_increment,
score int not null
);
-- 外键
alter table tb_score add constraint fk_stuId foreign key(sid) references tb_student(stuId); 




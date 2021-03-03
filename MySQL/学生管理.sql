use mydb;

-- 删除学生信息表
drop table if exists tb_stu;

-- 创建学生信息表
create table tb_stu(
		stu_id int unsigned primary key,
		stu_name varchar(30),
		stu_age int,
		stu_sex varchar(3),
		stu_kemu varchar(10),
		stu_enter_time date
); 

-- 成绩查询表
drop table if exists tb_number;
create table tb_number(
		num_id int primary key auto_increment,
		stu_id int not null, -- 业务【与学生信息表进行关联】
		stu_name varchar(30),
		stu_score float(5,2)
);

-- 学生表插入数据
insert INTO tb_stu values(101,'tom',20,'男','Java','2021-03-02');
insert INTO tb_stu values(102,'tom1',22,'女','SQL','2021-03-02');
insert INTO tb_stu values(103,'tom2',18,'男','Java','2021-03-02');
insert INTO tb_stu values(107,'tom3',25,'女','HTML','2021-03-02');
insert INTO tb_stu values(105,'tom4',17,'男','Java','2021-03-02');
insert INTO tb_stu values(106,'tom5',24,'男','C','2021-03-02');

insert INTO tb_stu(stu_id,stu_name,stu_age) values(104,'tom3',18);

-- 成绩表插入数据
insert into tb_number values(1,101,'Java',59);
insert into tb_number values(null,102,'Java',70);
insert into tb_number(stu_id,stu_name,stu_score) values(103,'Java',48);

-- 删除数据
delete from tb_number; -- 删除所有
-- 删除编号为1的数据
delete from tb_number where num_id = 1;
-- 删除分数小于90的成绩信息
delete from tb_number where stu_score < 90;

-- 修改数据
-- 语法：update 表名 set 列 = 值 [where条件]
update tb_number set stu_name = 'Java基础';
-- 修改编号（101）的性别为女、姓名：‘tomcat’学生信息表
update tb_stu set stu_sex = '女',stu_name = 'tomcat' where stu_id = 101;
-- 将所有年龄小于18的学生年龄+5
update tb_stu set stu_age = stu_age + 5 where stu_age < 20;
update tb_stu set stu_sex = '保密' where stu_sex = '女';

-- 查询所有
select * from tb_stu;
select * from tb_number;
-- 去重复的值
select distinct stu_age from tb_stu;
-- 查询学生的姓名和年龄
select stu_name,stu_age from tb_stu;
-- 给列添加别名
select stu_name '学生姓名',stu_age '年龄' from tb_stu;
select stu_name as '学生姓名',stu_age as '年龄' from tb_stu;
select s.stu_name,s.stu_age from tb_stu s;
-- 查询性别为‘保密’且年龄小于25岁的
select * from tb_stu where stu_sex = '保密' and stu_age < 25;
select * from tb_stu where stu_sex = '保密' or stu_age < 25;
-- 查看性别为null的数据
select * from tb_stu where stu_sex is null;
-- 查看性别不是null的数据
select * from tb_stu where stu_sex is not null;
-- 查询性别为男或者女
select * from tb_stu where stu_sex = '男' or stu_sex = '女';
select * from tb_stu where stu_sex in ('男','女');
-- 查询年龄在18-20之间的数据
select * from tb_stu where stu_age >= 18 and stu_age <= 20;
select * from tb_stu where stu_age between 18 and 20;
-- LIKE
select * from tb_stu where stu_name like 't___';
select * from tb_stu where stu_name like 't%';
-- 包含cat的名字
select * from tb_stu where stu_name like '%cat%';
-- 根据年龄排序
select * from tb_stu order by stu_age;
select * from tb_stu order by stu_age desc; -- 降序
select * from tb_stu order by stu_age asc;  -- 升序（默认）

-- 聚合分组
-- 根据性别分组【统计每个组的人数 统计每个组的平均年龄 统计每个组的年龄和】
select * from tb_stu;
select stu_sex,count(*) as '每组的人数',avg(stu_age),sum(stu_age) from tb_stu group by stu_sex;
-- 根据专业来分组，并且统计了每个专业的平均年龄  选出平均年龄大于20岁的专业
select stu_kemu,count(*) as '各专业人数',avg(stu_age) from tb_stu where stu_kemu is not null group by stu_kemu having avg(stu_age) >= 20
-- 错误的写法
-- select stu_kemu,count(*) as '各专业人数',avg(stu_age) from tb_stu where stu_kemu is not null and avg(stu_age) >= 20 group by stu_kemu

-- 联表查询
select * from tb_stu s inner join tb_number n on s.stu_id = n.stu_id;
select s.stu_id,s.stu_name,s.stu_kemu,n.stu_score 
from tb_stu s inner join tb_number n on s.stu_id = n.stu_id 
where n.stu_score > 60;

-- 左右连接
select s.* from tb_stu s left join tb_number n on s.stu_id = n.stu_id
where n.num_id is null; 

select s.* from tb_number n right join  tb_stu s on s.stu_id = n.stu_id
where n.num_id is null; 

-- 子查询
-- 查询tom3学生的成绩信息
select * from tb_number where stu_id = 104; -- 直接通过编号查询
-- 先根据名称查找编号
select stu_id from tb_stu where stu_name = 'tom1'; 
select * from tb_number where stu_id = ( -- 单条结果
		select stu_id from tb_stu where stu_name = 'tom1'
);
select * from tb_stu where stu_id in ( -- 多条结果
		select stu_id from tb_number where stu_name = 'Java基础'
);

-- 子查询当做临时表来用：from 之后 where 之前
-- 就是把子查询的结果当做一张临时表，再对临时表进行查询或者其他的操作
select * from(
select s.stu_id,s.stu_name,s.stu_kemu,n.stu_score
from tb_stu s inner join tb_number n on s.stu_id = n.stu_id
)tab where tab.stu_name like '%tom%';

-- 当做查询列来使用：select和from之间
-- 查询学生信息 查看一下成绩
select *,(select stu_score from tb_number where stu_id = s.stu_id) '学生成绩'
from tb_stu s;
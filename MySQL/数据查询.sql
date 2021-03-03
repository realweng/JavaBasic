-- 切换数据库
use mydb;

-- 查询学生信息、成绩信息
select * from tb_stu;
select * from tb_number;

-- inner join ... ON
-- 仅仅使用inner join查询出来仅仅只是两张表而已  只要表数据不足会自动重复补充（没有意义）必须要有on
select * from tb_stu s inner join tb_number n
on s.stu_id = n.stu_id;

-- 查询 学生姓名 学生的科目 学生的成绩
select tb_stu.stu_name,tb_number.stu_name,tb_number.stu_sorce from tb_stu inner join tb_number
on tb_stu.stu_id = tb_number.stu_id;

select s.stu_name,n.stu_name,n.stu_sorce from tb_stu s inner join tb_number n
on s.stu_id = n.stu_id;

-- 为什么使用表名.  或者 别名.  --> 就是为了当有重复的列的时候，能够指定该列属于哪一张表!
-- select stu_name,stu_name,stu_sorce from tb_stu inner join tb_number
-- on stu_id = stu_id;

-- 查询 学生姓名 学生的科目 学生的成绩 但是要求专业不为空
select s.stu_name,n.stu_name,n.stu_sorce from tb_stu s inner join tb_number n
on s.stu_id = n.stu_id
where s.stu_zhuanYe is not null;

-- 使用where
select s.stu_id,s.stu_name,n.stu_name,n.stu_sorce 
from tb_stu s, tb_number n 
where s.stu_id = n.stu_id and s.stu_zhuanYe is null;

-- 左连接[查询出所有的学生，学生没有参加考试会自动填充null]
select * from tb_stu left join tb_number 
on tb_stu.stu_id = tb_number.stu_id;

select * from tb_stu right join tb_number 
on tb_stu.stu_id = tb_number.stu_id;

-- 查询没有参加考试的学生
select * from tb_stu left join tb_number 
on tb_stu.stu_id = tb_number.stu_id
where tb_number.num_id is null;

select tb_stu.* from tb_number  right join tb_stu 
on tb_stu.stu_id = tb_number.stu_id
where tb_number.num_id is null;

-- 查询学号为103、查询小白 学生的成绩信息
select * from tb_number where stu_id = 103;  -- 直接通过编号查询

-- 先根据名称查找编号
select stu_id from tb_stu where stu_name = '小白';
-- 把上一句的返回结果/得到的编号 当做另外一个查询的条件
select * from tb_number where stu_id = (
	select stu_id from tb_stu where stu_name = 'lucy'
);

-- 查询参加了Java基础考试的学生信息
-- 先查询所有参加java基础考试的学生编号
select stu_id from tb_number where stu_name = 'Java基础';
-- 再通过学生的编号查询学生的信息
select * from tb_stu where stu_id = 103 or stu_id = 104;
-- 如果返回的结果是单个值 = 但是如果是多个值 in
select * from tb_stu where stu_id in(
	select stu_id from tb_number where stu_name = 'Java基础'
);

-- 子查询的结果当做临时表
select * from 
(
	select s.stu_id,s.stu_name,s.stu_zhuanYe,n.stu_sorce 
	from tb_stu s inner join tb_number n
	on s.stu_id = n.stu_id
) tab where tab.stu_name like '%li%';

-- 查询学生信息 查看一下学生的成绩
select stu_sorce from tb_number where stu_id = 101;
-- 
select *,
	(select stu_sorce from tb_number where stu_id = s.stu_id),
	(select stu_name from tb_number where stu_id = s.stu_id)
from tb_stu s;

-- UNION
select * from tb_stu where stu_sex is not null
UNION ALL
select stu_age from tb_stu where stu_zhuanYe = 'Java专业';

-- 查询年龄最大的一位学生
select * from tb_stu order by stu_age desc LIMIT 1;

select * from tb_stu limit 0,2;  -- 从索引0位置开始，取2条数据
select * from tb_stu limit 2,2;  -- 从索引2位置开始，取2条数据
/*
	返回总条数  106条
	假设每一页显示：10条数据
	一共要分11页？
	0页：0 10
	1页：10 10
	2页：20 10

	int allCount = 100;  //总条数
	int pageCount = 10; //每一页的条数
	int count = allCount / pageCount; // 总条数 / 每一页的条数 = 总的页数
	if(allCount % pageCount 1= 0){
		count  = count +1;
	}
	int num; //当前的页数
	select * from tb_stu limit num*pageCount,pageCount; 
*/


























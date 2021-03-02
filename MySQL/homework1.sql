/*
创建三张表：部门信息表、员工信息表、工资信息表。
*/
create database if not exists db_homework;
use db_homework;
-- 部门信息表
drop table if exists tb_department;
create table tb_department(
		department_id	int  unsigned primary key, -- 部门编号
		department_name	varchar(10)  -- 部门名称
);
-- 员工信息表
drop table if exists tb_staff;
create table tb_staff(
		staff_id int primary key auto_increment, -- 员工编号
		department_id int not null, -- 部门编号
		staff_name varchar(30), -- 员工名称
		staff_age int, -- 员工年龄
		staff_work_year int, -- 员工的工龄
		staff_in_date date, -- 员工的入职时间
		staff_state int -- 是否在职【使用0和1来代替】
);
-- 工资信息表
drop table if exists tb_salary;
create table tb_salary(
		salary_id int primary key auto_increment, -- 工资编号
		staff_id int not null, -- 员工编号【业务上与员工相关联】
		salary_money float(7,2), -- 薪资
		salary_date date, -- 薪资发放时间
		salary_state int -- 薪资是否发放【使用0和1来代替】
);
-- ---------------------------------------------------------------------------------------
-- 添加：每一张表至少添加3条测试数据，请注意表与表之间的关联关系
insert into tb_department values(101,'部门101');
insert into tb_department values(102,'部门101');
insert into tb_department values(103,'部门103');
insert into tb_department values(104,'部门104');
insert into tb_staff values(1,101,'张三',23,1,'2020-03-02',1);
insert into tb_staff values(NULL,102,'马一',26,4,'2017-03-02',1);
insert into tb_staff values(NULL,103,'张四',22,1,'2020-03-02',0);
insert into tb_staff values(NULL,102,'王五',27,5,'2016-03-02',1);
insert into tb_staff values(NULL,103,'李九',33,10,'2011-03-02',1);
insert into tb_staff values(NULL,101,'钱二',24,2,'2019-03-02',0);
insert into tb_staff values(NULL,103,'赵六',28,3,'2018-03-02',1);
insert into tb_staff values(NULL,102,'田七',42,6,'2015-03-02',0);
insert into tb_salary values(1,6,9000,'2021-03-01',1);
insert into tb_salary values(NULL,4,8000,'2021-03-01',1);
insert into tb_salary values(NULL,3,5000,NULL,0);
insert into tb_salary values(NULL,2,10000,'2021-03-01',1);
insert into tb_salary values(NULL,8,11000,NULL,0);

-- ---------------------------------------------------------------------------------------
-- 删除：删除已经离职的员工信息。【0、在职 1、已离职】
delete from tb_staff where staff_state = 0;
-- 修改：将所有员工的薪资调整20%
update tb_salary set salary_money = salary_money + salary_money*0.2;
-- d)修改：由于每个月的1号发工资，将所有的工资发放时间调整为：
-- 2021-03-01号，将薪资是否发放改为：1【0、未发放 1、已发放】
update tb_salary set salary_date = '2021-03-01',salary_state = 1;
-- 修改：将2021年3月份之前入职的员工的工龄+1
update tb_staff set staff_work_year = staff_work_year + 1 where staff_in_date BETWEEN '1970-01-01' and '2021-03-01';
-- i.查询所有的员工信息！
select * from tb_staff;
-- ii.查询员工编号、员工薪资、薪资发放时间以及薪资是否发放！
select staff_id,salary_money,salary_date,salary_state from tb_salary;
-- iii.查询工资大于5000元的工资信息。
select * from tb_salary where salary_money > 5000;
-- iv.查询‘2021-03-01’之前入职的员工信息。
select * from tb_staff where staff_in_date BETWEEN '1970-01-01' and '2021-03-01';
-- v.查询部门编号为：101，并且在职的员工信息。
select * from tb_staff where department_id = 101 and staff_state = 1;
-- vi.查询员工姓名中以“张”字开头的员工信息。
select * from tb_staff where staff_name like '张%';
-- vii.查询年龄大于25岁，并且工龄大于3年的员工姓名！
select staff_name as '员工姓名' from tb_staff where staff_age > 25 and staff_work_year > 3; 
-- viii.统计每个部门的人数。
select department_id as '部门',count(*) as '每个部门的人数' from tb_staff group by department_id;
-- ix.根据工龄将员工信息进行排序。按照降序。
select * from tb_staff order by staff_work_year desc;

-- ----------------------------------------------------------------------------------------
/*
连表查询
*/
-- 查询所有的员工姓名、员工工龄、薪资、薪资发放时间 【tb_staff tb_salary】
select a.staff_name,a.staff_age,b.salary_money,b.salary_date from tb_staff a inner join tb_salary b on a.staff_id = b.staff_id;
-- 查询所有的员工姓名、所属部门、工龄、薪资、薪资发放时间【tb_staff tb_salary】
select a.staff_name,c.department_name,a.department_id,a.staff_work_year,b.salary_money,b.salary_date from tb_staff a,tb_salary b,tb_department c where a.staff_id = b.staff_id;
-- 查询所有薪资大于5000元的员工姓名和所属部门【tb_staff tb_salary】
select a.staff_name,a.department_id from tb_staff a inner join tb_salary b on a.staff_id = b.staff_id where b.salary_money > 5000;
-- 查询还没有招聘任何员工的部门信息【tb_department tb_staff】
select a.department_id,a.department_name,b.staff_id
from tb_department a left join tb_staff b on a.department_id = b.department_id 
GROUP BY a.department_id HAVING b.staff_id is null;
-- 查询工资最高的员工信息
/*
select a.*, b.salary_money,max(b.salary_money)
from tb_staff a inner join tb_salary b on a.staff_id = b.staff_id 
group by a.staff_state HAVING b.salary_money = max(b.salary_money) ;
*/
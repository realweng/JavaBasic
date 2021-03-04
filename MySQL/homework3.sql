use db_homework;
-- 创建emp表【员工表】
create table emp(
		empno int(5) not null primary key auto_increment,
		ename varchar(10),
		job varchar(10),
		mgr int(5),
		hiredate date,
		sal float(7,2),
		COMM float(7,2),
		deptno int(3)
);
-- 创建dept表【部门表】
create table dept(
		deptno int(3) not null primary key,
		dname varchar(10),
		loc varchar(5)
);
-- 创建salgrade表【工资表】
create table salgrade(
		grade int(5) not null primary KEY,
		losal int(10),
		hisal int(10)
);
-- 创建【年度利润表】
create table earn(
		e_year year not null primary key,
		zz int(10)
);

insert into emp values(1001,'甘宁','文员',1013,'2000-12-17',8000.00,null,20);
insert into emp values(1002,'黛琦丝','销售员',1006,'2001-02-20',16000.00,3000.00,30);
insert into emp values(1003,'殷天正','销售员',1006,'2001-02-22',12500.00,5000.00,30);
insert into emp values(1004,'刘备','经理',1009,'2001-04-02',29750.00,null,20);
insert into emp values(1005,'谢逊','销售员',1006,'2001-09-28',12500.00,14000.00,30);
insert into emp values(1006,'关羽','经理',1009,'2001-05-01',28500.00,null,30);
insert into emp values(1007,'张飞','经理',1009,'2001-09-01',24500.00,null,10);
insert into emp values(1008,'诸葛亮','分析师',1004,'2007-04-19',30000.00,null,20);
insert into emp values(1009,'曾阿牛','董事长',NULL,'2001-11-17',50000.00,null,10);
insert into emp values(1010,'韦一笑','销售员',1006,'2001-09-08',15000.00,0.00,30);
insert into emp values(1011,'周泰','文员',1008,'2007-05-23',11000.00,null,20);
insert into emp values(1012,'程普','文员',1006,'2001-12-03',9500.00,null,30);
insert into emp values(1013,'庞统','分析师',1004,'2001-12-03',30000.00,null,20);
insert into emp values(1014,'黄盖','文员',1007,'2002-01-23',13000.00,null,10);
insert into emp values(1015,'张三','保洁员',1001,'2013-05-01',80000.00,50000.00,50);

insert into dept values(10,'教研部','北京');
insert into dept values(20,'学工部','上海');
insert into dept values(30,'销售部','广州');
insert into dept values(40,'财务部','武汉');

insert into salgrade values(1,7000,12000);
insert into salgrade values(2,12010,14000);
insert into salgrade values(3,14010,20000);
insert into salgrade values(4,20010,30000);
insert into salgrade values(5,30010,99990);

insert into earn VALUES(2010,100);
insert into earn VALUES(2011,150);
insert into earn VALUES(2012,250);
insert into earn VALUES(2013,800);
insert into earn VALUES(2014,1000);

-- 1. 查出至少有一个员工的部门。
-- 显示部门编号、部门名称、部门位置、部门人数。
select emp.deptno,dept.dname,count(*) as '部门人数',dept.loc from emp left join dept on emp.deptno = dept.deptno GROUP BY emp.deptno; 

-- 2. 列出所有员工的姓名及其直接上级的姓名。
select b.ename as '员工姓名',a.ename as '直接上级' from emp a inner join (select ename,mgr from emp) b where b.mgr = a.empno;
-- 3. 列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。
select b.*,a.ename,a.hiredate as '直接上级' 
from emp a inner join (
select e.empno,e.ename,e.mgr,e.hiredate,d.dname from emp e,dept d where e.deptno = d.deptno) b 
where b.mgr = a.empno and b.hiredate < a.hiredate;
-- 4. 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。
select d.*,e.* from emp e right join dept d on e.deptno = d.deptno; 
-- 5. 列出最低薪金大于15000的各种工作及从事此工作的员工人数
select job as '工资大于15000的工作',count(*) as '从事此工种人数' 
from emp where job in (select job from emp where sal > 15000) GROUP BY job; 
-- 6. 列出在销售部工作的员工的姓名，假定不知道销售部的部门编号。
select e.ename from emp e,dept d where e.deptno = d.deptno and d.dname = '销售部';
-- 7. 列出薪金高于公司平均薪金的所有员工信息，所在部门名称，上级领导，工资等级。 
select d.dname,e2.*,e1.ename as '上级',d.*,s.grade from emp e1 RIGHT JOIN emp e2 on e1.empno = e2.mgr 
left join dept d on d.deptno = e2.deptno,salgrade s 
where e2.sal BETWEEN s.losal and s.hisal and e2.sal >= (select avg(sal) from emp); 
-- 8.列出与庞统从事相同工作的所有员工及部门名称。
select e.ename,d.dname from emp e,dept d where e.deptno = d.deptno and e.job = (select job from emp where ename = '庞统');
-- 9.列出薪金高于在部门30工作的所有员工工姓名和薪金、部门名称。
select e.ename,e.sal,d.dname from emp e,dept d where e.deptno = d.deptno and e.sal > 
(select sal from emp where deptno = 30 order by sal desc LIMIT 1);
-- 10.查出年份、利润、年度增长比
select e1.*,e1.zz/e2.zz - 1 '增长率' from earn e1 left join earn e2 on e1.e_year - 1 = e2.e_year;

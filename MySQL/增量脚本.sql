-- 增量脚本：对原表进行修改（alter）
select * from tb_student;
-- 追加列
alter table tb_student add stu_addr varchar(100);
alter table tb_student add stu_phone varchar(30);

-- 删除原字段
alter table tb_student drop stu_phone;

-- 修改注册时间
alter table tb_student change stuName stu_name varchar(30);
alter table tb_student modify stuSex varchar(15);

-- 修改表名
alter table tb_student rename to tb_stuinfo;
alter table tb_stuinfo rename to tb_student;

-- 复制/备份数据表
create table tb_newuser select * from tb_user;
create table tb_newuser2 select * from tb_user where userName = 12;
create table tb_stu2 like tb_stu; -- 只备份结构
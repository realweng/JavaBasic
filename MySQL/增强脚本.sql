-- 增量脚本：对原表进行修改(alter)
select * from tb_stu;

-- 家庭住址
alter table tb_stu add stu_addr varchar(100);
alter table tb_stu add stu_phone varchar(30) not null;

-- 删除原字段
alter table tb_stu drop stu_phone;

-- 修改注册时间
alter table tb_stu change stu_enter_time stu_enterTime datetime;
alter table tb_stu change stu_sex stu_sex varchar(6);
alter table tb_stu MODIFY stu_sex varchar(10);

-- 修改表名
alter table tb_student RENAME to tb_stuInfo;

-- 复制/数据备份表
create table tb_newUser select * from tb_user;  -- 数据+结构
create table tb_newUser2 select * from tb_user where userName = 12; -- 
CREATE table tb_newStu like tb_stu;  -- 这个只有结构




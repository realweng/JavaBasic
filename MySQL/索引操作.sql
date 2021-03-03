-- 查询一下
select * from tb_stu where stu_id = 101;
select * from tb_stu where stu_id != 101;
EXPLAIN select * from tb_stu where stu_id = 101;
EXPLAIN select * from tb_stu where stu_id != 101;

-- 给姓名添加一个索引
create index index_stuName on tb_stu(stu_name);
EXPLAIN select * from tb_stu where stu_name = 'cat';
EXPLAIN select * from tb_stu where stu_name like '%c';

-- 联合索引  --> 这几个条件 需要经常and一起查询
create index index_stuSex_stuZhuanYe ON tb_stu(stu_sex,stu_zhuanYe);
EXPLAIN select * from tb_stu where stu_sex = '女' and stu_zhuanYe = 'SQL专业';

-- 删除索引
drop index index_stuSex_stuZhuanYe on tb_stu;
create index index_stuSex_stuZhuanYe ON tb_stu(stu_sex);



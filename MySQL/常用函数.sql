-- 常用函数
-- 字符串连接
select CONCAT(stu_name,"-",stu_age) from tb_stu;
select CONCAT("测试","abc","123","#$^#$^");

-- 插入或者替换  索引是从1开始的 len：需要替换的长度
select INSERT("asdfghjkl",1,0,"还是觉得会发生的");

-- 转大小写
select LOWER("ASD"),UPPER("asfsf");

-- 返回字符串的长度
select LENGTH("qwwqe"),CHAR_LENGTH("qafasffas");

-- 去掉前后的空格
select TRIM(" sdfdsf sdfsdf sdf ");

-- 字符串重复输出的次数
select REPEAT("abc",100);

-- 替换和截取
select REPLACE("傻瓜拉几个","傻瓜","qwe");
select SUBSTRING("sdfsdg",2,3);  -- 从1开始 然后包含起始位置

-- 数值函数
select ABS(-10),CEIL(10.5),FLOOR(10.5),MOD(10,3),RAND(),ROUND(10.555,2),TRUNCATE(10.559454,2);


-- 获取当前的系统时间
select NOW();
select * from tb_stu;
insert into tb_stu VALUES(108,'大白',10,'男','保密专业',NOW());
select week(now()),YEAR(now()),HOUR(NOW());
select DATEDIFF('2021-03-08','2021-03-15');
select DATE_FORMAT(now(),"%Y年%m月%d日 %H时%i分%s秒");







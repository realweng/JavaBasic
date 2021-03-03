/*
DDL: 创建（create）删除（drop） 修改（alter） 查看（show） 查询（select）
*/

-- 删除数据库
drop database myDB;
-- 删除如果存在的数据库
drop database if exists myDB;
-- 创建数据库
create database myDB;
-- 创建如果不存在的数据库
create database if not exists myDB;
-- 使用、切换进入数据库
use myDB;
-- 查看数据库的基本信息
show create DATABASE myDB;
-- 查询当前数据库
select database(); 
drop database if exists shoppingdb;

create database shoppingdb;

use shoppingdb;

DROP TABLE IF EXISTS `producttype`;
CREATE TABLE `producttype` (
  id int(10) primary key NOT NULL AUTO_INCREMENT,
  parentId int(10) not NULL,-- 父级Id，0为没有父级Id
  typeName varchar(50) not NULL,
  flagParent int(10),-- 是否为父级Id，1为是  0为不是
  createTime datetime,
  updateTime datetime	
) ENGINE=InnoDB CHARSET=utf8;
-- 父级类型
select * from producttype;
-- select * from producttype where id = 7;
INSERT INTO `producttype` VALUES (null, 0,'饮品',1,now(),null);
INSERT INTO `producttype` VALUES (null, 0,'生活用品',1,now(),null);
INSERT INTO `producttype` VALUES (null, 0,'食品',1,now(),null);

INSERT INTO `producttype` VALUES (null, 1,'饮料',0,now(),null);
INSERT INTO `producttype` VALUES (null, 2,'洗护用品',0,now(),null);
INSERT INTO `producttype` VALUES (null, 3,'膨化食品',0,now(),null);

select a.id,b.typeName as 'parentName',a.typeName,a.flagParent,a.createTime,a.updateTime from producttype a LEFT JOIN producttype b on a.parentid = b.id where a.id = 4;
select a.id,b.typeName as 'parentName',a.parentId,a.typeName,a.flagParent,a.createTime,a.updateTime from producttype a LEFT JOIN producttype b on a.parentid = b.id where a.id = 20
select p.id,p.pname,p.price,p.num,p.discount,pt.typeName,p.state from product p,producttype pt where p.typeId = pt.id and p.id = 13
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(10)  primary key NOT NULL AUTO_INCREMENT,
  `pname` varchar(50)  NULL,
  `price` double(10,2)  NULL,
  `num` int(10) UNSIGNED,
  `discount`  int(10)  NULL,-- 1~10之间
  `typeId` int(10) not null,
	state int -- 1为上架，2为下架，3为删除
) ENGINE=InnoDB CHARSET=utf8;
SELECT * from product;
select * from product where id = 1

INSERT INTO `product` VALUES (null, '海飞丝洗发水', '70.00', '30', '10', '5',1);
INSERT INTO `product` VALUES (null,  '清扬洗发水', '42.80', '61', '10', '5',1);
INSERT INTO `product` VALUES (null, '沙宣洗发水', '59.80', '30', '10', '5',1);
INSERT INTO `product` VALUES (null, '潘婷氨基酸洗发水', '39.80', '30', '10', '5',1);
INSERT INTO `product` VALUES (null,  '飘柔洗护套装', '58.90', '50', '10', '5',1);
INSERT INTO `product` VALUES (null,  '霸王防脱洗发水', '68.50', '30', '10', '5',1);
INSERT INTO `product` VALUES (null,  '红牛复活水', '6.00', '120', '10', '4',1);
INSERT INTO `product` VALUES (null,  '脉动随时动起来', '5.00', '30', '10', '4',1);
INSERT INTO `product` VALUES (null,  '康帅傅冰红茶', '3.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '脉劫', '3.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '激动', '3.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '雪碧', '3.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '雷碧', '3.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '旺子', '6.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '旺仔', '6.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '六个核桃', '6.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '大个核桃', '6.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '六亿核桃', '3.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '营养快线', '3.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '营养专线', '3.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '小明同学', '3.00', '60', '10', '4',1);
INSERT INTO `product` VALUES (null,  '小明同桌', '3.00', '60', '10', '4',1);

INSERT INTO `product` VALUES (null,  '妙脆角', '6.00', '60', '10', '6',1);
INSERT INTO `product` VALUES (null,  '乐事黄瓜味', '6.00', '60', '10', '6',1);
INSERT INTO `product` VALUES (null,  '可比可', '3.00', '60', '10', '6',1);
INSERT INTO `product` VALUES (null,  '鲜虾条', '3.00', '60', '10', '6',1);

select * from product limit 0,10;
select count(*) from product;
select p.id,p.pname,p.price,p.num,p.discount,pt.typeName,p.state from product p,producttype pt where p.typeId = pt.id; 

drop table if exists vip;

create table vip(
	id int(10) primary key NOT NULL AUTO_INCREMENT,
	cardNumber varchar(12),
	vipPassword varchar(50),-- 密码MD5值
	vipName varchar(10),
	iphone varchar(11),
	jiFen int(10),
	money  double UNSIGNED,
	createTime datetime,
	updateTime datetime
) ENGINE=InnoDB CHARSET=utf8;

insert into vip(id,cardnumber,vipname) values(null,'1000','未办理会员');
insert into vip values(null,'1001',NULL,'小白','13502222222',0,100,NOW(),null);
insert into vip values(null,'1002',NULL,'小红','13502222223',0,100,NOW(),null);
insert into vip values(null,'1003',NULL,'小吕','13502222224',0,100,NOW(),null);


select * from product;
select * from producttype;
select * from vip;
select * from orderinfo;
select * from orderdetails;

select * from vip ORDER BY id desc LIMIT 1;
SELECT * from product;

drop table if exists orderinfo;

create table orderinfo(
	id int(10) primary key NOT NULL AUTO_INCREMENT,
	-- ordernumber int(10),
	vipId  int(10),
	price  double,
	orderDate TIMESTAMP,
	payType int(5) -- 订单支付方式，1：现金，2：卡内余额
) ENGINE=InnoDB CHARSET=utf8;
select * from orderinfo order by id desc limit 1;

-- 根据会员编号查询订单详细信息
select a.vipId,d.vipName,b.productId,c.pname,b.money,b.num,a.price,a.payType,b.id,a.orderDate from orderinfo a,orderdetails b,product c ,vip d
where a.vipId = 1 and a.id = b.orderId and c.id = b.productId and a.vipId = d.id;

-- 根据商品编号查询订单详细信息
select a.vipId,d.vipName,b.productId,c.pname,b.money,b.num,a.price,a.payType,b.id,a.orderDate from orderinfo a,orderdetails b,product c ,vip d
where b.productId = 15 and a.id = b.orderId and c.id = b.productId and a.vipId = d.id;

-- 根据月份查询订单排行前十
select od.id,month(oi.orderDate),p.pname,sum(DISTINCT od.num),pt.typeName,oi.orderDate from orderinfo oi,orderdetails od,product p,vip v,producttype pt 
where oi.id = od.orderId and od.productId = p.id and pt.id = p.typeId and month(oi.orderDate) = 3
GROUP BY p.id ORDER BY sum(DISTINCT od.num) desc limit 0,10;

-- 根据商品类型查询订单排行前十
select od.id,month(oi.orderDate),p.pname,sum(DISTINCT od.num),pt.typeName,oi.orderDate from orderinfo oi,orderdetails od,product p,vip v,producttype pt 
where oi.id = od.orderId and od.productId = p.id and pt.id = p.typeId and pt.id = 4
GROUP BY p.id ORDER BY sum(DISTINCT od.num) desc limit 0,10;

select sum(DISTINCT od.id) from orderinfo oi,orderdetails od,product p,vip v,producttype pt 
where oi.id = od.orderId and od.productId = p.id and pt.id = p.typeId and month(oi.orderDate) = 3
GROUP BY p.id ORDER BY sum(od.num) desc;

-- 查询已经在订单数据库中的商品类型
select pt.id,pt.typeName from orderinfo oi,orderdetails od,product p,vip v,producttype pt 
where oi.id = od.orderId and od.productId = p.id and pt.id = p.typeId
GROUP BY pt.id;

drop table if exists orderdetails;
select * from orderdetails;
create table orderdetails(
	id int(10) primary key NOT NULL AUTO_INCREMENT,
	orderId int(10), -- 订单ID
	productId int(10), -- 商品ID
	num int(10),
	money DOUBLE
	-- primary key (orderid,productid)
) ENGINE=InnoDB CHARSET=utf8;
/* ALTER TABLE 表名 WITH NOCHECK ADD 
CONSTRAINT [PK_表名] PRIMARY KEY  NONCLUSTERED 
(
  [字段名1],
  [字段名2]
)
*/


-- insert INTo producttype(type_name,id) values('aa',null);

select * from producttype , product where producttype.id = product.typeId;

select p.*,pt.typeName from product p,producttype pt where p.typeId=pt.id  limit 0,4

INSERT INTO producttype VALUES(null, 0,'饮品',1,now(),null);


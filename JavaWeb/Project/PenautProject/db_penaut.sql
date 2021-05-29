/*
Navicat MySQL Data Transfer

Source Server         : 192.168.3.158
Source Server Version : 50717
Source Host           : 192.168.3.158:3306
Source Database       : db_penaut

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2021-05-25 15:50:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `pwd` varchar(40) DEFAULT NULL,
  `role` int(2) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES ('1', 'admin', '698d51a19d8a121ce581499d7b701668', '1', '1', '2021-04-21 23:22:43', '2021-04-25 22:06:55');
INSERT INTO `adminuser` VALUES ('2', 'game', '698d51a19d8a121ce581499d7b701668', '2', '1', '2021-04-21 23:22:43', '2021-04-22 17:38:22');
INSERT INTO `adminuser` VALUES ('3', 'book', '698d51a19d8a121ce581499d7b701668', '3', '1', '2021-04-21 23:22:43', '2021-04-23 10:43:45');
INSERT INTO `adminuser` VALUES ('4', 'chan', '698d51a19d8a121ce581499d7b701668', '4', '1', '2021-04-21 23:22:43', null);
INSERT INTO `adminuser` VALUES ('5', 'chan3', '698d51a19d8a121ce581499d7b701668', '4', '0', '2021-04-21 23:22:43', null);
INSERT INTO `adminuser` VALUES ('6', 'chan4', '698d51a19d8a121ce581499d7b701668', '4', '0', '2021-04-21 23:22:43', null);
INSERT INTO `adminuser` VALUES ('7', 'chan5', '698d51a19d8a121ce581499d7b701668', '4', '0', '2021-04-21 23:22:43', null);
INSERT INTO `adminuser` VALUES ('8', 'admin111', '698d51a19d8a121ce581499d7b701668', '1', '1', '2021-04-22 16:54:29', '2021-04-22 16:59:30');
INSERT INTO `adminuser` VALUES ('9', 'admin1111', '698d51a19d8a121ce581499d7b701668', '1', '1', '2021-04-23 17:24:06', null);

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) DEFAULT NULL,
  `bookName` varchar(20) DEFAULT NULL,
  `authorName` varchar(30) DEFAULT NULL,
  `secondTypeId` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `coverUrl` varchar(100) DEFAULT NULL,
  `isCompletion` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `lastupchapter` varchar(100) DEFAULT NULL,
  `wordcount` int(11) DEFAULT NULL,
  PRIMARY KEY (`bid`),
  UNIQUE KEY `bookId` (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=100034 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('100000', '100000', '临渊行11223', '宅猪', '100', '　<本书已出版，各大网上平台及新华书店有售>\r\n苏云怎么也没有想到，自己生活了十几年的天门镇，只有自己是人。', 'url', '1', '0', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100001', '100001', '长夜余火', '爱潜水的乌贼', '101', '　灰土上所有人都相信，埋葬在危险和\r\n饥荒中的某个遗迹深处，有通往新世界的道路，只要能找到一把独特的钥匙，打开那扇门，就能进入\r\n新世界。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100002', '100002', '重生维京海盗王', '作者', '102', '<描述', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100003', '100003', '沧元图', '作者', '103', '<描述', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100004', '100004', '天启预报', '作者', '104', '<描述', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100005', '100005', '我就是死亡骑士', '作者', '105', '<描述', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100006', '100006', '天道方程式', '作者', '106', '<描述', 'url', '1', '0', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100007', '100007', '中古骑砍录', '作者', '107', '<描述', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100008', '100008', '大魏厂公', '作者', '108', '<描述', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100009', '100009', '金刚不坏大寨主', '作者', '109', '<描述', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100010', '100010', '青灯侠影', '作者', '110', '<描述', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100011', '100011', '如意事', '非10', '135', '青砖绿瓦，陌上花开香染衣；朱门紫殿，素手摘星霓作裳。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100012', '100012', '重生后我成了权臣的掌中娇', '风吹小白菜', '136', '南宝衣自幼锦衣玉食娇养长大，没想到\r\n所嫁非人，落了个家破人亡的凄惨下场。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100013', '100013', '农家小福女', '作者', '137', '青砖绿瓦，陌上花开香染衣；朱门紫殿，素手摘星霓作裳。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100014', '100014', '凤啼长安', '作者', '138', '青砖绿瓦，陌上花开香染衣；朱门紫殿，素手摘星霓作裳。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100015', '100015', '女尊之我可能是大佬', '作者', '139', '青砖绿瓦，陌上花开香染衣；朱门紫殿，素手摘星霓作裳。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100016', '100016', '穿越之直上青云', '作者', '140', '青砖绿瓦，陌上花开香染衣；朱门紫殿，素手摘星霓作裳。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100017', '100017', '师父又掉线了', '作者', '141', '青砖绿瓦，陌上花开香染衣；朱门紫殿，素手摘星霓作裳。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100018', '100018', '摘仙令', '作者', '142', '青砖绿瓦，陌上花开香染衣；朱门紫殿，素手摘星霓作裳。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100019', '100019', '女娲成长日记', '作者', '143', '青砖绿瓦，陌上花开香染衣；朱门紫殿，素手摘星霓作裳。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100020', '100020', '普普通通大师姐', '作者', '144', '青砖绿瓦，陌上花开香染衣；朱门紫殿，素手摘星霓作裳。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100021', '100021', '一线女法医', '逍遥游游', '145', '重生花样年华，玩转市井豪门，携手逆袭人生，共揽一世风云！', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100022', '100022', '退婚后她成了真祖宗', '病娇猫娘', '146', '苏家的废物千金苏也，被薄氏集团总裁退婚后疯了！\r\n第一天，她摸着父亲的头：“大侄子，我看好一个项目，明天你去竞标。”', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100023', '100023', '快穿之专业打脸指南 ', '凤栖桐', '147', '　安宁被主神系统控制做了无数世的女配和炮灰，有一天，她终于脱离了主神的控制，从此之后，安宁踏上了帮许许多多的炮灰女配逆袭、打脸之路。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100024', '100024', '分手后我在娱乐圈爆红了 ', '蓝白格子', '148', '　重生花样年华，玩转市井豪门，携手逆袭人生，共揽一世风云！', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100025', '100025', '大佬级炮灰 ', '蜗碎', '149', '天师界大佬符慕白在捉妖途中，被劈歪了的天雷打中，一命呜呼。\r\n再次醒来，大佬却成了三百年后的校园少女神棍！', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100026', '100026', '我在淘宝买老公 ', '曼仪', '150', '　陨落的世家千金，绝境中遭至亲抛弃，\r\n恍惚间打开淘宝，\r\n居然给自己买了一个腹黑霸道的帝王级老公。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100027', '100027', '穿越之民国明珠  ', '即墨伦珊', '151', '　　爱好网文阅读的制药工程师张美溪，穿越百年前的民国。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100028', '100028', '青藤心事——中学时代 ', '清颜令雪', '152', '　高二（5）的何诗菱数学考了65分，被选为班长；高二（5）的耿欣雨课堂上怼了年级组长，却被传为校园“小才女”。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100029', '100029', '阳光很暖你很远 ', '霜序八', '153', '　生命中遇见的每一个人，都是一场花开，每一场都灿烂美艳；', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100030', '100030', '贝姐有毒 ', '八月微澜', '154', '　前校园后都市，双强，甜宠，马甲，商战，微异能。', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100031', '100031', '暗恋休止符  ', '夕梨nunu', '155', '　我想带你看遍世间最美好的两情相悦\r\n我想让你听到暗恋休止后的浪漫心跳\r\n我想容你碰触情窦初开时的绯红面庞', 'url', '1', '1', '第788章：最后一个问题', '2026666');
INSERT INTO `books` VALUES ('100032', '100032', '小时代', '郭敬明', '147', '小时代', 'url', '0', '1', null, null);
INSERT INTO `books` VALUES ('100033', '100033', '111', '111', '147', '11111', 'url', '1', '1', null, null);

-- ----------------------------
-- Table structure for channel
-- ----------------------------
DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `typeId` varchar(30) DEFAULT NULL,
  `channelNumber` varchar(30) DEFAULT NULL,
  `channelPath` varchar(60) DEFAULT NULL,
  `productName` varchar(30) DEFAULT NULL,
  `showName` varchar(30) DEFAULT NULL,
  `area` varchar(30) DEFAULT NULL,
  `platform` int(2) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel
-- ----------------------------
INSERT INTO `channel` VALUES ('1', '1', '11111', 'www.baidu.com', '百度', '百度应用商店', '湖北', '2', '2021-04-21 17:10:57', '1', '备注');
INSERT INTO `channel` VALUES ('2', '2', '11161', 'huawei.com', '华为', '华为应用商店', '湖北', '2', '2021-04-21 17:10:57', '1', '备注');
INSERT INTO `channel` VALUES ('3', '2', '11211', 'xiaomi.com', '小米', '小米应用商店', '湖北', '2', '2021-04-21 17:10:57', '1', '备注');
INSERT INTO `channel` VALUES ('4', '1', '12111', 'coolapk.com', '酷安', '酷安', '湖北', '2', '2021-04-21 17:10:57', '1', '备注');
INSERT INTO `channel` VALUES ('5', '1', '11113', 'apple.com', '苹果', '应用商店', '湖北', '1', '2021-04-21 17:10:57', '1', '备注');
INSERT INTO `channel` VALUES ('6', '4', '981113', null, 'vivo', 'vivo应用商店', 'cn', '2', '2021-04-21 17:19:41', '0', '添加测试');
INSERT INTO `channel` VALUES ('7', '5', '98113', null, 'OPPO', 'oppo', 'cn', '2', '2021-04-21 17:48:55', '0', '测试333');
INSERT INTO `channel` VALUES ('8', '3', '123456', null, '测试1', '测试111', '111', '2', '2021-04-21 18:43:20', '0', '111');
INSERT INTO `channel` VALUES ('9', '3', '测试18', null, '11111', '11111', '111', '0', '2021-04-21 18:47:29', '0', '111');
INSERT INTO `channel` VALUES ('10', '3', '89994', 'http://192.168.3.158:8080/', '5+6', '1456', '12536251', '2', '2021-04-21 18:49:38', '1', '111');
INSERT INTO `channel` VALUES ('11', '5', '111111', null, '12', '1212', '4242', '2', '2021-04-21 18:54:01', '0', '7777');
INSERT INTO `channel` VALUES ('12', null, '111111', 'ab.com', '12', '1212', '4242', '2', '2021-04-21 18:54:31', '0', '7777');
INSERT INTO `channel` VALUES ('13', '6', 'ggg', null, 'ggg', 'gg', 'g', '2', '2021-04-21 20:51:03', '0', 'ggg');
INSERT INTO `channel` VALUES ('14', '5', 'gb', null, 'dsagf', 'fsd', 'dfs', '2', '2021-04-21 21:13:29', '0', 'fads');
INSERT INTO `channel` VALUES ('15', '1', '99999', 'hello.com', '1111', '222', '111', '0', '2021-04-22 19:21:28', '1', '111');
INSERT INTO `channel` VALUES ('16', '1', '999991', '1111', '11119', '222', '111', '0', '2021-04-22 19:21:57', '0', '111');
INSERT INTO `channel` VALUES ('17', '2', '1114454', null, '豌豆荚', '豌豆荚应用商店', '湖北', '0', '2021-04-22 22:39:51', '1', '');
INSERT INTO `channel` VALUES ('18', '18', '1114454', null, '豌豆荚', '豌豆荚应用商店', '湖北', '0', '2021-04-22 22:41:17', '1', '');
INSERT INTO `channel` VALUES ('19', '14', '9999', 'a.com', 'adsf', 'asdf', 'aaaa', '0', '2021-04-23 17:20:55', '1', '1111');

-- ----------------------------
-- Table structure for channeltype
-- ----------------------------
DROP TABLE IF EXISTS `channeltype`;
CREATE TABLE `channeltype` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(30) DEFAULT NULL,
  `parentId` int(11) NOT NULL,
  `note` varchar(30) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channeltype
-- ----------------------------
INSERT INTO `channeltype` VALUES ('1', '一级分类', '0', '备注111', '1', '2021-04-15 09:43:45');
INSERT INTO `channeltype` VALUES ('2', '二级分类', '1', '备注222', '1', '2021-04-15 09:44:21');
INSERT INTO `channeltype` VALUES ('3', '测试111', '1', '111', '1', '2021-04-20 15:49:26');
INSERT INTO `channeltype` VALUES ('4', '测试112', '0', '111', '0', '2021-04-20 15:52:01');
INSERT INTO `channeltype` VALUES ('5', '测试333', '1', '333', '0', '2021-04-20 15:58:05');
INSERT INTO `channeltype` VALUES ('6', '11112', '2', '222', '0', '2021-04-20 19:36:49');
INSERT INTO `channeltype` VALUES ('7', '测试ggg', '0', '备注111', '0', '2021-04-20 19:42:33');
INSERT INTO `channeltype` VALUES ('8', '999', '1', '0000', '0', '2021-04-20 19:44:21');
INSERT INTO `channeltype` VALUES ('9', '测试18', '2', '111', '0', '2021-04-21 18:37:48');
INSERT INTO `channeltype` VALUES ('10', 'ggg', '0', '0', '0', '2021-04-21 20:37:07');
INSERT INTO `channeltype` VALUES ('11', 'ggg', '1', '0000', '0', '2021-04-21 20:47:53');
INSERT INTO `channeltype` VALUES ('12', 'ggg1', '1', '0000', '0', '2021-04-21 20:49:12');
INSERT INTO `channeltype` VALUES ('13', 'fsdg', '0', 'fsdad', '0', '2021-04-21 22:55:25');
INSERT INTO `channeltype` VALUES ('14', 'dfas', '2', 'df', '1', '2021-04-21 23:29:27');
INSERT INTO `channeltype` VALUES ('15', 'dfasdfddsa', '2', 'df', '0', '2021-04-21 23:29:35');
INSERT INTO `channeltype` VALUES ('16', '测试1-1-2', '3', '测试1', '1', '2021-04-22 15:15:01');
INSERT INTO `channeltype` VALUES ('17', '测试1-2', '2', '测试1', '0', '2021-04-22 15:15:31');
INSERT INTO `channeltype` VALUES ('18', '22233', '1', '11111', '1', '2021-04-22 19:19:31');
INSERT INTO `channeltype` VALUES ('19', '测试5', '14', '111', '1', '2021-04-23 17:19:42');

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `bookId` int(11) DEFAULT NULL,
  `chapterId` int(11) NOT NULL AUTO_INCREMENT,
  `chaptername` varchar(30) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `chaptercontent` varchar(20000) DEFAULT NULL,
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('100001', '1', '章节名1', '0.15', '上回书说道……');
INSERT INTO `chapter` VALUES ('100001', '2', '章节名2', '0.15', '上回书说道……');
INSERT INTO `chapter` VALUES ('100001', '3', '章节名3', '0.15', '上回书说道……');
INSERT INTO `chapter` VALUES ('100000', '4', '章节名1', '0.15', '上回书说道……');
INSERT INTO `chapter` VALUES ('100000', '5', '章节名2', '0.15', '上回书说道……');
INSERT INTO `chapter` VALUES ('100000', '6', '章节名3', '0.15', '上回书说道……');

-- ----------------------------
-- Table structure for firsttype
-- ----------------------------
DROP TABLE IF EXISTS `firsttype`;
CREATE TABLE `firsttype` (
  `firstTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `firstTypeName` varchar(20) DEFAULT NULL,
  `attribution` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`firstTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of firsttype
-- ----------------------------
INSERT INTO `firsttype` VALUES ('1', '玄幻', '1', '1');
INSERT INTO `firsttype` VALUES ('2', '奇幻', '1', '1');
INSERT INTO `firsttype` VALUES ('3', '武侠', '1', '1');
INSERT INTO `firsttype` VALUES ('4', '仙侠', '1', '1');
INSERT INTO `firsttype` VALUES ('5', '都市', '1', '1');
INSERT INTO `firsttype` VALUES ('6', '现实', '1', '1');
INSERT INTO `firsttype` VALUES ('7', '军事', '1', '1');
INSERT INTO `firsttype` VALUES ('8', '历史', '1', '1');
INSERT INTO `firsttype` VALUES ('9', '古代言情', '2', '1');
INSERT INTO `firsttype` VALUES ('10', '仙侠奇缘', '2', '1');
INSERT INTO `firsttype` VALUES ('11', '现代言情', '2', '1');
INSERT INTO `firsttype` VALUES ('12', '浪漫青春', '2', '1');
INSERT INTO `firsttype` VALUES ('13', '玄幻言情', '2', '1');
INSERT INTO `firsttype` VALUES ('14', '悬疑推理', '2', '1');
INSERT INTO `firsttype` VALUES ('15', '科幻空间', '2', '1');
INSERT INTO `firsttype` VALUES ('16', '游戏竞技', '2', '1');

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game` (
  `gameId` int(11) NOT NULL AUTO_INCREMENT,
  `gameName` varchar(30) NOT NULL,
  `gameTitle` varchar(200) NOT NULL,
  `gameSize` float(10,2) NOT NULL,
  `gameIcon` varchar(200) DEFAULT NULL,
  `gameDetails` varchar(500) DEFAULT NULL,
  `iosUrl` varchar(200) DEFAULT NULL,
  `androidUrl` varchar(200) DEFAULT NULL,
  `gameDownloads` varchar(10) DEFAULT NULL,
  `gameRecommendType` int(1) NOT NULL,
  `State` int(1) NOT NULL,
  `gameClassify` int(11) NOT NULL,
  `gamePlatformType` int(1) NOT NULL,
  `gameOver` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`gameId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES ('1', 'LOL', '英雄联盟', '400.00', 'upload/gameIcon/1619148394007菜单管理_列表.png', 'upload/gameDetails/1619148395542权限管理_列表.png', 'upload/iosUrl/1619148396976菜单管理_列表.png', 'upload/androidUrl/1619148398626权限管理_列表.png', '19', '2', '1', '4', '2', '23323');
INSERT INTO `game` VALUES ('2', 'Dota', '多塔', '500.00', 'upload/gameIcon/1619148438602菜单管理_列表.png', 'upload/gameDetails/1619148440077权限管理_列表.png', 'upload/iosUrl/1619148441944菜单管理_列表.png', 'upload/androidUrl/1619148443351权限管理_添加.png', '7', '2', '1', '3', '2', '2323');
INSERT INTO `game` VALUES ('3', 'DNF', '毒奶粉', '700.00', 'upload/gameIcon/1619148513340菜单管理_列表.png', 'upload/gameDetails/1619148515268权限管理_添加.png', 'upload/iosUrl/1619148517140菜单管理_列表.png', 'upload/androidUrl/1619148518911权限管理_列表.png', '9', '2', '1', '4', '1', 'we');
INSERT INTO `game` VALUES ('4', 'CF', '穿越火线', '500.00', 'upload/gameIcon/1619148592395权限管理_添加.png', 'upload/gameDetails/1619148593974菜单管理_列表.png', 'upload/iosUrl/1619148595814权限管理_列表.png', 'upload/androidUrl/1619148597455菜单管理_列表.png', '7', '1', '1', '1', '1', '2323');
INSERT INTO `game` VALUES ('5', '植物大战僵尸', '植物大战僵尸', '123.00', 'upload/gameIcon/1619148698184菜单管理_列表.png', 'upload/gameDetails/1619148699869权限管理_列表.png', 'upload/iosUrl/1619148701455权限管理_添加.png', 'upload/androidUrl/1619148702984菜单管理_列表.png', '15', '2', '1', '4', '1', '2323');
INSERT INTO `game` VALUES ('6', '三国杀', '三国杀', '2323.00', 'upload/gameIcon/1619148732868权限管理_列表.png', 'upload/gameDetails/1619148734742权限管理_添加.png', 'upload/iosUrl/1619148739253权限管理_列表.png', 'upload/androidUrl/1619148736585菜单管理_列表.png', '9', '2', '1', '3', '1', '3232');
INSERT INTO `game` VALUES ('7', '合成大西瓜', '5546', '4646.00', 'upload/gameIcon/1619150048887无标题.png', 'upload/gameDetails/1619150051104对象.png', 'upload/iosUrl/1619150053239string.png', 'upload/androidUrl/1619150055136无标题.png', '3', '2', '1', '1', '2', '6+26+26');
INSERT INTO `game` VALUES ('8', 'asd', '88', '22.00', 'upload/gameIcon/1619159452542菜单管理_列表.png', 'upload/gameDetails/1619159454162权限管理_列表.png', 'upload/iosUrl/1619159456502权限管理_添加.png', 'upload/androidUrl/1619159458310菜单管理_列表.png', '1', '1', '0', '1', '1', '2323');
INSERT INTO `game` VALUES ('10', '111', '111', '111.00', 'upload/gameIcon/1619162612487权限管理_添加.png', 'upload/gameDetails/1619162612487权限管理_列表.png', 'upload/iosUrl/1619162612487权限管理_添加.png', 'upload/androidUrl/1619162612487权限管理_列表.png', '0', '2', '1', '4', '1', '213213213213');
INSERT INTO `game` VALUES ('11', '2122', '222', '222.00', 'upload/gameIcon/16191702261454.jpg', 'upload/gameDetails/16191702261454.jpg', 'upload/iosUrl/16191702261454.jpg', 'upload/androidUrl/16191702261454.jpg', '0', '1', '0', '6', '1', '33333');

-- ----------------------------
-- Table structure for gameclass
-- ----------------------------
DROP TABLE IF EXISTS `gameclass`;
CREATE TABLE `gameclass` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gameclass
-- ----------------------------
INSERT INTO `gameclass` VALUES ('1', '休闲益智');
INSERT INTO `gameclass` VALUES ('2', '网络游戏');
INSERT INTO `gameclass` VALUES ('3', '动作冒险');
INSERT INTO `gameclass` VALUES ('4', '棋牌中心');
INSERT INTO `gameclass` VALUES ('5', '飞行射击');
INSERT INTO `gameclass` VALUES ('6', '经营策略');
INSERT INTO `gameclass` VALUES ('7', '角色扮演');
INSERT INTO `gameclass` VALUES ('8', '体育竞技');

-- ----------------------------
-- Table structure for gametype
-- ----------------------------
DROP TABLE IF EXISTS `gametype`;
CREATE TABLE `gametype` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `gameRecommendTypes` varchar(20) DEFAULT NULL,
  `states` varchar(20) DEFAULT NULL,
  `gamePlatformTypes` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gametype
-- ----------------------------
INSERT INTO `gametype` VALUES ('1', '普通', '启用', 'android');
INSERT INTO `gametype` VALUES ('2', '首页推荐', '未启用', 'ios');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `mid` int(4) NOT NULL AUTO_INCREMENT,
  `menuIcon` varchar(40) DEFAULT NULL,
  `menuName` varchar(20) DEFAULT NULL,
  `menuUrl` varchar(60) DEFAULT NULL,
  `parentId` int(2) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', 'el-icon-s-shop', '游戏管理', '', '0', '1');
INSERT INTO `menu` VALUES ('2', 'el-icon-s-home', '书籍管理', '', '0', '1');
INSERT INTO `menu` VALUES ('3', 'el-icon-s-marketing', '渠道管理', '', '0', '1');
INSERT INTO `menu` VALUES ('4', 'el-icon-odometer', '权限管理', '', '0', '1');
INSERT INTO `menu` VALUES ('5', 'el-icon-user-solid', '用户管理', '', '0', '1');
INSERT INTO `menu` VALUES ('6', 'el-icon-s-shop', '游戏管理', 'gameServlet.do?type=queryGame', '1', '1');
INSERT INTO `menu` VALUES ('7', 'el-icon-s-shop', '游戏类型', 'gameServlet.do?type=queryGame', '1', '1');
INSERT INTO `menu` VALUES ('8', 'el-icon-s-fold', '书籍信息', 'book.jsp', '2', '1');
INSERT INTO `menu` VALUES ('9', 'el-icon-s-marketing', '渠道种类', 'showChannelType.jsp', '3', '1');
INSERT INTO `menu` VALUES ('10', 'el-icon-s-marketing', '渠道管理', 'showChannel.jsp', '3', '1');
INSERT INTO `menu` VALUES ('11', 'el-icon-s-fold', '菜单管理', 'showMenu.jsp', '4', '1');
INSERT INTO `menu` VALUES ('12', 'el-icon-s-custom', '角色管理', 'showRole.jsp', '4', '1');
INSERT INTO `menu` VALUES ('13', 'el-icon-user', '用户管理', 'showAllAdminUser.jsp', '5', '1');
INSERT INTO `menu` VALUES ('14', '', '55555', '123.jsp', '5', '1');
INSERT INTO `menu` VALUES ('15', 'el-icon-user-solid', '测试菜单', 'hello.html', '0', '0');
INSERT INTO `menu` VALUES ('16', 'el-icon-s-fold', '测试111', 'test.jsp', '15', '0');
INSERT INTO `menu` VALUES ('17', 'el-icon-s-marketing', '测试233', '233.jsp', '3', '0');
INSERT INTO `menu` VALUES ('18', 'el-icon-s-fold', '测试111', '1111', '5', '0');
INSERT INTO `menu` VALUES ('19', 'el-icon-s-fold', '测试1112', '1111', '5', '1');

-- ----------------------------
-- Table structure for platform
-- ----------------------------
DROP TABLE IF EXISTS `platform`;
CREATE TABLE `platform` (
  `id` int(2) DEFAULT NULL,
  `platformname` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platform
-- ----------------------------
INSERT INTO `platform` VALUES ('0', 'all');
INSERT INTO `platform` VALUES ('1', 'iOS');
INSERT INTO `platform` VALUES ('2', 'Android');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(4) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) NOT NULL,
  `state` int(2) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '1');
INSERT INTO `role` VALUES ('2', '游戏管理员', '1');
INSERT INTO `role` VALUES ('3', '书籍管理员', '1');
INSERT INTO `role` VALUES ('4', '渠道管理员', '1');

-- ----------------------------
-- Table structure for roleandmenu
-- ----------------------------
DROP TABLE IF EXISTS `roleandmenu`;
CREATE TABLE `roleandmenu` (
  `rid` int(11) DEFAULT NULL,
  `menuId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roleandmenu
-- ----------------------------
INSERT INTO `roleandmenu` VALUES ('2', '1');
INSERT INTO `roleandmenu` VALUES ('2', '6');
INSERT INTO `roleandmenu` VALUES ('2', '7');
INSERT INTO `roleandmenu` VALUES ('4', '3');
INSERT INTO `roleandmenu` VALUES ('4', '9');
INSERT INTO `roleandmenu` VALUES ('4', '10');
INSERT INTO `roleandmenu` VALUES ('3', '2');
INSERT INTO `roleandmenu` VALUES ('3', '8');
INSERT INTO `roleandmenu` VALUES ('1', '1');
INSERT INTO `roleandmenu` VALUES ('1', '6');
INSERT INTO `roleandmenu` VALUES ('1', '7');
INSERT INTO `roleandmenu` VALUES ('1', '2');
INSERT INTO `roleandmenu` VALUES ('1', '8');
INSERT INTO `roleandmenu` VALUES ('1', '3');
INSERT INTO `roleandmenu` VALUES ('1', '9');
INSERT INTO `roleandmenu` VALUES ('1', '10');
INSERT INTO `roleandmenu` VALUES ('1', '4');
INSERT INTO `roleandmenu` VALUES ('1', '11');
INSERT INTO `roleandmenu` VALUES ('1', '12');
INSERT INTO `roleandmenu` VALUES ('1', '5');
INSERT INTO `roleandmenu` VALUES ('1', '13');
INSERT INTO `roleandmenu` VALUES ('1', '14');
INSERT INTO `roleandmenu` VALUES ('1', '19');

-- ----------------------------
-- Table structure for secondtype
-- ----------------------------
DROP TABLE IF EXISTS `secondtype`;
CREATE TABLE `secondtype` (
  `secondTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `secondTypeName` varchar(20) DEFAULT NULL,
  `firstTypeId` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`secondTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of secondtype
-- ----------------------------
INSERT INTO `secondtype` VALUES ('100', '东方玄幻', '1', '1');
INSERT INTO `secondtype` VALUES ('101', '异世大陆', '1', '1');
INSERT INTO `secondtype` VALUES ('102', '王朝争霸', '1', '1');
INSERT INTO `secondtype` VALUES ('103', '高武世界', '1', '1');
INSERT INTO `secondtype` VALUES ('104', '现代魔法', '2', '1');
INSERT INTO `secondtype` VALUES ('105', '剑与魔法', '2', '1');
INSERT INTO `secondtype` VALUES ('106', '史诗奇幻', '2', '1');
INSERT INTO `secondtype` VALUES ('107', '黑暗幻想', '2', '1');
INSERT INTO `secondtype` VALUES ('108', '传统武侠', '3', '1');
INSERT INTO `secondtype` VALUES ('109', '武侠幻想', '3', '1');
INSERT INTO `secondtype` VALUES ('110', '国术无双', '3', '1');
INSERT INTO `secondtype` VALUES ('111', '修真文明', '4', '1');
INSERT INTO `secondtype` VALUES ('112', '幻想修仙', '4', '1');
INSERT INTO `secondtype` VALUES ('113', '现代修真', '4', '1');
INSERT INTO `secondtype` VALUES ('114', '神话修真', '4', '1');
INSERT INTO `secondtype` VALUES ('115', '爱情婚姻', '5', '1');
INSERT INTO `secondtype` VALUES ('116', '都市生活', '5', '1');
INSERT INTO `secondtype` VALUES ('117', '都市异能', '5', '1');
INSERT INTO `secondtype` VALUES ('118', '异术超能', '5', '1');
INSERT INTO `secondtype` VALUES ('119', '青春校园', '5', '1');
INSERT INTO `secondtype` VALUES ('120', '娱乐明星', '5', '1');
INSERT INTO `secondtype` VALUES ('121', '社会乡土', '6', '1');
INSERT INTO `secondtype` VALUES ('122', '爱情婚姻', '6', '1');
INSERT INTO `secondtype` VALUES ('123', '现实百态', '6', '1');
INSERT INTO `secondtype` VALUES ('124', '军旅生涯', '7', '1');
INSERT INTO `secondtype` VALUES ('125', '军事战争', '7', '1');
INSERT INTO `secondtype` VALUES ('126', '战争幻想', '7', '1');
INSERT INTO `secondtype` VALUES ('127', '抗战烽火', '7', '1');
INSERT INTO `secondtype` VALUES ('128', '谍战特工', '7', '1');
INSERT INTO `secondtype` VALUES ('129', '架空历史', '8', '1');
INSERT INTO `secondtype` VALUES ('130', '秦汉三国', '8', '1');
INSERT INTO `secondtype` VALUES ('131', '两晋隋唐', '8', '1');
INSERT INTO `secondtype` VALUES ('132', '两宋元明', '8', '1');
INSERT INTO `secondtype` VALUES ('133', '清史民国', '8', '1');
INSERT INTO `secondtype` VALUES ('134', '外国历史', '8', '1');
INSERT INTO `secondtype` VALUES ('135', '古代情缘', '9', '1');
INSERT INTO `secondtype` VALUES ('136', '宫闱宅斗', '9', '1');
INSERT INTO `secondtype` VALUES ('137', '经商种田', '9', '1');
INSERT INTO `secondtype` VALUES ('138', '古典架空', '9', '1');
INSERT INTO `secondtype` VALUES ('139', '女尊王朝', '9', '1');
INSERT INTO `secondtype` VALUES ('140', '穿越奇情', '9', '1');
INSERT INTO `secondtype` VALUES ('141', '武侠情缘', '10', '1');
INSERT INTO `secondtype` VALUES ('142', '古典仙侠', '10', '1');
INSERT INTO `secondtype` VALUES ('143', '现代修真', '10', '1');
INSERT INTO `secondtype` VALUES ('144', '远古洪荒', '10', '1');
INSERT INTO `secondtype` VALUES ('145', '商战职场', '11', '1');
INSERT INTO `secondtype` VALUES ('146', '豪门世家', '11', '1');
INSERT INTO `secondtype` VALUES ('147', '都市生活', '11', '1');
INSERT INTO `secondtype` VALUES ('148', '娱乐明星', '11', '1');
INSERT INTO `secondtype` VALUES ('149', '都市异能', '11', '1');
INSERT INTO `secondtype` VALUES ('150', '极道江湖', '11', '1');
INSERT INTO `secondtype` VALUES ('151', '民国情缘', '11', '1');
INSERT INTO `secondtype` VALUES ('152', '青春校园', '12', '1');
INSERT INTO `secondtype` VALUES ('153', '青春疼痛', '12', '1');
INSERT INTO `secondtype` VALUES ('154', '叛逆成长', '12', '1');
INSERT INTO `secondtype` VALUES ('155', '青春纯爱', '12', '1');
INSERT INTO `secondtype` VALUES ('156', '东方玄幻', '13', '1');
INSERT INTO `secondtype` VALUES ('157', '异世大陆', '13', '1');
INSERT INTO `secondtype` VALUES ('158', '西方奇幻', '13', '1');
INSERT INTO `secondtype` VALUES ('159', '远古神话', '13', '1');
INSERT INTO `secondtype` VALUES ('160', '异族恋情', '13', '1');
INSERT INTO `secondtype` VALUES ('161', '魔法幻情', '13', '1');
INSERT INTO `secondtype` VALUES ('162', '推理侦探', '14', '1');
INSERT INTO `secondtype` VALUES ('163', '诡秘惊险', '14', '1');
INSERT INTO `secondtype` VALUES ('164', '悬疑探险', '14', '1');
INSERT INTO `secondtype` VALUES ('165', '奇妙世界', '14', '1');
INSERT INTO `secondtype` VALUES ('166', '神秘文化', '14', '1');
INSERT INTO `secondtype` VALUES ('167', '星际恋歌', '15', '1');
INSERT INTO `secondtype` VALUES ('168', '时空穿梭', '15', '1');
INSERT INTO `secondtype` VALUES ('169', '未来世界', '15', '1');
INSERT INTO `secondtype` VALUES ('170', '古武机甲', '15', '1');
INSERT INTO `secondtype` VALUES ('171', '超级科技', '15', '1');
INSERT INTO `secondtype` VALUES ('172', '进化变异', '15', '1');
INSERT INTO `secondtype` VALUES ('173', '末世危机', '15', '1');
INSERT INTO `secondtype` VALUES ('174', '电子竞技', '16', '1');
INSERT INTO `secondtype` VALUES ('175', '网游情缘', '16', '1');
INSERT INTO `secondtype` VALUES ('176', '游戏异界', '16', '1');
INSERT INTO `secondtype` VALUES ('177', '体育竞技', '16', '1');

-- ----------------------------
-- Table structure for suggestion
-- ----------------------------
DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion` (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `suggestion` varchar(100) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `platform` varchar(20) DEFAULT NULL,
  `os` int(2) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of suggestion
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `pwd` varchar(40) DEFAULT NULL,
  `headpic` varchar(40) DEFAULT NULL,
  `headpicthumb` varchar(40) DEFAULT NULL,
  `des` varchar(40) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `avatarcolor` varchar(40) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `grade` int(20) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

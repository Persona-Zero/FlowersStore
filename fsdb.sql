/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : flower

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2023-11-21 22:25:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `carts`
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(11) DEFAULT NULL,
  `flower` varchar(255) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `flower` (`flower`),
  KEY `uid` (`uid`),
  KEY `fk2` (`fid`),
  CONSTRAINT `carts_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `users` (`id`),
  CONSTRAINT `fk2` FOREIGN KEY (`fid`) REFERENCES `flowers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carts
-- ----------------------------

-- ----------------------------
-- Table structure for `flowers`
-- ----------------------------
DROP TABLE IF EXISTS `flowers`;
CREATE TABLE `flowers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `species_name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `img_guid` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT '1' COMMENT '商品状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `species_name` (`species_name`),
  CONSTRAINT `flowers_ibfk_1` FOREIGN KEY (`species_name`) REFERENCES `species` (`species_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flowers
-- ----------------------------
INSERT INTO `flowers` VALUES ('1', '鲜花', '春日', '23', 'vvv', '002dc799ac5641e3a6ad0033a0138aee.jpg', '1');
INSERT INTO `flowers` VALUES ('2', '梅花', '夏日', '34', 'ddd', '4ab3adfdfc444f4ebbb783e92cb9f22f.jpg', '1');
INSERT INTO `flowers` VALUES ('3', '荷花', '夏日', '22', 'ddd', 'hehua.jpg', '1');
INSERT INTO `flowers` VALUES ('4', '玫瑰', '秋日', '999.99', 'SSS', 'e3dd46c6943c46d09ad92872b2715dc5.jpg', '1');
INSERT INTO `flowers` VALUES ('5', 'test', '夏日', '56.36', 'testtest', 'meigui.jpg', '1');
INSERT INTO `flowers` VALUES ('6', null, null, null, null, '', '1');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_guid` varchar(255) DEFAULT NULL,
  `flower` varchar(255) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `flower` (`flower`),
  KEY `uid` (`uid`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('5', null, '鲜花', '1', '23', '1', '1');
INSERT INTO `orders` VALUES ('12', null, '鲜花', '1', '23', '0', '1');
INSERT INTO `orders` VALUES ('13', null, '梅花', '1', '34', '0', '1');
INSERT INTO `orders` VALUES ('17', null, '鲜花', '1', '23', '0', '1');
INSERT INTO `orders` VALUES ('18', null, '梅花', '1', '34', '0', '1');
INSERT INTO `orders` VALUES ('19', null, '荷花', '1', '22', '0', '1');
INSERT INTO `orders` VALUES ('20', null, 'test', '1', '56.36', '0', '1');
INSERT INTO `orders` VALUES ('21', null, '玫瑰', '1', '999.99', '0', '1');
INSERT INTO `orders` VALUES ('22', null, '鲜花', '1', '23', '0', '1');
INSERT INTO `orders` VALUES ('23', null, '梅花', '1', '34', '0', '1');
INSERT INTO `orders` VALUES ('24', null, '荷花', '1', '22', '0', '1');

-- ----------------------------
-- Table structure for `species`
-- ----------------------------
DROP TABLE IF EXISTS `species`;
CREATE TABLE `species` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `species_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `species` (`species_name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of species
-- ----------------------------
INSERT INTO `species` VALUES ('8', null);
INSERT INTO `species` VALUES ('7', '冬日');
INSERT INTO `species` VALUES ('11', '友情花');
INSERT INTO `species` VALUES ('2', '夏日');
INSERT INTO `species` VALUES ('9', '情人花');
INSERT INTO `species` VALUES ('1', '春日');
INSERT INTO `species` VALUES ('3', '秋日');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'zhangsan', '张三', 'zhangsan', '13566662222', '北京市昌平区2号', 'user');
INSERT INTO `users` VALUES ('2', 'admin', '系统管理员', 'admin', '123456', '上海市黄浦区南京西路8号', 'admin');
INSERT INTO `users` VALUES ('3', 'dddddd', 'dddddd', 'dddddd', '12141241412', 'dddddd', 'user');
INSERT INTO `users` VALUES ('9', 'test', 'test', 'test', '13122223365', 'ceshi', 'user');

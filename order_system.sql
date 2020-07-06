/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : order_system

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-07-06 09:12:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for system_order
-- ----------------------------
DROP TABLE IF EXISTS `system_order`;
CREATE TABLE `system_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `product_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `out_trade_no` varchar(255) COLLATE utf8_bin NOT NULL,
  `order_status` tinyint(1) NOT NULL,
  `pay_type` varchar(20) COLLATE utf8_bin NOT NULL,
  `order_time` datetime NOT NULL,
  `order_price` decimal(10,0) NOT NULL,
  `order_address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `order_pay_time` datetime DEFAULT NULL,
  `is_del` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of system_order
-- ----------------------------
INSERT INTO `system_order` VALUES ('3', '2', null, '1', null, '234', '1', '', '2020-06-11 08:46:26', '13', null, null, null);
INSERT INTO `system_order` VALUES ('10', '1', null, '2', null, '112', '1', '', '2020-06-11 00:00:00', '14', null, null, null);
INSERT INTO `system_order` VALUES ('13', '1', null, '2', null, '20200611115158753', '1', '', '2020-06-11 00:00:00', '14', null, null, null);
INSERT INTO `system_order` VALUES ('14', '1', null, '2', null, '20200611130909290', '1', '', '2020-06-11 00:00:00', '14', null, null, null);
INSERT INTO `system_order` VALUES ('15', '1', null, '2', null, '20200611130959946', '1', '', '2020-06-11 00:00:00', '141', null, null, null);
INSERT INTO `system_order` VALUES ('16', '1', null, '2', null, '20200611131342009', '1', '', '2020-06-11 00:00:00', '141', null, null, null);
INSERT INTO `system_order` VALUES ('17', '1', null, '2', null, '20200611131507911', '1', '', '2020-06-11 00:00:00', '141', null, null, null);
INSERT INTO `system_order` VALUES ('18', '1', null, '2', null, '20200611131649354', '1', '', '2020-06-11 00:00:00', '141', null, null, null);
INSERT INTO `system_order` VALUES ('19', '1', null, '2', null, '20200611132015401', '1', '', '2020-06-11 00:00:00', '141', null, null, null);
INSERT INTO `system_order` VALUES ('20', '1', null, '2', null, '20200611140143984', '1', '', '2020-06-11 00:00:00', '141', null, null, null);
INSERT INTO `system_order` VALUES ('21', '1', null, '2', null, '20200611140333789', '1', '', '2020-06-11 00:00:00', '141', null, null, null);
INSERT INTO `system_order` VALUES ('22', '2', null, '1', null, '20200611141927667', '1', '', '2020-06-11 00:00:00', '141', null, null, null);
INSERT INTO `system_order` VALUES ('23', '1', null, '2', null, '20200611141927223', '1', '', '2020-06-11 00:00:00', '141', null, null, null);
INSERT INTO `system_order` VALUES ('24', '1', null, '2', null, '20200611184424382', '1', '', '2020-06-11 00:00:00', '3', null, null, null);
INSERT INTO `system_order` VALUES ('25', '1', null, '2', null, '20200611184645762', '1', '', '2020-06-11 00:00:00', '3', null, null, null);
INSERT INTO `system_order` VALUES ('26', '1', null, '2', null, '20200611184707210', '1', '', '2020-06-11 00:00:00', '3', null, null, null);
INSERT INTO `system_order` VALUES ('27', '2', null, '1', null, '20200611201102822', '1', '', '2020-06-11 00:00:00', '1', null, null, null);
INSERT INTO `system_order` VALUES ('28', '2', null, '1', null, '20200611201514552', '1', '', '2020-06-11 00:00:00', '1', null, null, null);
INSERT INTO `system_order` VALUES ('29', '1', null, '2', null, '20200612093421075', '1', '', '2020-06-12 00:00:00', '3', null, null, null);
INSERT INTO `system_order` VALUES ('30', '2', null, '1', null, '20200612110138464', '1', '', '2020-06-12 00:00:00', '1', null, null, null);
INSERT INTO `system_order` VALUES ('31', '1', null, '2', null, '20200612110138023', '1', '', '2020-06-12 00:00:00', '3', null, null, null);
INSERT INTO `system_order` VALUES ('32', '1', 'test1', '2', 'apple', '20200612122011637', '1', '', '2020-06-12 00:00:00', '22', null, null, null);
INSERT INTO `system_order` VALUES ('33', '1', 'test1', '1', 'banana', '20200705214650956', '1', 'wechat', '2020-07-05 00:00:00', '1', null, null, null);
INSERT INTO `system_order` VALUES ('34', '1', 'test1', '1', 'banana', '20200705214857515', '1', 'wechat', '2020-07-05 00:00:00', '1', null, null, null);
INSERT INTO `system_order` VALUES ('35', '1', 'test1', '2', 'apple', '20200706002749654', '1', 'wechat', '2020-07-06 00:00:00', '3', null, null, null);

-- ----------------------------
-- Table structure for system_product
-- ----------------------------
DROP TABLE IF EXISTS `system_product`;
CREATE TABLE `system_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `product_price` decimal(20,0) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of system_product
-- ----------------------------
INSERT INTO `system_product` VALUES ('1', 'banana', '1');
INSERT INTO `system_product` VALUES ('2', 'apple', '3');
INSERT INTO `system_product` VALUES ('3', 'wahaha', '10');
INSERT INTO `system_product` VALUES ('4', 'Chocolates', '50');

-- ----------------------------
-- Table structure for system_receiver_address
-- ----------------------------
DROP TABLE IF EXISTS `system_receiver_address`;
CREATE TABLE `system_receiver_address` (
  `address_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `address_country` varchar(255) NOT NULL,
  `address_province` varchar(255) NOT NULL,
  `address_city` varchar(255) NOT NULL,
  `address_street` varchar(255) DEFAULT NULL,
  `address_detail` varchar(255) NOT NULL,
  `address_receiver_phone` varchar(30) NOT NULL,
  `address_receiver_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_receiver_address
-- ----------------------------
INSERT INTO `system_receiver_address` VALUES ('1', '1', 'china', 'hunan', 'changsha', 'luelvqu', 'CLP software country', '123445668899', 'nice');

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `user_pwd` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1', 'test1', '123');
INSERT INTO `system_user` VALUES ('2', 'test2', '345');

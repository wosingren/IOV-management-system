/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50163
Source Host           : localhost:3306
Source Database       : cartocar

Target Server Type    : MYSQL
Target Server Version : 50163
File Encoding         : 65001

Date: 2017-02-04 22:11:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for usr
-- ----------------------------
DROP TABLE IF EXISTS `usr`;
CREATE TABLE `usr` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `devId` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of usr
-- ----------------------------
INSERT INTO `usr` VALUES ('zhangyong', '123', '1', '0');
INSERT INTO `usr` VALUES ('tom', '123', '2', '1');
INSERT INTO `usr` VALUES ('jerry', '123', '3', '0');

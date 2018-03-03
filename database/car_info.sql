/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50163
Source Host           : localhost:3306
Source Database       : cartocar

Target Server Type    : MYSQL
Target Server Version : 50163
File Encoding         : 65001

Date: 2017-02-04 22:51:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car_info
-- ----------------------------
DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `devID` char(17) DEFAULT 'NULL',
  `time` datetime DEFAULT NULL,
  `state` char(4) DEFAULT 'NULL',
  `GPS_longitude` char(10) DEFAULT 'NULL',
  `GPS_latitude` char(9) DEFAULT 'NULL',
  `cellID` char(8) DEFAULT 'NULL',
  `carNum` char(5) DEFAULT 'NULL',
  `warn` char(4) DEFAULT 'NULL',
  `info1_devID` char(17) DEFAULT 'NULL',
  `info1_FP` char(4) DEFAULT 'NULL',
  `info1_RP` char(4) DEFAULT 'NULL',
  `info1_time` datetime DEFAULT NULL,
  `info1_state` char(4) DEFAULT 'NULL',
  `info1_longitude` char(9) DEFAULT 'NULL',
  `info1_latitude` char(8) DEFAULT 'NULL',
  `info1_cellID` char(8) DEFAULT 'NULL',
  `info1_carNum` char(5) DEFAULT 'NULL',
  `info2_devID` char(17) DEFAULT 'NULL',
  `info2_FP` char(4) DEFAULT 'NULL',
  `info2_RP` char(4) DEFAULT 'NULL',
  `info2_time` datetime DEFAULT NULL,
  `info2_state` char(4) DEFAULT 'NULL',
  `info2_longitude` char(9) DEFAULT 'NULL',
  `info2_latitude` char(8) DEFAULT 'NULL',
  `info2_cellID` char(8) DEFAULT 'NULL',
  `info2_carNum` char(5) DEFAULT 'NULL',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car_info
-- ----------------------------
INSERT INTO `car_info` VALUES ('1', '1', '2017-01-17 21:45:16', '1', '116.361343', '39.960533', '1000', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('2', '1', '2017-01-17 21:50:11', '2', '116.361123', '39.964973', '1001', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('3', '1', '2017-01-17 21:55:23', '3', '116.360913', '39.967143', '1002', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('4', '1', '2017-01-17 22:00:29', '4', '116.358553', '39.967643', '1000', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('5', '1', '2017-01-17 22:05:41', '1', '116.355583', '39.967743', '1111', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('6', '1', '2017-01-17 22:10:51', '1', '116.354903', '39.966623', '2222', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('7', '2', '2017-01-17 22:50:03', '1', '116.354853', '39.963233', '1111', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('8', '3', '2017-01-17 23:50:15', '3', '116.354983', '39.961263', '1111', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('9', '4', '2017-01-17 21:50:24', '4', '116.352643', '39.958593', '1111', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('10', '2', '2017-01-17 19:08:14', '1', '116.352640', '39.958590', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('11', '2', '2017-01-17 19:12:19', '2', '116.361120', '39.964970', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('12', '2', '2017-01-17 20:08:30', '3', '116.360910', '39.967140', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('13', '2', '2017-01-17 20:11:35', '4', '116.358550', '39.967640', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('14', '3', '2017-01-17 20:08:46', '1', '116.355588', '39.966628', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('15', '3', '2017-01-17 21:09:02', '1', '116.354909', '39.966629', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('16', '3', '2017-01-17 19:18:10', '2', '116.354918', '39.966638', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('17', '4', '2017-01-17 19:24:42', '1', '116.354318', '39.966138', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('18', '4', '2017-01-17 19:30:47', '2', '116.354609', '39.966229', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('19', '4', '2017-01-17 19:35:55', '3', '116.358050', '39.967340', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');
INSERT INTO `car_info` VALUES ('20', '1', '2017-01-17 23:31:00', '1', '116.350318', '39.960229', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', 'NULL', null, 'NULL', 'NULL', 'NULL', 'NULL', 'NULL');

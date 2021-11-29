/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : swufind

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 25/11/2021 22:08:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tab_category
-- ----------------------------
DROP TABLE IF EXISTS `tab_category`;
CREATE TABLE `tab_category`  (
  `cid` int(11) NOT NULL,
  `cname` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tab_category
-- ----------------------------
INSERT INTO `tab_category` VALUES (1, '主页');
INSERT INTO `tab_category` VALUES (2, '寻人');
INSERT INTO `tab_category` VALUES (3, '寻物');
INSERT INTO `tab_category` VALUES (4, '其他');
INSERT INTO `tab_category` VALUES (5, '联系我们');

-- ----------------------------
-- Table structure for tab_detail
-- ----------------------------
DROP TABLE IF EXISTS `tab_detail`;
CREATE TABLE `tab_detail`  (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `intro` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `cid` int(11) NOT NULL,
  `rimage` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tab_detail
-- ----------------------------
INSERT INTO `tab_detail` VALUES (1, 'find people', 'my name is mark', 'I am intersted in watching films', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (2, 'find people', 'my name is mark', 'I am intersted in watching films', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (3, 'find things', 'my name is jason', 'I am intersted in watching films', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (4, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (5, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (6, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (7, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (8, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (9, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (10, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (11, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (12, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (13, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (14, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (15, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (16, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (17, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (18, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (19, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (20, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (21, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (22, 'find things', 'my name is jason', 'I am interested in playing football', 2, 'images/04-search_03.jpg');
INSERT INTO `tab_detail` VALUES (23, 'find things', 'my name is Chris', 'I am interested in watching comic Animation', 2, '8504219.jpg');

SET FOREIGN_KEY_CHECKS = 1;

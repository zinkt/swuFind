/*
 Navicat Premium Data Transfer

 Source Server         : zinkt
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : swuFind

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 13/11/2021 17:54:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tab_user
-- ----------------------------
DROP TABLE IF EXISTS `tab_user`;
CREATE TABLE `tab_user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `AK_nq_username`(`username`) USING BTREE,
  UNIQUE INDEX `AK_nq_code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tab_user
-- ----------------------------
INSERT INTO `tab_user` VALUES (10, 'zinktzinkt', 'wujiacheng', '吴嘉诚', '2021-11-04', '男', '18011662763', 'zinkt@foxmail.com', 'Y', '4e7a4e5b62e440218c85bb6390e97053');
INSERT INTO `tab_user` VALUES (11, 'gedonglin', 'gedonglin', 'gedongl', '2021-11-12', '男', '1021740831', '9184128@qq.com', 'N', 'dfba9240f162412f9a0ce58ae69a4015');
INSERT INTO `tab_user` VALUES (12, 'panlong000', 'panlong000', 'panlong', '2021-11-02', '男', '19784652146', 'zinkt@foxmail.com', 'Y', 'fba42f5b0a804ba6ab72f56676e06d10');

SET FOREIGN_KEY_CHECKS = 1;

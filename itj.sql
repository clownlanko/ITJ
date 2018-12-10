/*
 Navicat Premium Data Transfer

 Source Server         : VI
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : itj

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 10/12/2018 01:38:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for itj_article
-- ----------------------------
DROP TABLE IF EXISTS `itj_article`;
CREATE TABLE `itj_article`  (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `like_quantity` int(11) NULL DEFAULT 0,
  `look_quantity` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for itj_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `itj_article_tag`;
CREATE TABLE `itj_article_tag`  (
  `article_id` int(11) NULL DEFAULT NULL,
  `tag_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for itj_tag
-- ----------------------------
DROP TABLE IF EXISTS `itj_tag`;
CREATE TABLE `itj_tag`  (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE,
  UNIQUE INDEX `tag_name`(`tag_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for itj_user
-- ----------------------------
DROP TABLE IF EXISTS `itj_user`;
CREATE TABLE `itj_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `head_photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `autograph` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `join_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `account`(`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

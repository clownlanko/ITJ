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

 Date: 21/12/2018 00:28:55
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
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `like_quantity` int(11) NULL DEFAULT 0,
  `look_quantity` int(11) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for itj_article_commont
-- ----------------------------
DROP TABLE IF EXISTS `itj_article_commont`;
CREATE TABLE `itj_article_commont`  (
  `commont_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `article_id` int(11) NULL DEFAULT NULL,
  `commont` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`commont_id`) USING BTREE
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
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Procedure structure for proc_delete_article
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_delete_article`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_delete_article`(id INT,OUT success INT)
BEGIN
  DECLARE error_count ,commont_count,tag_count INT;
  SET error_count=0,commont_count=0,tag_count=0;
#   删除关于文章的评论
  IF EXISTS(SELECT commont_count=COUNT(article_id) FROM itj_article_commont WHERE article_id=id)
    THEN
    DELETE FROM itj_article_commont WHERE article_id=id;
    SET error_count = error_count+commont_count;
  END IF ;
#   删除关于文章的标签
  IF EXISTS(SELECT tag_count=COUNT(article_id) FROM itj_article_tag WHERE article_id=id)
    THEN
    DELETE FROM itj_article_tag WHERE article_id=id;
    SET error_count= error_count+tag_count;
  END IF;
#   删除文章
  DELETE FROM itj_article WHERE article_id=id;
  SET error_count = error_count+1;
  IF(error_count = commont_count+tag_count+1)
  THEN SET success=1;
  ELSE SET success=0;
  END IF;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;

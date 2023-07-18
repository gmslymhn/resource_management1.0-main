/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : resourcemanagement

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 18/07/2023 15:37:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for assets
-- ----------------------------
DROP TABLE IF EXISTS `assets`;
CREATE TABLE `assets`  (
  `total_assets` float NULL DEFAULT NULL COMMENT '总资产',
  `disposable_assets` float NULL DEFAULT NULL COMMENT '可支配资产'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of assets
-- ----------------------------

-- ----------------------------
-- Table structure for assets_log
-- ----------------------------
DROP TABLE IF EXISTS `assets_log`;
CREATE TABLE `assets_log`  (
  `user_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '管理',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '描述',
  `change_assets` float NULL DEFAULT NULL COMMENT '花了多少',
  `processing
_time` datetime NULL DEFAULT NULL COMMENT '处理时间',
  `before_assets` float NULL DEFAULT NULL COMMENT '花费前可支配资产',
  `afterwards_assets` float NULL DEFAULT NULL COMMENT '花费后可支配资产'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of assets_log
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int NOT NULL COMMENT '物品id\r\n',
  `goods_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '物品名称',
  `goods_state` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL COMMENT '物品状态（正常 损坏 处理中）',
  `goods_Image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '物品图片',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `goods_id` int NOT NULL COMMENT '损坏物品id',
  `goods_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '物品名称',
  `damage_description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL COMMENT '损坏描述',
  `reporting_time` datetime NULL DEFAULT NULL COMMENT '上报时间',
  `goods_state` int NULL DEFAULT NULL COMMENT '状态 已处理或未处理',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of report
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account_number` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '账号',
  `password` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '姓名',
  `student_number` bigint NOT NULL COMMENT '学号',
  `gender` int NOT NULL COMMENT '性别',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '电话号码',
  `post` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '邮箱',
  `register_time` timestamp NOT NULL COMMENT '注册时间',
  `login_status` int NOT NULL COMMENT '登录状态',
  `role_id` int NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`, `student_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

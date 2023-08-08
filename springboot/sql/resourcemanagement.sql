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

 Date: 08/08/2023 13:39:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply_assets
-- ----------------------------
DROP TABLE IF EXISTS `apply_assets`;
CREATE TABLE `apply_assets`  (
  `apply_id` int NOT NULL AUTO_INCREMENT COMMENT '申请id',
  `apply_assets` float NOT NULL COMMENT '申请资金',
  `apply_name_id` int NULL DEFAULT NULL COMMENT '申请人id',
  `apply_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '申请人',
  `dispose_name_id` int NULL DEFAULT NULL COMMENT '处理人id',
  `dispose_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '处理人',
  `apply_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '申请人购买描述',
  `dispose_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT '未处理' COMMENT '处理描述',
  `apply-time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `dispose_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '处理时间',
  `apply_state` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT '未处理' COMMENT '申请状态',
  PRIMARY KEY (`apply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23312 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for assets
-- ----------------------------
DROP TABLE IF EXISTS `assets`;
CREATE TABLE `assets`  (
  `total_assets` float NOT NULL COMMENT '总资产',
  `disposable_assets` float NOT NULL COMMENT '可支配资产',
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL COMMENT '描述',
  `percentage` float NOT NULL COMMENT '百分比',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for assets_log
-- ----------------------------
DROP TABLE IF EXISTS `assets_log`;
CREATE TABLE `assets_log`  (
  `assets_log_id` int NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `user_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL COMMENT '管理',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL COMMENT '描述',
  `change_assets` float NOT NULL COMMENT '花了多少',
  `process_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '处理时间',
  `before_assets` float NOT NULL COMMENT '花费前可支配资产',
  `afterwards_assets` float NOT NULL COMMENT '花费后可支配资产',
  PRIMARY KEY (`assets_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int NOT NULL AUTO_INCREMENT COMMENT '物品id\r\n',
  `goods_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '物品名称',
  `goods_state` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL COMMENT '物品状态（正常1 损坏2 处理中3）',
  `goods_Image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '物品图片',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36717 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `sequence_id` int NOT NULL AUTO_INCREMENT COMMENT '上报id',
  `report_name_id` int NULL DEFAULT NULL COMMENT '上报人id',
  `report_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL COMMENT '上报人',
  `goods_id` int NOT NULL COMMENT '损坏物品id',
  `goods_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL COMMENT '物品名称',
  `damage_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL COMMENT '损坏描述',
  `report_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上报时间',
  `process_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '处理时间',
  `goods_state` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL DEFAULT '未处理' COMMENT '未处理1    已处理已同意2   已处理但未同意3',
  `dispose_name_id` int NULL DEFAULT 0 COMMENT '处理人id',
  `dispose_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '处理人',
  `dispose_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT '未处理' COMMENT '处理人描述',
  PRIMARY KEY (`sequence_id`, `goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3217 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '账号',
  `password` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `student_number` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '学号',
  `sex` int NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `post` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `register_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `login_status` int NULL DEFAULT NULL COMMENT '登录状态',
  `role_id` int NOT NULL COMMENT '角色id管理或用户',
  PRIMARY KEY (`user_id`, `student_number`, `account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 126 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;

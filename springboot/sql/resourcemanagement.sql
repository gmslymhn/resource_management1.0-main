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

 Date: 05/08/2023 14:07:52
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
  `apply-time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `dispose_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '处理时间',
  `apply_state` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT '未处理' COMMENT '申请状态',
  `dispose_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT '未处理' COMMENT '处理描述',
  PRIMARY KEY (`apply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23214 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apply_assets
-- ----------------------------
INSERT INTO `apply_assets` VALUES (23213, 321, NULL, NULL, NULL, NULL, NULL, '2023-08-04 20:59:49', '2023-08-04 21:00:22', NULL, NULL);

-- ----------------------------
-- Table structure for assets
-- ----------------------------
DROP TABLE IF EXISTS `assets`;
CREATE TABLE `assets`  (
  `total_assets` float NOT NULL COMMENT '总资产',
  `disposable_assets` float NOT NULL COMMENT '可支配资产',
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL DEFAULT '无' COMMENT '描述',
  `percentage` float NOT NULL COMMENT '百分比',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of assets
-- ----------------------------
INSERT INTO `assets` VALUES (200, 140, '2023-08-04 17:06:14', 1, '无', 0);

-- ----------------------------
-- Table structure for assets_log
-- ----------------------------
DROP TABLE IF EXISTS `assets_log`;
CREATE TABLE `assets_log`  (
  `assets_log_id` int NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `user_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL COMMENT '管理',
  `  description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL COMMENT '描述',
  `change_assets` float NOT NULL COMMENT '花了多少',
  `process_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '处理时间',
  `before_assets` float NOT NULL COMMENT '花费前可支配资产',
  `afterwards_assets` float NOT NULL COMMENT '花费后可支配资产',
  PRIMARY KEY (`assets_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of assets_log
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 35451 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '椅子', '未损坏', '1.hgfhf1');
INSERT INTO `goods` VALUES (4, '5453', '已损坏', '4324');
INSERT INTO `goods` VALUES (5, '321', '已损坏', '3');
INSERT INTO `goods` VALUES (35442, '321', '已损坏', '321');
INSERT INTO `goods` VALUES (35443, '3213', '已损坏', '321');
INSERT INTO `goods` VALUES (35444, '321', '已损坏', '32');
INSERT INTO `goods` VALUES (35445, '3213', '已损坏', '321');
INSERT INTO `goods` VALUES (35446, '3213', '已损坏', '1323');
INSERT INTO `goods` VALUES (35447, 'rfdss', 'fdsfds', 'fdsfsdf');
INSERT INTO `goods` VALUES (35448, 'fdsfds', 'fdsfds', 'fdsfds');
INSERT INTO `goods` VALUES (35449, 'fdsfds', 'fdsfds', 'fdsfds');
INSERT INTO `goods` VALUES (35450, 'fjhgjh', 'jhgj', 'hgjhgjgh');

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
  `reporting_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上报时间',
  `process_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '处理时间',
  `goods_state` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NOT NULL DEFAULT '未处理' COMMENT '未处理1    已处理已同意2   已处理但未同意3',
  `dispose_name_id` int NULL DEFAULT 0 COMMENT '处理人id',
  `dispose_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '处理人',
  `dispose_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT '未处理' COMMENT '处理人描述',
  PRIMARY KEY (`sequence_id`, `goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES (1, NULL, '321', 321, '321', '321', '2023-08-05 01:16:32', '2023-08-05 01:16:32', '1', 0, NULL, NULL);
INSERT INTO `report` VALUES (2, NULL, '321', 321, '321', '321', '2023-08-05 01:49:30', '2023-08-05 01:49:30', '1', 0, '32', NULL);
INSERT INTO `report` VALUES (4, NULL, '432', 432, '432', '432', '2023-08-05 01:51:22', '2023-08-05 01:51:22', '432', 0, '432', NULL);
INSERT INTO `report` VALUES (5, NULL, '432', 432, '432', '432', '2023-08-05 01:51:34', '2023-08-05 01:51:34', '432', 0, '432', NULL);
INSERT INTO `report` VALUES (6, NULL, '432', 432, '4324', '324', '2023-08-05 01:51:41', '2023-08-05 01:51:41', '432', 0, '432', NULL);
INSERT INTO `report` VALUES (7, NULL, '432', 432, '432', '432', '2023-08-05 01:51:52', '2023-08-05 01:51:52', '543', 0, '543', NULL);
INSERT INTO `report` VALUES (8, NULL, '54354', 5435, '543534', '5435', '2023-08-05 01:54:48', '2023-08-05 01:54:48', '5435', 0, '543543', NULL);
INSERT INTO `report` VALUES (9, NULL, '543543', 5435, '45435', '5435', '2023-08-05 01:54:56', '2023-08-05 01:54:56', '4354', 0, '543543', NULL);
INSERT INTO `report` VALUES (10, NULL, '5435435', 543543, '543543', '543543', '2023-08-05 01:55:09', '2023-08-05 01:55:09', '54354', 0, '534543', NULL);
INSERT INTO `report` VALUES (11, NULL, '54trfe', 543, '543', '543', '2023-08-05 01:55:20', '2023-08-05 01:55:20', '543', 0, '543', NULL);
INSERT INTO `report` VALUES (12, NULL, '57657', 765, '765', '765', '2023-08-05 01:55:28', '2023-08-05 01:55:28', '765', 0, '765', NULL);
INSERT INTO `report` VALUES (32, NULL, '李浩坤好叼', 32, '321', '321', '2023-08-05 02:04:22', '2023-08-05 02:04:22', '321', 0, '321', NULL);
INSERT INTO `report` VALUES (32, NULL, '李浩坤', 321, '321', '32', '2023-08-05 02:04:05', '2023-08-05 02:04:05', '321', 0, '321', NULL);
INSERT INTO `report` VALUES (54, NULL, '李浩坤好厉害', 543, '543', '543', '2023-08-05 02:04:36', '2023-08-05 02:04:36', '543', 0, '543', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 125 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (109, 'abc', '3214231', NULL, '2022005789', 0, NULL, NULL, '2023-07-22 14:31:49', NULL, 1);
INSERT INTO `user` VALUES (111, 'abcd', '3214231', NULL, '2022005788', 0, NULL, NULL, '2023-07-22 14:51:41', NULL, 1);
INSERT INTO `user` VALUES (112, 'abdaewd', '3214231', NULL, '20220034788', 0, NULL, NULL, '2023-07-22 15:00:06', NULL, 1);
INSERT INTO `user` VALUES (113, '', '', '', '', 0, NULL, '', '2023-07-29 12:29:08', NULL, 1);
INSERT INTO `user` VALUES (114, '54354', '543543', '5435', '5435', 0, NULL, '543543', '2023-07-29 12:30:58', NULL, 1);
INSERT INTO `user` VALUES (115, '325431', '6ce7a1a472386f1639bfbf41ae7c608abe3c9182', 'dsadsadsa', '3213432', 0, NULL, 'dsdsadsa', '2023-08-03 13:43:34', NULL, 1);
INSERT INTO `user` VALUES (116, '321', '5f6955d227a320c7f1f6c7da2a6d96a851a8118f', 'dsadsadsa', '321gfd3432', 0, NULL, 'dsdsadsa', '2023-08-03 13:44:38', NULL, 1);
INSERT INTO `user` VALUES (117, '432', 'a2092f63a2f91825e2c72496b104e027c2a5b0f0', 'dsadsadsa', '321gd3432', 0, NULL, 'dsdsadsa', '2023-08-03 13:45:25', NULL, 2);
INSERT INTO `user` VALUES (118, '434342', 'a2092f63a2f91825e2c72496b104e027c2a5b0f0', 'dsadsadsa', '321gd33432', 0, NULL, 'dsdsadsa', '2023-08-03 15:18:25', NULL, 1);
INSERT INTO `user` VALUES (120, 'Iana', '4b88b16ef08c752bd65b4e0959745f44ae7abf8a', '李浩坤', '2022005374', 0, NULL, '3067815232@qq.com', '2023-08-04 21:39:22', NULL, 2);
INSERT INTO `user` VALUES (121, 'Iana666', '4b88b16ef08c752bd65b4e0959745f44ae7abf8a', '李浩坤好叼', '2022005370', 0, NULL, '3067815232@qq.com', '2023-08-03 22:09:26', NULL, 1);
INSERT INTO `user` VALUES (122, 'IanaTest', '4b88b16ef08c752bd65b4e0959745f44ae7abf8a', '李浩坤', '2022005555', 0, NULL, '3067815232@qq.com', '2023-08-04 01:20:45', NULL, 1);
INSERT INTO `user` VALUES (123, 'IanaTTT', '4b88b16ef08c752bd65b4e0959745f44ae7abf8a', '李浩坤', '1111111', 0, NULL, '3067815232@qq.com', '2023-08-04 01:56:25', NULL, 1);
INSERT INTO `user` VALUES (124, 'Iana2', '4b88b16ef08c752bd65b4e0959745f44ae7abf8a', '李浩坤', '2022001111', 0, NULL, '3067815232@qq.com', '2023-08-04 22:49:38', NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;

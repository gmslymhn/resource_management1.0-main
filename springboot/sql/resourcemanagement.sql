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

 Date: 08/08/2023 18:20:08
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
) ENGINE = InnoDB AUTO_INCREMENT = 23344 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of apply_assets
-- ----------------------------
INSERT INTO `apply_assets` VALUES (23312, 0, 131, '123', 126, 'G M', '', 'dwas', '2023-08-08 15:59:14', '2023-08-08 16:22:29', '同意');
INSERT INTO `apply_assets` VALUES (23315, 0, 131, '123', 126, 'G M', '', 'dsasDas', '2023-08-08 16:07:00', '2023-08-08 16:25:10', '同意');
INSERT INTO `apply_assets` VALUES (23318, 1, 131, '123', 128, '李浩坤', '1', '123131', '2023-08-08 16:36:56', '2023-08-08 17:23:04', '同意');
INSERT INTO `apply_assets` VALUES (23319, 123, 131, '123', 126, 'G M', '123', '4535', '2023-08-08 16:37:50', '2023-08-08 17:14:26', '同意');
INSERT INTO `apply_assets` VALUES (23323, 123, 131, '123', 126, 'G M', NULL, '3421312', '2023-08-08 16:39:06', '2023-08-08 17:21:32', '同意');
INSERT INTO `apply_assets` VALUES (23325, 123, 131, '123', 126, 'G M', '5', '4324', '2023-08-08 16:39:31', '2023-08-08 17:25:01', '同意');
INSERT INTO `apply_assets` VALUES (23326, 1, 131, '123', 128, '李浩坤', '1', '1313', '2023-08-08 16:42:03', '2023-08-08 17:24:09', '同意');
INSERT INTO `apply_assets` VALUES (23328, 115550, 131, '123', 126, 'G M', '123', '321', '2023-08-08 16:48:36', '2023-08-08 17:27:17', '同意');
INSERT INTO `apply_assets` VALUES (23329, 15263100, 131, '123', 126, 'G M', '1523', '321321', '2023-08-08 16:48:46', '2023-08-08 17:29:32', '同意');
INSERT INTO `apply_assets` VALUES (23330, 0, 131, '123', 128, '李浩坤', NULL, '123', '2023-08-08 16:49:20', '2023-08-08 17:28:23', '同意');
INSERT INTO `apply_assets` VALUES (23331, 123123000, 130, '12345678', 126, 'G M', '123123123', '3213', '2023-08-08 16:50:17', '2023-08-08 17:27:22', '同意');
INSERT INTO `apply_assets` VALUES (23332, 987, 130, '12345678', 126, 'G M', '789', '3211', '2023-08-08 16:50:50', '2023-08-08 17:27:51', '同意');
INSERT INTO `apply_assets` VALUES (23333, 11, 126, 'G M', 128, '李浩坤', '342', '1231', '2023-08-08 17:14:12', '2023-08-08 17:28:37', '同意');
INSERT INTO `apply_assets` VALUES (23334, 999, 126, 'G M', 128, '李浩坤', '000', '131', '2023-08-08 17:21:19', '2023-08-08 17:28:43', '同意');
INSERT INTO `apply_assets` VALUES (23335, 10000000, 126, 'G M', 126, 'G M', 'hghfg', 'tfgdfg', '2023-08-08 17:30:00', '2023-08-08 17:31:12', '同意');
INSERT INTO `apply_assets` VALUES (23336, 3213210, 126, 'G M', 126, 'G M', 'ewqew', 'dsasad', '2023-08-08 17:31:32', '2023-08-08 17:31:41', '同意');
INSERT INTO `apply_assets` VALUES (23338, 789, 130, '12345678', 126, 'G M', '456', '432432', '2023-08-08 17:31:49', '2023-08-08 17:49:37', '未处理');
INSERT INTO `apply_assets` VALUES (23339, 34432, 126, 'G M', 126, 'G M', '321312321', 'dwads', '2023-08-08 17:32:09', '2023-08-08 17:32:18', '同意');
INSERT INTO `apply_assets` VALUES (23340, 321, 126, 'G M', NULL, NULL, '132321', NULL, '2023-08-08 17:35:17', '2023-08-08 17:35:17', '未处理');
INSERT INTO `apply_assets` VALUES (23341, 0, 126, 'G M', NULL, NULL, NULL, NULL, '2023-08-08 17:49:16', '2023-08-08 17:49:16', '未处理');
INSERT INTO `apply_assets` VALUES (23342, 0, 130, '12345678', NULL, NULL, '123', NULL, '2023-08-08 17:49:53', '2023-08-08 17:49:53', '未处理');
INSERT INTO `apply_assets` VALUES (23343, 0, 126, 'G M', NULL, NULL, NULL, NULL, '2023-08-08 17:57:37', '2023-08-08 17:57:37', '未处理');

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
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of assets
-- ----------------------------
INSERT INTO `assets` VALUES (1000, 1000, '2023-08-08 15:28:05', 1, '初始资金', 1);
INSERT INTO `assets` VALUES (1000, 700, '2023-08-08 15:28:19', 37, '保底', 0.7);
INSERT INTO `assets` VALUES (1000, 900, '2023-08-08 15:35:21', 38, 'dsad', 0.9);
INSERT INTO `assets` VALUES (1000, 900, '2023-08-08 15:35:43', 39, 'dsad', 0.9);
INSERT INTO `assets` VALUES (10000, 9000, '2023-08-08 15:43:10', 40, '有钱了', 0.9);
INSERT INTO `assets` VALUES (10000, 9000, '2023-08-08 16:22:29', 41, 'dwas', 0.9);
INSERT INTO `assets` VALUES (10000, 9000, '2023-08-08 16:25:10', 42, 'dsasDas', 0.9);
INSERT INTO `assets` VALUES (123, 110.7, '2023-08-08 17:00:42', 43, '123', 0.9);
INSERT INTO `assets` VALUES (5, 4.5, '2023-08-08 17:05:25', 44, '', 0.9);
INSERT INTO `assets` VALUES (123, 110.7, '2023-08-08 17:05:31', 45, '123', 0.9);
INSERT INTO `assets` VALUES (123, 0.615, '2023-08-08 17:05:47', 46, '5', 0.005);
INSERT INTO `assets` VALUES (123, 6.15, '2023-08-08 17:05:55', 47, '6', 0.05);
INSERT INTO `assets` VALUES (123, 104.55, '2023-08-08 17:06:30', 48, '123', 0.85);
INSERT INTO `assets` VALUES (456, 387.6, '2023-08-08 17:06:46', 49, '456', 0.85);
INSERT INTO `assets` VALUES (333, 283.05, '2023-08-08 17:14:26', 50, '4535', 0.85);
INSERT INTO `assets` VALUES (1000, 850, '2023-08-08 17:15:15', 51, '999', 0.85);
INSERT INTO `assets` VALUES (1000, 0, '2023-08-08 17:21:03', 52, 'edsas', 0);
INSERT INTO `assets` VALUES (1000, 0, '2023-08-08 17:28:24', 53, '123', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of assets_log
-- ----------------------------
INSERT INTO `assets_log` VALUES (12, '至尊管理', '789', 0, '2023-08-08 15:43:09', 900, 0);
INSERT INTO `assets_log` VALUES (13, 'G M', 'dwas', 0, '2023-08-08 16:22:29', 10000, 10000);
INSERT INTO `assets_log` VALUES (14, 'G M', 'dsasDas', 0, '2023-08-08 16:25:10', 10000, 10000);
INSERT INTO `assets_log` VALUES (15, '至尊管理', '修改总资产', 0, '2023-08-08 17:00:42', 9000, 110.7);
INSERT INTO `assets_log` VALUES (16, '至尊管理', '修改总资产', 0, '2023-08-08 17:05:25', 110.7, 4.5);
INSERT INTO `assets_log` VALUES (17, '至尊管理', '修改总资产', 0, '2023-08-08 17:05:31', 4.5, 110.7);
INSERT INTO `assets_log` VALUES (18, '至尊管理', '修改可支配资产占总资产百分比', 0, '2023-08-08 17:05:47', 0.615, 0.615);
INSERT INTO `assets_log` VALUES (19, '至尊管理', '修改可支配资产占总资产百分比', 0, '2023-08-08 17:05:55', 6.15, 6.15);
INSERT INTO `assets_log` VALUES (20, '至尊管理', '修改可支配资产占总资产百分比', 0, '2023-08-08 17:06:30', 104.55, 104.55);
INSERT INTO `assets_log` VALUES (21, '至尊管理', '修改总资产', 0, '2023-08-08 17:06:45', 104.55, 387.6);
INSERT INTO `assets_log` VALUES (22, 'G M', '4535', 123, '2023-08-08 17:14:26', 456, 333);
INSERT INTO `assets_log` VALUES (23, '至尊管理', '修改总资产', 0, '2023-08-08 17:15:14', 283.05, 850);
INSERT INTO `assets_log` VALUES (24, '至尊管理', '修改可支配资产占总资产百分比', 0, '2023-08-08 17:21:02', 0, 0);
INSERT INTO `assets_log` VALUES (25, '李浩坤', '123', 0, '2023-08-08 17:28:23', 1000, 1000);

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
) ENGINE = InnoDB AUTO_INCREMENT = 36777 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (36727, '实验室logo', '已损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36731, '实验室logo', '已损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36732, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36733, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36734, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36735, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36736, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36737, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36738, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36739, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36740, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36741, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36742, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36743, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36744, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36745, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36746, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36747, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36748, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36749, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36750, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36751, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36752, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36753, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36754, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36755, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36756, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36757, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36758, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36759, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36760, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36761, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36762, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36763, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36764, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36765, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36766, '实验室logo', '未损坏', '/goodsImage/5285881b-f3f5-4531-b671-2351e1e35f86.jpg');
INSERT INTO `goods` VALUES (36767, 'ewqew', '未损坏', '/goodsImage/af752cfa-9741-45f5-aa4d-65c8bb795218.jpg');
INSERT INTO `goods` VALUES (36768, 'ewqew', '未损坏', '/goodsImage/af752cfa-9741-45f5-aa4d-65c8bb795218.jpg');
INSERT INTO `goods` VALUES (36769, 'ewqew', '未损坏', '/goodsImage/af752cfa-9741-45f5-aa4d-65c8bb795218.jpg');
INSERT INTO `goods` VALUES (36770, 'ewqew', '未损坏', '/goodsImage/af752cfa-9741-45f5-aa4d-65c8bb795218.jpg');
INSERT INTO `goods` VALUES (36771, 'ewqew', '未损坏', '/goodsImage/c0f731c1-d7d1-405d-95df-ebc78d67464a.jpg');
INSERT INTO `goods` VALUES (36772, '54353', '未损坏', '/goodsImage/4a36d85a-ae41-44fa-b954-d2dd8ef63e01.jpg');
INSERT INTO `goods` VALUES (36773, '54353', '未损坏', '/goodsImage/4a36d85a-ae41-44fa-b954-d2dd8ef63e01.jpg');
INSERT INTO `goods` VALUES (36774, '32312', '未损坏', '/goodsImage/971bcf59-80c9-4917-a1b5-b31257975683.jpg');
INSERT INTO `goods` VALUES (36775, 'gfdeg', '未损坏', '/goodsImage/9cfad851-9e35-4203-ad5b-f77c5b6d8fc0.jpg');
INSERT INTO `goods` VALUES (36776, '11231', '未损坏', '/goodsImage/0dc77cf8-c2a6-400b-a3d2-a19bee02020c.jpg');

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
) ENGINE = InnoDB AUTO_INCREMENT = 3238 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES (3223, 126, 'G M', 36720, '实验室logo', 'dsadsadasd', '2023-08-08 15:37:34', '2023-08-08 15:37:42', '已处理', 126, 'G M', 'dsadsadsd');
INSERT INTO `report` VALUES (3224, 128, '李浩坤', 36721, '实验室logo', 'aaa', '2023-08-08 15:38:47', '2023-08-08 15:39:08', '已处理', 128, '李浩坤', 'aaaaaaaa');
INSERT INTO `report` VALUES (3225, 128, '李浩坤', 36722, '实验室logo', 'aa', '2023-08-08 15:38:49', '2023-08-08 15:41:41', '已处理', 128, '李浩坤', 'aaa');
INSERT INTO `report` VALUES (3226, 128, '李浩坤', 36723, '实验室logo', 'asdad', '2023-08-08 15:38:52', '2023-08-08 15:41:21', '已处理', 128, '李浩坤', 'aaa');
INSERT INTO `report` VALUES (3227, 128, '李浩坤', 36724, '实验室logo', 'aaaa', '2023-08-08 15:38:54', '2023-08-08 15:40:56', '已处理', 128, '李浩坤', 'a');
INSERT INTO `report` VALUES (3228, 126, 'G M', 36723, '实验室logo', 'dsadsadsd', '2023-08-08 15:39:55', '2023-08-08 15:40:23', '已处理', 128, '李浩坤', 'aaaa');
INSERT INTO `report` VALUES (3229, 128, '李浩坤', 36725, '实验室logo', 'aa', '2023-08-08 15:42:30', '2023-08-08 15:42:45', '已处理', 128, '李浩坤', 'aaa');
INSERT INTO `report` VALUES (3230, 128, '李浩坤', 36726, '实验室logo', 'asd', '2023-08-08 15:42:32', '2023-08-08 17:25:55', '已处理', 126, 'G M', '32131');
INSERT INTO `report` VALUES (3231, 128, '李浩坤', 36727, '实验室logo', 'asda', '2023-08-08 15:42:34', '2023-08-08 17:26:06', '已处理', 126, 'G M', '3213');
INSERT INTO `report` VALUES (3232, 128, '李浩坤', 36728, '实验室logo', 'asdasda', '2023-08-08 15:42:36', '2023-08-08 15:42:54', '已处理', 128, '李浩坤', 'asdadad');
INSERT INTO `report` VALUES (3233, 128, '李浩坤', 36729, '实验室logo', 'asdasda', '2023-08-08 15:42:39', '2023-08-08 15:43:04', '已处理', 128, '李浩坤', 'asdasd');
INSERT INTO `report` VALUES (3234, 127, '乔璟润', 36726, '实验室logo', '123', '2023-08-08 17:16:13', '2023-08-08 17:49:28', '已处理', 126, 'G M', '3213213213');
INSERT INTO `report` VALUES (3235, 128, '李浩坤', 36726, '实验室logo', '111', '2023-08-08 17:20:01', '2023-08-08 17:20:01', '未处理', 0, '无', '无');
INSERT INTO `report` VALUES (3236, 128, '李浩坤', 36730, '实验室logo', '111', '2023-08-08 17:20:04', '2023-08-08 17:22:32', '已处理', 126, 'G M', '321');
INSERT INTO `report` VALUES (3237, 128, '李浩坤', 36731, '实验室logo', '1111', '2023-08-08 17:20:08', '2023-08-08 17:20:08', '未处理', 0, '无', '无');

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
) ENGINE = InnoDB AUTO_INCREMENT = 132 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (126, '432', 'a2092f63a2f91825e2c72496b104e027c2a5b0f0', 'G M', '2022005744', 0, NULL, 'gmslymhn@163.com', '2023-08-08 15:22:10', NULL, 2);
INSERT INTO `user` VALUES (127, '321', '5f6955d227a320c7f1f6c7da2a6d96a851a8118f', '乔璟润', '2020005744', 0, NULL, 'gmslymhn@163.com', '2023-08-08 15:22:53', NULL, 1);
INSERT INTO `user` VALUES (128, 'Iana', '4b88b16ef08c752bd65b4e0959745f44ae7abf8a', '李浩坤', '2022005374', 0, NULL, '3067815232@qq.com', '2023-08-08 15:23:08', NULL, 2);
INSERT INTO `user` VALUES (129, 'Iana2', '4b88b16ef08c752bd65b4e0959745f44ae7abf8a', '李浩坤', '2022005373', 0, NULL, '3067815232@qq.com', '2023-08-08 15:24:03', NULL, 1);
INSERT INTO `user` VALUES (130, '123456789', 'f7c3bc1d808e04732adf679965ccc34ca7ae3441', '12345678', '123456789', 0, NULL, '123456789', '2023-08-08 15:29:21', NULL, 1);
INSERT INTO `user` VALUES (131, '20040202', 'e0b76331aa3ee7dc4f389e4c6cf1fdd387d05fd6', '123', '123', 0, NULL, '123', '2023-08-08 15:39:01', NULL, 2);

SET FOREIGN_KEY_CHECKS = 1;

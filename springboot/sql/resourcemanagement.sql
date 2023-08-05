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

 Date: 20/07/2023 17:29:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for assets
-- ----------------------------
DROP TABLE IF EXISTS `assets`;
CREATE TABLE `assets`  (
                         total_assets      float    not null comment '总资产',
                         disposable_assets float    not null comment '可支配资产',
                         time              datetime not null comment '最后一次修改时间',
                         id                int auto_increment
                           primary key
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Records of assets
-- ----------------------------

-- ----------------------------
-- Table structure for assets_log
-- ----------------------------
DROP TABLE IF EXISTS `assets_log`;
CREATE TABLE `assets_log`  (
                             assets_log_id     int auto_increment comment '日志id'
                               primary key,
                             user_name         varchar(255) not null comment '管理',
                             description       varchar(255) not null comment '描述',
                             change_assets     float        not null comment '花了多少',
                             process_time      datetime     not null comment '处理时间',
                             before_assets     float        not null comment '花费前可支配资产',
                             afterwards_assets float        not null comment '花费后可支配资产'
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
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (

                         sequence_id        int       not null comment '上报id',
                         report_name        varchar(255) not null comment '上报人',
                         goods_id           int          not null comment '损坏物品id',
                         goods_name         varchar(255) not null comment '物品名称',
                         damage_description text         not null comment '损坏描述',
                         reporting_time     TIMESTAMP    not null DEFAULT CURRENT_TIMESTAMP comment '上报时间',
                         process_time       TIMESTAMP    not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '处理时间',
                         goods_state        int          not null comment '未处理1    已处理已同意2   已处理但未同意3',
                         dispose_name       varchar(255) not null comment '处理人',
                         primary key (goods_id, sequence_id)
)
 ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Records of report
-- ----------------------------

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
                         `register_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
                         `login_status` int NULL DEFAULT NULL COMMENT '登录状态',
                         `role_id` int NOT NULL COMMENT '角色id管理或用户',
                         PRIMARY KEY (`user_id`, `student_number`, `account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;
-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

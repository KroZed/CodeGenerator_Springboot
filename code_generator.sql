/*
 Navicat Premium Data Transfer

 Source Server         : localhost-mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : code_generator

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 15/03/2025 21:13:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_id` bigint(20) NULL DEFAULT NULL,
  `owner_id` bigint(20) NOT NULL,
  `type` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `db_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `port` int(11) NOT NULL,
  `db_schema` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `db_username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `db_password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `template_id` bigint(20) NOT NULL,
  `output_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `extra_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, NULL, 1, '啥类型？', '项目1', 'localhost', 3306, 'code_generator', 'root', 'root', 1, 'output', NULL, b'0');
INSERT INTO `project` VALUES (2, NULL, 2, 'Java', '代码生成', 'localhost', 3306, 'code_generator', 'root', 'root', 2, 'output', NULL, b'0');

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `extra_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of template
-- ----------------------------
INSERT INTO `template` VALUES (1, NULL, 'Java-Spring', 'template', NULL, b'0');
INSERT INTO `template` VALUES (2, NULL, 'Java', 'template', NULL, b'0');

-- ----------------------------
-- Table structure for template_file
-- ----------------------------
DROP TABLE IF EXISTS `template_file`;
CREATE TABLE `template_file`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_id` bigint(20) NULL DEFAULT NULL,
  `template_id` bigint(20) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `file` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name_rule` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `template_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `extra_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of template_file
-- ----------------------------
INSERT INTO `template_file` VALUES (1, NULL, 1, '实体类', '/upload/739008683.vm', '【table】.java', NULL, NULL, b'0');
INSERT INTO `template_file` VALUES (2, NULL, 2, '实体类', '/upload/551598587.vm', '【table】.java', NULL, NULL, b'0');
INSERT INTO `template_file` VALUES (3, NULL, 2, 'DAO', '/upload/1103770880.vm', '【table】Dao.java', NULL, NULL, b'0');
INSERT INTO `template_file` VALUES (4, NULL, 2, 'MyBatisMapper', '/upload/1097922797.vm', '【table】Mapper.xml', NULL, NULL, b'0');
INSERT INTO `template_file` VALUES (5, NULL, 2, 'Service', '/upload/1459520716.vm', '【table】Service.java', NULL, NULL, b'0');
INSERT INTO `template_file` VALUES (6, NULL, 2, 'ServiceImpl', '/upload/947090045.vm', '【table】ServiceImpl.java', NULL, NULL, b'0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_id` bigint(20) NULL DEFAULT NULL,
  `login_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `realname` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '用户',
  `status` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '正常',
  `extra_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, NULL, 'admin', 'admin', '管理员', '管理员', '正常', NULL, b'0', NULL);
INSERT INTO `user` VALUES (2, NULL, 'U1', 'U1', '用户1', '用户', '正常', NULL, b'0', '100000@qq.com');

SET FOREIGN_KEY_CHECKS = 1;

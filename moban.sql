/*
 Navicat Premium Data Transfer

 Source Server         : service1
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : service1:3306
 Source Schema         : moban

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 19/12/2017 19:52:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(100) DEFAULT NULL,
  `creatData` date DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
BEGIN;
INSERT INTO `dept` VALUES (1, '大数据部', '2017-10-04');
INSERT INTO `dept` VALUES (2, '人事部', '2017-10-06');
INSERT INTO `dept` VALUES (3, '生产部', '2017-10-03');
INSERT INTO `dept` VALUES (14, '研发部', '2017-10-04');
INSERT INTO `dept` VALUES (38, 'wqeqwe', '2017-12-06');
INSERT INTO `dept` VALUES (39, 'weqwq', '2017-11-29');
INSERT INTO `dept` VALUES (40, 'wqewqe', '2017-12-01');
INSERT INTO `dept` VALUES (41, 'qweqe', '2017-12-01');
INSERT INTO `dept` VALUES (42, 'dwaddaw', '2017-12-01');
INSERT INTO `dept` VALUES (43, 'dsadds', '2017-12-02');
COMMIT;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `EMPNO` int(4) NOT NULL,
  `ENAME` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `JOB` varchar(9) COLLATE utf8_bin DEFAULT NULL,
  `MGR` int(4) DEFAULT NULL,
  `HIREDATE` date DEFAULT NULL,
  `SAL` double(7,2) DEFAULT NULL,
  `COMM` double(7,2) DEFAULT NULL,
  `DEPTNO` int(2) DEFAULT NULL,
  PRIMARY KEY (`EMPNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of emp
-- ----------------------------
BEGIN;
INSERT INTO `emp` VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 801.00, NULL, 20);
INSERT INTO `emp` VALUES (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600.00, 300.00, 30);
INSERT INTO `emp` VALUES (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250.00, 500.00, 30);
INSERT INTO `emp` VALUES (7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975.00, NULL, 20);
INSERT INTO `emp` VALUES (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250.00, 1400.00, 30);
INSERT INTO `emp` VALUES (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850.00, NULL, 30);
INSERT INTO `emp` VALUES (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450.00, NULL, 10);
INSERT INTO `emp` VALUES (7788, 'SCOTT', 'ANALYST', 7566, '1987-04-19', 3000.00, NULL, 20);
INSERT INTO `emp` VALUES (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000.00, NULL, 10);
INSERT INTO `emp` VALUES (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500.00, 0.00, 30);
INSERT INTO `emp` VALUES (7876, 'ADAMS', 'CLERK', 7788, '1987-05-23', 1100.00, NULL, 20);
INSERT INTO `emp` VALUES (7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950.00, NULL, 30);
INSERT INTO `emp` VALUES (7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000.00, NULL, 20);
INSERT INTO `emp` VALUES (7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1301.00, NULL, 10);
COMMIT;

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `pid` int(20) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  `icon` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_sys_resource_parent_id` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
BEGIN;
INSERT INTO `sys_resource` VALUES (1, '系统管理', 'menu', 'sysresource/windou/1', 0, 'sys:menu', 1, 'menu-icon glyphicon glyphicon-cog');
INSERT INTO `sys_resource` VALUES (47, '资源管理', 'menu', 'resourceIndext', 1, 'menu:menu', 1, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (57, '角色管理', 'menu', 'roleIndext', 1, 'role:menu', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (61, '用户管理', 'menu', 'userIndext', 1, 'user:menu', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (62, '添加用户', 'button', '', 61, 'user:create', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (63, '修改用户或密码', 'button', '', 61, 'user:update', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (64, '删除用户', 'button', '', 61, 'user:delete', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (80, '系统日志', 'menu', 'druid', 1, 'syslog:menu', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (81, 'springMVC学习', 'menu', 'sysresource/windou/81', 0, 'springMVC:menu', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (83, '数据校验', 'menu', 'dataValidationIndext', 81, 'dataValidation:menu', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (84, 'zdy类型转换器', 'menu', 'conversionServiceIndext', 81, 'conversionService:menu', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (85, '数据格式化', 'menu', 'formattingIndex', 81, 'formatting:menu', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (86, 'zdy视图解析器与视图', 'menu', 'viewIndext', 81, 'view:menu', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (87, 'zdy参数解析器', 'menu', 'argumentResolverIndext', 81, 'argumentResolver:menu', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (88, '国际化', 'menu', 'i18nIndext', 81, 'i18n:menu', 0, 'menu-icon glyphicon glyphicon-leaf');
INSERT INTO `sys_resource` VALUES (89, '消息转换器', 'menu', 'messageConverterIndex', 81, 'messageConverter:menu', 0, 'menu-icon glyphicon glyphicon-leaf');
COMMIT;

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_roles_role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
BEGIN;
INSERT INTO `sys_roles` VALUES (1, 'admin', '系统管理员', 0);
INSERT INTO `sys_roles` VALUES (2, 'del', '一级管理员', 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_roles_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_resource`;
CREATE TABLE `sys_roles_resource` (
  `role_id` int(20) NOT NULL,
  `resource_id` int(20) NOT NULL,
  PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles_resource
-- ----------------------------
BEGIN;
INSERT INTO `sys_roles_resource` VALUES (1, 1);
INSERT INTO `sys_roles_resource` VALUES (1, 47);
INSERT INTO `sys_roles_resource` VALUES (1, 57);
INSERT INTO `sys_roles_resource` VALUES (1, 61);
INSERT INTO `sys_roles_resource` VALUES (1, 62);
INSERT INTO `sys_roles_resource` VALUES (1, 63);
INSERT INTO `sys_roles_resource` VALUES (1, 64);
INSERT INTO `sys_roles_resource` VALUES (1, 80);
INSERT INTO `sys_roles_resource` VALUES (1, 81);
INSERT INTO `sys_roles_resource` VALUES (1, 83);
INSERT INTO `sys_roles_resource` VALUES (1, 84);
INSERT INTO `sys_roles_resource` VALUES (1, 85);
INSERT INTO `sys_roles_resource` VALUES (1, 86);
INSERT INTO `sys_roles_resource` VALUES (1, 87);
INSERT INTO `sys_roles_resource` VALUES (1, 88);
INSERT INTO `sys_roles_resource` VALUES (1, 89);
INSERT INTO `sys_roles_resource` VALUES (2, 1);
INSERT INTO `sys_roles_resource` VALUES (2, 57);
INSERT INTO `sys_roles_resource` VALUES (2, 61);
INSERT INTO `sys_roles_resource` VALUES (2, 62);
INSERT INTO `sys_roles_resource` VALUES (2, 63);
INSERT INTO `sys_roles_resource` VALUES (2, 80);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_users_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'xiaohei', 'ecc4e28642eb2a738228a20629a64fa2', '08eea8ffe8d4d1716d7e426a1b0353b8', 0);
INSERT INTO `sys_user` VALUES (18, 'xiaobai', 'ccf25ef2eaf4456ddd9e9164789dccb0', 'd34a30fba39e74bc923069114c88b3f8', 0);
INSERT INTO `sys_user` VALUES (20, 'xiaolan', '8546873bacadbcdcb9fdf82cad99cb74', 'f461f2fc3acfa78f9b698fd39f08926a', 0);
INSERT INTO `sys_user` VALUES (49, 'x1', '5d4dfb28069cd351360b767fe7a05efb', '340e346e76e70021432807263a3c8102', 0);
INSERT INTO `sys_user` VALUES (50, 'x2', 'c9c3011c93b63497205af883dadfab0a', '2021a188f9dd0a29b1ca9fefb97a6f4a', 0);
INSERT INTO `sys_user` VALUES (51, 'x3', '2292caac9fadbc9de8c491e6c38cf6b8', 'c66ad504abd8b16cbd9d0791f6768044', 0);
INSERT INTO `sys_user` VALUES (52, 'x4', '7087d2232b994905db65ad1c598790c2', 'f8340b9992f8a7d9fc3d4f28a8c0e2d4', 0);
INSERT INTO `sys_user` VALUES (53, 'x5', '6081b1836a9cc133c653a6292e19bab0', '81c412c52be82fe0c9f42ce8604dce90', 0);
INSERT INTO `sys_user` VALUES (54, 'x6', '628da79faec1745d72afb0fbb0786775', 'a5816af1bb388b1c2d099cced52873b0', 0);
INSERT INTO `sys_user` VALUES (55, 'x7', '98efebbfd86fac7dc3196183826f9521', '52ff76ce7a2975be64a31da151868dcc', 0);
INSERT INTO `sys_user` VALUES (56, 'x8', '4d08e4b6e692fb615780754e6202abfa', 'c078ba813dadee9cb880c76712aa74ff', 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
BEGIN;
INSERT INTO `sys_users_roles` VALUES (1, 1);
INSERT INTO `sys_users_roles` VALUES (18, 2);
INSERT INTO `sys_users_roles` VALUES (20, 1);
INSERT INTO `sys_users_roles` VALUES (49, 1);
INSERT INTO `sys_users_roles` VALUES (50, 1);
INSERT INTO `sys_users_roles` VALUES (51, 1);
INSERT INTO `sys_users_roles` VALUES (52, 1);
INSERT INTO `sys_users_roles` VALUES (53, 1);
INSERT INTO `sys_users_roles` VALUES (54, 1);
INSERT INTO `sys_users_roles` VALUES (55, 2);
INSERT INTO `sys_users_roles` VALUES (56, 1);
COMMIT;

-- ----------------------------
-- Procedure structure for myproc1
-- ----------------------------
DROP PROCEDURE IF EXISTS `myproc1`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `myproc1`(in did int, OUT s int)
BEGIN
      SELECT COUNT(*) INTO s FROM dept where dept.deptno=did;
	set s =2;
    END;
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;

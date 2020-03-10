/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50727
Source Host           : 10.16.33.51:3306
Source Database       : df_oa

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-03-09 13:43:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oa_software
-- ----------------------------
DROP TABLE IF EXISTS `oa_software`;
CREATE TABLE `oa_software` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '软件名s',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of oa_software
-- ----------------------------
INSERT INTO `oa_software` VALUES ('0cb0585a80084efeb6450f675bf68d53', 'Photoshop');
INSERT INTO `oa_software` VALUES ('0d4bc3386b25487facd9d9d7eb46889a', '驱动精灵');
INSERT INTO `oa_software` VALUES ('12e92e993ff44ea8a04075be37607634', 'Adobe Illustrator');
INSERT INTO `oa_software` VALUES ('189b835016534a2695cb4a013ae4781b', 'Adobe After Effects');
INSERT INTO `oa_software` VALUES ('2130a69494ab461ca1514f728d8c3f2b', 'VMware Workstation Pro');
INSERT INTO `oa_software` VALUES ('3dd6998c052a4ed69d8ceb23082489e6', '会声会影');
INSERT INTO `oa_software` VALUES ('418be6bef2e449bea302de0de27914f6', 'Windows优化大师');
INSERT INTO `oa_software` VALUES ('463d700b9bab43de9b6d7964de149e74', 'CAD');
INSERT INTO `oa_software` VALUES ('53de261e3e2b4388990676be2ba89e0f', 'ACDSee');
INSERT INTO `oa_software` VALUES ('5a4379b736954cbca83a8a98fa143979', 'Disk Genius');
INSERT INTO `oa_software` VALUES ('62b584b43a5a481abed4389ba5ed06fd', 'TeamViewer');
INSERT INTO `oa_software` VALUES ('68530175756c409b82a169bea75eea1b', '鲁大师');
INSERT INTO `oa_software` VALUES ('79e7f43353654bee9e04e75c327e1a5a', 'WinRar');
INSERT INTO `oa_software` VALUES ('85a470a2f454445ca27869e9c02201cf', 'iMindMap');
INSERT INTO `oa_software` VALUES ('8907779a123448ae9614408cc4a3a056', 'CorelDRAW');
INSERT INTO `oa_software` VALUES ('937992e2ea45406988505d28822310a9', 'PDF转换器');
INSERT INTO `oa_software` VALUES ('996f912e471a465c954251442c697533', 'Xmind');
INSERT INTO `oa_software` VALUES ('9dafe0ec4c394da392c64672ac73c4a8', 'Office');
INSERT INTO `oa_software` VALUES ('9db5764fda3d45928aa30dc2dfa1bed4', '驱动人生');
INSERT INTO `oa_software` VALUES ('a5f93014f2734b4b8e219ee294a8ee73', '万彩动画大师');
INSERT INTO `oa_software` VALUES ('a8022bcf6926416088ece76e34bd836d', 'Picasa');
INSERT INTO `oa_software` VALUES ('b3a1c66c450148b89aa1191b16325cec', 'PDF');
INSERT INTO `oa_software` VALUES ('be3f9abcb4bd4381a695620a954c3440', 'WPS');
INSERT INTO `oa_software` VALUES ('ca4d82500a834aa9b8c4657e7172e9d5', '金山PDF');
INSERT INTO `oa_software` VALUES ('d274f88a0f734a82b09591e52cc13d8e', 'Nero');
INSERT INTO `oa_software` VALUES ('d60d5161e62f4235b3af41ad640e24ea', '美图秀秀');
INSERT INTO `oa_software` VALUES ('f3c822cd6d344bc5a13f1ac6f372286e', 'PPT助手');

-- ----------------------------
-- Table structure for oa_user
-- ----------------------------
DROP TABLE IF EXISTS `oa_user`;
CREATE TABLE `oa_user` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
  `job_number` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '工号',
  `department` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '部门',
  `oa_ids` char(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '办公软件id',
  `other_oa` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '其他软件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of oa_user
-- ----------------------------
INSERT INTO `oa_user` VALUES ('262485412bdb41559df179bb6a651884', '呵呵', '056', '123', '62b584b43a5a481abed4389ba5ed06fd,68530175756c409b82a169bea75eea1b', '啊啊');
INSERT INTO `oa_user` VALUES ('2947028cc3334fada00540f197a028e1', '红孩儿', '222', '天宫', '53de261e3e2b4388990676be2ba89e0f,5a4379b736954cbca83a8a98fa143979', '合会');
INSERT INTO `oa_user` VALUES ('3b47332216cc4a72868afc296cec64c5', '321', '223', '11', '463d700b9bab43de9b6d7964de149e74,53de261e3e2b4388990676be2ba89e0f', '113');
INSERT INTO `oa_user` VALUES ('b2c82b76fd8441909706370234c0aab4', '戴飞', '09', '开发部', '0cb0585a80084efeb6450f675bf68d53,0d4bc3386b25487facd9d9d7eb46889a', '灭有了');
INSERT INTO `oa_user` VALUES ('c39fea46b6164ab3a844ef546086cc6b', '钉钉', '啊啊', '问我', '463d700b9bab43de9b6d7964de149e74,53de261e3e2b4388990676be2ba89e0f,', '');

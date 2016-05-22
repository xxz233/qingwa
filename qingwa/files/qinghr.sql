/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost
 Source Database       : qinghr

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : utf-8

 Date: 05/20/2016 15:07:35 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL,
  `loginIp` varchar(30) DEFAULT NULL,
  `isSuper` tinyint(1) DEFAULT NULL,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `count` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `admin`
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', null, null, '1', '2016-05-16 12:56:13', null, '1'), ('2', 'zhang', '1234', null, null, '0', '2016-05-17 11:43:48', null, '1'), ('3', 'sun', '1234', null, null, '0', '2016-05-17 11:43:55', null, '1');
COMMIT;

-- ----------------------------
--  Table structure for `adminLog`
-- ----------------------------
DROP TABLE IF EXISTS `adminLog`;
CREATE TABLE `adminLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminId` int(11) DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL,
  `loginIp` varchar(30) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `adminId` (`adminId`),
  CONSTRAINT `FK_adminLog_adminId` FOREIGN KEY (`adminId`) REFERENCES `admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `admin_manageMenu`
-- ----------------------------
DROP TABLE IF EXISTS `admin_manageMenu`;
CREATE TABLE `admin_manageMenu` (
  `adminId` int(11) DEFAULT NULL,
  `manageMenuId` int(11) DEFAULT NULL,
  KEY `adminId` (`adminId`),
  KEY `managerMenuId` (`manageMenuId`),
  CONSTRAINT `FK_admin_manageMenu_adminId` FOREIGN KEY (`adminId`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_admin_manageMenu_manageMenuId` FOREIGN KEY (`manageMenuId`) REFERENCES `manageMenu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `admin_manageMenu`
-- ----------------------------
BEGIN;
INSERT INTO `admin_manageMenu` VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('1', '4'), ('1', '5'), ('1', '6'), ('1', '7');
COMMIT;

-- ----------------------------
--  Table structure for `advertisementCompany`
-- ----------------------------
DROP TABLE IF EXISTS `advertisementCompany`;
CREATE TABLE `advertisementCompany` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `target` varchar(6) DEFAULT '_blank',
  `pic` varchar(50) DEFAULT NULL,
  `smallPic` varchar(50) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `editTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `count` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `advertisementPosition`
-- ----------------------------
DROP TABLE IF EXISTS `advertisementPosition`;
CREATE TABLE `advertisementPosition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position` varchar(20) DEFAULT NULL,
  `advertisementId` int(11) DEFAULT NULL,
  `editTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `advertisementId` (`advertisementId`),
  CONSTRAINT `FK_advertisementPositon_advertisementId` FOREIGN KEY (`advertisementId`) REFERENCES `advertisementCompany` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `area`
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `area`
-- ----------------------------
BEGIN;
INSERT INTO `area` VALUES ('1', '市南区', '1', '1'), ('2', '市北区', '2', '1');
COMMIT;

-- ----------------------------
--  Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminId` int(11) DEFAULT NULL,
  `articleTypeId` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `keyWord` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `info` varchar(10000) DEFAULT NULL,
  `view` int(11) DEFAULT '0',
  `agree` int(11) DEFAULT '0',
  `isTop` tinyint(1) DEFAULT '0',
  `pic` varchar(50) DEFAULT NULL,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `eidtTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `articleTypeId` (`articleTypeId`),
  KEY `adminId` (`adminId`),
  CONSTRAINT `FK_article_adminId` FOREIGN KEY (`adminId`) REFERENCES `admin` (`id`),
  CONSTRAINT `FK_article_articleTypeId` FOREIGN KEY (`articleTypeId`) REFERENCES `articleType` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `articleType`
-- ----------------------------
DROP TABLE IF EXISTS `articleType`;
CREATE TABLE `articleType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `attachmenResume`
-- ----------------------------
DROP TABLE IF EXISTS `attachmenResume`;
CREATE TABLE `attachmenResume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `filePath` varchar(50) DEFAULT NULL,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `isDefault` tinyint(1) DEFAULT '0',
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `FK_attachmenResume_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `companyExperience`
-- ----------------------------
DROP TABLE IF EXISTS `companyExperience`;
CREATE TABLE `companyExperience` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `minTime` int(11) DEFAULT NULL,
  `maxTime` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `companyExperience`
-- ----------------------------
BEGIN;
INSERT INTO `companyExperience` VALUES ('1', '2k以下', null, '2', '1'), ('2', '15k-25k', '15', '25', '2'), ('3', '25k-50k', '25', '50', '3');
COMMIT;

-- ----------------------------
--  Table structure for `companyFoundTeam`
-- ----------------------------
DROP TABLE IF EXISTS `companyFoundTeam`;
CREATE TABLE `companyFoundTeam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `direction` varchar(200) DEFAULT NULL,
  `pic` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `companyInfo`
-- ----------------------------
DROP TABLE IF EXISTS `companyInfo`;
CREATE TABLE `companyInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `fullName` varchar(100) DEFAULT NULL,
  `shortName` varchar(50) DEFAULT NULL,
  `pic` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `areaId` int(11) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `industryId` int(11) DEFAULT NULL,
  `scaleId` int(11) DEFAULT NULL,
  `stagId` int(11) DEFAULT NULL,
  `direction` varchar(200) DEFAULT NULL,
  `detail` varchar(1000) DEFAULT NULL,
  `isPass` tinyint(1) DEFAULT '0',
  `isValidate` tinyint(1) DEFAULT '0',
  `validatePic` varchar(50) DEFAULT NULL,
  `validateAdmin` varchar(50) DEFAULT NULL,
  `validateTime` datetime DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `downloadCount` int(11) DEFAULT NULL,
  `createJobCount` int(11) DEFAULT NULL,
  `view` int(11) DEFAULT '0',
  `isTop` tinyint(1) DEFAULT NULL,
  `editTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `canCreateJob` tinyint(1) DEFAULT '0',
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `areaId` (`areaId`),
  KEY `industryId` (`industryId`),
  KEY `scaleId` (`scaleId`),
  KEY `stagId` (`stagId`),
  CONSTRAINT `FK_companyInfo_areaId` FOREIGN KEY (`areaId`) REFERENCES `area` (`id`),
  CONSTRAINT `FK_companyInfo_industryId` FOREIGN KEY (`industryId`) REFERENCES `industry` (`id`),
  CONSTRAINT `FK_companyInfo_scaleId` FOREIGN KEY (`scaleId`) REFERENCES `companyScale` (`id`),
  CONSTRAINT `FK_companyInfo_stageId` FOREIGN KEY (`stagId`) REFERENCES `companyStage` (`id`),
  CONSTRAINT `FK_companyInfo_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `companyInvestor`
-- ----------------------------
DROP TABLE IF EXISTS `companyInvestor`;
CREATE TABLE `companyInvestor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) DEFAULT NULL,
  `stageId` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `companyId` (`companyId`),
  KEY `stageId` (`stageId`),
  CONSTRAINT `FK_companyInvestor_companyId` FOREIGN KEY (`companyId`) REFERENCES `companyInfo` (`id`),
  CONSTRAINT `FK_companyInvestor_stageId` FOREIGN KEY (`stageId`) REFERENCES `companyStage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `companyJob`
-- ----------------------------
DROP TABLE IF EXISTS `companyJob`;
CREATE TABLE `companyJob` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) DEFAULT NULL,
  `jobTypeId` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `jobNatureId` int(4) DEFAULT NULL,
  `minSalary` int(11) DEFAULT NULL,
  `maxSalary` int(11) DEFAULT NULL,
  `areaId` int(11) DEFAULT NULL,
  `experienceId` int(11) DEFAULT NULL,
  `degreeId` int(11) DEFAULT NULL,
  `direction` varchar(1000) DEFAULT NULL,
  `view` int(11) DEFAULT '0',
  `resumeCount` int(11) DEFAULT NULL,
  `editTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `refreshTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `isDown` tinyint(1) DEFAULT '1',
  `isValidate` tinyint(1) DEFAULT NULL,
  `adress` varchar(200) DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `companyId` (`companyId`),
  KEY `jobTypeId` (`jobTypeId`),
  KEY `jobNatureId` (`jobNatureId`),
  KEY `areaId` (`areaId`),
  KEY `experienceId` (`experienceId`),
  KEY `digreeId` (`degreeId`),
  CONSTRAINT `FK_companyJob_areaId` FOREIGN KEY (`areaId`) REFERENCES `area` (`id`),
  CONSTRAINT `FK_companyJob_companyId` FOREIGN KEY (`companyId`) REFERENCES `companyInfo` (`id`),
  CONSTRAINT `FK_companyJob_digreeId` FOREIGN KEY (`degreeId`) REFERENCES `degree` (`id`),
  CONSTRAINT `FK_companyJob_experienceId` FOREIGN KEY (`experienceId`) REFERENCES `companyExperience` (`id`),
  CONSTRAINT `FK_companyJob_jobNatureId` FOREIGN KEY (`jobNatureId`) REFERENCES `companyJobNature` (`id`),
  CONSTRAINT `FK_companyJob_jobTypeId` FOREIGN KEY (`jobTypeId`) REFERENCES `jobType` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `companyJobNature`
-- ----------------------------
DROP TABLE IF EXISTS `companyJobNature`;
CREATE TABLE `companyJobNature` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `companyJobNature`
-- ----------------------------
BEGIN;
INSERT INTO `companyJobNature` VALUES ('1', '全职', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `companyLabel`
-- ----------------------------
DROP TABLE IF EXISTS `companyLabel`;
CREATE TABLE `companyLabel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `companyId` (`companyId`),
  CONSTRAINT `FK_companyLabel_companyId` FOREIGN KEY (`companyId`) REFERENCES `companyInfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `companyPic`
-- ----------------------------
DROP TABLE IF EXISTS `companyPic`;
CREATE TABLE `companyPic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `pic` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `companyId` (`companyId`),
  CONSTRAINT `FK_companyPic_companyId` FOREIGN KEY (`companyId`) REFERENCES `companyInfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `companyPreparedLabel`
-- ----------------------------
DROP TABLE IF EXISTS `companyPreparedLabel`;
CREATE TABLE `companyPreparedLabel` (
  `title` varchar(20) NOT NULL,
  `sort` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `companyProduct`
-- ----------------------------
DROP TABLE IF EXISTS `companyProduct`;
CREATE TABLE `companyProduct` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `pic` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `direction` varchar(1000) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `companyId` (`companyId`),
  CONSTRAINT `FK_companyProduct_companyId` FOREIGN KEY (`companyId`) REFERENCES `companyInfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `companyScale`
-- ----------------------------
DROP TABLE IF EXISTS `companyScale`;
CREATE TABLE `companyScale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `companyStage`
-- ----------------------------
DROP TABLE IF EXISTS `companyStage`;
CREATE TABLE `companyStage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `companyTemptation`
-- ----------------------------
DROP TABLE IF EXISTS `companyTemptation`;
CREATE TABLE `companyTemptation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `companyId` (`companyId`),
  CONSTRAINT `FK_companyTemptation_companyId` FOREIGN KEY (`companyId`) REFERENCES `companyInfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `config`
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `configKey` varchar(50) DEFAULT NULL,
  `configValue` varchar(500) DEFAULT NULL,
  `configDescription` varchar(500) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `config`
-- ----------------------------
BEGIN;
INSERT INTO `config` VALUES ('1', 'smtpHost', 'smtp.163.com', '系统邮件发送地址', '1'), ('2', 'licenseCode', '1qingsoft', 'smtp服务授权码', '1'), ('3', 'serverEmail', 'frogofficial@163.com', '系统邮箱', '1'), ('4', 'emailFirstForReg', '亲，欢迎您注册青蛙人才招聘网，现在距离成功还有一步，请点击下面的链接完成注册吧。如果打不开请复制一下粘贴到浏览器的地址栏访问~<br />', '注册验证邮件开头', '1'), ('5', 'emailLastForReg', '<br />本邮件是系统自动发送的，请勿回复！', '注册验证邮件结尾', '1'), ('6', 'subjectForReg', '青蛙网--注册验证', '注册验证主题', '1'), ('7', 'hotSearch', 'Java,PHP,Adroid,IOS,前端,产品经理,UI,运营,BD,实习', '首页热门搜索', '1'), ('8', 'copyRight', '2016-2017 Qingwa', '版权所有', '1'), ('9', 'beianUrl', null, '网站备案url', '1'), ('10', 'beianNum', '青ICP备14023790号-2', '网站备案号', '1');
COMMIT;

-- ----------------------------
--  Table structure for `current`
-- ----------------------------
DROP TABLE IF EXISTS `current`;
CREATE TABLE `current` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `current`
-- ----------------------------
BEGIN;
INSERT INTO `current` VALUES ('1', 'current', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `degree`
-- ----------------------------
DROP TABLE IF EXISTS `degree`;
CREATE TABLE `degree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `degree`
-- ----------------------------
BEGIN;
INSERT INTO `degree` VALUES ('1', '大专', '1', '1'), ('2', '本科', '2', '1');
COMMIT;

-- ----------------------------
--  Table structure for `educationalBackground`
-- ----------------------------
DROP TABLE IF EXISTS `educationalBackground`;
CREATE TABLE `educationalBackground` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resumeId` int(11) DEFAULT NULL,
  `school` varchar(50) DEFAULT NULL,
  `degreeId` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `enable` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `resumeId` (`resumeId`),
  KEY `digreeId` (`degreeId`),
  CONSTRAINT `FK_educationalBackground_digreeId` FOREIGN KEY (`degreeId`) REFERENCES `degree` (`id`),
  CONSTRAINT `FK_educationalBackground_resumeId` FOREIGN KEY (`resumeId`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `industry`
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jobCollection`
-- ----------------------------
DROP TABLE IF EXISTS `jobCollection`;
CREATE TABLE `jobCollection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jobId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `jobId` (`jobId`),
  CONSTRAINT `FK_jobCollection_jobId` FOREIGN KEY (`jobId`) REFERENCES `companyJob` (`id`),
  CONSTRAINT `FK_jobCollection_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jobSubscriber`
-- ----------------------------
DROP TABLE IF EXISTS `jobSubscriber`;
CREATE TABLE `jobSubscriber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `cycle` int(11) DEFAULT NULL,
  `jobTypeId` int(11) DEFAULT NULL,
  `areaId` int(11) DEFAULT NULL,
  `stageId` int(11) DEFAULT NULL,
  `industryId` int(11) DEFAULT NULL,
  `personalSalaryId` int(11) DEFAULT NULL,
  `nextSendTime` datetime DEFAULT NULL,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `jobTypeId` (`jobTypeId`),
  KEY `areaId` (`areaId`),
  KEY `developmentStageId` (`stageId`),
  KEY `industryId` (`industryId`),
  KEY `personalSalaryId` (`personalSalaryId`),
  CONSTRAINT `FK_jobSubscriber_areaId` FOREIGN KEY (`areaId`) REFERENCES `area` (`id`),
  CONSTRAINT `FK_jobSubscriber_industryId` FOREIGN KEY (`industryId`) REFERENCES `industry` (`id`),
  CONSTRAINT `FK_jobSubscriber_jobTypeId` FOREIGN KEY (`jobTypeId`) REFERENCES `jobType` (`id`),
  CONSTRAINT `FK_jobSubscriber_personalSalaryId` FOREIGN KEY (`personalSalaryId`) REFERENCES `personalSalary` (`id`),
  CONSTRAINT `FK_jobSubscriber_stageId` FOREIGN KEY (`stageId`) REFERENCES `companyStage` (`id`),
  CONSTRAINT `FK_jobSubscriber_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jobtype`
-- ----------------------------
DROP TABLE IF EXISTS `jobtype`;
CREATE TABLE `jobtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `isHot` tinyint(1) DEFAULT '0',
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `parentId` (`parentId`),
  CONSTRAINT `FK_jobType_shelf` FOREIGN KEY (`parentId`) REFERENCES `jobtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `jobtype`
-- ----------------------------
BEGIN;
INSERT INTO `jobtype` VALUES ('1', null, '技术', '1', '0', '1'), ('2', null, '产品', '2', '0', '1'), ('3', null, '设计', '3', '0', '1'), ('4', null, '运营', '4', '0', '1'), ('5', null, '市场与销售', '5', '0', '1'), ('6', null, '职能', '6', '0', '1'), ('7', '1', '后端开发', '7', '0', '1'), ('8', '1', '移动开发', '8', '0', '1'), ('9', '1', '前端开发', '9', '0', '1'), ('10', '1', '测试', '10', '0', '1'), ('11', '1', '运维', '11', '0', '1'), ('12', '1', 'DBA', '12', '0', '1'), ('13', '1', '项目管理', '13', '0', '1'), ('14', '1', '高端职位', '14', '0', '1'), ('15', '7', 'Java', '15', '1', '1'), ('16', '7', 'C++', '16', '1', '1'), ('17', '7', 'PHP', '17', '1', '1'), ('18', '7', '数据挖掘', '18', '0', '1'), ('19', '7', 'C', '19', '1', '1'), ('20', '7', 'C#', '20', '0', '1'), ('21', '7', '.NET', '21', '0', '1'), ('22', '7', 'Hadoop', '22', '0', '1'), ('23', '7', 'Python', '23', '0', '1'), ('24', '7', 'Delphi', '24', '0', '1'), ('25', '7', 'VB', '25', '0', '1'), ('26', '7', 'Perl', '26', '0', '1'), ('27', '7', 'Ruby', '27', '0', '1'), ('28', '7', 'Node.js', '28', '0', '1'), ('29', '8', 'HTML5', '29', '0', '1'), ('30', '8', 'Android', '30', '1', '1'), ('31', '8', 'IOS', '31', '1', '1'), ('32', '8', 'WP', '32', '0', '1'), ('33', '9', 'web前端', '33', '0', '1'), ('34', '9', 'Flash', '34', '0', '1'), ('35', '9', 'html5', '35', '0', '1'), ('36', '9', 'JavaScript', '36', '0', '1'), ('37', '9', 'U3D', '37', '0', '1'), ('38', '9', 'COCOS2D-X', '38', '0', '1'), ('39', '10', '测试工程师', '39', '0', '1'), ('40', '10', '自动化测试', '40', '0', '1'), ('41', '10', '功能测试', '41', '0', '1'), ('42', '10', '性能测试', '42', '0', '1'), ('43', '10', '测试开发', '43', '0', '1'), ('44', '11', '运维工程师', '44', '0', '1'), ('45', '11', '运维开发工程师', '45', '0', '1'), ('46', '11', '网络工程师', '46', '0', '1'), ('47', '11', '系统工程师', '47', '0', '1'), ('48', '11', 'IT支持', '48', '0', '1'), ('49', '12', 'MySQL', '49', '0', '1'), ('50', '12', 'SQLServer', '50', '0', '1'), ('51', '12', 'Oracle', '51', '0', '1'), ('52', '12', 'DB2', '52', '0', '1'), ('53', '12', 'MongoDB', '53', '0', '1'), ('54', '13', '项目经理', '54', '1', '1'), ('55', '14', '技术经理', '55', '1', '1'), ('56', '14', '技术总监', '56', '0', '1'), ('57', '14', '测试经理', '57', '0', '1'), ('58', '14', '架构师', '58', '1', '1'), ('59', '14', 'CTO', '59', '0', '1'), ('60', '14', '运维总监', '60', '0', '1'), ('61', '2', '产品经理', '61', '0', '1'), ('62', '2', '产品设计师', '62', '0', '1'), ('63', '2', '高端职位', '63', '0', '1'), ('64', '61', '产品经理', '64', '1', '1'), ('65', '61', '网页产品经理', '65', '0', '1'), ('66', '61', '移动产品经理', '66', '0', '1'), ('67', '61', '产品助理', '67', '1', '1'), ('68', '61', '数据产品经理', '68', '0', '1'), ('69', '61', '电商产品经理', '69', '0', '1'), ('70', '61', '游戏策划', '70', '1', '1'), ('71', '61', '无线产品经理', '71', '1', '1'), ('72', '62', '网页产品设计师', '72', '0', '1'), ('73', '62', '无线产品设计师', '73', '0', '1'), ('74', '63', '产品部经理', '74', '0', '1'), ('75', '63', '产品总监', '75', '0', '1'), ('76', '3', '视觉设计', '76', '0', '1'), ('77', '3', '交互设计', '77', '0', '1'), ('78', '3', '用户研究', '78', '0', '1'), ('79', '3', '高端职位', '79', '0', '1'), ('80', '76', '视觉设计师', '80', '0', '1'), ('81', '76', '网页设计师', '81', '0', '1'), ('82', '76', 'Flash设计师', '82', '0', '1'), ('83', '76', 'APP设计师', '83', '0', '1'), ('84', '76', 'UI设计师', '84', '1', '1'), ('85', '76', '平面设计师', '85', '0', '1'), ('86', '76', '美术设计师', '86', '0', '1'), ('87', '76', '广告设计师', '87', '1', '1'), ('88', '76', '多媒体设计师', '88', '0', '1'), ('89', '76', '原画师', '89', '1', '1'), ('90', '76', '游戏特效', '90', '0', '1'), ('91', '76', '游戏界面设计时', '91', '0', '1'), ('92', '76', '游戏场景', '92', '0', '1'), ('93', '76', '游戏角色', '93', '0', '1'), ('94', '76', '游戏动作', '94', '0', '1'), ('95', '77', '交互设计师', '95', '1', '1'), ('96', '77', '无线交互设计师', '96', '0', '1'), ('97', '77', '网页交互设计师', '97', '0', '1'), ('98', '77', '硬件交互设计师', '98', '0', '1'), ('99', '78', '数据分析师', '99', '1', '1'), ('100', '78', '用户研究员', '100', '0', '1'), ('101', '78', '游戏数值策划', '101', '0', '1'), ('102', '79', '设计经理/主管', '102', '0', '1'), ('103', '79', '设计总监', '103', '0', '1'), ('104', '79', '视觉设计经理/主管', '104', '0', '1'), ('105', '79', '视觉设计总监', '105', '0', '1'), ('106', '79', '交互设计经理/主管', '106', '0', '1'), ('107', '79', '交互设计总监', '107', '0', '1'), ('108', '79', '用户研究经理/主管', '108', '0', '1'), ('109', '79', '用户研究总监', '109', '0', '1'), ('110', '4', '运营', '110', '0', '1'), ('111', '4', '编辑', '111', '0', '1'), ('112', '4', '客服', '112', '0', '1'), ('113', '4', '高端职位', '113', '0', '1'), ('114', '110', '用户运营', '114', '0', '1'), ('115', '110', '产品运营', '115', '0', '1'), ('116', '110', '数据运营', '116', '1', '1'), ('117', '110', '内容运营', '117', '0', '1'), ('118', '110', '活动运营', '118', '0', '1'), ('119', '110', '商家运营', '119', '0', '1'), ('120', '110', '品类运营', '120', '0', '1'), ('121', '110', '游戏运营', '121', '1', '1'), ('122', '110', '网络推广', '122', '0', '1'), ('123', '111', '副主编', '123', '0', '1'), ('124', '111', '内容编辑', '124', '0', '1'), ('125', '112', '售前咨询', '125', '0', '1'), ('126', '112', '售后客服', '126', '0', '1'), ('127', '113', '主编', '127', '1', '1'), ('128', '113', '运营总监', '128', '0', '1'), ('129', '113', 'COO', '129', '0', '1'), ('130', '5', '市场/营销', '130', '0', '1'), ('131', '5', '公关', '131', '0', '1'), ('132', '5', '销售', '132', '0', '1'), ('133', '5', '高端职位', '133', '0', '1'), ('134', '130', '市场营销', '134', '0', '1'), ('135', '130', '市场策划', '135', '1', '1'), ('136', '130', '市场顾问', '136', '0', '1'), ('137', '130', '市场推广', '137', '1', '1'), ('138', '130', 'SEO', '138', '0', '1'), ('139', '130', 'SEM', '139', '0', '1'), ('140', '130', '商务渠道', '140', '0', '1'), ('141', '130', '商务数据分析', '141', '0', '1'), ('142', '130', '活动策划', '142', '1', '1'), ('143', '131', '媒介经理', '143', '0', '1'), ('144', '131', '广告协调', '144', '0', '1'), ('145', '131', '品牌公关', '145', '0', '1'), ('146', '132', '销售专员', '146', '0', '1'), ('147', '132', '销售经理', '147', '1', '1'), ('148', '132', '客户代表', '148', '0', '1'), ('149', '132', '大客户代表', '149', '0', '1'), ('150', '132', 'BD经理', '150', '1', '1'), ('151', '132', '商务渠道', '151', '0', '1'), ('152', '132', '渠道销售', '152', '0', '1'), ('153', '132', '代理商销售', '153', '0', '1'), ('154', '133', '市场总监', '154', '1', '1'), ('155', '133', '销售总监', '155', '0', '1'), ('156', '133', '商务总监', '156', '0', '1'), ('157', '133', 'CMO', '157', '0', '1'), ('158', '133', '公关总监', '158', '0', '1'), ('159', '6', '人力资源', '159', '0', '1'), ('160', '6', '行政', '160', '0', '1'), ('161', '6', '财务', '161', '0', '1'), ('162', '6', '高端职位', '162', '0', '1'), ('163', '159', '人力资源', '163', '0', '1'), ('164', '159', '招聘', '164', '0', '1'), ('165', '159', 'HRBP', '165', '1', '1'), ('166', '159', '人事/HR', '166', '0', '1'), ('167', '159', '培训经理', '167', '0', '1'), ('168', '159', '薪资福利经理', '168', '0', '1'), ('169', '159', '绩效考核经理', '169', '0', '1'), ('170', '160', '助理', '170', '0', '1'), ('171', '160', '前台', '171', '0', '1'), ('172', '160', '法务', '172', '0', '1'), ('173', '160', '行政', '173', '1', '1'), ('174', '161', '会计', '174', '1', '1'), ('175', '161', '出纳', '175', '1', '1'), ('176', '161', '财务', '176', '0', '1'), ('177', '162', '行政总监/经理', '177', '0', '1'), ('178', '162', '财务总监/经理', '178', '0', '1'), ('179', '162', 'HRD/HRM', '179', '0', '1'), ('180', '162', 'CFO', '180', '0', '1');
COMMIT;

-- ----------------------------
--  Table structure for `manageMenu`
-- ----------------------------
DROP TABLE IF EXISTS `manageMenu`;
CREATE TABLE `manageMenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `target` varchar(6) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `parentId` (`parentId`),
  CONSTRAINT `FK_manageMenu_shelf` FOREIGN KEY (`parentId`) REFERENCES `manageMenu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `manageMenu`
-- ----------------------------
BEGIN;
INSERT INTO `manageMenu` VALUES ('1', '管理员', null, '1', null, '_shelf', '1'), ('2', '用户管理', null, '2', null, '_shelf', '1'), ('3', '公司管理', null, '3', null, '_shelf', '1'), ('4', '公司审核', null, '4', null, '_shelf', '1'), ('5', '职场资讯', null, '5', null, '_shelf', '1'), ('6', '广告管理', null, '6', null, '_shelf', '1'), ('7', '网站配置', null, '7', null, '_shelf', '1'), ('8', '超级管理员', '1', '8', 'list_super.jsp', '_shelf', '1'), ('9', '普通管理员', '1', '9', 'list.jsp', '_shelf', '1'), ('10', '个人用户', '2', '10', null, '_shelf', '1'), ('11', '公司用户', '2', '11', null, '_shelf', '1'), ('12', '查看公司', '3', '12', null, '_shelf', '1'), ('13', '职位管理', '3', '13', null, '_shelf', '1'), ('14', '其它配置', '3', '14', null, '_shelf', '1'), ('15', '正在审核', '4', '15', null, '_shelf', '1'), ('16', '审核完成', '4', '16', null, '_shelf', '1'), ('17', '文章管理', '5', '17', null, '_shelf', '1'), ('18', '分类管理', '5', '18', null, '_shelf', '1'), ('19', '展示位置', '6', '19', null, '_shelf', '1'), ('20', '广告商管理', '6', '20', null, '_shelf', '1'), ('21', '网站信息', '7', '21', null, '_shelf', '1'), ('22', '友情链接', '7', '22', null, '_shelf', '1'), ('23', '系统设置', '7', '23', null, '_shelf', '1');
COMMIT;

-- ----------------------------
--  Table structure for `personalExperience`
-- ----------------------------
DROP TABLE IF EXISTS `personalExperience`;
CREATE TABLE `personalExperience` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `personalExperience`
-- ----------------------------
BEGIN;
INSERT INTO `personalExperience` VALUES ('1', '应届毕业生', '1', '1'), ('2', '一年', '2', '1');
COMMIT;

-- ----------------------------
--  Table structure for `personalMenu`
-- ----------------------------
DROP TABLE IF EXISTS `personalMenu`;
CREATE TABLE `personalMenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `target` varchar(6) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `personalMenu`
-- ----------------------------
BEGIN;
INSERT INTO `personalMenu` VALUES ('1', '我的简历', null, '_top', '1', '0', '1'), ('2', '我收藏的职位', null, '_top', '2', '0', '1'), ('3', '我投递的职位', null, '_top', '3', '0', '1'), ('4', '我的订阅', null, '_top', '4', '0', '1'), ('5', '我要找工作', null, '_top', '5', '0', '1'), ('6', '账号设置', null, '_top', '6', '0', '1'), ('7', '退出', null, '_top', '7', '0', '1'), ('8', '我的公司', null, '_top', '8', '1', '1'), ('9', '我发布的职位', null, '_top', '9', '1', '1'), ('10', '我收到的简历', null, '_top', '10', '1', '1'), ('11', '我要招人', '', '_top', '11', '1', '1'), ('12', '账号设置', null, '_top', '12', '1', '1'), ('13', '退出', null, '_top', '13', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `personalSalary`
-- ----------------------------
DROP TABLE IF EXISTS `personalSalary`;
CREATE TABLE `personalSalary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `minSalary` int(11) DEFAULT NULL,
  `maxSalary` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resumeId` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `direction` varchar(1000) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `resumeId` (`resumeId`),
  CONSTRAINT `FK_project_resumeId` FOREIGN KEY (`resumeId`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `protectQuestion`
-- ----------------------------
DROP TABLE IF EXISTS `protectQuestion`;
CREATE TABLE `protectQuestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resumeId` int(11) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `direction` varchar(1000) DEFAULT NULL,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `resumeId` (`resumeId`),
  CONSTRAINT `FK_result_resumeId` FOREIGN KEY (`resumeId`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `resume`
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `pic` varchar(100) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `degreeId` int(11) DEFAULT NULL,
  `experienceId` int(11) DEFAULT NULL,
  `direction` varchar(500) DEFAULT NULL,
  `currentId` int(11) DEFAULT NULL,
  `view` int(11) DEFAULT '0',
  `eaitTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `areaId` int(11) DEFAULT NULL,
  `jobNatureId` int(11) DEFAULT NULL,
  `expectedJob` varchar(50) DEFAULT NULL,
  `minSalary` int(11) DEFAULT NULL,
  `maxSalary` int(11) DEFAULT NULL,
  `downCount` int(11) DEFAULT NULL,
  `releaseTime` datetime DEFAULT NULL,
  `isRelease` tinyint(1) DEFAULT '0',
  `isDefault` tinyint(1) DEFAULT '0',
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `digreeId` (`degreeId`),
  KEY `experienceId` (`experienceId`),
  KEY `areaId` (`areaId`),
  KEY `jobNatureId` (`jobNatureId`),
  KEY `currentId` (`currentId`),
  CONSTRAINT `FK_resume_areaId` FOREIGN KEY (`areaId`) REFERENCES `area` (`id`),
  CONSTRAINT `FK_resume_companyJobNatureId` FOREIGN KEY (`jobNatureId`) REFERENCES `companyJobNature` (`id`),
  CONSTRAINT `FK_resume_currentId` FOREIGN KEY (`currentId`) REFERENCES `current` (`id`),
  CONSTRAINT `FK_resume_digreeId` FOREIGN KEY (`degreeId`) REFERENCES `degree` (`id`),
  CONSTRAINT `FK_resume_experienceId` FOREIGN KEY (`experienceId`) REFERENCES `personalExperience` (`id`),
  CONSTRAINT `FK_resume_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `resume`
-- ----------------------------
BEGIN;
INSERT INTO `resume` VALUES ('1', '1', 'nihao', '???', null, '?', '1231231231', 'chenxianshun@qq.com', '1', '1', 'javaee', '1', '0', '2016-05-14 18:36:07', '1', '1', '11', '15', '25', '0', '2016-05-13 22:38:28', '0', '0', '1');
COMMIT;

-- ----------------------------
--  Table structure for `resumeJob`
-- ----------------------------
DROP TABLE IF EXISTS `resumeJob`;
CREATE TABLE `resumeJob` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyJobId` int(11) DEFAULT NULL,
  `resumeId` int(11) DEFAULT NULL,
  `attachmenResumeId` int(11) DEFAULT NULL,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `statusId` int(11) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT '1',
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `resumeId` (`resumeId`),
  KEY `companyJobId` (`companyJobId`),
  KEY `statusId` (`statusId`),
  KEY `attachmenResumeId` (`attachmenResumeId`),
  CONSTRAINT `FK_resumeJob_attachmenResumeId` FOREIGN KEY (`attachmenResumeId`) REFERENCES `attachmenResume` (`id`),
  CONSTRAINT `FK_resumeJob_companyJobId` FOREIGN KEY (`companyJobId`) REFERENCES `companyJob` (`id`),
  CONSTRAINT `FK_resumeJob_resumeId` FOREIGN KEY (`resumeId`) REFERENCES `resume` (`id`),
  CONSTRAINT `FK_resumeJob_statusId` FOREIGN KEY (`statusId`) REFERENCES `resumeStatus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `resumeStatus`
-- ----------------------------
DROP TABLE IF EXISTS `resumeStatus`;
CREATE TABLE `resumeStatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(20) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `count` int(11) DEFAULT NULL,
  `loginIp` varchar(50) DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `isValidate` tinyint(1) DEFAULT '0',
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'admin@admin.com', '1234', null, '1', '2016-05-11 13:02:30', null, null, null, null, '0', '1'), ('2', '229496115@qq.com', 'adminsfsdf', null, '0', '2016-05-11 16:50:11', null, '0:0:0:0:0:0:0:1', '2016-05-11 16:50:11', 'JeGLGDpADWxjZciYEmrF6IiWVseFb9D3j9A6meW6hUdZVK3NgxkM3o936WNwJN2ni2D8g2gIPMmsiC5fmDiArb7syiXmWQoZHA5Z', '0', '1'), ('3', '229496115@qq.com', 'adminsdfsdf', null, '0', '2016-05-11 17:00:01', null, '127.0.0.1', '2016-05-11 17:00:01', 'fpGyt93ino3qb7aCj8nOt8RbXQKUjNe2fYFjxbLgBRrEjwoIokWHiPRawmIQOLqjBqzEFgtEfJn2ParLRsBGEKnogkfy8qBfVHou', '0', '1'), ('4', 'frogofficial1@163.com', '123456', null, '0', '2016-05-12 10:19:19', null, '127.0.0.1', '2016-05-12 10:19:20', 'k6IhHtYLpb8MR6BsQJp7ImXgfSGI3UID2eBNSBPUdXhvWqcLaCOmokGVGEM3kwWygSGQdipzmaRBBBJunoY3EInEfkq9wTC2fgIe', '0', '1'), ('5', 'frogofficia2l@163.com', '123456', null, '0', '2016-05-12 10:44:22', null, '127.0.0.1', '2016-05-12 10:44:22', '4OrD9Y3ZHApjhs9nnnEogIPCWbWn5Bp4KAgsLWKUTS6fd08kBkoYZRbfqJXqgIqPfWK8eobCMDQxXLjO3Mo5d4z5gYfGeyIE923K', '0', '1'), ('6', 'frogofficia3l@163.com', '123456', null, '0', '2016-05-12 10:55:46', null, '127.0.0.1', '2016-05-12 10:55:46', 'HYBiP5y7JqTkybO7tnBFHY62ShKM5Vp2yEKC6wUC4jceM7KDmLdhLJcc8wxnFNNkIftpg8CxLIeSh74bSJ8rbSmhTuwFe9vrIpdt', '0', '1'), ('7', '2294961154@qq.com', 'admin323', null, '0', '2016-05-17 14:04:26', null, '127.0.0.1', '2016-05-17 14:04:27', 'i3F5RcZJERgW7WCqUmQPuFF3c23CiD9zfwMG4NzPfXavbOdMLb7hiyfuEuxVjMygC4jzodKepZcsxbWmN2HjirCBtSrPJeLHuMgW', '0', '1'), ('8', '2223424323@qq.com', 'adminsdfsfd', null, '0', '2016-05-17 14:05:53', null, '127.0.0.1', '2016-05-17 14:05:54', 'roIsMIZTC2BIjC4kf6OWDZOuMfLYCGmIjhbKmmShFteq4L2AOOyUi3z6mZ4Qtn30WHPunTPaQmOdACPDtNzrRWTaJOcE3uMJj8TJ', '0', '1'), ('9', '234324235@qq.com', 'adminsdfsdf', null, '0', '2016-05-17 14:10:19', '1', '127.0.0.1', '2016-05-17 14:10:20', 'zHgp9bnrHVLYdotUDRaq3fA07YpYrEp6TBxEueXH2Oyh08UB5JWVx5D6nyCKjupwc4eFxCVNbGZwdv8FIt97NWcEdrhKBG2YgfA3', '0', '1');
COMMIT;

-- ----------------------------
--  Table structure for `userProtectQuestion`
-- ----------------------------
DROP TABLE IF EXISTS `userProtectQuestion`;
CREATE TABLE `userProtectQuestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `questionId` int(11) DEFAULT NULL,
  `answer` varchar(20) DEFAULT NULL,
  `inputTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `questionId` (`questionId`),
  CONSTRAINT `FK_userProtectQuestion_questionId` FOREIGN KEY (`questionId`) REFERENCES `protectQuestion` (`id`),
  CONSTRAINT `FK_userProtectQuestion_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `webMenu`
-- ----------------------------
DROP TABLE IF EXISTS `webMenu`;
CREATE TABLE `webMenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `target` varchar(6) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  `position` varchar(10) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `webMenu`
-- ----------------------------
BEGIN;
INSERT INTO `webMenu` VALUES ('1', '首页', 'index.html', '_top', '1', '0', 'top', '1'), ('2', '职位', 'job.html', '_top', '2', '0', 'top', '1'), ('3', '公司', 'company.html', '_top', '3', '0', 'top', '1'), ('4', '蛙塘', 'watang.html', '_top', '4', '0', 'top', '1'), ('5', '我的简历', 'resume.html', '_top', '5', '0', 'top', '1'), ('6', '首页', 'index.html', '_top', '6', '1', 'top', '1'), ('7', '职位', 'job.html', '_top', '7', '1', 'top', '1'), ('8', '公司', 'company.html', '_top', '8', '1', 'top', '1'), ('9', '蛙塘', 'watang.html', '_top', '9', '1', 'top', '1'), ('10', '我的公司', 'my_company.html', '_top', '10', '1', 'top', '1'), ('11', '住趣家居网', 'http://www.zhuqu.com', '_blank', null, null, 'link', '1'), ('12', '人人都是产品经理', 'http://www.woshipm.com', '_blank', null, null, 'link', '1'), ('13', '互联网er的早读课', 'http://zaodula.com', '_blank', null, null, 'link', '1'), ('14', '猎云网', 'http://lieyunwang.com', '_blank', null, null, 'link', '1'), ('15', 'UCloud', 'http://www.ucloud.cn', '_blank', null, null, 'link', '1'), ('16', 'icofans', 'http://www.iconfans.com', '_blank', null, null, 'link', '1'), ('17', 'html5梦工厂', 'http://www.html5dw.com', '_blank', null, null, 'link', '1'), ('18', '手游那点事', 'http://www.skykong.com', '_blank', null, null, 'link', '1'), ('19', 'php100', 'http://www.php100.com', '_blank', null, null, 'link', '1'), ('20', 'uehtml', 'http://www.uehtml.com', '_blank', null, null, 'link', '1'), ('21', 'W3CPlus', 'http://www.w3cplus.com', '_blank', null, null, 'link', '1'), ('22', '盒子UI', 'http://www.boxui.com', '_blank', null, null, 'link', '1'), ('23', 'uimaker', 'http://www.uimaker.com', '_blank', null, null, 'link', '1'), ('24', '互联网的一些事', 'http://www.yixieshi.com', '_blank', null, null, 'link', '1'), ('25', '传课网', 'http://www.chuanke.com', '_blank', null, null, 'link', '1'), ('26', '安卓开发', 'http://www.eoe.cn', '_blank', null, null, 'link', '1'), ('27', '安卓开发论坛', 'http://www.eoeandroid.com', '_blank', null, null, 'link', '1'), ('28', '360安全网址导航', 'http://hao.360.cn', '_blank', null, null, 'link', '1'), ('29', '360安全浏览器', 'http://se.360.cn', '_blank', null, null, 'link', '1'), ('30', 'hao123上网导航', 'http://www.hao123.com', '_blank', null, null, 'link', '1'), ('31', '互联网创业', 'http://www.ycpai.com', '_blank', null, null, 'link', '1'), ('32', '众筹网', 'http://www.zhongchou.cn', '_blank', null, null, 'link', '1'), ('33', '马克互联网', 'http://www.marklol.com', '_blank', null, null, 'link', '1'), ('34', '巢湖英才网', 'http://www.chaohuhr.com', '_blank', null, null, 'link', '1'), ('35', '创意服务外包', 'http://www.zhubajie.com', '_blank', null, null, 'link', '1'), ('36', 'thinkphp', 'http://www.thinkphp.cn', '_blank', null, null, 'link', '1'), ('37', '创新派', 'http://www.chuangxinpai.com', '_blank', null, null, 'link', '1'), ('38', 'W3Cshare', 'http://w3cshare.com', '_blank', null, null, 'link', '1'), ('39', '论文发表网', 'http://www.518lunwen.cn', '_blank', null, null, 'link', '1'), ('40', '199it', 'http://www.199it.com', '_blank', null, null, 'link', '1'), ('41', '市场部网', 'http://www.shichangbu.com', '_blank', null, null, 'link', '1'), ('42', '美图公司', 'http://www.meitu.com', '_blank', null, null, 'link', '1'), ('43', 'Teambition', 'http://www.teambition.com', '_blank', null, null, 'link', '1'), ('44', '欧朋浏览器', 'http://oupeng.com', '_blank', null, null, 'link', '1'), ('45', '网络广告人社区', 'http://iwebad.com', '_blank', null, null, 'link', '1'), ('46', '联系我们', 'about.html', '_blank', null, null, 'bottom', '1'), ('47', '互联网公司导航', null, '_blank', null, null, 'bottom', '1'), ('48', '青蛙微博', null, '_blank', null, null, 'bottom', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

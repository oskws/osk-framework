# ************************************************************
# Sequel Pro SQL dump
# Version 5415
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.24-26)
# Database: pd_hym
# Generation Time: 2019-03-04 15:06:28 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table system_generator_mac
# ------------------------------------------------------------

DROP TABLE IF EXISTS `system_generator_mac`;

CREATE TABLE `system_generator_mac` (
  `pk_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `prefix` char(4) DEFAULT NULL COMMENT '4位前缀',
  `formatter` varchar(32) DEFAULT NULL COMMENT '28位格式 {YYYY}{MM}{DD}{HH}{mm}{ss}{14}',
  `init_val` varchar(32) DEFAULT NULL COMMENT '初始值 前缀4,时间14,max增长14',
  `step` tinyint(3) unsigned DEFAULT NULL COMMENT '步进',
  `curr_val` varchar(32) DEFAULT NULL COMMENT '最新值',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT=' ';

LOCK TABLES `system_generator_mac` WRITE;
/*!40000 ALTER TABLE `system_generator_mac` DISABLE KEYS */;

INSERT INTO `system_generator_mac` (`pk_id`, `created_time`, `prefix`, `formatter`, `init_val`, `step`, `curr_val`)
VALUES
	(1,'2019-03-04 11:22:04','USER',NULL,'USER1111111111111100000000000001',1,'USER2019030421101600000000000018');

/*!40000 ALTER TABLE `system_generator_mac` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table system_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `system_user`;

CREATE TABLE `system_user` (
  `pk_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uk_mac` varchar(32) NOT NULL COMMENT '唯一标识',
  `created_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `full_name` varchar(64) NOT NULL COMMENT '用户名',
  `login_name` varchar(64) NOT NULL COMMENT '登录账号',
  `login_password` varchar(64) NOT NULL DEFAULT '' COMMENT '登录密码',
  `login_salt` varchar(32) NOT NULL COMMENT '盐值',
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `uk` (`uk_mac`),
  UNIQUE KEY `uk_login_name` (`login_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户 ';

LOCK TABLES `system_user` WRITE;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;

INSERT INTO `system_user` (`pk_id`, `uk_mac`, `created_by`, `created_time`, `updated_by`, `updated_time`, `full_name`, `login_name`, `login_password`, `login_salt`)
VALUES
	(1,'USER2019030421085900000000000017','self register','2019-03-04 13:09:00',NULL,'2019-03-04 13:09:03','123','howie','CF47707B0AD9831EE6368AA724FA8FC78ECE638E225C7D51C4A9BC0FA5BF96BD','QQFYv7Bm'),
	(2,'USER2019030421101600000000000018','self register','2019-03-04 13:10:17',NULL,'2019-03-04 13:10:45','123','huawei','7D21E36C1A9A78FE426481F010F7D00884CA634A4070FA25571C7ACC537157AE','mT6rftcO');

/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

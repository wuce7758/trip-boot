/*
SQLyog Ultimate v11.24 (64 bit)
MySQL - 5.5.28 : Database - trip_boot
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`trip_boot` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `trip_boot`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='市级信息';

/*Data for the table `city` */

insert  into `city`(`id`,`name`,`state`) values (1,'石家庄','河北'),(2,'邯郸','河北'),(3,'北京','三里屯');

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `countryname` varchar(255) DEFAULT NULL COMMENT '名称',
  `countrycode` varchar(255) DEFAULT NULL COMMENT '代码',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8 COMMENT='国家信息';

/*Data for the table `country` */

insert  into `country`(`Id`,`countryname`,`countrycode`) values (1,'Angola','AO'),(2,'Afghanistan','AF'),(3,'Albania','AL'),(4,'Algeria','DZ'),(5,'Andorra','AD'),(6,'Anguilla','AI'),(7,'Antigua and Barbuda','AG'),(8,'Argentina','AR'),(9,'Armenia','AM'),(10,'Australia','AU'),(11,'Austria','AT'),(12,'Azerbaijan','AZ'),(13,'Bahamas','BS'),(14,'Bahrain','BH'),(15,'Bangladesh','BD'),(16,'Barbados','BB'),(17,'Belarus','BY'),(18,'Belgium','BE'),(19,'Belize','BZ'),(20,'Benin','BJ'),(21,'Bermuda Is.','BM'),(22,'Bolivia','BO'),(23,'Botswana','BW'),(24,'Brazil','BR'),(25,'Brunei','BN'),(26,'Bulgaria','BG'),(27,'Burkina-faso','BF'),(28,'Burma','MM'),(29,'Burundi','BI'),(30,'Cameroon','CM'),(31,'Canada','CA'),(32,'Central African Republic','CF'),(33,'Chad','TD'),(34,'Chile','CL'),(35,'China','CN'),(36,'Colombia','CO'),(37,'Congo','CG'),(38,'Cook Is.','CK'),(39,'Costa Rica','CR'),(40,'Cuba','CU'),(41,'Cyprus','CY'),(42,'Czech Republic','CZ'),(43,'Denmark','DK'),(44,'Djibouti','DJ'),(45,'Dominica Rep.','DO'),(46,'Ecuador','EC'),(47,'Egypt','EG'),(48,'EI Salvador','SV'),(49,'Estonia','EE'),(50,'Ethiopia','ET'),(51,'Fiji','FJ'),(52,'Finland','FI'),(53,'France','FR'),(54,'French Guiana','GF'),(55,'Gabon','GA'),(56,'Gambia','GM'),(57,'Georgia','GE'),(58,'Germany','DE'),(59,'Ghana','GH'),(60,'Gibraltar','GI'),(61,'Greece','GR'),(62,'Grenada','GD'),(63,'Guam','GU'),(64,'Guatemala','GT'),(65,'Guinea','GN'),(66,'Guyana','GY'),(67,'Haiti','HT'),(68,'Honduras','HN'),(69,'Hongkong','HK'),(70,'Hungary','HU'),(71,'Iceland','IS'),(72,'India','IN'),(73,'Indonesia','ID'),(74,'Iran','IR'),(75,'Iraq','IQ'),(76,'Ireland','IE'),(77,'Israel','IL'),(78,'Italy','IT'),(79,'Jamaica','JM'),(80,'Japan','JP'),(81,'Jordan','JO'),(82,'Kampuchea (Cambodia )','KH'),(83,'Kazakstan','KZ'),(84,'Kenya','KE'),(85,'Korea','KR'),(86,'Kuwait','KW'),(87,'Kyrgyzstan','KG'),(88,'Laos','LA'),(89,'Latvia','LV'),(90,'Lebanon','LB'),(91,'Lesotho','LS'),(92,'Liberia','LR'),(93,'Libya','LY'),(94,'Liechtenstein','LI'),(95,'Lithuania','LT'),(96,'Luxembourg','LU'),(97,'Macao','MO'),(98,'Madagascar','MG'),(99,'Malawi','MW'),(100,'Malaysia','MY'),(101,'Maldives','MV'),(102,'Mali','ML'),(103,'Malta','MT'),(104,'Mauritius','MU'),(105,'Mexico','MX'),(106,'Moldova, Republic of','MD'),(107,'Monaco','MC'),(108,'Mongolia','MN'),(109,'Montserrat Is','MS'),(110,'Morocco','MA'),(111,'Mozambique','MZ'),(112,'Namibia','NA'),(113,'Nauru','NR'),(114,'Nepal','NP'),(115,'Netherlands','NL'),(116,'New Zealand','NZ'),(117,'Nicaragua','NI'),(118,'Niger','NE'),(119,'Nigeria','NG'),(120,'North Korea','KP'),(121,'Norway','NO'),(122,'Oman','OM'),(123,'Pakistan','PK'),(124,'Panama','PA'),(125,'Papua New Cuinea','PG'),(126,'Paraguay','PY'),(127,'Peru','PE'),(128,'Philippines','PH'),(129,'Poland','PL'),(130,'French Polynesia','PF'),(131,'Portugal','PT'),(132,'Puerto Rico','PR'),(133,'Qatar','QA'),(134,'Romania','RO'),(135,'Russia','RU'),(136,'Saint Lueia','LC'),(137,'Saint Vincent','VC'),(138,'San Marino','SM'),(139,'Sao Tome and Principe','ST'),(140,'Saudi Arabia','SA'),(141,'Senegal','SN'),(142,'Seychelles','SC'),(143,'Sierra Leone','SL'),(144,'Singapore','SG'),(145,'Slovakia','SK'),(146,'Slovenia','SI'),(147,'Solomon Is','SB'),(148,'Somali','SO'),(149,'South Africa','ZA'),(150,'Spain','ES'),(151,'Sri Lanka','LK'),(152,'St.Lucia','LC'),(153,'St.Vincent','VC'),(154,'Sudan','SD'),(155,'Suriname','SR'),(156,'Swaziland','SZ'),(157,'Sweden','SE'),(158,'Switzerland','CH'),(159,'Syria','SY'),(160,'Taiwan','TW'),(161,'Tajikstan','TJ'),(162,'Tanzania','TZ'),(163,'Thailand','TH'),(164,'Togo','TG'),(165,'Tonga','TO'),(166,'Trinidad and Tobago','TT'),(167,'Tunisia','TN'),(168,'Turkey','TR'),(169,'Turkmenistan','TM'),(170,'Uganda','UG'),(171,'Ukraine','UA'),(172,'United Arab Emirates','AE'),(173,'United Kiongdom','GB'),(174,'United States of America','US'),(175,'Uruguay','UY'),(176,'Uzbekistan','UZ'),(177,'Venezuela','VE'),(178,'Vietnam','VN'),(179,'Yemen','YE'),(180,'Yugoslavia','YU'),(181,'Zimbabwe','ZW'),(182,'Zaire','ZR'),(183,'Zambia','ZM');

/*Table structure for table `sys_organization` */

DROP TABLE IF EXISTS `sys_organization`;

CREATE TABLE `sys_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_sys_organization_parent_id` (`parent_id`),
  KEY `idx_sys_organization_parent_ids` (`parent_ids`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `sys_organization` */

insert  into `sys_organization`(`id`,`name`,`parent_id`,`parent_ids`,`available`) values (1,'总公司',0,'0/',1),(2,'分公司1',1,'0/1/',1),(3,'分公司2',1,'0/1/',1),(4,'分公司11',2,'0/1/2/',1);

/*Table structure for table `sys_resource` */

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_sys_resource_parent_id` (`parent_id`),
  KEY `idx_sys_resource_parent_ids` (`parent_ids`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `sys_resource` */

insert  into `sys_resource`(`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`) values (1,'资源','menu','',0,'0/','',1),(11,'组织机构管理','menu','/organization',1,'0/1/','organization:*',1),(12,'组织机构新增','button','',11,'0/1/11/','organization:create',1),(13,'组织机构修改','button','',11,'0/1/11/','organization:update',1),(14,'组织机构删除','button','',11,'0/1/11/','organization:delete',1),(15,'组织机构查看','button','',11,'0/1/11/','organization:view',1),(21,'用户管理','menu','/user',1,'0/1/','user:*',1),(22,'用户新增','button','',21,'0/1/21/','user:create',1),(23,'用户修改','button','',21,'0/1/21/','user:update',1),(24,'用户删除','button','',21,'0/1/21/','user:delete',1),(25,'用户查看','button','',21,'0/1/21/','user:view',1),(31,'资源管理','menu','/resource',1,'0/1/','resource:*',1),(32,'资源新增','button','',31,'0/1/31/','resource:create',1),(33,'资源修改','button','',31,'0/1/31/','resource:update',1),(34,'资源删除','button','',31,'0/1/31/','resource:delete',1),(35,'资源查看','button','',31,'0/1/31/','resource:view',1),(41,'角色管理','menu','/role',1,'0/1/','role:*',1),(42,'角色新增','button','',41,'0/1/41/','role:create',1),(43,'角色修改','button','',41,'0/1/41/','role:update',1),(44,'角色删除','button','',41,'0/1/41/','role:delete',1),(45,'角色查看','button','',41,'0/1/41/','role:view',1);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `resource_ids` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_sys_role_resource_ids` (`resource_ids`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role`,`description`,`resource_ids`,`available`) values (1,'admin','超级管理员','11,21,31,41',1);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `organization_id` bigint(20) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `role_ids` varchar(100) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_user_username` (`username`),
  KEY `idx_sys_user_organization_id` (`organization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`organization_id`,`username`,`password`,`salt`,`role_ids`,`locked`) values (1,1,'admin','d3c59d25033dbf980d29554025c23a75','8d78869f470951332959580424d4bf4f','1',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

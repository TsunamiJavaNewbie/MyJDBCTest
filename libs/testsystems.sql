/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.5.11 : Database - testsystems
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`testsystems` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `testsystems`;

/*Table structure for table `admins` */

DROP TABLE IF EXISTS `admins`;

CREATE TABLE `admins` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `admins` */

insert  into `admins`(`id`,`username`,`password`) values (1,'admin','admin'),(2,'Test','123');

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `dept` int(11) NOT NULL AUTO_INCREMENT,
  `deptname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dept`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`dept`,`deptname`) values (1,'开发部'),(2,'市场部'),(3,'行政部'),(4,'财务部'),(5,'人力资源部');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `deptid` int(11) DEFAULT NULL,
  `birth` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userid`,`name`,`deptid`,`birth`) values (1,'Lee',1,'1993/06/23'),(2,'zhang',3,'1997/08/04'),(3,'joe',3,'1998/09/21'),(4,'King',4,'1994/05/21'),(5,'lucky',5,'1996/07/30'),(7,'Sam',2,'1999/09/26'),(10,'lllll',1,'1994/08/21');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

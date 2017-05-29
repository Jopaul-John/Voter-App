/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.21 : Database - e-votting
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`e-votting` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `e-votting`;

/*Table structure for table `candidate_list` */

DROP TABLE IF EXISTS `candidate_list`;

CREATE TABLE `candidate_list` (
  `candidate_id` bigint(50) NOT NULL,
  `candidate_name` varchar(50) DEFAULT NULL,
  `party_name` varchar(50) DEFAULT NULL,
  `region_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`candidate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `candidate_list` */

insert  into `candidate_list`(`candidate_id`,`candidate_name`,`party_name`,`region_code`) values (100,'Saji Alex','UDF','1'),(101,'Anto Antony','LDF','1'),(102,'Madhu Parumala','BJP','1'),(200,'Victor T.Thomas','UDF','2'),(201,'Mathew T.Thomas','LDF','2'),(202,'Akkeeraman','BJP','2'),(300,'ummanchandi','UDF','3'),(301,'Pinaraayi','LDF','3'),(302,'Suresh Menon','BJP','3');

/*Table structure for table `comp_table` */

DROP TABLE IF EXISTS `comp_table`;

CREATE TABLE `comp_table` (
  `comp_id` int(11) NOT NULL AUTO_INCREMENT,
  `aadhar_no` varchar(15) DEFAULT NULL,
  `user_nm` varchar(10) DEFAULT NULL,
  `complaint` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`comp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `comp_table` */

insert  into `comp_table`(`comp_id`,`aadhar_no`,`user_nm`,`complaint`) values (1,'12345','Kiran','jhjjhbjhbjbhbjhjhb');

/*Table structure for table `election` */

DROP TABLE IF EXISTS `election`;

CREATE TABLE `election` (
  `vote_id` int(50) NOT NULL AUTO_INCREMENT,
  `candidate_id` longblob,
  `region_code` varchar(50) DEFAULT NULL,
  `unique_token` longblob,
  PRIMARY KEY (`vote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `election` */

insert  into `election`(`vote_id`,`candidate_id`,`region_code`,`unique_token`) values (1,'yA3/L6sUBQTXe0s1SzNoA/tykVT4joHB1Lpq2HChE5E=','3','jP9WbQUexoZ6htrTZkL1CnO7WA/5A3IaOyiF4bK9MT8='),(2,'InKUumgtTZqVkvJnkmoMnaHe3PWceexITD5CGtCY860=','1','9yVHzQ90lDPR6wPyhZbhuGk38cnofB8UArGLEcniAB4='),(3,'poYfuqoBVDDI9x1HrADXY26UjzpTdc6qDEczRilwREg=','3','xRTw8qOeNt9F7+tWoZFTTPoJCG9YfOcXJRgbjApW1Cg=');

/*Table structure for table `key_tab` */

DROP TABLE IF EXISTS `key_tab`;

CREATE TABLE `key_tab` (
  `key_id` int(11) NOT NULL AUTO_INCREMENT,
  `vote_id` varchar(10) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`key_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `key_tab` */

insert  into `key_tab`(`key_id`,`vote_id`,`password`) values (1,'1','d61f9c94632201c5c7bcd119250c477a'),(2,'2','7e9b1d1d46edf01c37800cb6037b4353'),(3,'3','273e1c6d2c3ed394a8deb10aa0c09357');

/*Table structure for table `register` */

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
  `user_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `adhar_no` bigint(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `fingerprint` varchar(150) DEFAULT NULL,
  `region_code` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '0',
  `unique_key` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `register` */

insert  into `register`(`user_id`,`adhar_no`,`name`,`address`,`dob`,`gender`,`fingerprint`,`region_code`,`status`,`unique_key`) values (1,12345,'Kiran','Kiran[H],Aluva','12/03/1980','Male',NULL,'1','1','6297'),(2,654356345490,'rahul','Rahul[H],Edappalli','01/01/1989','male',NULL,'1','0',''),(3,908715263589,'Malini','Tagore lane','15/06/1988','Female',NULL,'2','0',NULL),(4,643532413256,'Sreya','Valiyakulathinkal lane','03/03/1978','Female',NULL,'1','0',NULL),(5,908928192819,'Raju','Raju\'s home','21/08/1970','male',NULL,'3','0',''),(6,889237182736,'Renju','Kulanada','25/12/1880','Male',NULL,'2','0',NULL),(7,778219201737,'Sruthy','Kunnathu','30/03/1987','Female',NULL,'3','1','5383'),(8,672819273829,'Nimisha','Geethalayam','27/04/1993','Female',NULL,'1','0',NULL),(9,362718283726,'Linu','Pulikkozhuppil','10/07/1990','Female',NULL,'2','0',''),(10,456728192038,'Terrins','Terrys,Kottayam','10/10/1980','male',NULL,'3','1','8528');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- MySQL dump 10.13  Distrib 8.0.16, for osx10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: papa_food
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `papa_food`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `papa_food` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `papa_food`;

--
-- Table structure for table `consistency`
--

DROP TABLE IF EXISTS `consistency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `consistency` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` bigint(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `allergy` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customerRevenue`
--

DROP TABLE IF EXISTS `customerRevenue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customerRevenue` (
  `id` int(15) NOT NULL,
  `cost_order` text NOT NULL,
  `cost_invoice` text NOT NULL,
  `revenue` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `food` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `category` int(2) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `ingredient_id` varchar(50) NOT NULL,
  `nutrition_id` varchar(100) NOT NULL,
  `image` varchar(150) NOT NULL,
  `capacity` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `foodCategory`
--

DROP TABLE IF EXISTS `foodCategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `foodCategory` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `price` float NOT NULL,
  `currency` varchar(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `food_category`
--

DROP TABLE IF EXISTS `food_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `food_category` (
  `food_category_id` int(11) DEFAULT NULL,
  `food_category_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `food_consistency`
--

DROP TABLE IF EXISTS `food_consistency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `food_consistency` (
  `food_consistency_id` int(11) DEFAULT NULL,
  `food_id` int(11) DEFAULT NULL,
  `consistency_id` int(11) DEFAULT NULL,
  `default` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `food_ingredient`
--

DROP TABLE IF EXISTS `food_ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `food_ingredient` (
  `food_ingredient` int(11) DEFAULT NULL,
  `food_id` int(11) DEFAULT NULL,
  `ingredient_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `food_nutrition`
--

DROP TABLE IF EXISTS `food_nutrition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `food_nutrition` (
  `food_nutrition_id` int(11) DEFAULT NULL,
  `food_id` int(11) DEFAULT NULL,
  `nutrition_id` int(11) DEFAULT NULL,
  `nutrition_value` float DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ingredient` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `menus`
--

DROP TABLE IF EXISTS `menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `menus` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `date` date NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `menus_foods`
--

DROP TABLE IF EXISTS `menus_foods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `menus_foods` (
  `food_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `menu_id` varchar(255) COLLATE utf8_bin NOT NULL,
  UNIQUE KEY `menus_foods_food_id_menu_id_uindex` (`food_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `notification` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `message` text,
  `read` tinyint(1) DEFAULT NULL,
  `notification_type` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nutrition`
--

DROP TABLE IF EXISTS `nutrition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nutrition` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `customer_id` int(15) NOT NULL,
  `reciever_name` varchar(30) NOT NULL,
  `reciever_phone` varchar(13) NOT NULL,
  `reciever_address` varchar(50) NOT NULL,
  `deliver_time` varchar(30) NOT NULL,
  `package_id` int(2) NOT NULL,
  `set_id` int(3) NOT NULL,
  `before_price` float NOT NULL,
  `discount` float NOT NULL DEFAULT '0',
  `currency` varchar(5) NOT NULL,
  `payment_method` int(2) NOT NULL,
  `note` varchar(50) DEFAULT NULL,
  `status` int(2) NOT NULL,
  `data` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_comment`
--

DROP TABLE IF EXISTS `order_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_comment` (
  `order_comment_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `comment_text` text CHARACTER SET latin1 COLLATE latin1_swedish_ci,
  `created_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_detail` (
  `order_detail_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `package_id` int(11) DEFAULT NULL,
  `foot_set_data` text CHARACTER SET latin1 COLLATE latin1_swedish_ci,
  `price` double DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_history`
--

DROP TABLE IF EXISTS `order_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_history` (
  `order_history_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `description` text CHARACTER SET latin1 COLLATE latin1_swedish_ci,
  `created_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `package` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `test` tinyint(1) NOT NULL DEFAULT '1',
  `description` varchar(50) NOT NULL,
  `description_discount` varchar(45) DEFAULT NULL,
  `rule` varchar(20) NOT NULL,
  `dates` int(2) NOT NULL,
  `sets_delivery` int(1) NOT NULL,
  `term` int(1) NOT NULL,
  `condition` varchar(10) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `payment_methods`
--

DROP TABLE IF EXISTS `payment_methods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payment_methods` (
  `id` varchar(255) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `id` varchar(255) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `seo`
--

DROP TABLE IF EXISTS `seo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `seo` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `page` varchar(45) NOT NULL,
  `title` varchar(20) NOT NULL,
  `meta` varchar(2048) DEFAULT NULL,
  `link` varchar(512) DEFAULT NULL,
  `script` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `page_UNIQUE` (`page`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `set_food`
--

DROP TABLE IF EXISTS `set_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `set_food` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `main_bottle` varchar(50) NOT NULL,
  `sub_bottle` varchar(100) NOT NULL,
  `price` float NOT NULL,
  `currency` varchar(5) NOT NULL,
  `status` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_tokens`
--

DROP TABLE IF EXISTS `user_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_tokens` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `token` varchar(250) DEFAULT NULL,
  `expired_at` datetime NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` varchar(255) NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` varchar(100) DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_user_name_uindex` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users_roles` (
  `user_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  UNIQUE KEY `users_roles_user_id_role_id_uindex` (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-16 15:03:13

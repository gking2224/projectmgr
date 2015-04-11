-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	5.6.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `Budget`
--

LOCK TABLES `Budget` WRITE;
/*!40000 ALTER TABLE `Budget` DISABLE KEYS */;
INSERT INTO `Budget` VALUES (1,1,1,'Proposal 1');
/*!40000 ALTER TABLE `Budget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Forecast`
--

LOCK TABLES `Forecast` WRITE;
/*!40000 ALTER TABLE `Forecast` DISABLE KEYS */;
INSERT INTO `Forecast` VALUES (1,1,1,1),(2,2,1,1),(3,3,1,1),(4,4,1,1),(5,5,1,1),(6,6,1,1),(7,7,1,1),(8,8,1,1),(9,9,1,1),(10,10,1,1),(11,11,1,1),(12,12,1,1),(13,1,1,2),(14,2,1,2),(15,3,1,2),(16,4,1,2),(17,5,1,2),(18,6,1,2),(19,7,1,2),(20,8,1,2),(21,9,1,2),(22,10,1,2),(23,11,1,2),(24,12,1,2);
/*!40000 ALTER TABLE `Forecast` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `OrgUnit`
--

LOCK TABLES `OrgUnit` WRITE;
/*!40000 ALTER TABLE `OrgUnit` DISABLE KEYS */;
INSERT INTO `OrgUnit` VALUES (1,NULL,'MegaBank','Ewan McRoss'),(2,1,'Services','Paul Hogan'),(3,2,'Transformation','Some Yank'),(4,3,'Risk Solutions','Dan Localman'),(5,4,'Wholesale Credit Risk','Bobby Kekkers'),(6,5,'PCDD','Reggie Skeleton'),(7,6,'Risk Models','Graham King'),(8,6,'PRisM','Ramneek SW');
/*!40000 ALTER TABLE `OrgUnit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Project`
--

LOCK TABLES `Project` WRITE;
/*!40000 ALTER TABLE `Project` DISABLE KEYS */;
INSERT INTO `Project` VALUES (1,'WCRS RDAR','Active',5),(2,'WCR Models Compliance','Active',6),(3,'WCR Models KSOR','Active',6),(4,'WCR IFRS9','Pending',5),(5,'WCR PRisM KSOR','Active',7);
/*!40000 ALTER TABLE `Project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Resource`
--

LOCK TABLES `Resource` WRITE;
/*!40000 ALTER TABLE `Resource` DISABLE KEYS */;
INSERT INTO `Resource` VALUES (1,1,1),(2,1,2);
/*!40000 ALTER TABLE `Resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `RoleSubType`
--

LOCK TABLES `RoleSubType` WRITE;
/*!40000 ALTER TABLE `RoleSubType` DISABLE KEYS */;
INSERT INTO `RoleSubType` VALUES (1,1,'Project Manager'),(2,1,'Delivery Manager');
/*!40000 ALTER TABLE `RoleSubType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `RoleType`
--

LOCK TABLES `RoleType` WRITE;
/*!40000 ALTER TABLE `RoleType` DISABLE KEYS */;
INSERT INTO `RoleType` VALUES (1,'Manager');
/*!40000 ALTER TABLE `RoleType` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-06 16:41:59

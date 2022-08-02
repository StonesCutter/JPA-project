-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: db2
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `idOrder` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `idPackage` int NOT NULL,
  `idUser` int NOT NULL,
  `totalAmount` int NOT NULL,
  `fromWhen` datetime NOT NULL,
  `status` tinyint(1) NOT NULL,
  `idvalidityPeriod` int NOT NULL,
  PRIMARY KEY (`idOrder`),
  UNIQUE KEY `idOrder_UNIQUE` (`idOrder`),
  KEY `idValidity_idx` (`idvalidityPeriod`),
  KEY `idUser_idx` (`idUser`),
  KEY `idPack_idx` (`idPackage`),
  CONSTRAINT `idPack` FOREIGN KEY (`idPackage`) REFERENCES `package` (`idPackage`),
  CONSTRAINT `idUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  CONSTRAINT `idValidity` FOREIGN KEY (`idvalidityPeriod`) REFERENCES `validityperiod` (`idvalidityPeriod`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'2020-01-01 00:00:00',1,2,10,'2020-01-01 00:00:00',0,3),(2,'2021-02-02 00:00:00',2,2,20,'2021-03-03 00:00:00',0,2),(15,'2022-07-21 00:00:00',2,2,672,'2022-09-07 00:00:00',0,2),(16,'2022-07-29 00:00:00',3,2,648,'2022-09-09 00:00:00',0,3),(17,'2022-07-29 00:00:00',3,2,648,'2022-09-09 00:00:00',0,3),(18,'2022-07-30 00:00:00',2,2,432,'2022-10-10 00:00:00',0,2),(19,'2022-07-30 00:00:00',17,2,360,'2023-02-02 00:00:00',1,15),(20,'2022-07-30 00:00:00',17,2,360,'2022-10-10 00:00:00',0,15),(21,'2022-07-30 00:00:00',17,2,360,'2022-10-10 00:00:00',0,15),(22,'2022-07-30 00:00:00',17,2,360,'2022-10-10 00:00:00',0,15),(32,'2022-07-31 00:00:00',2,2,432,'2022-09-15 00:00:00',0,2),(33,'2022-07-31 00:00:00',1,2,240,'2022-10-10 00:00:00',0,1),(34,'2022-07-31 00:00:00',1,2,240,'2022-11-11 00:00:00',1,1),(35,'2022-07-31 00:00:00',2,2,432,'2022-09-09 00:00:00',1,2),(36,'2022-08-01 00:00:00',21,2,240,'2022-10-14 00:00:00',1,19);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-02 12:26:25

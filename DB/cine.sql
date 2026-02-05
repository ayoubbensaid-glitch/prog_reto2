create database cine;
use cine;
-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: cine
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `DNI` varchar(9) NOT NULL,
  `Cliente_Nom` varchar(20) NOT NULL,
  `Cliente_Apel` varchar(40) DEFAULT NULL,
  `Cliente_Correo` varchar(100) NOT NULL,
  `Cliente_Pass_hash` varchar(255) NOT NULL,
  PRIMARY KEY (`DNI`),
  UNIQUE KEY `Cliente_Correo` (`Cliente_Correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('01234567J','Elena','Dominguez Alonso','elena.dominguez@email.com','2200167d39d5088c1f39b9bbb62ff3e8c95ace8eff15bbaa4098f580e7a51024'),('12345678A','Carlos','Garc?a L?pez','carlos.garcia@email.com','5ac0852e770506dcd80f1a36d20ba7878bf82244b836d9324593bd14bc56dcb5'),('23456789B','Ana','Mart?nez Ruiz','ana.martinez@email.com','ec7be197de9fbe3a60c8af23a9ffad7783bb684470c9d137ef4bde4e56354b70'),('34567890C','David','Fern?ndez Castro','david.fernandez@email.com','699751bcbb177cff3eada492060f508b185d2b7221dbacb2e55810b1e979bcb1'),('45678901D','Laura','Rodr?guez G?mez','laura.rodriguez@email.com','cbb515413b9316679d646037abc52ab82f168ca7b80e5ee9f5f7ef9a61ca6684'),('56789012E','Javier','S?nchez P?rez','javier.sanchez@email.com','310a885d2d93d56c1baa18703af5a9cf619835ee4f761a3693d373bc031472c3'),('67890123F','Marta','Gonz?lez D?az','marta.gonzalez@email.com','58b745195183459d40b0a72e11ef67dda60ea6e637e3670ed6bd19583f459319'),('78901234G','Alejandro','Hern?ndez Mart?n','alejandro.h@email.com','fae9f7c52a4e2db151b1645dc027c8302e9c512fb83aeef3b8051a322faaf924'),('89012345H','Sof?a','Jim?nez Navarro','sofia.jimenez@email.com','59e7f06c2254f065768b4e34e7ec9ea398b5e7d816a0afea3b02b02d4085aec8'),('90123456I','Pablo','Torres Romero','pablo.torres@email.com','22d1ffda373078a2a71dd52bb2021bc67da034838b16afe86ff2bcfba1ea5fea');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-01 23:23:56

-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: cine
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala` (
  `Sala_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Sala_Nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`Sala_ID`),
  UNIQUE KEY `Sala_Nombre` (`Sala_Nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (2,'Sala 3D'),(7,'Sala Atmos'),(10,'Sala Cl?sica'),(4,'Sala Deluxe'),(5,'Sala Familiar'),(8,'Sala Imax'),(9,'Sala Mini'),(6,'Sala Premium'),(1,'Sala Principal'),(3,'Sala VIP');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-01 23:23:55
-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: cine
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `pelis`
--

DROP TABLE IF EXISTS `pelis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelis` (
  `Peli_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Peli_Titulo` varchar(100) DEFAULT NULL,
  `Peli_Duracion` int NOT NULL,
  `Peli_Genero` varchar(100) DEFAULT NULL,
  `Peli_Precio` decimal(5,2) NOT NULL,
  PRIMARY KEY (`Peli_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelis`
--

LOCK TABLES `pelis` WRITE;
/*!40000 ALTER TABLE `pelis` DISABLE KEYS */;
INSERT INTO `pelis` VALUES (1,'El Padrino',175,'Drama/Crimen',8.50),(2,'Pulp Fiction',154,'Crimen/Drama',7.80),(3,'El Se?or de los Anillos 1',178,'Fantas?a/Aventura',9.00),(4,'Origen',148,'C.F/Acci?n',8.20),(5,'La La Land',128,'Musical/Romance',7.50),(6,'El Caballero Oscuro',152,'Acci?n/Drama',8.80),(7,'Forrest Gump',142,'Drama/Romance',7.20),(8,'Gladiator',155,'Acci?n/Drama',8.00),(9,'Interestelar',169,'C.F/Aventura',9.20),(10,'Par?sitos',132,'Drama/Comedia',8.60);
/*!40000 ALTER TABLE `pelis` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-01 23:23:55

-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: cine
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `sesion`
--

DROP TABLE IF EXISTS `sesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sesion` (
  `Sesion_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Sala_ID` int unsigned NOT NULL,
  `Peli_ID` int unsigned NOT NULL,
  `Sesion_Hora_Ini` time NOT NULL,
  `Sesion_Hora_Fin` time NOT NULL,
  `Sesion_Precio` decimal(5,2) NOT NULL,
  `Sesion_Fech` date NOT NULL,
  `Sesion_Tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Sesion_ID`),
  KEY `Sala_ID` (`Sala_ID`),
  KEY `Peli_ID` (`Peli_ID`),
  CONSTRAINT `sesion_ibfk_1` FOREIGN KEY (`Sala_ID`) REFERENCES `sala` (`Sala_ID`),
  CONSTRAINT `sesion_ibfk_2` FOREIGN KEY (`Peli_ID`) REFERENCES `pelis` (`Peli_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesion`
--

LOCK TABLES `sesion` WRITE;
/*!40000 ALTER TABLE `sesion` DISABLE KEYS */;
INSERT INTO `sesion` VALUES (1,1,1,'16:00:00','18:55:00',8.50,'2026-02-05','Tarde'),(2,2,3,'18:30:00','21:28:00',11.00,'2026-02-06','Tarde'),(3,3,5,'20:00:00','22:08:00',12.50,'2026-02-07','Noche'),(4,4,2,'17:15:00','19:49:00',9.80,'2026-02-08','Tarde'),(5,5,7,'15:45:00','18:07:00',7.20,'2026-02-09','Matin?'),(6,6,9,'21:30:00','00:19:00',13.00,'2026-02-10','Noche'),(7,7,4,'19:00:00','21:28:00',10.20,'2026-02-11','Tarde'),(8,8,6,'22:00:00','00:32:00',14.50,'2026-02-12','Noche'),(9,9,8,'18:00:00','20:35:00',9.00,'2026-02-13','Tarde'),(10,10,10,'16:30:00','18:42:00',8.60,'2026-02-14','Tarde'),(11,1,1,'18:00:00','20:55:00',8.50,'2026-02-07','Tarde'),(12,2,3,'16:30:00','19:28:00',9.00,'2026-02-08','Tarde'),(14,4,2,'12:00:00','14:34:00',9.80,'2026-02-05','Matin?'),(15,4,2,'17:15:00','19:49:00',9.80,'2026-02-06','Tarde'),(16,4,2,'20:00:00','22:34:00',9.80,'2026-02-06','Noche'),(17,2,3,'14:00:00','17:00:00',9.00,'2026-02-05','Matin?'),(18,2,3,'18:30:00','21:28:00',9.00,'2026-02-06','Tarde'),(19,2,3,'20:00:00','23:00:00',9.00,'2026-02-07','Noche'),(20,1,1,'20:00:00','22:55:00',8.50,'2026-02-05','Noche'),(21,4,2,'12:00:00','14:34:00',9.80,'2026-02-09','Matin'),(22,2,3,'12:00:00','15:00:00',9.00,'2026-02-07','Matin'),(23,7,4,'21:30:00','23:58:00',10.20,'2026-02-12','Noche'),(24,3,5,'15:00:00','17:08:00',12.50,'2026-02-08','Tarde'),(25,8,6,'18:00:00','20:32:00',14.50,'2026-02-10','Tarde'),(26,5,7,'18:00:00','20:22:00',7.20,'2026-02-10','Tarde'),(27,6,9,'18:00:00','20:49:00',13.00,'2026-02-12','Tarde');
/*!40000 ALTER TABLE `sesion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-01 23:23:56
-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: cine
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `Compra_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `DNI` varchar(9) NOT NULL,
  `Compra_Fech` date NOT NULL,
  `Compra_Hora` time NOT NULL,
  `Compra_Descuento` decimal(5,2) NOT NULL,
  PRIMARY KEY (`Compra_ID`),
  KEY `DNI` (`DNI`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `cliente` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,'12345678A','2024-01-25','14:30:00',2.50),(2,'23456789B','2024-01-25','15:45:00',0.00),(3,'34567890C','2024-01-25','16:20:00',5.00),(4,'45678901D','2024-01-26','12:15:00',0.00),(5,'56789012E','2024-01-26','13:40:00',3.00),(6,'67890123F','2024-01-26','18:30:00',0.00),(7,'78901234G','2024-01-27','11:00:00',4.50),(8,'89012345H','2024-01-27','17:25:00',0.00),(9,'90123456I','2024-01-28','14:50:00',6.00),(10,'01234567J','2024-01-28','20:10:00',0.00);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-01 23:23:56
-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: cine
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrada` (
  `Entrada_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Sesion_ID` int unsigned NOT NULL,
  `Compra_ID` int unsigned NOT NULL,
  `Entrada_Personas` int unsigned NOT NULL DEFAULT '1',
  `Entrada_Precio` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`Entrada_ID`),
  KEY `Sesion_ID` (`Sesion_ID`),
  KEY `Compra_ID` (`Compra_ID`),
  CONSTRAINT `entrada_ibfk_1` FOREIGN KEY (`Sesion_ID`) REFERENCES `sesion` (`Sesion_ID`),
  CONSTRAINT `entrada_ibfk_2` FOREIGN KEY (`Compra_ID`) REFERENCES `compra` (`Compra_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,1,1,2,15.50),(2,2,2,1,11.00),(3,3,3,3,34.50),(4,4,4,2,18.60),(5,5,5,4,25.80),(6,6,6,1,13.00),(7,7,7,2,19.40),(8,8,8,2,27.00),(9,9,9,3,24.00),(10,10,10,1,8.60);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-01 23:23:56

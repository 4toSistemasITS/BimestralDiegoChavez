-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: examenbimestral
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.19-MariaDB

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
-- Table structure for table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrera` (
  `id_carrera` int(11) NOT NULL AUTO_INCREMENT,
  `carrera` varchar(45) DEFAULT NULL,
  `eliminado` bit(1) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  PRIMARY KEY (`id_carrera`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` VALUES (1,'Sistemas','\0','2017-06-08 00:00:00'),(2,'Contabilidad','\0','2017-06-08 00:00:00');
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasante`
--

DROP TABLE IF EXISTS `pasante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pasante` (
  `id_pasante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `cedula` varchar(45) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `eliminado` bit(1) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `id_pasantia` int(11) DEFAULT NULL,
  `id_carrera` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pasante`),
  KEY `carrera_pasante_idx` (`id_carrera`),
  KEY `pasantia_pasante_idx` (`id_pasantia`),
  CONSTRAINT `carrera_pasante` FOREIGN KEY (`id_carrera`) REFERENCES `carrera` (`id_carrera`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pasantia_pasante` FOREIGN KEY (`id_pasantia`) REFERENCES `pasantia` (`id_pasantia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasante`
--

LOCK TABLES `pasante` WRITE;
/*!40000 ALTER TABLE `pasante` DISABLE KEYS */;
INSERT INTO `pasante` VALUES (1,'Alejandro','Sanchez','1105218513',20,'','2017-06-08 21:44:44',1,1),(2,'Diego','Gonzalez','1105218514',24,'\0','2017-06-08 21:36:36',1,1),(3,'Juan','Perez','1104699531',20,'\0','2017-06-08 21:37:22',2,2),(4,'Diego','Sanchez','1104625621',19,'\0','2017-06-08 21:47:02',2,NULL);
/*!40000 ALTER TABLE `pasante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasantia`
--

DROP TABLE IF EXISTS `pasantia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pasantia` (
  `id_pasantia` int(11) NOT NULL AUTO_INCREMENT,
  `nombrePasantia` varchar(45) DEFAULT NULL,
  `numeroHoras` int(11) DEFAULT NULL,
  `eliminado` bit(1) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  PRIMARY KEY (`id_pasantia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasantia`
--

LOCK TABLES `pasantia` WRITE;
/*!40000 ALTER TABLE `pasantia` DISABLE KEYS */;
INSERT INTO `pasantia` VALUES (1,'Mantenimiento',50,'\0','2017-06-08 21:05:46'),(2,'Servicio a la Comunidad',200,'\0','2017-06-08 21:06:48');
/*!40000 ALTER TABLE `pasantia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-08 21:52:27

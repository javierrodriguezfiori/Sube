-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sube
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `colectivo`
--

DROP TABLE IF EXISTS `colectivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colectivo` (
  `idColectivo` int(11) NOT NULL,
  PRIMARY KEY (`idColectivo`),
  KEY `fk_TransportePublico_colectivo_idx` (`idColectivo`),
  CONSTRAINT `fk_TransportePublico_colectivo` FOREIGN KEY (`idColectivo`) REFERENCES `transportepublico` (`idTransportePublico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colectivo`
--

LOCK TABLES `colectivo` WRITE;
/*!40000 ALTER TABLE `colectivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `colectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `costosubte`
--

DROP TABLE IF EXISTS `costosubte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costosubte` (
  `idcostosubte` int(11) NOT NULL,
  `costo` float NOT NULL,
  PRIMARY KEY (`idcostosubte`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costosubte`
--

LOCK TABLES `costosubte` WRITE;
/*!40000 ALTER TABLE `costosubte` DISABLE KEYS */;
INSERT INTO `costosubte` VALUES (1,15);
/*!40000 ALTER TABLE `costosubte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parada`
--

DROP TABLE IF EXISTS `parada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parada` (
  `idParada` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idParada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parada`
--

LOCK TABLES `parada` WRITE;
/*!40000 ALTER TABLE `parada` DISABLE KEYS */;
INSERT INTO `parada` VALUES (1,'Constitucion'),(2,'Hipólito Yrigoyen'),(3,'D.Santillán Y M.Kosteki'),(4,'Gerli'),(5,'Lanús'),(6,'Remedios de Escalada'),(7,'Banfield'),(8,'Lomas de Zamora'),(9,'Termperey'),(10,'Adrogue'),(11,'Burzaco'),(12,'Longhcamps'),(13,'Glew'),(14,'Guernica'),(15,'Alejandro Korn'),(16,'San Juan'),(17,'Independencia'),(18,'Moreno'),(19,'Av. de Mayo'),(20,'Diagonal Norte'),(21,'Lavalle'),(22,'Gnral. San Martin'),(23,'Retiro');
/*!40000 ALTER TABLE `parada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paradaporsubte`
--

DROP TABLE IF EXISTS `paradaporsubte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paradaporsubte` (
  `idSubte` int(11) NOT NULL,
  `idParada` int(11) NOT NULL,
  PRIMARY KEY (`idSubte`,`idParada`),
  KEY `fk_parada_subte_idx` (`idParada`),
  CONSTRAINT `fk_parada_subte` FOREIGN KEY (`idParada`) REFERENCES `parada` (`idParada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_subte_parada` FOREIGN KEY (`idSubte`) REFERENCES `subte` (`idSubte`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paradaporsubte`
--

LOCK TABLES `paradaporsubte` WRITE;
/*!40000 ALTER TABLE `paradaporsubte` DISABLE KEYS */;
/*!40000 ALTER TABLE `paradaporsubte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paradaportren`
--

DROP TABLE IF EXISTS `paradaportren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paradaportren` (
  `idTren` int(11) NOT NULL,
  `idParada` int(11) NOT NULL,
  PRIMARY KEY (`idTren`,`idParada`),
  KEY `fk_parada_tren_idx` (`idParada`),
  CONSTRAINT `fk_parada_tren` FOREIGN KEY (`idParada`) REFERENCES `parada` (`idParada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tren_parada` FOREIGN KEY (`idTren`) REFERENCES `tren` (`idTren`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paradaportren`
--

LOCK TABLES `paradaportren` WRITE;
/*!40000 ALTER TABLE `paradaportren` DISABLE KEYS */;
INSERT INTO `paradaportren` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15);
/*!40000 ALTER TABLE `paradaportren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccion`
--

DROP TABLE IF EXISTS `seccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seccion` (
  `idSeccion` int(11) NOT NULL,
  `costo` float NOT NULL,
  PRIMARY KEY (`idSeccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccion`
--

LOCK TABLES `seccion` WRITE;
/*!40000 ALTER TABLE `seccion` DISABLE KEYS */;
INSERT INTO `seccion` VALUES (1,2.75),(2,4),(3,5.5);
/*!40000 ALTER TABLE `seccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccionporrecorrido`
--

DROP TABLE IF EXISTS `seccionporrecorrido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seccionporrecorrido` (
  `idSeccionPorRecorrido` int(11) NOT NULL,
  `idSeccion` int(11) NOT NULL,
  `idOrigen` int(11) NOT NULL,
  `idDestino` int(11) NOT NULL,
  PRIMARY KEY (`idSeccionPorRecorrido`),
  KEY `fk_parada_origen_idx` (`idOrigen`),
  KEY `fk_parada_destino_idx` (`idDestino`),
  KEY `fk_seccion_idx` (`idSeccion`),
  CONSTRAINT `fk_parada_destino` FOREIGN KEY (`idDestino`) REFERENCES `parada` (`idParada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_parada_origen` FOREIGN KEY (`idOrigen`) REFERENCES `parada` (`idParada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_seccion` FOREIGN KEY (`idSeccion`) REFERENCES `seccion` (`idSeccion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccionporrecorrido`
--

LOCK TABLES `seccionporrecorrido` WRITE;
/*!40000 ALTER TABLE `seccionporrecorrido` DISABLE KEYS */;
INSERT INTO `seccionporrecorrido` VALUES (1,1,1,2),(2,1,1,3),(3,1,1,4),(4,1,1,5),(5,1,1,6),(6,2,1,7),(7,2,1,8),(8,2,1,9),(9,2,1,10),(10,2,1,11),(11,2,1,12),(12,3,1,13),(13,3,1,14),(14,3,1,15),(15,1,2,1),(16,1,2,3),(17,1,2,4),(18,1,2,5),(19,1,2,6),(20,1,2,7),(21,1,2,8),(22,2,2,9),(23,2,2,10),(24,2,2,11),(25,2,2,12),(26,3,2,13),(27,3,2,14),(28,3,2,15),(29,1,3,1),(30,1,3,2),(31,1,3,4),(32,1,3,5),(33,1,3,6),(34,1,3,7),(35,1,3,8),(36,2,3,9),(37,2,3,10),(38,2,3,11),(39,2,3,12),(40,2,3,13),(41,3,3,14),(42,3,3,15),(43,1,4,1),(44,1,4,2),(45,1,4,3),(46,1,4,5),(47,1,4,6),(48,1,4,7),(49,1,4,8),(50,1,4,9),(51,2,4,10),(52,2,4,11),(53,2,4,12),(54,2,4,13),(55,2,4,14),(56,3,4,15),(57,1,5,1),(58,1,5,2),(59,1,5,3),(60,1,5,4),(61,1,5,6),(62,1,5,7),(63,1,5,8),(64,1,5,9),(65,1,5,10),(66,2,5,11),(67,2,5,12),(68,2,5,13),(69,2,5,14),(70,3,5,15),(71,1,6,1),(72,1,6,2),(73,1,6,3),(74,1,6,4),(75,1,6,5),(77,1,6,7),(78,1,6,8),(79,1,6,9),(80,1,6,10),(81,1,6,11),(82,2,6,12),(83,2,6,13),(84,2,6,14),(85,2,6,15),(86,2,7,1),(87,1,7,2),(88,1,7,3),(89,1,7,4),(90,1,7,5),(91,1,7,6),(92,1,7,8),(93,1,7,9),(94,1,7,10),(95,1,7,11),(96,2,7,12),(97,2,7,13),(98,2,7,14),(99,2,7,15),(100,2,8,1),(101,1,8,2),(102,1,8,3),(103,1,8,4),(104,1,8,5),(105,1,8,6),(106,1,8,7),(107,1,8,9),(108,1,8,10),(109,1,8,11),(110,1,8,12),(111,2,8,13),(112,2,8,14),(113,2,8,15),(114,2,9,1),(115,2,9,2),(116,2,9,3),(117,1,9,4),(118,1,9,5),(119,1,9,6),(120,1,9,7),(121,1,9,8),(122,1,9,10),(123,1,9,11),(124,1,9,12),(125,1,9,13),(126,2,9,14),(127,2,9,15),(128,2,10,1),(129,2,10,2),(130,2,10,3),(131,2,10,4),(132,1,10,5),(133,1,10,6),(134,1,10,7),(135,1,10,8),(136,1,10,9),(137,1,10,11),(138,1,10,12),(139,1,10,13),(140,2,10,14),(141,2,10,15),(142,2,11,1),(143,2,11,2),(144,2,11,3),(145,2,11,4),(146,2,11,5),(147,1,11,6),(148,1,11,7),(149,1,11,8),(150,1,11,9),(151,1,11,10),(152,1,11,12),(153,1,11,13),(154,1,11,14),(155,2,11,15),(156,2,12,1),(157,2,12,2),(158,2,12,3),(159,2,12,4),(160,2,12,5),(161,2,12,6),(162,2,12,7),(163,1,12,8),(164,1,12,9),(165,1,12,10),(166,1,12,11),(167,1,12,13),(168,1,12,14),(169,2,12,15),(170,3,13,1),(171,2,13,2),(172,2,13,3),(173,2,13,4),(174,2,13,5),(175,2,13,6),(176,2,13,7),(177,2,13,8),(178,1,13,9),(179,1,13,10),(180,1,13,11),(181,1,13,12),(182,1,13,14),(183,1,13,15),(184,3,14,1),(185,3,14,2),(186,3,14,3),(187,2,14,4),(188,2,14,5),(189,2,14,6),(190,2,14,7),(191,2,14,8),(192,2,14,9),(193,2,14,10),(194,1,14,11),(195,1,14,12),(196,1,14,13),(197,1,14,15),(198,3,15,1),(199,3,15,2),(200,3,15,3),(201,3,15,4),(202,3,15,5),(203,2,15,6),(204,2,15,7),(205,2,15,8),(206,2,15,9),(207,2,15,10),(208,2,15,11),(209,2,15,12),(210,1,15,13),(211,1,15,14);
/*!40000 ALTER TABLE `seccionporrecorrido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subte`
--

DROP TABLE IF EXISTS `subte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subte` (
  `idSubte` int(11) NOT NULL,
  PRIMARY KEY (`idSubte`),
  KEY `fk_TransportePublico_Subte_idx` (`idSubte`),
  CONSTRAINT `fk_TransportePublico_Subte` FOREIGN KEY (`idSubte`) REFERENCES `transportepublico` (`idTransportePublico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subte`
--

LOCK TABLES `subte` WRITE;
/*!40000 ALTER TABLE `subte` DISABLE KEYS */;
INSERT INTO `subte` VALUES (2);
/*!40000 ALTER TABLE `subte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tramo`
--

DROP TABLE IF EXISTS `tramo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tramo` (
  `idTramo` int(11) NOT NULL AUTO_INCREMENT,
  `distancia` varchar(45) NOT NULL,
  `costo` float NOT NULL,
  PRIMARY KEY (`idTramo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tramo`
--

LOCK TABLES `tramo` WRITE;
/*!40000 ALTER TABLE `tramo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tramo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tramoporcolectivo`
--

DROP TABLE IF EXISTS `tramoporcolectivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tramoporcolectivo` (
  `idColectivo` int(11) NOT NULL,
  `idTramo` int(11) NOT NULL,
  PRIMARY KEY (`idColectivo`,`idTramo`),
  KEY `fk_tramo_idx` (`idTramo`),
  CONSTRAINT `fk_colectivo` FOREIGN KEY (`idColectivo`) REFERENCES `colectivo` (`idColectivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tramo` FOREIGN KEY (`idTramo`) REFERENCES `tramo` (`idTramo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tramoporcolectivo`
--

LOCK TABLES `tramoporcolectivo` WRITE;
/*!40000 ALTER TABLE `tramoporcolectivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tramoporcolectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transportepublico`
--

DROP TABLE IF EXISTS `transportepublico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transportepublico` (
  `idTransportePublico` int(11) NOT NULL AUTO_INCREMENT,
  `linea` varchar(45) NOT NULL,
  PRIMARY KEY (`idTransportePublico`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transportepublico`
--

LOCK TABLES `transportepublico` WRITE;
/*!40000 ALTER TABLE `transportepublico` DISABLE KEYS */;
INSERT INTO `transportepublico` VALUES (1,'Constitucion-A.Korn'),(2,'C');
/*!40000 ALTER TABLE `transportepublico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tren`
--

DROP TABLE IF EXISTS `tren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tren` (
  `idTren` int(11) NOT NULL,
  PRIMARY KEY (`idTren`),
  KEY `fk_TransportePublico_idx` (`idTren`),
  CONSTRAINT `fk_TransportePublico` FOREIGN KEY (`idTren`) REFERENCES `transportepublico` (`idTransportePublico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tren`
--

LOCK TABLES `tren` WRITE;
/*!40000 ALTER TABLE `tren` DISABLE KEYS */;
INSERT INTO `tren` VALUES (1);
/*!40000 ALTER TABLE `tren` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-27 19:28:43

-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sube
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
  `ramal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idColectivo`),
  CONSTRAINT `fk_TransportePublico_colectivo` FOREIGN KEY (`idColectivo`) REFERENCES `transportepublico` (`idTransportePublico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colectivo`
--

LOCK TABLES `colectivo` WRITE;
/*!40000 ALTER TABLE `colectivo` DISABLE KEYS */;
INSERT INTO `colectivo` VALUES (3,'A'),(4,NULL);
/*!40000 ALTER TABLE `colectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacto`
--

DROP TABLE IF EXISTS `contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacto` (
  `idContacto` bigint(20) NOT NULL AUTO_INCREMENT,
  `mail` varchar(45) DEFAULT NULL,
  `movil` varchar(45) DEFAULT NULL,
  `fijo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idContacto`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacto`
--

LOCK TABLES `contacto` WRITE;
/*!40000 ALTER TABLE `contacto` DISABLE KEYS */;
INSERT INTO `contacto` VALUES (3,'mail','movil','fijo'),(4,'modificado','movil','fijo'),(5,'modificado2','movil','fijo'),(6,'rjavier@pepito.com','1162574132','42486183'),(7,'mail@gmail.com','11585825858','2525252525'),(8,'messicareta@gmail.com','',''),(9,'','','');
/*!40000 ALTER TABLE `contacto` ENABLE KEYS */;
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
-- Table structure for table `datosusuario`
--

DROP TABLE IF EXISTS `datosusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datosusuario` (
  `idDatosUsuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `genero` enum('X','F','M') NOT NULL,
  `contacto` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idDatosUsuario`),
  KEY `fk_datosusuario_contacto_idx` (`contacto`),
  CONSTRAINT `fk_datosusuario_contacto` FOREIGN KEY (`contacto`) REFERENCES `contacto` (`idContacto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datosusuario`
--

LOCK TABLES `datosusuario` WRITE;
/*!40000 ALTER TABLE `datosusuario` DISABLE KEYS */;
INSERT INTO `datosusuario` VALUES (4,'nombre','apellido','X',5),(5,'Javier','Rodriguez','M',6),(6,'Alejo','Ortega','X',7),(7,'Diego Armando','Maradona','X',8),(8,'Riquelme','Riquelme','M',9);
/*!40000 ALTER TABLE `datosusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devolucion`
--

DROP TABLE IF EXISTS `devolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `devolucion` (
  `idDevolucion` int(11) NOT NULL,
  PRIMARY KEY (`idDevolucion`),
  CONSTRAINT `fk_devolucion_transaccion` FOREIGN KEY (`idDevolucion`) REFERENCES `transaccion` (`idTransaccion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devolucion`
--

LOCK TABLES `devolucion` WRITE;
/*!40000 ALTER TABLE `devolucion` DISABLE KEYS */;
INSERT INTO `devolucion` VALUES (52),(54),(56);
/*!40000 ALTER TABLE `devolucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parada`
--

DROP TABLE IF EXISTS `parada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parada` (
  `idParada` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `distanciaKM` float DEFAULT '0',
  PRIMARY KEY (`idParada`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parada`
--

LOCK TABLES `parada` WRITE;
/*!40000 ALTER TABLE `parada` DISABLE KEYS */;
INSERT INTO `parada` VALUES (1,'Constitucion',0),(2,'Hipólito Yrigoyen',2.6),(3,'D.Santillán Y M.Kosteki',0.9),(4,'Gerli',2.78),(5,'Lanús',2.5),(6,'Remedios de Escalada',2.16),(7,'Banfield',2.16),(8,'Lomas de Zamora',2.02),(9,'Temperley',1.66),(10,'Adrogue',2.35),(11,'Burzaco',3.14),(12,'Longhcamps',3.5),(13,'Glew',3.22),(14,'Guernica',3.33),(15,'Alejandro Korn',7.03),(16,'San Juan',0),(17,'Independencia',0),(18,'Moreno',0),(19,'Av. de Mayo',0),(20,'Diagonal Norte',0),(21,'Lavalle',0),(22,'Gnral. San Martin',0),(23,'Retiro',0);
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
INSERT INTO `paradaporsubte` VALUES (2,1),(2,16),(2,17),(2,18),(2,19),(2,20),(2,21),(2,22),(2,23);
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
-- Table structure for table `recarga`
--

DROP TABLE IF EXISTS `recarga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recarga` (
  `idRecarga` int(11) NOT NULL,
  PRIMARY KEY (`idRecarga`),
  CONSTRAINT `fk_transaccion_recarga` FOREIGN KEY (`idRecarga`) REFERENCES `transaccion` (`idTransaccion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recarga`
--

LOCK TABLES `recarga` WRITE;
/*!40000 ALTER TABLE `recarga` DISABLE KEYS */;
INSERT INTO `recarga` VALUES (57),(58),(59),(60),(61);
/*!40000 ALTER TABLE `recarga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `redsube`
--

DROP TABLE IF EXISTS `redsube`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `redsube` (
  `idRedSube` int(11) NOT NULL,
  `fechaHora` datetime DEFAULT NULL,
  `contador` smallint(6) DEFAULT '0',
  `linea` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRedSube`),
  CONSTRAINT `fk-tarjetasube` FOREIGN KEY (`idRedSube`) REFERENCES `tarjetasube` (`nroTarjeta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `redsube`
--

LOCK TABLES `redsube` WRITE;
/*!40000 ALTER TABLE `redsube` DISABLE KEYS */;
INSERT INTO `redsube` VALUES (25,'2018-07-04 00:18:33',1,'C'),(26,'2018-07-23 21:22:00',1,'C');
/*!40000 ALTER TABLE `redsube` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'SinPrivilegios'),(2,'Admin');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
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
  CONSTRAINT `fk_TransportePublico_Subte` FOREIGN KEY (`idSubte`) REFERENCES `transportepublico` (`idTransportePublico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subte`
--

LOCK TABLES `subte` WRITE;
/*!40000 ALTER TABLE `subte` DISABLE KEYS */;
INSERT INTO `subte` VALUES (2),(5);
/*!40000 ALTER TABLE `subte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetasube`
--

DROP TABLE IF EXISTS `tarjetasube`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarjetasube` (
  `nroTarjeta` int(11) NOT NULL AUTO_INCREMENT,
  `saldo` float DEFAULT '0',
  `estado` smallint(1) DEFAULT '0',
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`nroTarjeta`),
  KEY `fk_tarjetasube_usuario1_idx` (`usuario`),
  CONSTRAINT `fk_tarjetasube_usuario1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetasube`
--

LOCK TABLES `tarjetasube` WRITE;
/*!40000 ALTER TABLE `tarjetasube` DISABLE KEYS */;
INSERT INTO `tarjetasube` VALUES (25,3000,2,4),(26,1945,0,5);
/*!40000 ALTER TABLE `tarjetasube` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tramo`
--

LOCK TABLES `tramo` WRITE;
/*!40000 ALTER TABLE `tramo` DISABLE KEYS */;
INSERT INTO `tramo` VALUES (1,'0-5',10),(2,'5-10',20),(3,'10-15',30),(4,'20',40);
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
INSERT INTO `tramoporcolectivo` VALUES (3,1),(3,2),(3,3),(3,4);
/*!40000 ALTER TABLE `tramoporcolectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaccion`
--

DROP TABLE IF EXISTS `transaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaccion` (
  `idTransaccion` int(11) NOT NULL AUTO_INCREMENT,
  `monto` float NOT NULL,
  `fechaHora` datetime NOT NULL,
  `nroTarjeta` int(11) NOT NULL,
  PRIMARY KEY (`idTransaccion`),
  KEY `fk_tarjetasube_transaccion_idx` (`nroTarjeta`),
  CONSTRAINT `fk_tarjetasube_transaccion` FOREIGN KEY (`nroTarjeta`) REFERENCES `tarjetasube` (`nroTarjeta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaccion`
--

LOCK TABLES `transaccion` WRITE;
/*!40000 ALTER TABLE `transaccion` DISABLE KEYS */;
INSERT INTO `transaccion` VALUES (1,1,'2018-06-13 07:03:03',25),(2,1,'2018-06-13 07:03:03',25),(3,1,'2018-06-13 07:03:03',25),(4,1,'2018-06-13 07:03:03',25),(5,40,'2018-06-13 07:03:03',25),(6,5,'2018-06-13 07:03:03',25),(7,40,'2018-06-13 07:03:03',25),(8,40,'2018-06-13 07:03:03',25),(50,5.5,'2018-06-13 01:47:43',25),(51,5.5,'2018-06-13 01:57:36',25),(52,2.75,'2018-06-13 01:58:06',25),(53,5.5,'2018-06-13 01:58:40',25),(54,1.5,'2018-06-13 01:59:34',25),(55,5.5,'2018-06-13 02:00:49',25),(56,1.5,'2018-06-13 02:01:32',25),(57,500,'2018-06-13 05:37:13',26),(58,300,'2018-06-13 07:02:41',25),(59,0.14,'2018-06-13 07:02:56',25),(60,17,'2018-06-13 07:03:00',25),(61,40,'2018-06-13 07:03:03',25),(62,40,'2018-06-13 07:03:03',25),(63,40,'2018-06-13 07:03:03',25),(64,10,'2018-06-17 21:37:00',26),(65,0,'2018-07-25 10:18:00',25),(66,0,'2018-07-25 11:40:00',25),(67,0,'2018-07-20 11:41:00',25),(68,15,'2018-07-25 15:52:00',26),(69,0,'2018-07-03 18:19:35',25),(70,15,'2018-07-03 18:20:22',26),(71,0,'2018-07-17 21:01:00',25),(72,0,'2018-07-10 21:06:00',25),(73,0,'2018-07-10 21:06:00',25),(74,0,'2018-07-24 21:07:00',25),(75,0,'2018-07-24 21:07:00',25),(76,0,'2018-07-16 21:09:00',25),(77,0,'2018-07-09 21:13:00',25),(78,0,'2018-07-03 21:14:52',25),(79,0,'2018-07-09 21:15:00',25),(80,0,'2018-07-17 21:16:00',25),(81,0,'2018-07-03 21:21:56',25),(82,15,'2018-07-23 21:22:00',26),(83,0,'2018-07-04 00:18:33',25);
/*!40000 ALTER TABLE `transaccion` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transportepublico`
--

LOCK TABLES `transportepublico` WRITE;
/*!40000 ALTER TABLE `transportepublico` DISABLE KEYS */;
INSERT INTO `transportepublico` VALUES (1,'Constitucion-A.Korn'),(2,'C'),(3,'318'),(4,'160'),(5,'D');
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
  CONSTRAINT `fk_transportepublio_tren` FOREIGN KEY (`idTren`) REFERENCES `transportepublico` (`idTransportePublico`) ON DELETE NO ACTION ON UPDATE NO ACTION
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

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipoDocumento` varchar(45) NOT NULL,
  `documento` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `fechaAlta` date NOT NULL,
  `datosusuario` bigint(20) NOT NULL,
  `idRol` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idUsuario`),
  KEY `fk_usuario_datosusuario_idx` (`datosusuario`),
  KEY `fk_usuario_rol_idx` (`idRol`),
  CONSTRAINT `fk_usuario_datosusuario` FOREIGN KEY (`datosusuario`) REFERENCES `datosusuario` (`idDatosUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (4,'DNI','1','clave','2018-05-12',4,1),(5,'DNI','admin','admin','2018-06-11',5,2),(6,'Nacional','33333','clave','2018-07-03',6,1),(7,'Nacional','123','messichupala','2018-07-03',7,1),(8,'Nacional','22222','esa','2018-07-03',8,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viaje`
--

DROP TABLE IF EXISTS `viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viaje` (
  `idviaje` int(11) NOT NULL,
  `idTransportePublico` int(11) NOT NULL,
  PRIMARY KEY (`idviaje`),
  KEY `fk_transportepublico_idx` (`idTransportePublico`),
  CONSTRAINT `fk_transaccion_viaje` FOREIGN KEY (`idviaje`) REFERENCES `transaccion` (`idTransaccion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transportepublico` FOREIGN KEY (`idTransportePublico`) REFERENCES `transportepublico` (`idTransportePublico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaje`
--

LOCK TABLES `viaje` WRITE;
/*!40000 ALTER TABLE `viaje` DISABLE KEYS */;
INSERT INTO `viaje` VALUES (50,1),(51,1),(53,1),(55,1),(62,1),(63,1),(71,1),(6,2),(7,2),(8,2),(65,2),(66,2),(67,2),(68,2),(69,2),(70,2),(77,2),(78,2),(79,2),(80,2),(81,2),(82,2),(83,2),(1,3),(2,3),(3,3),(4,3),(5,3),(64,3),(72,3),(73,3),(74,3),(75,3),(76,3);
/*!40000 ALTER TABLE `viaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viajecolectivo`
--

DROP TABLE IF EXISTS `viajecolectivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viajecolectivo` (
  `idViajeColectivo` int(11) NOT NULL,
  `idTramo` int(11) NOT NULL,
  PRIMARY KEY (`idViajeColectivo`),
  KEY `fk_tramo_idx` (`idTramo`),
  CONSTRAINT `fk_tramo_colectivo` FOREIGN KEY (`idTramo`) REFERENCES `tramo` (`idTramo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_viaje_colectivo` FOREIGN KEY (`idViajeColectivo`) REFERENCES `viaje` (`idviaje`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viajecolectivo`
--

LOCK TABLES `viajecolectivo` WRITE;
/*!40000 ALTER TABLE `viajecolectivo` DISABLE KEYS */;
INSERT INTO `viajecolectivo` VALUES (1,1),(2,1),(64,1),(5,2),(74,2),(75,2),(76,2),(3,3),(72,3),(73,3),(4,4);
/*!40000 ALTER TABLE `viajecolectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viajesubte`
--

DROP TABLE IF EXISTS `viajesubte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viajesubte` (
  `idViajeSubte` int(11) NOT NULL,
  `idParada` int(11) NOT NULL,
  PRIMARY KEY (`idViajeSubte`),
  KEY `fk_parada_subte_idx` (`idParada`),
  CONSTRAINT `fk_parada_subte1` FOREIGN KEY (`idParada`) REFERENCES `parada` (`idParada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_viaje_subte1` FOREIGN KEY (`idViajeSubte`) REFERENCES `viaje` (`idviaje`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viajesubte`
--

LOCK TABLES `viajesubte` WRITE;
/*!40000 ALTER TABLE `viajesubte` DISABLE KEYS */;
INSERT INTO `viajesubte` VALUES (6,1),(7,1),(8,16),(67,16),(78,16),(79,16),(80,16),(81,16),(82,16),(83,16),(68,17),(69,17),(70,17),(77,17),(65,18),(66,18);
/*!40000 ALTER TABLE `viajesubte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viajetren`
--

DROP TABLE IF EXISTS `viajetren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viajetren` (
  `idViajeTren` int(11) NOT NULL,
  `idParadaOrigen` int(11) NOT NULL,
  `idParadaDestino` int(11) DEFAULT NULL,
  PRIMARY KEY (`idViajeTren`),
  KEY `fk_parada_tren_origen_idx` (`idParadaOrigen`),
  KEY `fk_parada_tren_destino_idx` (`idParadaDestino`),
  CONSTRAINT `fk_parada_tren_destino` FOREIGN KEY (`idParadaDestino`) REFERENCES `parada` (`idParada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_parada_tren_origen` FOREIGN KEY (`idParadaOrigen`) REFERENCES `parada` (`idParada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_viaje_tren` FOREIGN KEY (`idViajeTren`) REFERENCES `viaje` (`idviaje`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viajetren`
--

LOCK TABLES `viajetren` WRITE;
/*!40000 ALTER TABLE `viajetren` DISABLE KEYS */;
INSERT INTO `viajetren` VALUES (50,1,1),(51,1,1),(53,3,3),(55,1,9),(62,1,5),(63,1,1),(71,9,9);
/*!40000 ALTER TABLE `viajetren` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-04  0:32:27

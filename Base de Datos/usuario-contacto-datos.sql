CREATE TABLE `usuario` (
  `idUsuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipoDocumento` varchar(45) NOT NULL,
  `documento` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `fechaAlta` date NOT NULL,
  `datosusuario` bigint(20) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_usuario_datosusuario_idx` (`datosusuario`),
  CONSTRAINT `fk_usuario_datosusuario` FOREIGN KEY (`datosusuario`) REFERENCES `datosusuario` (`idDatosUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;



CREATE TABLE `datosusuario` (
  `idDatosUsuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `genero` enum('X','F','M') NOT NULL,
  `contacto` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idDatosUsuario`),
  KEY `fk_datosusuario_contacto_idx` (`contacto`),
  CONSTRAINT `fk_datosusuario_contacto` FOREIGN KEY (`contacto`) REFERENCES `contacto` (`idContacto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `contacto` (
  `idContacto` bigint(20) NOT NULL AUTO_INCREMENT,
  `mail` varchar(45) DEFAULT NULL,
  `movil` varchar(45) DEFAULT NULL,
  `fijo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idContacto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
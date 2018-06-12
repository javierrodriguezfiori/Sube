-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sube
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sube
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sube` DEFAULT CHARACTER SET utf8 ;
USE `sube` ;

-- -----------------------------------------------------
-- Table `sube`.`transportepublico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`transportepublico` (
  `idTransportePublico` INT(11) NOT NULL AUTO_INCREMENT,
  `linea` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTransportePublico`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`colectivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`colectivo` (
  `idColectivo` INT(11) NOT NULL,
  `ramal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idColectivo`),
  CONSTRAINT `fk_TransportePublico_colectivo`
    FOREIGN KEY (`idColectivo`)
    REFERENCES `sube`.`transportepublico` (`idTransportePublico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`contacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`contacto` (
  `idContacto` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `mail` VARCHAR(45) NULL DEFAULT NULL,
  `movil` VARCHAR(45) NULL DEFAULT NULL,
  `fijo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idContacto`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sube`.`costosubte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`costosubte` (
  `idcostosubte` INT(11) NOT NULL,
  `costo` FLOAT NOT NULL,
  PRIMARY KEY (`idcostosubte`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`datosusuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`datosusuario` (
  `idDatosUsuario` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `genero` ENUM('X', 'F', 'M') NOT NULL,
  `contacto` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`idDatosUsuario`),
  INDEX `fk_datosusuario_contacto_idx` (`contacto` ASC),
  CONSTRAINT `fk_datosusuario_contacto`
    FOREIGN KEY (`contacto`)
    REFERENCES `sube`.`contacto` (`idContacto`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sube`.`parada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`parada` (
  `idParada` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idParada`))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`subte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`subte` (
  `idSubte` INT(11) NOT NULL,
  PRIMARY KEY (`idSubte`),
  CONSTRAINT `fk_TransportePublico_Subte`
    FOREIGN KEY (`idSubte`)
    REFERENCES `sube`.`transportepublico` (`idTransportePublico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`paradaporsubte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`paradaporsubte` (
  `idSubte` INT(11) NOT NULL,
  `idParada` INT(11) NOT NULL,
  PRIMARY KEY (`idSubte`, `idParada`),
  INDEX `fk_parada_subte_idx` (`idParada` ASC),
  CONSTRAINT `fk_parada_subte`
    FOREIGN KEY (`idParada`)
    REFERENCES `sube`.`parada` (`idParada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_subte_parada`
    FOREIGN KEY (`idSubte`)
    REFERENCES `sube`.`subte` (`idSubte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`tren`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`tren` (
  `idTren` INT(11) NOT NULL,
  PRIMARY KEY (`idTren`),
  CONSTRAINT `fk_transportepublio_tren`
    FOREIGN KEY (`idTren`)
    REFERENCES `sube`.`transportepublico` (`idTransportePublico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`paradaportren`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`paradaportren` (
  `idTren` INT(11) NOT NULL,
  `idParada` INT(11) NOT NULL,
  PRIMARY KEY (`idTren`, `idParada`),
  INDEX `fk_parada_tren_idx` (`idParada` ASC),
  CONSTRAINT `fk_parada_tren`
    FOREIGN KEY (`idParada`)
    REFERENCES `sube`.`parada` (`idParada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tren_parada`
    FOREIGN KEY (`idTren`)
    REFERENCES `sube`.`tren` (`idTren`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`usuario` (
  `idUsuario` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tipoDocumento` VARCHAR(45) NOT NULL,
  `documento` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `fechaAlta` DATE NOT NULL,
  `datosusuario` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_usuario_datosusuario_idx` (`datosusuario` ASC),
  CONSTRAINT `fk_usuario_datosusuario`
    FOREIGN KEY (`datosusuario`)
    REFERENCES `sube`.`datosusuario` (`idDatosUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sube`.`tarjetasube`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`tarjetasube` (
  `nroTarjeta` INT(11) NOT NULL AUTO_INCREMENT,
  `saldo` FLOAT NULL DEFAULT '0',
  `estado` SMALLINT(1) NULL DEFAULT '0',
  `usuario` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`nroTarjeta`),
  INDEX `fk_tarjetasube_usuario1_idx` (`usuario` ASC),
  CONSTRAINT `fk_tarjetasube_usuario1`
    FOREIGN KEY (`usuario`)
    REFERENCES `sube`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`transaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`transaccion` (
  `idTransaccion` INT(11) NOT NULL AUTO_INCREMENT,
  `monto` FLOAT NOT NULL,
  `fechaHora` DATETIME NOT NULL,
  `nroTarjeta` INT(11) NOT NULL,
  PRIMARY KEY (`idTransaccion`),
  INDEX `fk_tarjetasube_transaccion_idx` (`nroTarjeta` ASC),
  CONSTRAINT `fk_tarjetasube_transaccion`
    FOREIGN KEY (`nroTarjeta`)
    REFERENCES `sube`.`tarjetasube` (`nroTarjeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`recarga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`recarga` (
  `idRecarga` INT(11) NOT NULL,
  PRIMARY KEY (`idRecarga`),
  CONSTRAINT `fk_transaccion_recarga`
    FOREIGN KEY (`idRecarga`)
    REFERENCES `sube`.`transaccion` (`idTransaccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`redsube`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`redsube` (
  `idRedSube` INT(11) NOT NULL,
  `fechaHora` DATETIME NULL DEFAULT NULL,
  `contador` SMALLINT(6) NULL DEFAULT '0',
  `linea` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idRedSube`),
  CONSTRAINT `fk-tarjetasube`
    FOREIGN KEY (`idRedSube`)
    REFERENCES `sube`.`tarjetasube` (`nroTarjeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`seccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`seccion` (
  `idSeccion` INT(11) NOT NULL,
  `costo` FLOAT NOT NULL,
  PRIMARY KEY (`idSeccion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`seccionporrecorrido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`seccionporrecorrido` (
  `idSeccionPorRecorrido` INT(11) NOT NULL,
  `idSeccion` INT(11) NOT NULL,
  `idOrigen` INT(11) NOT NULL,
  `idDestino` INT(11) NOT NULL,
  PRIMARY KEY (`idSeccionPorRecorrido`),
  INDEX `fk_parada_origen_idx` (`idOrigen` ASC),
  INDEX `fk_parada_destino_idx` (`idDestino` ASC),
  INDEX `fk_seccion_idx` (`idSeccion` ASC),
  CONSTRAINT `fk_parada_destino`
    FOREIGN KEY (`idDestino`)
    REFERENCES `sube`.`parada` (`idParada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parada_origen`
    FOREIGN KEY (`idOrigen`)
    REFERENCES `sube`.`parada` (`idParada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_seccion`
    FOREIGN KEY (`idSeccion`)
    REFERENCES `sube`.`seccion` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`tramo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`tramo` (
  `idTramo` INT(11) NOT NULL AUTO_INCREMENT,
  `distancia` VARCHAR(45) NOT NULL,
  `costo` FLOAT NOT NULL,
  PRIMARY KEY (`idTramo`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`tramoporcolectivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`tramoporcolectivo` (
  `idColectivo` INT(11) NOT NULL,
  `idTramo` INT(11) NOT NULL,
  PRIMARY KEY (`idColectivo`, `idTramo`),
  INDEX `fk_tramo_idx` (`idTramo` ASC),
  CONSTRAINT `fk_colectivo`
    FOREIGN KEY (`idColectivo`)
    REFERENCES `sube`.`colectivo` (`idColectivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tramo`
    FOREIGN KEY (`idTramo`)
    REFERENCES `sube`.`tramo` (`idTramo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`viaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`viaje` (
  `idviaje` INT(11) NOT NULL,
  `idTransportePublico` INT(11) NOT NULL,
  PRIMARY KEY (`idviaje`),
  INDEX `fk_transportepublico_idx` (`idTransportePublico` ASC),
  CONSTRAINT `fk_transaccion_viaje`
    FOREIGN KEY (`idviaje`)
    REFERENCES `sube`.`transaccion` (`idTransaccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transportepublico`
    FOREIGN KEY (`idTransportePublico`)
    REFERENCES `sube`.`transportepublico` (`idTransportePublico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`viajecolectivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`viajecolectivo` (
  `idViajeColectivo` INT(11) NOT NULL,
  `idTramo` INT(11) NOT NULL,
  PRIMARY KEY (`idViajeColectivo`),
  INDEX `fk_tramo_idx` (`idTramo` ASC),
  CONSTRAINT `fk_tramo_colectivo`
    FOREIGN KEY (`idTramo`)
    REFERENCES `sube`.`tramo` (`idTramo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_viaje_colectivo`
    FOREIGN KEY (`idViajeColectivo`)
    REFERENCES `sube`.`viaje` (`idviaje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`viajesubte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`viajesubte` (
  `idViajeSubte` INT(11) NOT NULL,
  `idParada` INT(11) NOT NULL,
  PRIMARY KEY (`idViajeSubte`),
  INDEX `fk_parada_subte_idx` (`idParada` ASC),
  CONSTRAINT `fk_parada_subte1`
    FOREIGN KEY (`idParada`)
    REFERENCES `sube`.`parada` (`idParada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_viaje_subte1`
    FOREIGN KEY (`idViajeSubte`)
    REFERENCES `sube`.`viaje` (`idviaje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sube`.`viajetren`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`viajetren` (
  `idViajeTren` INT(11) NOT NULL,
  `idParadaOrigen` INT(11) NOT NULL,
  `idParadaDestino` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idViajeTren`),
  INDEX `fk_parada_tren_origen_idx` (`idParadaOrigen` ASC),
  INDEX `fk_parada_tren_destino_idx` (`idParadaDestino` ASC),
  CONSTRAINT `fk_parada_tren_destino`
    FOREIGN KEY (`idParadaDestino`)
    REFERENCES `sube`.`parada` (`idParada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parada_tren_origen`
    FOREIGN KEY (`idParadaOrigen`)
    REFERENCES `sube`.`parada` (`idParada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_viaje_tren`
    FOREIGN KEY (`idViajeTren`)
    REFERENCES `sube`.`viaje` (`idviaje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

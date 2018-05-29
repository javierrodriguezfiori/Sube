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
-- Table `sube`.`tarjetasube`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube`.`tarjetasube` (
  `nroTarjeta` INT(11) NOT NULL AUTO_INCREMENT,
  `saldo` FLOAT NOT NULL DEFAULT '0',
  `estado` SMALLINT(1) NULL DEFAULT '0',
  PRIMARY KEY (`nroTarjeta`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- MySQL Script generated by MySQL Workbench
-- Sun Jan 15 22:31:14 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Building_Company_F
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Building_Company_F` ;

-- -----------------------------------------------------
-- Schema Building_Company_F
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Building_Company_F` DEFAULT CHARACTER SET utf8 ;
USE `Building_Company_F` ;

-- -----------------------------------------------------
-- Table `Building_Company_F`.`Persons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Persons` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Workers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Workers` (
  `id` INT NOT NULL,
  `position` VARCHAR(45) NULL,
  `salary` INT NULL,
  `person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Employees_Persons1`
    FOREIGN KEY (`person_id`)
    REFERENCES `Building_Company_F`.`Persons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Customers` (
  `id` INT NOT NULL,
  `budget` INT NULL,
  `person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Customers_Persons`
    FOREIGN KEY (`person_id`)
    REFERENCES `Building_Company_F`.`Persons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Building_Costs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Building_Costs` (
  `id` INT NOT NULL,
  `cost_per_square_meter` INT NULL,
  `permit_cost` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Building_Timelines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Building_Timelines` (
  `id` INT NOT NULL,
  `construction_time` INT NULL,
  `permit_process_time` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Building_Types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Building_Types` (
  `id` INT NOT NULL,
  `capacity` INT NULL,
  `floors` INT NULL,
  `category` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Buildings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Buildings` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `building_cost_id` INT NOT NULL,
  `building_timeline_id` INT NOT NULL,
  `building_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Buildings_Buildings costs1`
    FOREIGN KEY (`building_cost_id`)
    REFERENCES `Building_Company_F`.`Building_Costs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Buildings_Buildings timelines1`
    FOREIGN KEY (`building_timeline_id`)
    REFERENCES `Building_Company_F`.`Building_Timelines` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Buildings_Buildings types1`
    FOREIGN KEY (`building_type_id`)
    REFERENCES `Building_Company_F`.`Building_Types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Constructions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Constructions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `is_paid` TINYINT NULL,
  `customer_id` INT NOT NULL,
  `building_id` INT NOT NULL,
  `construction_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Orders_Customers1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `Building_Company_F`.`Customers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orders_Buildings1`
    FOREIGN KEY (`building_id`)
    REFERENCES `Building_Company_F`.`Buildings` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orders_Constructions1`
    FOREIGN KEY (`construction_id`)
    REFERENCES `Building_Company_F`.`Constructions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `price` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Required_Items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Required_Items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `required_amount` INT NULL,
  `item_id` INT NOT NULL,
  `building_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Required items_Buildings1`
    FOREIGN KEY (`building_id`)
    REFERENCES `Building_Company_F`.`Buildings` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Required items_Items1`
    FOREIGN KEY (`item_id`)
    REFERENCES `Building_Company_F`.`Items` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Inventory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Inventory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `available` INT NULL,
  `item_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Inventory_Items1`
    FOREIGN KEY (`item_id`)
    REFERENCES `Building_Company_F`.`Items` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Construction_Items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Construction_Items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` INT NULL,
  `item_id` INT NOT NULL,
  `construction_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Construction inventory_Constructions1`
    FOREIGN KEY (`construction_id`)
    REFERENCES `Building_Company_F`.`Constructions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Construction items_Items1`
    FOREIGN KEY (`item_id`)
    REFERENCES `Building_Company_F`.`Items` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_Company_F`.`Construction_Workers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_Company_F`.`Construction_Workers` (
  `id` INT NOT NULL,
  `worker_id` INT NOT NULL,
  `construction_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Workers team_Constructions1`
    FOREIGN KEY (`construction_id`)
    REFERENCES `Building_Company_F`.`Constructions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Workers team_Workers1`
    FOREIGN KEY (`worker_id`)
    REFERENCES `Building_Company_F`.`Workers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- MySQL Script generated by MySQL Workbench
-- Fri Jan 13 16:35:15 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Building_company
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Building_company` ;

-- -----------------------------------------------------
-- Schema Building_company
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Building_company` DEFAULT CHARACTER SET utf8 ;
USE `Building_company` ;

-- -----------------------------------------------------
-- Table `Building_company`.`Persons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Persons` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_company`.`Constructions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Constructions` (
  `id` INT NOT NULL,
  `address` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `start_date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_company`.`Workers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Workers` (
  `id` INT NOT NULL,
  `position` VARCHAR(45) NULL,
  `salary` INT NULL,
  `person_id` INT NOT NULL,
  `construction_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Employees_Persons1_idx` (`person_id` ASC) VISIBLE,
  INDEX `fk_Workers_Constructions1_idx` (`construction_id` ASC) VISIBLE,
  CONSTRAINT `fk_Employees_Persons1`
    FOREIGN KEY (`person_id`)
    REFERENCES `Building_company`.`Persons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Workers_Constructions1`
    FOREIGN KEY (`construction_id`)
    REFERENCES `Building_company`.`Constructions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_company`.`Customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Customers` (
  `id` INT NOT NULL,
  `budget` INT NULL,
  `person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Customers_Persons_idx` (`person_id` ASC) VISIBLE,
  CONSTRAINT `fk_Customers_Persons`
    FOREIGN KEY (`person_id`)
    REFERENCES `Building_company`.`Persons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_company`.`Building costs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Building costs` (
  `id` INT NOT NULL,
  `cost_per_square_meter` INT NULL,
  `permit_cost` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_company`.`Building timelines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Building timelines` (
  `id` INT NOT NULL,
  `construction_time` INT NULL,
  `permit_process_time` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_company`.`Building types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Building types` (
  `id` INT NOT NULL,
  `capacity` INT NULL,
  `floors` INT NULL,
  `category` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_company`.`Buildings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Buildings` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `building_cost_id` INT NOT NULL,
  `building_timeline_id` INT NOT NULL,
  `building_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Buildings_Buildings costs1_idx` (`building_cost_id` ASC) VISIBLE,
  INDEX `fk_Buildings_Buildings timelines1_idx` (`building_timeline_id` ASC) VISIBLE,
  INDEX `fk_Buildings_Buildings types1_idx` (`building_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_Buildings_Buildings costs1`
    FOREIGN KEY (`building_cost_id`)
    REFERENCES `Building_company`.`Building costs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Buildings_Buildings timelines1`
    FOREIGN KEY (`building_timeline_id`)
    REFERENCES `Building_company`.`Building timelines` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Buildings_Buildings types1`
    FOREIGN KEY (`building_type_id`)
    REFERENCES `Building_company`.`Building types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_company`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Orders` (
  `id` INT NOT NULL,
  `is_paid` TINYINT NULL,
  `customer_id` INT NOT NULL,
  `building_id` INT NOT NULL,
  `construction_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Orders_Customers1_idx` (`customer_id` ASC) VISIBLE,
  INDEX `fk_Orders_Buildings1_idx` (`building_id` ASC) VISIBLE,
  INDEX `fk_Orders_Constructions1_idx` (`construction_id` ASC) VISIBLE,
  CONSTRAINT `fk_Orders_Customers1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `Building_company`.`Customers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orders_Buildings1`
    FOREIGN KEY (`building_id`)
    REFERENCES `Building_company`.`Buildings` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orders_Constructions1`
    FOREIGN KEY (`construction_id`)
    REFERENCES `Building_company`.`Constructions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_company`.`Items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Items` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `price` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_company`.`Required items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Required items` (
  `id` INT NOT NULL,
  `required_amount` INT NULL,
  `item_id` INT NOT NULL,
  `building_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Required items_Buildings1_idx` (`building_id` ASC) VISIBLE,
  INDEX `fk_Required items_Items1_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `fk_Required items_Buildings1`
    FOREIGN KEY (`building_id`)
    REFERENCES `Building_company`.`Buildings` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Required items_Items1`
    FOREIGN KEY (`item_id`)
    REFERENCES `Building_company`.`Items` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_company`.`Inventory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Inventory` (
  `id` INT NOT NULL,
  `available` INT NULL,
  `item_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Inventory_Items1_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `fk_Inventory_Items1`
    FOREIGN KEY (`item_id`)
    REFERENCES `Building_company`.`Items` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Building_company`.`Construction items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Building_company`.`Construction items` (
  `id` INT NOT NULL,
  `amount` INT NULL,
  `item_id` INT NOT NULL,
  `construction_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Construction inventory_Constructions1_idx` (`construction_id` ASC) VISIBLE,
  INDEX `fk_Construction items_Items1_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `fk_Construction inventory_Constructions1`
    FOREIGN KEY (`construction_id`)
    REFERENCES `Building_company`.`Constructions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Construction items_Items1`
    FOREIGN KEY (`item_id`)
    REFERENCES `Building_company`.`Items` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

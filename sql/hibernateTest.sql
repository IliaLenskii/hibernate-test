DROP DATABASE `hibernateTest`;

CREATE DATABASE IF NOT EXISTS `hibernateTest`;

USE `hibernateTest`;

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
    `id` MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(150) DEFAULT NUll,
    `last_name` VARCHAR(150) DEFAULT NUll,
    `email` VARCHAR(150) DEFAULT NUll,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
    `id` MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(150) DEFAULT NUll,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `students_books_related`;

CREATE TABLE `students_books_related` (
    `studentId` MEDIUMINT UNSIGNED NOT NULL,
    `booksId` MEDIUMINT UNSIGNED NOT NULL,
    PRIMARY KEY (`studentId`, `booksId`),
    KEY `student_books_related_idx` (`booksId`),
    CONSTRAINT `this-to-student` FOREIGN KEY (`studentId`)
    REFERENCES `students` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

    CONSTRAINT `this-to-books` FOREIGN KEY (`booksId`)
    REFERENCES `books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

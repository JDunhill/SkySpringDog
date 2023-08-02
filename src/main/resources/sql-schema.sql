DROP TABLE IF EXISTS `dog` CASCADE;
CREATE TABLE `dog` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `age` INTEGER CHECK (age>=0 AND age<=32),
    `colour` VARCHAR(255),
    `name` VARCHAR(255)
);
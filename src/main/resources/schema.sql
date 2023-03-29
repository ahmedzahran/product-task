CREATE TABLE IF NOT EXISTS `user` (
    `id`         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(150) NOT NULL,
    `password` VARCHAR(70) NOT NULL
    );

CREATE TABLE IF NOT EXISTS `product` (
    `id`         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    `description` VARCHAR(150) NOT NULL,
    `serial` VARCHAR(150) NOT NULL,
    `status` BOOLEAN NOT NULL Default true

    );

CREATE TABLE IF NOT EXISTS `orders` (
    `id`         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    `status` BOOLEAN NOT NULL Default false,
    `product_id` INTEGER NOT NULL,
    `address` VARCHAR(150) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id)
);
CREATE TABLE IF NOT EXISTS `ecommercedb`.`users`
(
    `id`    BIGINT PRIMARY KEY,
    `email` VARCHAR(50) UNIQUE,
    `name`  VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS `ecommercedb`.`module`
(
    `id`   BIGINT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS `ecommercedb`.`user_module`
(
    `user_id`   BIGINT,
    `module_id` BIGINT,
    `order`     INTEGER NOT NULL,
    PRIMARY KEY (`user_id`, `module_id`),
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    FOREIGN KEY (`module_id`) REFERENCES `module` (`id`)
);

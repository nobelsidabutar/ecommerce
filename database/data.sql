INSERT INTO `ecommercedb`.`users`
VALUES (1, 'user1@mail.com', 'UserA');
INSERT INTO `ecommercedb`.`users`
VALUES (2, 'user2@mail.com', 'UserB');
INSERT INTO `ecommercedb`.`users`
VALUES (3, 'user3@mail.com', 'UserC');

INSERT INTO `ecommercedb`.`module`
VALUES (1, 'Promo');
INSERT INTO `ecommercedb`.`module`
VALUES (2, 'Category');
INSERT INTO `ecommercedb`.`module`
VALUES (3, 'FlashSale');
INSERT INTO `ecommercedb`.`module`
VALUES (4, 'History');
INSERT INTO `ecommercedb`.`module`
VALUES (5, 'News');

INSERT INTO `ecommercedb`.`user_module`
VALUES (1, 1, 1);
INSERT INTO `ecommercedb`.`user_module`
VALUES (1, 2, 2);
INSERT INTO `ecommercedb`.`user_module`
VALUES (1, 3, 3);
INSERT INTO `ecommercedb`.`user_module`
VALUES (1, 4, 4);
INSERT INTO `ecommercedb`.`user_module`
VALUES (1, 5, 5);

INSERT INTO `ecommercedb`.`user_module`
VALUES (2, 1, 1);
INSERT INTO `ecommercedb`.`user_module`
VALUES (2, 5, 2);
INSERT INTO `ecommercedb`.`user_module`
VALUES (2, 3, 3);
INSERT INTO `ecommercedb`.`user_module`
VALUES (2, 2, 4);
INSERT INTO `ecommercedb`.`user_module`
VALUES (2, 4, 5);

INSERT INTO `ecommercedb`.`user_module`
VALUES (3, 1, 1);
INSERT INTO `ecommercedb`.`user_module`
VALUES (3, 3, 2);
INSERT INTO `ecommercedb`.`user_module`
VALUES (3, 2, 3);
INSERT INTO `ecommercedb`.`user_module`
VALUES (3, 5, 4);
INSERT INTO `ecommercedb`.`user_module`
VALUES (3, 4, 5);
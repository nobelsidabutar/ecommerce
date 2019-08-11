INSERT INTO `users`
VALUES (1, 'user1@mail.com', 'UserA');
INSERT INTO `users`
VALUES (2, 'user2@mail.com', 'UserB');
INSERT INTO `users`
VALUES (3, 'user3@mail.com', 'UserC');

INSERT INTO `module`
VALUES (1, 'Promo');
INSERT INTO `module`
VALUES (2, 'Category');
INSERT INTO `module`
VALUES (3, 'FlashSale');
INSERT INTO `module`
VALUES (4, 'History');
INSERT INTO `module`
VALUES (5, 'News');

INSERT INTO `user_module`
VALUES (1, 1, 1);
INSERT INTO `user_module`
VALUES (1, 2, 2);
INSERT INTO `user_module`
VALUES (1, 3, 3);
INSERT INTO `user_module`
VALUES (1, 4, 4);
INSERT INTO `user_module`
VALUES (1, 5, 5);

INSERT INTO `user_module`
VALUES (2, 1, 1);
INSERT INTO `user_module`
VALUES (2, 5, 2);
INSERT INTO `user_module`
VALUES (2, 3, 3);
INSERT INTO `user_module`
VALUES (2, 2, 4);
INSERT INTO `user_module`
VALUES (2, 4, 5);

INSERT INTO `user_module`
VALUES (3, 1, 1);
INSERT INTO `user_module`
VALUES (3, 3, 2);
INSERT INTO `user_module`
VALUES (3, 2, 3);
INSERT INTO `user_module`
VALUES (3, 5, 4);
INSERT INTO `user_module`
VALUES (3, 4, 5);
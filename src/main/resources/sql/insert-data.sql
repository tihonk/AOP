INSERT INTO price VALUES (101, 1.99);
INSERT INTO price VALUES (102, 0.50);
INSERT INTO price VALUES (103, 103.39);
INSERT INTO price VALUES (104, 8.44);
INSERT INTO price VALUES (105, 28.44);

INSERT INTO address VALUES (41, 'Tockio, 笑、チェブレク Str. 87, 124');
INSERT INTO address VALUES (42, 'Peckin, 从模因中尖叫 62, 182');
INSERT INTO address VALUES (43, 'Minsk, ул. Кульман 1 412');
INSERT INTO address VALUES (44, 'Moscow, Красная площадь 1');

INSERT INTO payment VALUES (300, 'Request is being processed');
INSERT INTO payment VALUES (301, 'Request confirmed');
INSERT INTO payment VALUES (302, 'Request not confirmed');
INSERT INTO payment VALUES (303, 'Package sent');
INSERT INTO payment VALUES (304, '');

INSERT INTO landlord VALUES (21, 43, 301);
INSERT INTO landlord VALUES (22, 41, 302);

INSERT INTO tenant VALUES (31, 44, 300);
INSERT INTO tenant VALUES (32, 42, 300);

INSERT INTO deposit VALUES (1001, 21, 31);
INSERT INTO deposit VALUES (1002, 22, 32);
INSERT INTO deposit VALUES (1003, 21, 32);
INSERT INTO deposit VALUES (1004, 22, 31);

INSERT INTO orders VALUES (118283716, 'Bon-bones', 101, 1004, 304);
INSERT INTO orders VALUES (212321653, 'Banana', 102, 1001, 303);
INSERT INTO orders VALUES (322717277, 'Snicker', 103, 1002, 304);
INSERT INTO orders VALUES (412891892, 'T-short', 104, 1001, 303);
INSERT INTO orders VALUES (512761772, 'Jeans', 105, 1003, 303);



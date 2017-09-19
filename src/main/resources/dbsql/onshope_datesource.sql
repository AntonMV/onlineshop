
--
-- Data for table `roles`
--
LOCK TABLES `roles` WRITE;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
UNLOCK TABLES;

--
-- Data for table `user`
--
LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'Anton','ant@bk.ru','1111','2017-09-19 06:39:24',1);
INSERT INTO `user` VALUES (2,'Dmitriy','dim@bk.ru','2222','2017-09-15 06:39:24',1);
INSERT INTO `user` VALUES (3,'Alex','al@bk.ru','3333','2017-09-17 06:39:24',1);
INSERT INTO `user` VALUES (4,'Igor','ig@bk.ru','4444','2017-09-16 06:39:24',1);
INSERT INTO `user` VALUES (5,'Sergey','ser@bk.ru','5555','2017-09-13 06:39:24',1);
UNLOCK TABLES;
--
-- Data for table `user_roles`
--
LOCK TABLES `user_roles` WRITE;
INSERT INTO `user_roles` VALUES (1,1),(1,2),(2,2),(3,2),(4,2),(5,2);
UNLOCK TABLES;

--
-- Data for table `orrder`
--
LOCK TABLES `orrder` WRITE;
INSERT INTO `orrder` VALUES (1,1,2,1,'2017-09-08 07:38:57'),(2,1,1,1,'2017-09-08 07:39:20');
UNLOCK TABLES;

--
-- Data for table `product`
--
LOCK TABLES `product` WRITE;
INSERT INTO `product` VALUES (1,'Asus','noutbook',6,1000,'EMS'),(2,'Dell','netbook',4,400,'CDEK');
UNLOCK TABLES;
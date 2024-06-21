-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 152.42.248.95    Database: foodapp
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `posts_ibfk_1` (`user_id`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (12,10,'THE BEST BAGGED STREET FOOD','If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.If you’re ever in Vietnam and looking for an incredibly cheap snack, Bánh Tráng Trộn is the Vietnamese Rice Paper Salad that packs a punch and has unbeatable textures.','2024-05-15 14:12:09'),(13,10,'Bún Bò Huế Recipe – Spicy Beef & Pork Noodle Soup','Bún bò Huế is a hidden Vietnamese gem that has yet to “make it” in mainstream American cuisine. It’s a rich and spicy soup with deep layers of flavor. This Central Vietnamese soup is paired with tender slices of beef and pork, then topped with lots of fresh herbs.\n\nI consulted my favorite Vietnamese cook–Mom–on how to make bún bò Huế. And to find out subleties that make BBH authentic. I promise you’ll love this version!','2024-05-15 14:13:55'),(14,10,'BUN RIEU CUA (VIETNAMESE CRAB NOODLE SOUP)','Bun Rieu Cua is a comforting bowl of Vietnamese noodle soup with mouth-watering crab and shrimp meatballs in a light pork and tomato-based broth. It\'s served with rice vermicelli and topped with a variety of healthy greens and herbs. \n\n','2024-05-15 14:15:18'),(15,10,'fadf','ad','2024-05-21 15:21:43'),(61,10,'bhz','hshs','2024-05-21 18:25:44'),(62,10,'nsnsnnsnznznNNNNNnnnsnsnnzjznznznznznznznznznzn,n,jjzn,n,nnnzn,n,nzn,n,n,nnN!n![n!nn+*+*+*','hshsjzjzjjzz+jjjjj+jzxufufigigigigogigohohogigigigigigigigihigigiggigigigigigig yigigifigigigigvkgkvkgkvkvkvjvjvjcjcjvjvjcjvigigigic\n\n\n\n\n\n\n\n','2024-05-21 18:29:21'),(63,10,'nsnsnnsnznznNNNNNnnnsnsnnzjznznznznznznznznznzn,n,jjzn,n,nnnzn,n,nzn,n,n,nnN!n![n!nn+*+*+*','hshsjzjzjjzz+jjjjj+jzxufufigigigigogigohohogigigigigigigigihigigiggigigigigigig yigigifigigigigvkgkvkgkvkvkvjvjvjcjcjvjvjcjvigigigic\n\n\n\n\n\n\n\n','2024-05-21 18:29:31'),(64,10,'hhs','jjsj','2024-05-21 18:40:29'),(65,11,'123','123123','2024-05-22 17:52:15'),(66,11,'hi','hi','2024-05-22 18:07:55'),(67,24,'bún đỏ tây nguyên','tuy chưa ăn bh , nhưng nghe nói ngta khen rất nhiêud \" nghe nói \"','2024-05-22 18:25:14'),(68,19,'ngu ch may anh','helooooo','2024-05-22 18:36:33'),(69,19,'ua ','nani kincha na','2024-05-22 18:37:52'),(70,19,'abcd','kh phai a bê cê đê','2024-05-22 18:41:06'),(89,12,'hello anh híu','hihihi','2024-05-28 08:54:32'),(90,12,'hi a híu kon','anh còn ở đó ko ta','2024-05-28 09:01:04'),(91,19,'có ch anh','lô','2024-05-28 09:04:40'),(92,12,'hi','','2024-05-28 09:09:26'),(93,10,'looo','fc g. hv','2024-05-29 10:58:44'),(94,10,'bbs','bzbz','2024-05-29 11:29:35');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-30 17:56:13

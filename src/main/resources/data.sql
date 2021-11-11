CREATE DATABASE  IF NOT EXISTS `easter_egg` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `easter_egg`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: easter_egg
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `contacto`
--

DROP TABLE IF EXISTS `contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacto` (
  `id_contacto` int NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `mensaje` varchar(255) NOT NULL,
  PRIMARY KEY (`id_contacto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacto`
--

LOCK TABLES `contacto` WRITE;
/*!40000 ALTER TABLE `contacto` DISABLE KEYS */;
/*!40000 ALTER TABLE `contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_publicaciones`
--

DROP TABLE IF EXISTS `usuario_publicaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_publicaciones` (
  `id_publicaciones` int NOT NULL AUTO_INCREMENT,
  `id_usuarios` int NOT NULL,
  `imagen` varchar(255) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_publicaciones`),
  KEY `fk_id_usuarios_idx` (`id_usuarios`),
  KEY `fk_id_usuarios_datos_idx` (`id_usuarios`),
  CONSTRAINT `fk_id_usuarios_datos` FOREIGN KEY (`id_usuarios`) REFERENCES `usuarios` (`id_usuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_publicaciones`
--

LOCK TABLES `usuario_publicaciones` WRITE;
/*!40000 ALTER TABLE `usuario_publicaciones` DISABLE KEYS */;
INSERT INTO `usuario_publicaciones` VALUES (8,13,'https://res.cloudinary.com/dfk9ayr1h/image/upload/v1636620306/Prey_23_10_2021_11_13_46_p._m._c5bwnj.png','Ya me dio miedo','Prey lo acabo de iniciar y ya me esta asustando xD'),(9,17,'https://res.cloudinary.com/dfk9ayr1h/image/upload/v1636607892/pexels-photo-7360387_liquss.jpg','Aqui jugando desde mi sofa','Les dejo este codigo para que me agregen a Steam 1237461234123');
/*!40000 ALTER TABLE `usuario_publicaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuarios` int NOT NULL AUTO_INCREMENT,
  `correo` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `id_usuario_datos` int DEFAULT NULL,
  PRIMARY KEY (`id_usuarios`),
  UNIQUE KEY `id_usuarios_UNIQUE` (`id_usuarios`),
  UNIQUE KEY `correo_UNIQUE` (`correo`),
  KEY `f_usuario_usuarioDatos` (`id_usuario_datos`),
  CONSTRAINT `f_usuario_usuarioDatos` FOREIGN KEY (`id_usuario_datos`) REFERENCES `usuarios_datos` (`id_usuarios_datos`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (13,'asdasd@gmail.com','$2a$10$d7sYutxpMK5h8vP6bHIpGuxFMvc4rM7W9ejXs3vrMikAEeFSZywjq',8),(14,'asdsadsad@gmail.com','$2a$10$E5ikkdJx1thGeOFd1LRY1up0czRuK8oVeQzobi5KgIGDiGgyg8vZG',9),(15,'asdsad@gmail.com','$2a$10$xkKcHTf/0fzyIUqXX5y85ez/xAwBP8Rz2NrTvJmgje8Cpz5nRH/jy',10),(16,'1234111214@gmail.com','$2a$10$AK6CdBn61xdxcJgsrrA1wehiZSceK2wNA7/fZd5iAjeqPnEld879e',11),(17,'1@gmail.com','$2a$10$Bi3CPcj7c9GKoCpSTwiL/u6sCtgmlGW2rzfYipHgc01gtkWCq2ivq',12),(18,'234@gmail.com','$2a$10$pLuwpgMspJSh.25yHImh5OcXo78vcGkTHciv4r8XdcU899F1WRTOm',13),(19,'3@gmail.com','$2a$10$PeBofOOiS2VtFucAXCupmOz8PGtJwyLXf5lg.WX9mu8cbZvUiP8JC',14);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_datos`
--

DROP TABLE IF EXISTS `usuarios_datos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_datos` (
  `id_usuarios_datos` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `sexo` varchar(50) NOT NULL,
  `f_nacimiento` date NOT NULL,
  `gamer_tagg` varchar(255) NOT NULL,
  `miembro_desde` date DEFAULT NULL,
  `img_perfil` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuarios_datos`),
  UNIQUE KEY `id_usuarios_datos_UNIQUE` (`id_usuarios_datos`),
  KEY `fk_id_usuarios_idx` (`id_usuarios_datos`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_datos`
--

LOCK TABLES `usuarios_datos` WRITE;
/*!40000 ALTER TABLE `usuarios_datos` DISABLE KEYS */;
INSERT INTO `usuarios_datos` VALUES (8,'Javier','Serrano','Masculino','2003-12-16','Cookie','2021-11-10','http://res.cloudinary.com/dfk9ayr1h/image/upload/v1636603773/img_perfil/wmsnzrqkj7xhvoq8udik.jpg'),(9,'Javier','Serrano','Masculino','2003-12-16','Kari',NULL,'http://res.cloudinary.com/dfk9ayr1h/image/upload/v1636611496/img_perfil/vngy6mytirdlimuumand.jpg'),(10,'Javier','Serrano','Masculino','2003-12-10','Juan2005',NULL,NULL),(11,'Javier','Eduardo','Masculino','2021-05-01','Impala24',NULL,NULL),(12,'Javier','Eduardo','Masculino','2021-05-01','Sacrogrito',NULL,'http://res.cloudinary.com/dfk9ayr1h/image/upload/v1636607542/img_perfil/uagn5po1iejymshsnnpi.jpg'),(13,'Javier','Eduardo','Masculino','2021-05-01','Ragnarok','2001-05-01',''),(14,'Javier','Serrano','Femenino','2003-12-15','Medan','2021-11-10','www.firieri.com');
/*!40000 ALTER TABLE `usuarios_datos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-11 11:02:16

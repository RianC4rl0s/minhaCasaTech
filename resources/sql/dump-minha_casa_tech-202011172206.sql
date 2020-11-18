-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: minha_casa_tech
-- ------------------------------------------------------
-- Server version	5.5.5-10.5.4-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `caixa`
--

DROP TABLE IF EXISTS `caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caixa` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `valor` double NOT NULL DEFAULT 2000,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caixa`
--

LOCK TABLES `caixa` WRITE;
/*!40000 ALTER TABLE `caixa` DISABLE KEYS */;
INSERT INTO `caixa` VALUES (1,24394);
/*!40000 ALTER TABLE `caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cpf` varchar(18) NOT NULL,
  `id_pessoa` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_fk` (`id_pessoa`),
  CONSTRAINT `cliente_fk` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'09876543210',3);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_transacao` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `compra_fk` (`id_transacao`),
  CONSTRAINT `compra_fk` FOREIGN KEY (`id_transacao`) REFERENCES `transacao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipamento`
--

DROP TABLE IF EXISTS `equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `peso` double NOT NULL,
  `preco` double NOT NULL,
  `quantidade` int(11) NOT NULL,
  `numero_de_serie` varchar(100) NOT NULL,
  `id_local` bigint(20) unsigned NOT NULL,
  `id_responsavel` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `equipamento_fk` (`id_local`),
  KEY `equipamento_fk_1` (`id_responsavel`),
  CONSTRAINT `equipamento_fk` FOREIGN KEY (`id_local`) REFERENCES `local` (`id`),
  CONSTRAINT `equipamento_fk_1` FOREIGN KEY (`id_responsavel`) REFERENCES `responsavel` (`id`),
  CONSTRAINT `CONSTRAINT_1` CHECK (`preco` >= 0)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipamento`
--

LOCK TABLES `equipamento` WRITE;
/*!40000 ALTER TABLE `equipamento` DISABLE KEYS */;
INSERT INTO `equipamento` VALUES (1,'Mouse',0.2,200,8,'0',1,1),(2,'Impressora',1,1000,10,'10',1,2),(4,'Computado Gamer',10,4000,10,'5673',1,2),(5,'Xiaomi miBand 4',0.5,150,200,'4545324',1,1),(6,'Samsung Expert x51',1.9,3300.99,10,'56735435',2,1),(7,'Lenovo ideapad 320',2.3,2600,4,'34546357',1,2);
/*!40000 ALTER TABLE `equipamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`poo_20203`@`localhost`*/ /*!50003 TRIGGER insert_log
AFTER INSERT
ON equipamento FOR EACH ROW CALL log_insert() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`poo_20203`@`localhost`*/ /*!50003 TRIGGER update_log
AFTER UPDATE 
ON equipamento FOR EACH ROW CALL log_update() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`poo_20203`@`localhost`*/ /*!50003 TRIGGER delete_log
AFTER DELETE 
ON equipamento FOR EACH ROW CALL log_delete() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary table structure for view `equipamentoselocais`
--

DROP TABLE IF EXISTS `equipamentoselocais`;
/*!50001 DROP VIEW IF EXISTS `equipamentoselocais`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `equipamentoselocais` (
  `nome` tinyint NOT NULL,
  `casa` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_responsavel` bigint(20) unsigned NOT NULL,
  `id_pessoa` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `funcionario_fk` (`id_responsavel`),
  KEY `funcionario_fk_1` (`id_pessoa`),
  CONSTRAINT `funcionario_fk` FOREIGN KEY (`id_responsavel`) REFERENCES `responsavel` (`id`),
  CONSTRAINT `funcionario_fk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,2,2),(3,4,5);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `local` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `casa` varchar(100) NOT NULL DEFAULT 'Casa Principal',
  `compartimento` varchar(100) NOT NULL DEFAULT 'Não Identificado',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'Loja Principal Rua 2','Prateleira 2 setor A'),(2,'Casa Fortal','Prateleira');
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `localview`
--

DROP TABLE IF EXISTS `localview`;
/*!50001 DROP VIEW IF EXISTS `localview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `localview` (
  `casa` tinyint NOT NULL,
  `compartimento` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `log_table`
--

DROP TABLE IF EXISTS `log_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_table` (
  `data` datetime DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `modificacao` varchar(20) DEFAULT 'update'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_table`
--

LOCK TABLES `log_table` WRITE;
/*!40000 ALTER TABLE `log_table` DISABLE KEYS */;
INSERT INTO `log_table` VALUES ('2020-11-12 15:32:57','poo_20203@localhost','insert'),('2020-11-12 15:33:24','poo_20203@localhost','update'),('2020-11-12 15:35:02','poo_20203@localhost','insert'),('2020-11-12 15:35:23','poo_20203@localhost','update'),('2020-11-12 15:35:34','poo_20203@localhost','update'),('2020-11-12 15:35:40','poo_20203@localhost','update'),('2020-11-12 15:35:52','poo_20203@localhost','update'),('2020-11-16 16:13:38','poo_20203@localhost','insert'),('2020-11-16 16:15:30','poo_20203@localhost','delete'),('2020-11-16 16:16:08','poo_20203@localhost','update'),('2020-11-16 20:26:44','poo_20203@localhost','insert'),('2020-11-16 20:27:31','poo_20203@localhost','insert'),('2020-11-17 14:19:57','poo_20203@localhost','update'),('2020-11-17 16:01:08','poo_20203@localhost','insert'),('2020-11-17 16:03:31','poo_20203@localhost','insert'),('2020-11-17 16:22:55','poo_20203@localhost','update');
/*!40000 ALTER TABLE `log_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'Rian Carlos Silva','Rua Dr Joao'),(2,'M. Ricardo','Av. Duarte'),(3,'Maria Luz','Rua candido 1532'),(5,'Joao Moscoso','Rua Rua');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `preco_produto`
--

DROP TABLE IF EXISTS `preco_produto`;
/*!50001 DROP VIEW IF EXISTS `preco_produto`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `preco_produto` (
  `nome` tinyint NOT NULL,
  `preco` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `proprietario`
--

DROP TABLE IF EXISTS `proprietario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proprietario` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_responsavel` bigint(20) unsigned NOT NULL,
  `id_pessoa` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `proprietario_fk` (`id_responsavel`),
  KEY `proprietario_fk_1` (`id_pessoa`),
  CONSTRAINT `proprietario_fk` FOREIGN KEY (`id_responsavel`) REFERENCES `responsavel` (`id`),
  CONSTRAINT `proprietario_fk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proprietario`
--

LOCK TABLES `proprietario` WRITE;
/*!40000 ALTER TABLE `proprietario` DISABLE KEYS */;
INSERT INTO `proprietario` VALUES (1,1,1);
/*!40000 ALTER TABLE `proprietario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsavel`
--

DROP TABLE IF EXISTS `responsavel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsavel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `id_pessoa` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `responsavel_fk` (`id_pessoa`),
  CONSTRAINT `responsavel_fk` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsavel`
--

LOCK TABLES `responsavel` WRITE;
/*!40000 ALTER TABLE `responsavel` DISABLE KEYS */;
INSERT INTO `responsavel` VALUES (1,'loginRIAN','loginRIAN123','88999999998',1),(2,'loginManoel','loginMANOEL321','84888888888',2),(4,'JAOmosc','JAOmosc3434','77999999999',5);
/*!40000 ALTER TABLE `responsavel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transacao`
--

DROP TABLE IF EXISTS `transacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transacao` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `valor_total` double NOT NULL,
  `peso_total` double NOT NULL,
  `total_equip` int(11) NOT NULL,
  `data` date NOT NULL,
  `tipo` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacao`
--

LOCK TABLES `transacao` WRITE;
/*!40000 ALTER TABLE `transacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `transacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transacao_equipamentos`
--

DROP TABLE IF EXISTS `transacao_equipamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transacao_equipamentos` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_transacao` bigint(20) unsigned NOT NULL,
  `id_equipamento` bigint(20) unsigned NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `transacao_equipamentos_fk` (`id_transacao`),
  KEY `transacao_equipamentos_fk_1` (`id_equipamento`),
  CONSTRAINT `transacao_equipamentos_fk` FOREIGN KEY (`id_transacao`) REFERENCES `transacao` (`id`),
  CONSTRAINT `transacao_equipamentos_fk_1` FOREIGN KEY (`id_equipamento`) REFERENCES `equipamento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacao_equipamentos`
--

LOCK TABLES `transacao_equipamentos` WRITE;
/*!40000 ALTER TABLE `transacao_equipamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `transacao_equipamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_cliente` bigint(20) unsigned NOT NULL,
  `id_transacao` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `venda_fk` (`id_cliente`),
  KEY `venda_fk_1` (`id_transacao`),
  CONSTRAINT `venda_fk` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `venda_fk_1` FOREIGN KEY (`id_transacao`) REFERENCES `transacao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'minha_casa_tech'
--
/*!50003 DROP PROCEDURE IF EXISTS `log_delete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`poo_20203`@`localhost` PROCEDURE `log_delete`()
BEGIN
	INSERT INTO log_table (data, usuario, modificacao)           
                        VALUES (NOW(), CURRENT_USER(), "delete");
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `log_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`poo_20203`@`localhost` PROCEDURE `log_insert`()
BEGIN
	INSERT INTO log_table (data, usuario, modificacao)           
                        VALUES (NOW(), CURRENT_USER(), "insert");
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `log_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`poo_20203`@`localhost` PROCEDURE `log_update`()
BEGIN
	INSERT INTO log_table (data, usuario, modificacao)           
                        VALUES (NOW(), CURRENT_USER(), "update");
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `equipamentoselocais`
--

/*!50001 DROP TABLE IF EXISTS `equipamentoselocais`*/;
/*!50001 DROP VIEW IF EXISTS `equipamentoselocais`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`poo_20203`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `equipamentoselocais` AS select `e`.`nome` AS `nome`,`l`.`casa` AS `casa` from (`equipamento` `e` join `local` `l`) where `e`.`id_local` = `l`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `localview`
--

/*!50001 DROP TABLE IF EXISTS `localview`*/;
/*!50001 DROP VIEW IF EXISTS `localview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`poo_20203`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `localview` AS select `l`.`casa` AS `casa`,`l`.`compartimento` AS `compartimento` from `local` `l` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `preco_produto`
--

/*!50001 DROP TABLE IF EXISTS `preco_produto`*/;
/*!50001 DROP VIEW IF EXISTS `preco_produto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`poo_20203`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `preco_produto` AS select `e`.`nome` AS `nome`,`e`.`preco` AS `preco` from `equipamento` `e` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-17 22:06:52

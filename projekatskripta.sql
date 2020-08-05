CREATE DATABASE  IF NOT EXISTS `projekat` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `projekat`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: projekat
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `anagrami`
--

DROP TABLE IF EXISTS `anagrami`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anagrami` (
  `idanagrami` int(11) NOT NULL AUTO_INCREMENT,
  `tekst` varchar(100) DEFAULT NULL,
  `resenje` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idanagrami`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anagrami`
--

LOCK TABLES `anagrami` WRITE;
/*!40000 ALTER TABLE `anagrami` DISABLE KEYS */;
INSERT INTO `anagrami` VALUES (1,'KRASAN JE ODMOR','jadransko more'),(2,'DABOME LUDAK','komad budale'),(3,'JURCA NAG','crna guja'),(4,'PAZI, ON LOKAO!','zlo i naopako'),(5,'PLATI I ZAMAK','kapitalizam'),(6,'BRAVO LUKA!','vokabular'),(7,'UM PIPA ZLO','populizam'),(8,'NI JA JALOV','novajlija'),(11,'PADAÅ  U NAROD','prodana duÅ¡a');
/*!40000 ALTER TABLE `anagrami` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bazaigradana`
--

DROP TABLE IF EXISTS `bazaigradana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bazaigradana` (
  `idbazaigradana` int(11) NOT NULL AUTO_INCREMENT,
  `datum` varchar(45) DEFAULT NULL,
  `idigre` int(11) DEFAULT NULL,
  `tipigre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idbazaigradana`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bazaigradana`
--

LOCK TABLES `bazaigradana` WRITE;
/*!40000 ALTER TABLE `bazaigradana` DISABLE KEYS */;
INSERT INTO `bazaigradana` VALUES (14,'2019-08-21',2,'pehar'),(19,'2019-08-22',2,'pehar'),(22,'2019-08-27',6,'anagram'),(23,'2019-09-02',1,'anagram');
/*!40000 ALTER TABLE `bazaigradana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bazapartija`
--

DROP TABLE IF EXISTS `bazapartija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bazapartija` (
  `idbazapartija` int(11) NOT NULL AUTO_INCREMENT,
  `username1` varchar(45) DEFAULT NULL,
  `username2` varchar(45) DEFAULT NULL,
  `brpoena1` int(11) DEFAULT NULL,
  `brpoena2` int(11) DEFAULT NULL,
  `rezultat` varchar(45) DEFAULT NULL,
  `datum` date DEFAULT NULL,
  PRIMARY KEY (`idbazapartija`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bazapartija`
--

LOCK TABLES `bazapartija` WRITE;
/*!40000 ALTER TABLE `bazapartija` DISABLE KEYS */;
INSERT INTO `bazapartija` VALUES (80,'stefan','djole',63,51,'pobedio plavi','2019-08-20'),(81,'stefan','djole',63,51,'pobedio plavi','2019-08-20'),(82,'stefan','djole',55,64,'pobedio crveni','2019-08-21'),(83,'stefan','andora',49,27,'pobedio plavi','2019-08-21'),(84,'andora','stefan',62,46,'pobedio plavi','2019-08-22'),(85,'stefan','andora',56,33,'pobedio plavi','2019-08-23'),(86,'stefan','andora',25,46,'pobedio crveni','2019-08-23'),(87,'stefan','andora',51,55,'pobedio crveni','2019-08-26');
/*!40000 ALTER TABLE `bazapartija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bazapitanja`
--

DROP TABLE IF EXISTS `bazapitanja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bazapitanja` (
  `idbazapitanja` int(11) NOT NULL AUTO_INCREMENT,
  `pitanjeprvo9` varchar(145) DEFAULT NULL,
  `odgovorprvi9` varchar(145) DEFAULT NULL,
  `pitanjeprvo8` varchar(145) DEFAULT NULL,
  `odgovorprvi8` varchar(145) DEFAULT NULL,
  `pitanjeprvo7` varchar(145) DEFAULT NULL,
  `odgovorprvi7` varchar(145) DEFAULT NULL,
  `pitanjeprvo6` varchar(145) DEFAULT NULL,
  `odgovorprvi6` varchar(145) DEFAULT NULL,
  `pitanjeprvo5` varchar(145) DEFAULT NULL,
  `odgovorprvi5` varchar(145) DEFAULT NULL,
  `pitanjeprvo4` varchar(145) DEFAULT NULL,
  `odgovorprvi4` varchar(145) DEFAULT NULL,
  `pitanjeprvo3` varchar(145) DEFAULT NULL,
  `odgovorprvi3` varchar(145) DEFAULT NULL,
  `pitanjedrugo3` varchar(145) DEFAULT NULL,
  `odgovordrugi3` varchar(145) DEFAULT NULL,
  `pitanjedrugo4` varchar(145) DEFAULT NULL,
  `odgovordrugi4` varchar(145) DEFAULT NULL,
  `pitanjedrugo5` varchar(145) DEFAULT NULL,
  `odgovordrugi5` varchar(145) DEFAULT NULL,
  `pitanjedrugo6` varchar(145) DEFAULT NULL,
  `odgovordrugi6` varchar(145) DEFAULT NULL,
  `pitanjedrugo7` varchar(145) DEFAULT NULL,
  `odgovordrugi7` varchar(145) DEFAULT NULL,
  `pitanjedrugo8` varchar(145) DEFAULT NULL,
  `odgovordrugi8` varchar(145) DEFAULT NULL,
  `pitanjedrugo9` varchar(145) DEFAULT NULL,
  `odgovordrugi9` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`idbazapitanja`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bazapitanja`
--

LOCK TABLES `bazapitanja` WRITE;
/*!40000 ALTER TABLE `bazapitanja` DISABLE KEYS */;
INSERT INTO `bazapitanja` VALUES (1,'Drustveno uredjenje?','komunizam','IgraÄ u koÅ¡arci?','koÅ¡arkaÅ¡','Jedan sport?','rukomet','Mesto pripreme hleba?','pekara','Ime muziÄara BregoviÄ‡a?','goran','Ruski automobil?','lada','Blato (drugaÄije)?','kal','NeÅ¾eljena smetnja koja se preklapa sa korisnim signalom?','Å¡um','Svedok na venÄanju?','kuma','Onaj koji kupuje?','kupac','Planina u Srbiji (CvijiÄ‡ev vrh)?','rudnik','Deo kompjutera?','monitor','ÄŒlan vlade?','ministar','Jedno prevozno sredstvo?','automobil'),(2,'Zemlja JuÅ¾ne Amerike?','argentina','Grad u Vojvodini?','subotica','Glavni grad Srbije?','beograd','Glavni grad Rusije?','moskva','Onaj koji leÄi rane?','vidar','Brza riba iz porodice skuÅ¡a?','tuna','Roman Mome Kapora?','una','PriÄa iz narodnog predanja koja govori o natprirodnim biÄ‡ima, precima ili junacima?','mit','Grupa slonova?','krdo','Francuski filozof, romansijer i esejista (biÄ‡e i niÅ¡tavilo)?','sartr','Likovni umetnik?','slikar','Kanap (drugaÄije)?','konopac','Kraljica sportova?','atletika','Vrsta psa?','jazaviÄar');
/*!40000 ALTER TABLE `bazapitanja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bazareci`
--

DROP TABLE IF EXISTS `bazareci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bazareci` (
  `idrec` int(11) NOT NULL AUTO_INCREMENT,
  `pocetnoslovo` char(1) DEFAULT NULL,
  `rec` varchar(45) DEFAULT NULL,
  `tip` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrec`)
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bazareci`
--

LOCK TABLES `bazareci` WRITE;
/*!40000 ALTER TABLE `bazareci` DISABLE KEYS */;
INSERT INTO `bazareci` VALUES (1,'a','australija','drzava'),(2,'a','avganistan','drzava'),(3,'a','albanija','drzava'),(4,'a','andora','drzava'),(5,'a','alÅ¾ir','drzava'),(6,'a','azerbejdÅ¾an','drzava'),(7,'a','atina','grad'),(8,'a','amsterdam','grad'),(9,'a','aleksinac','grad'),(10,'a','astana','grad'),(11,'a','aralsko','jezero'),(12,'a','albano','jezero'),(13,'a','avala','planina'),(14,'a','atos','planina'),(15,'a','amazon','reka'),(16,'a','avon','reka'),(17,'a','araks','reka'),(18,'a','anakonda','zivotinja'),(19,'a','ajkula','zivotinja'),(20,'a','albatros','zivotinja'),(21,'a','antilopa','zivotinja'),(22,'a','ambrozija','biljka'),(23,'a','aloja','biljka'),(24,'a','ananas','biljka'),(25,'a','artiÄoka','biljka'),(26,'a','aerosmit','grupa'),(27,'b','barbados','drzava'),(28,'b','belorusija','drzava'),(29,'b','bolivija','drzava'),(30,'b','bugarska','drzava'),(31,'b','bar','grad'),(32,'b','beograd','grad'),(33,'b','baku','grad'),(34,'b','bejrut','grad'),(35,'b','bor','grad'),(36,'b','bajkalsko','jezero'),(37,'b','balaton','jezero'),(38,'b','bodensko','jezero'),(39,'b','bjelasica','planina'),(40,'b','bukovik','planina'),(41,'b','bukulja','planina'),(42,'b','bosna','reka'),(43,'b','begej','reka'),(44,'b','bosut','reka'),(45,'b','brzava','reka'),(46,'b','babun','zivotinja'),(47,'b','bakalar','zivotinja'),(48,'b','bivo','zivotinja'),(49,'b','bizon','zivotinja'),(50,'b','breskva','biljka'),(51,'b','biber','biljka'),(52,'b','bamija','biljka'),(53,'b','bokvica','biljka'),(54,'b','bajaga i instruktori','grupa'),(55,'Ä','Äad','drzava'),(56,'Ä','ÄeÅ¡ka','drzava'),(57,'Ä','Äile','drzava'),(58,'Ä','ÄaÄak','grad'),(59,'Ä','Äikago','grad'),(60,'Ä','Äernobilj','grad'),(61,'Ä','Äad','jezero'),(62,'Ä','Äemernica','planina'),(63,'Ä','ÄiÄavica','planina'),(64,'Ä','Äemernica','reka'),(65,'Ä','ÄinÄila','zivotinja'),(66,'Ä','Äavka','zivotinja'),(67,'Ä','ÄiÄak','billjka'),(68,'Ä‡','Äuprija','grad'),(69,'Ä‡','Ä‡elije','jezero'),(70,'Ä‡','Ä‡iÄ‡arija','planina'),(71,'Ä‡','Ä‡ehotina','reka'),(72,'Ä‡','Ä‡uk','zivotinja'),(73,'Ä‡','Ä‡urka','zivotinja'),(74,'g','gana','drzava'),(75,'g','gruzija','drzava'),(76,'g','gvineja','drzava'),(77,'g','gambija','drzava'),(78,'g','gvineja','drzava'),(79,'g','grozni','grad'),(80,'g','golubac','grad'),(81,'g','gruÅ¾ansko','jezero'),(82,'g','goÄ','planina'),(83,'g','grmeÄ','planina'),(84,'g','gang','reka'),(85,'g','gavran','zivotinja'),(86,'g','galeb','zivotinja'),(87,'g','glog','biljka'),(88,'g','guns and roses','grupa'),(89,'o','oman','drzava'),(90,'o','obala slonovaÄe','drzava'),(91,'o','otava','grad'),(92,'o','oslo','grad'),(93,'o','obrenovac','grad'),(94,'o','ontario','jezero'),(95,'o','ohridsko','jezero'),(96,'o','olimp','planina'),(97,'o','orinoko','reka'),(98,'o','odra','reka'),(99,'o','orao','zivotinja'),(100,'o','orah','biljka'),(101,'p','panama','drzava'),(102,'p','pakistan','drzava'),(103,'p','paragvaj','drzava'),(104,'p','poljska','drzava'),(105,'p','peru','portugal'),(106,'p','panÄevo','grad'),(107,'p','prokuplje','grad'),(108,'p','paraÄ‡in','grad'),(109,'p','peruÄ‡ac','jezero'),(110,'p','paliÄ‡ko','jezero'),(111,'p','povlen','planina'),(112,'p','plitvica','reka'),(113,'p','pek','reka'),(114,'p','pÄinja','reka'),(115,'p','pauk','zivotinja'),(116,'p','puma','zivotinja'),(117,'p','paprika','biljka'),(118,'p','paradajz','biljka'),(119,'p','papaja','biljka'),(120,'p','partibrejkers','grupa'),(121,'a','argentina','drzava'),(122,'a','alpi','planina'),(123,'a','ara','zivotinja'),(124,'a','arandjelovac','grad'),(125,'a','aljaska','drzava'),(126,'a','austrija','drzava'),(127,'a','amerika','drzava'),(128,'b','bukureÅ¡t','grad'),(129,'Å¾','Å¾aba','zivotinja'),(130,'Å¾','Å¾eneva','grad'),(131,'u','uvac','reka'),(132,'u','ukrajina','drzava'),(133,'d','danska','drzava'),(135,'d','drina','reka'),(136,'b','brisel','grad'),(137,'n','nigerija','drzava'),(138,'n','niÅ¡','grad'),(139,'n','niÅ¡ava','reka'),(140,'r','rumunija','drzava'),(141,'r','ruma','grad'),(142,'r','rajna','reka'),(143,'r','rudnik','planina'),(144,'d','dablin','grad'),(145,'s','srbija','drzava'),(146,'s','sremska mitrovica','grad'),(147,'v','velika britanija','drzava'),(148,'v','varÅ¡ava','grad'),(149,'v','vltava','reka'),(150,'i','irska','drzava'),(151,'i','indjija','grad'),(152,'r','rusija','drzava'),(153,'k','kirgistan','drzava'),(154,'k','kruÅ¡evac','grad'),(155,'k','kopaonik','planina'),(156,'d','dnjepar','reka'),(157,'i','ivanjica','grad'),(158,'i','ibar','reka'),(159,'k','kambodÅ¾a','drzava'),(160,'k','kit','zivotinja'),(161,'p','prag','grad'),(162,'i','indija','drzava'),(163,'i','irvas','zivotinja'),(164,'i','indika','biljka'),(165,'o','orangutan','zivotinja'),(166,'o','oni','grupa'),(167,'m','madjarska','drzava'),(168,'m','madrid','grad'),(169,'m','morava','reka'),(170,'m','mrav','zivotinja'),(171,'m','mangolija','biljka'),(172,'m','miÄigen','jezero'),(173,'h','hrvatska','drzava'),(174,'h','hrast','biljka'),(175,'v','van gog','grupa'),(176,'v','vepar','zivotinja'),(177,'v','visibaba','biljka'),(178,'v','vlasinsko','jezero'),(179,'v','veverica','zivotinja'),(180,'s','srebrno','jezero'),(181,'s','stara planina','planina'),(182,'s','slon','zivotinja'),(183,'f','finska','drzava'),(184,'j','jordan','drzava'),(185,'j','jagodina','grad'),(186,'j','jordan','reka'),(187,'j','jazavac','zivotinja'),(188,'f','francuska','drzava'),(189,'f','frankfurt','grad'),(190,'f','faun','zivotinja'),(191,'Å¾','Å¾irafa','zivotinja'),(192,'Å¾','Å¾alfija','biljka'),(193,'l','luksemburg','grad');
/*!40000 ALTER TABLE `bazareci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `igraanagrami`
--

DROP TABLE IF EXISTS `igraanagrami`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `igraanagrami` (
  `idigraanagrami` int(11) NOT NULL AUTO_INCREMENT,
  `idigranapartija` int(11) DEFAULT NULL,
  `odgovorusername1` varchar(100) DEFAULT NULL,
  `odgovorusername2` varchar(100) DEFAULT NULL,
  `igrase` int(11) DEFAULT '0',
  `tekst` varchar(100) DEFAULT NULL,
  `resenje` varchar(100) DEFAULT NULL,
  `username1` varchar(45) DEFAULT NULL,
  `username2` varchar(45) DEFAULT NULL,
  `zakljucan1` tinyint(4) DEFAULT '0',
  `zakljucan2` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`idigraanagrami`)
) ENGINE=InnoDB AUTO_INCREMENT=503 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `igraanagrami`
--

LOCK TABLES `igraanagrami` WRITE;
/*!40000 ALTER TABLE `igraanagrami` DISABLE KEYS */;
/*!40000 ALTER TABLE `igraanagrami` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `igradanapartija`
--

DROP TABLE IF EXISTS `igradanapartija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `igradanapartija` (
  `idigradanapartija` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `datum` varchar(45) DEFAULT NULL,
  `brpoena` int(11) DEFAULT '0',
  PRIMARY KEY (`idigradanapartija`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `igradanapartija`
--

LOCK TABLES `igradanapartija` WRITE;
/*!40000 ALTER TABLE `igradanapartija` DISABLE KEYS */;
INSERT INTO `igradanapartija` VALUES (37,'stefan','2019-08-21',28),(38,'andora','2019-08-21',20),(63,'andora','2019-08-22',18),(64,'stefan','2019-08-22',8),(65,'stefan','2019-08-27',10),(66,'andora','2019-08-27',0);
/*!40000 ALTER TABLE `igradanapartija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `igramojbroj`
--

DROP TABLE IF EXISTS `igramojbroj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `igramojbroj` (
  `idigramojbroj` int(11) NOT NULL AUTO_INCREMENT,
  `idigranapartija` int(11) DEFAULT NULL,
  `glavnibr` int(11) DEFAULT NULL,
  `jednocifr1` int(11) DEFAULT NULL,
  `jednocifr2` int(11) DEFAULT NULL,
  `jednocifr3` int(11) DEFAULT NULL,
  `jednocifr4` int(11) DEFAULT NULL,
  `dvocifrenimali` int(11) DEFAULT NULL,
  `dvocifreniveliki` int(11) DEFAULT NULL,
  `odgovorusername1` int(11) DEFAULT '0',
  `odgovorusername2` int(11) DEFAULT '0',
  `igrase` int(11) DEFAULT '0',
  `zakljucan1` tinyint(4) DEFAULT '0',
  `zakljucan2` tinyint(4) DEFAULT '0',
  `username1` varchar(45) DEFAULT NULL,
  `username2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idigramojbroj`)
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `igramojbroj`
--

LOCK TABLES `igramojbroj` WRITE;
/*!40000 ALTER TABLE `igramojbroj` DISABLE KEYS */;
/*!40000 ALTER TABLE `igramojbroj` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `igranapartija`
--

DROP TABLE IF EXISTS `igranapartija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `igranapartija` (
  `idigranapartija` int(11) NOT NULL AUTO_INCREMENT,
  `username1` varchar(45) DEFAULT NULL,
  `username2` varchar(45) DEFAULT NULL,
  `poeni1` int(11) DEFAULT NULL,
  `poeni2` int(11) DEFAULT NULL,
  `ishod` varchar(45) DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `anagram1` int(11) DEFAULT '0',
  `anagram2` int(11) DEFAULT '0',
  `mojbroj1` int(11) DEFAULT '0',
  `mojbroj2` int(11) DEFAULT '0',
  `vesanje1` int(11) DEFAULT '0',
  `vesanje2` int(11) DEFAULT '0',
  `zanimljivageografija1` int(11) DEFAULT '0',
  `zanimljivageografija2` int(11) DEFAULT '0',
  `pehar1` int(11) DEFAULT '0',
  `pehar2` int(11) DEFAULT '0',
  `pogledano` int(11) DEFAULT '0',
  PRIMARY KEY (`idigranapartija`)
) ENGINE=InnoDB AUTO_INCREMENT=343 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `igranapartija`
--

LOCK TABLES `igranapartija` WRITE;
/*!40000 ALTER TABLE `igranapartija` DISABLE KEYS */;
/*!40000 ALTER TABLE `igranapartija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `igrapehar`
--

DROP TABLE IF EXISTS `igrapehar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `igrapehar` (
  `idigrapehar` int(11) NOT NULL AUTO_INCREMENT,
  `idigranapartija` int(11) DEFAULT NULL,
  `idpitanjaubazi` int(11) DEFAULT NULL,
  `pogodio1` int(11) DEFAULT NULL,
  `pogodio2` int(11) DEFAULT NULL,
  `pogodio3` int(11) DEFAULT NULL,
  `pogodio4` int(11) DEFAULT NULL,
  `pogodio5` int(11) DEFAULT NULL,
  `pogodio6` int(11) DEFAULT NULL,
  `pogodio7` int(11) DEFAULT NULL,
  `pogodio8` int(11) DEFAULT NULL,
  `pogodio9` int(11) DEFAULT NULL,
  `pogodio10` int(11) DEFAULT NULL,
  `pogodio11` int(11) DEFAULT NULL,
  `pogodio12` int(11) DEFAULT NULL,
  `pogodio13` int(11) DEFAULT NULL,
  `pogodio14` int(11) DEFAULT NULL,
  `koigra` int(11) DEFAULT NULL,
  `igrase` tinyint(4) DEFAULT '0',
  `username1` varchar(45) DEFAULT NULL,
  `username2` varchar(45) DEFAULT NULL,
  `brpoena1` int(11) DEFAULT NULL,
  `brpoena2` int(11) DEFAULT NULL,
  `brpitanja` int(11) DEFAULT '1',
  PRIMARY KEY (`idigrapehar`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `igrapehar`
--

LOCK TABLES `igrapehar` WRITE;
/*!40000 ALTER TABLE `igrapehar` DISABLE KEYS */;
/*!40000 ALTER TABLE `igrapehar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `igravesanja`
--

DROP TABLE IF EXISTS `igravesanja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `igravesanja` (
  `idigravesanja` int(11) NOT NULL AUTO_INCREMENT,
  `idigranapartija` int(11) DEFAULT NULL,
  `rec` varchar(45) DEFAULT NULL,
  `username1` varchar(45) DEFAULT NULL,
  `username2` varchar(45) DEFAULT NULL,
  `igrase` tinyint(4) DEFAULT '0',
  `koigra` int(11) DEFAULT NULL,
  `brpromasenih1` int(11) DEFAULT '0',
  `brpromasenih2` int(11) DEFAULT '0',
  `pogodjenaslova` varchar(45) DEFAULT NULL,
  `promasenaslova` varchar(45) DEFAULT NULL,
  `brpoena1` int(11) DEFAULT '0',
  `brpoena2` int(11) DEFAULT '0',
  PRIMARY KEY (`idigravesanja`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `igravesanja`
--

LOCK TABLES `igravesanja` WRITE;
/*!40000 ALTER TABLE `igravesanja` DISABLE KEYS */;
/*!40000 ALTER TABLE `igravesanja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `igrazgeos`
--

DROP TABLE IF EXISTS `igrazgeos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `igrazgeos` (
  `idigrazgeos` int(11) NOT NULL AUTO_INCREMENT,
  `idigranapartija` int(11) DEFAULT NULL,
  `slovo` char(1) DEFAULT NULL,
  `username1` varchar(45) DEFAULT NULL,
  `username2` varchar(45) DEFAULT NULL,
  `koigra` int(11) DEFAULT NULL,
  `igrase` tinyint(4) DEFAULT '0',
  `drzava` varchar(45) DEFAULT NULL,
  `grad` varchar(45) DEFAULT NULL,
  `reka` varchar(45) DEFAULT NULL,
  `jezero` varchar(45) DEFAULT NULL,
  `planina` varchar(45) DEFAULT NULL,
  `zivotinja` varchar(45) DEFAULT NULL,
  `biljka` varchar(45) DEFAULT NULL,
  `grupa` varchar(45) DEFAULT NULL,
  `brpoena1` varchar(45) DEFAULT NULL,
  `brpoena2` varchar(45) DEFAULT NULL,
  `zavrsenarevizija` tinyint(4) DEFAULT '0',
  `zakljucanodgovor1` tinyint(4) DEFAULT '0',
  `zakljucanodgovor2` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`idigrazgeos`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `igrazgeos`
--

LOCK TABLES `igrazgeos` WRITE;
/*!40000 ALTER TABLE `igrazgeos` DISABLE KEYS */;
/*!40000 ALTER TABLE `igrazgeos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `korisnik` (
  `username` varchar(45) NOT NULL,
  `password` varchar(50) NOT NULL,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `zanimanje` varchar(45) NOT NULL,
  `pol` char(1) NOT NULL,
  `jmbg` bigint(20) NOT NULL,
  `slika` mediumblob,
  `tajanstveno_pitanje` varchar(150) DEFAULT NULL,
  `odgovor` varchar(45) DEFAULT NULL,
  `odobren` int(11) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES ('admin','y+tmhOkIY+NDOI/LxOhyygDtOaE=','admin','admin','admin@gmail.com','admin','M',2259205920124,NULL,NULL,NULL,1),('andjela','jI/qAUWoGHj42ISa+2BCSdI+g/E=','Andjela','Andjelkovic','andjela@gmail.com','student','Z',2259105930124,_binary 'ÿ\Øÿ\átExif\0\0MM\0*\0\0\0\0\0\0\0\0\0\0\0\Z\0\0\0\0\0\0\0b\0\0\0\0\0\0\0j(\0\0\0\0\0\0\01\0\0\0\0\0\0\0r2\0\0\0\0\0\0\0‡i\0\0\0\0\0\0\0¤\0\0\0\Ð\0\nü€\0\0\'\0\nü€\0\0\'Adobe Photoshop CS6 (Windows)\02019:08:11 19:22:59\0\0 \0\0\0\0\0\0\0 \0\0\0\0\0\0\0ú \0\0\0\0\0\0\0ú\0\0\0\0\0\0\0\0\0\0\0\0\0\0\Z\0\0\0\0\0\0\0\0\0\0\0\0&(\0\0\0\0\0\0\0\0\0\0\0\0\0.\0\0\0\0\0\0>\0\0\0\0\0\0\0H\0\0\0\0\0\0H\0\0\0ÿ\Øÿ\âXICC_PROFILE\0\0\0HLino\0\0mntrRGB XYZ \Î\0\0	\0\01\0\0acspMSFT\0\0\0\0IEC sRGB\0\0\0\0\0\0\0\0\0\0\0\0\0\0ö\Ö\0\0\0\0\0\Ó-HP  \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0cprt\0\0P\0\0\03desc\0\0„\0\0\0lwtpt\0\0ð\0\0\0bkpt\0\0\0\0\0rXYZ\0\0\0\0\0gXYZ\0\0,\0\0\0bXYZ\0\0@\0\0\0dmnd\0\0T\0\0\0pdmdd\0\0\Ä\0\0\0ˆvued\0\0L\0\0\0†view\0\0\Ô\0\0\0$lumi\0\0ø\0\0\0meas\0\0\0\0\0$tech\0\00\0\0\0rTRC\0\0<\0\0gTRC\0\0<\0\0bTRC\0\0<\0\0text\0\0\0\0Copyright (c) 1998 Hewlett-Packard Company\0\0desc\0\0\0\0\0\0\0sRGB IEC61966-2.1\0\0\0\0\0\0\0\0\0\0\0sRGB IEC61966-2.1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0XYZ \0\0\0\0\0\0óQ\0\0\0\0\ÌXYZ \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0XYZ \0\0\0\0\0\0o¢\0\08õ\0\0XYZ \0\0\0\0\0\0b™\0\0·…\0\0\ÚXYZ \0\0\0\0\0\0$ \0\0„\0\0¶\Ïdesc\0\0\0\0\0\0\0IEC http://www.iec.ch\0\0\0\0\0\0\0\0\0\0\0IEC http://www.iec.ch\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0desc\0\0\0\0\0\0\0.IEC 61966-2.1 Default RGB colour space - sRGB\0\0\0\0\0\0\0\0\0\0\0.IEC 61966-2.1 Default RGB colour space - sRGB\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0desc\0\0\0\0\0\0\0,Reference Viewing Condition in IEC61966-2.1\0\0\0\0\0\0\0\0\0\0\0,Reference Viewing Condition in IEC61966-2.1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0view\0\0\0\0\0¤þ\0_.\0\Ï\0\í\Ì\0\0\\ž\0\0\0XYZ \0\0\0\0\0L	V\0P\0\0\0W\çmeas\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0sig \0\0\0\0CRT curv\0\0\0\0\0\0\0\0\0\0\0\n\0\0\0\0\0#\0(\0-\02\07\0;\0@\0E\0J\0O\0T\0Y\0^\0c\0h\0m\0r\0w\0|\0\0†\0‹\0\0•\0š\0Ÿ\0¤\0©\0®\0²\0·\0¼\0Á\0\Æ\0\Ë\0\Ð\0\Õ\0\Û\0\à\0\å\0\ë\0ð\0ö\0û\r%+28>ELRY`gnu|ƒ‹’š¡©±¹Á\É\Ñ\Ù\á\éòú&/8AKT]gqz„Ž˜¢¬¶Á\Ë\Õ\à\ëõ\0!-8COZfr~Š–¢®º\Ç\Ó\à\ìù -;HUcq~Œš¨¶\Ä\Ó\áðþ\r+:IXgw†–¦µ\Å\Õ\åö\'7HYj{Œ¯À\Ñ\ãõ+=Oat†™¬¿\Ò\åø2FZn‚–ª¾\Ò\çû		%	:	O	d	y		¤	º	\Ï	\å	û\n\n\'\n=\nT\nj\n\n˜\n®\n\Å\n\Ü\nó\"9Qi€˜°\È\áù*C\\uŽ§À\Ùó\r\r\r&\r@\rZ\rt\rŽ\r©\r\Ã\r\Þ\rø.Id›¶\Ò\î	%A^z–³\Ï\ì	&Ca~›¹\×õ1OmŒª\É\è&Ed„£\Ã\ã#Ccƒ¤\Å\å\'Ij‹­\Îð4Vx›½\à&Il²\ÖúAe‰®\Ò÷@eŠ¯\Õú Ek‘·\Ý\Z\Z*\ZQ\Zw\Zž\Z\Å\Z\ì;cŠ²\Ú*R{£\ÌõGp™\Ã\ì@j”¾\é>i”¿\ê  A l ˜ \Ä ð!!H!u!¡!\Î!û\"\'\"U\"‚\"¯\"\Ý#\n#8#f#”#\Â#ð$$M$|$«$\Ú%	%8%h%—%\Ç%÷&\'&W&‡&·&\è\'\'I\'z\'«\'\Ü(\r(?(q(¢(\Ô))8)k))\Ð**5*h*›*\Ï++6+i++\Ñ,,9,n,¢,\×--A-v-«-\á..L.‚.·.\î/$/Z/‘/\Ç/þ050l0¤0\Û11J1‚1º1ò2*2c2›2\Ô3\r3F33¸3ñ4+4e4ž4\Ø55M5‡5\Â5ý676r6®6\é7$7`7œ7\×88P8Œ8\È99B99¼9ù:6:t:²:\ï;-;k;ª;\è<\'<e<¤<\ã=\"=a=¡=\à> >`> >\à?!?a?¢?\â@#@d@¦@\çA)AjA¬A\îB0BrBµB÷C:C}CÀDDGDŠD\ÎEEUEšE\ÞF\"FgF«FðG5G{GÀHHKH‘H\×IIcI©IðJ7J}J\ÄKKSKšK\âL*LrLºMMJM“M\ÜN%NnN·O\0OIO“O\ÝP\'PqP»QQPQ›Q\æR1R|R\ÇSS_SªSöTBTT\ÛU(UuU\ÂVV\\V©V÷WDW’W\àX/X}X\ËY\ZYiY¸ZZVZ¦Zõ[E[•[\å\\5\\†\\\Ö]\']x]\É^\Z^l^½__a_³``W`ª`üaOa¢aõbIbœbðcCc—c\ëd@d”d\ée=e’e\çf=f’f\èg=g“g\éh?h–h\ìiCišiñjHjŸj÷kOk§kÿlWl¯mm`m¹nnkn\Äooxo\Ñp+p†p\àq:q•qðrKr¦ss]s¸ttpt\Ìu(u…u\áv>v›vøwVw³xxnx\Ìy*y‰y\çzFz¥{{c{\Â|!||\á}A}¡~~b~\Â#„\å€G€¨\nkÍ‚0‚’‚ôƒWƒº„„€„\ã…G…«††r†×‡;‡ŸˆˆiˆÎ‰3‰™‰þŠdŠÊ‹0‹–‹üŒcŒÊ1˜ÿŽfŽÎ6žnÖ‘?‘¨’’z’\ã“M“¶” ”Š”ô•_•É–4–Ÿ—\n—u—\à˜L˜¸™$™™üšhšÕ›B›¯œœ‰œ÷dÒž@ž®ŸŸ‹Ÿú i Ø¡G¡¶¢&¢–££v£\æ¤V¤Ç¥8¥©¦\Z¦‹¦ý§n§\à¨R¨Ä©7©©ªª««u«\é¬\\¬Ð­D­¸®-®¡¯¯‹°\0°u°\ê±`±Ö²K²Â³8³®´%´œµµŠ¶¶y¶ð·h·\à¸Y¸Ñ¹J¹Âº;ºµ».»§¼!¼›½½¾\n¾„¾ÿ¿z¿õÀpÀ\ìÁgÁ\ã\Â_\Â\Û\ÃX\Ã\Ô\ÄQ\Ä\Î\ÅK\Å\È\ÆF\Æ\Ã\ÇAÇ¿\È=È¼\É:É¹\Ê8Ê·\Ë6Ë¶\Ì5Ìµ\Í5Íµ\Î6Î¶\Ï7Ï¸\Ð9Ðº\Ñ<Ñ¾\Ò?\ÒÁ\ÓD\Ó\Æ\ÔI\Ô\Ë\ÕN\Õ\Ñ\ÖU\Ö\Ø\×\\\×\à\Ød\Ø\è\Ùl\Ùñ\Úv\ÚûÛ€\ÜÜŠ\ÝÝ–\ÞÞ¢\ß)ß¯\à6\à½\áD\á\Ì\âS\â\Û\ãc\ã\ë\äs\äü\å„\æ\r\æ–\ç\ç©\è2\è¼\éF\é\Ð\ê[\ê\å\ëp\ëû\ì†\í\íœ\î(\î´\ï@\ï\ÌðXð\åñrñÿòŒóó§ô4ô\ÂõPõ\Þömöû÷Šøø¨ù8ù\ÇúWú\çûwüü˜ý)ýºþKþ\Üÿmÿÿÿ\í\0Adobe_CM\0ÿ\î\0Adobe\0d€\0\0\0ÿ\Û\0„\0			\n\r\r\rÿÀ\0\0 \0 \"\0ÿ\Ý\0\0\nÿ\Ä?\0\0\0\0\0\0\0\0\0\0	\n\0\0\0\0\0\0\0\0\0	\n\03\0!1AQa\"q2‘¡±B#$RÁb34r‚\ÑC%’Sð\áñcs5¢²ƒ&D“TdEÂ£t6\ÒU\âeò³„\Ã\Óu\ãóF\'”¤…´•\Ä\Ô\äô¥µ\Å\Õ\åõVfv†–¦¶\Æ\Ö\æö7GWgw‡—§·\Ç\×\ç÷\05\0!1AQaq\"2‘¡±B#ÁR\Ñð3$b\ár‚’CScs4ñ%¢²ƒ&5\Â\ÒD“T£dEU6te\âò³„\Ã\Óu\ãóF”¤…´•\Ä\Ô\äô¥µ\Å\Õ\åõVfv†–¦¶\Æ\Ö\æö\'7GWgw‡—§·\Çÿ\Ú\0\0\0?\0\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ð\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ñ\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ò\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ó\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ô\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Õ\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ö\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\×\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ð\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ùÿ\í0Photoshop 3.0\08BIM%\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\08BIM:\0\0\0\0\0\å\0\0\0\0\0\0\0\0\0\0\0printOutput\0\0\0\0\0\0\0PstSbool\0\0\0\0Inteenum\0\0\0\0Inte\0\0\0\0Clrm\0\0\0printSixteenBitbool\0\0\0\0printerNameTEXT\0\0\0\0\0\0\0\0printProofSetupObjc\0\0\0\0P\0r\0o\0o\0f\0 \0S\0e\0t\0u\0p\0\0\0\0\0\nproofSetup\0\0\0\0\0\0\0Bltnenum\0\0\0builtinProof\0\0\0	proofCMYK\08BIM;\0\0\0\0-\0\0\0\0\0\0\0\0\0\0\0printOutputOptions\0\0\0\0\0\0\0Cptnbool\0\0\0\0\0Clbrbool\0\0\0\0\0RgsMbool\0\0\0\0\0CrnCbool\0\0\0\0\0CntCbool\0\0\0\0\0Lblsbool\0\0\0\0\0Ngtvbool\0\0\0\0\0EmlDbool\0\0\0\0\0Intrbool\0\0\0\0\0BckgObjc\0\0\0\0\0\0\0\0\0RGBC\0\0\0\0\0\0\0Rd  doub@o\à\0\0\0\0\0\0\0\0\0Grn doub@o\à\0\0\0\0\0\0\0\0\0Bl  doub@o\à\0\0\0\0\0\0\0\0\0BrdTUntF#Rlt\0\0\0\0\0\0\0\0\0\0\0\0Bld UntF#Rlt\0\0\0\0\0\0\0\0\0\0\0\0RsltUntF#Pxl@R\0\0\0\0\0\0\0\0\0\nvectorDatabool\0\0\0\0PgPsenum\0\0\0\0PgPs\0\0\0\0PgPC\0\0\0\0LeftUntF#Rlt\0\0\0\0\0\0\0\0\0\0\0\0Top UntF#Rlt\0\0\0\0\0\0\0\0\0\0\0\0Scl UntF#Prc@Y\0\0\0\0\0\0\0\0\0cropWhenPrintingbool\0\0\0\0cropRectBottomlong\0\0\0\0\0\0\0cropRectLeftlong\0\0\0\0\0\0\0\rcropRectRightlong\0\0\0\0\0\0\0cropRectToplong\0\0\0\0\08BIM\í\0\0\0\0\0\0H\0\0\0\0\0H\0\0\0\08BIM&\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0?€\0\08BIM\r\0\0\0\0\0\0\0\0x8BIM\0\0\0\0\0\0\0\08BIMó\0\0\0\0\0	\0\0\0\0\0\0\0\0\08BIM\'\0\0\0\0\0\n\0\0\0\0\0\0\0\08BIMõ\0\0\0\0\0H\0/ff\0\0lff\0\0\0\0\0\0\0/ff\0\0¡™š\0\0\0\0\0\0\02\0\0\0\0Z\0\0\0\0\0\0\0\0\05\0\0\0\0-\0\0\0\0\0\0\0\08BIMø\0\0\0\0\0p\0\0ÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿ\è\0\0\0\0ÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿ\è\0\0\0\0ÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿ\è\0\0\0\0ÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿ\è\0\08BIM\0\0\0\0\0\0\0\0\0\0@\0\0@\0\0\0\08BIM\0\0\0\0\0\0\0\0\08BIM\Z\0\0\0\0I\0\0\0\0\0\0\0\0\0\0\0\0\0\0ú\0\0\0ú\0\0\0\n\0U\0n\0t\0i\0t\0l\0e\0d\0-\01\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ú\0\0\0ú\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0null\0\0\0\0\0\0boundsObjc\0\0\0\0\0\0\0\0\0Rct1\0\0\0\0\0\0\0Top long\0\0\0\0\0\0\0\0Leftlong\0\0\0\0\0\0\0\0Btomlong\0\0\0ú\0\0\0\0Rghtlong\0\0\0ú\0\0\0slicesVlLs\0\0\0Objc\0\0\0\0\0\0\0\0slice\0\0\0\0\0\0sliceIDlong\0\0\0\0\0\0\0groupIDlong\0\0\0\0\0\0\0originenum\0\0\0ESliceOrigin\0\0\0\rautoGenerated\0\0\0\0Typeenum\0\0\0\nESliceType\0\0\0\0Img \0\0\0boundsObjc\0\0\0\0\0\0\0\0\0Rct1\0\0\0\0\0\0\0Top long\0\0\0\0\0\0\0\0Leftlong\0\0\0\0\0\0\0\0Btomlong\0\0\0ú\0\0\0\0Rghtlong\0\0\0ú\0\0\0urlTEXT\0\0\0\0\0\0\0\0\0nullTEXT\0\0\0\0\0\0\0\0\0MsgeTEXT\0\0\0\0\0\0\0\0altTagTEXT\0\0\0\0\0\0\0\0cellTextIsHTMLbool\0\0\0cellTextTEXT\0\0\0\0\0\0\0\0	horzAlignenum\0\0\0ESliceHorzAlign\0\0\0default\0\0\0	vertAlignenum\0\0\0ESliceVertAlign\0\0\0default\0\0\0bgColorTypeenum\0\0\0ESliceBGColorType\0\0\0\0None\0\0\0	topOutsetlong\0\0\0\0\0\0\0\nleftOutsetlong\0\0\0\0\0\0\0bottomOutsetlong\0\0\0\0\0\0\0rightOutsetlong\0\0\0\0\08BIM(\0\0\0\0\0\0\0\0?ð\0\0\0\0\0\08BIM\0\0\0\0\0\0\0\08BIM\0\0\0\0Z\0\0\0\0\0\0 \0\0\0 \0\0\à\0,\0\0\0>\0\0ÿ\Øÿ\âXICC_PROFILE\0\0\0HLino\0\0mntrRGB XYZ \Î\0\0	\0\01\0\0acspMSFT\0\0\0\0IEC sRGB\0\0\0\0\0\0\0\0\0\0\0\0\0\0ö\Ö\0\0\0\0\0\Ó-HP  \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0cprt\0\0P\0\0\03desc\0\0„\0\0\0lwtpt\0\0ð\0\0\0bkpt\0\0\0\0\0rXYZ\0\0\0\0\0gXYZ\0\0,\0\0\0bXYZ\0\0@\0\0\0dmnd\0\0T\0\0\0pdmdd\0\0\Ä\0\0\0ˆvued\0\0L\0\0\0†view\0\0\Ô\0\0\0$lumi\0\0ø\0\0\0meas\0\0\0\0\0$tech\0\00\0\0\0rTRC\0\0<\0\0gTRC\0\0<\0\0bTRC\0\0<\0\0text\0\0\0\0Copyright (c) 1998 Hewlett-Packard Company\0\0desc\0\0\0\0\0\0\0sRGB IEC61966-2.1\0\0\0\0\0\0\0\0\0\0\0sRGB IEC61966-2.1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0XYZ \0\0\0\0\0\0óQ\0\0\0\0\ÌXYZ \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0XYZ \0\0\0\0\0\0o¢\0\08õ\0\0XYZ \0\0\0\0\0\0b™\0\0·…\0\0\ÚXYZ \0\0\0\0\0\0$ \0\0„\0\0¶\Ïdesc\0\0\0\0\0\0\0IEC http://www.iec.ch\0\0\0\0\0\0\0\0\0\0\0IEC http://www.iec.ch\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0desc\0\0\0\0\0\0\0.IEC 61966-2.1 Default RGB colour space - sRGB\0\0\0\0\0\0\0\0\0\0\0.IEC 61966-2.1 Default RGB colour space - sRGB\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0desc\0\0\0\0\0\0\0,Reference Viewing Condition in IEC61966-2.1\0\0\0\0\0\0\0\0\0\0\0,Reference Viewing Condition in IEC61966-2.1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0view\0\0\0\0\0¤þ\0_.\0\Ï\0\í\Ì\0\0\\ž\0\0\0XYZ \0\0\0\0\0L	V\0P\0\0\0W\çmeas\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0sig \0\0\0\0CRT curv\0\0\0\0\0\0\0\0\0\0\0\n\0\0\0\0\0#\0(\0-\02\07\0;\0@\0E\0J\0O\0T\0Y\0^\0c\0h\0m\0r\0w\0|\0\0†\0‹\0\0•\0š\0Ÿ\0¤\0©\0®\0²\0·\0¼\0Á\0\Æ\0\Ë\0\Ð\0\Õ\0\Û\0\à\0\å\0\ë\0ð\0ö\0û\r%+28>ELRY`gnu|ƒ‹’š¡©±¹Á\É\Ñ\Ù\á\éòú&/8AKT]gqz„Ž˜¢¬¶Á\Ë\Õ\à\ëõ\0!-8COZfr~Š–¢®º\Ç\Ó\à\ìù -;HUcq~Œš¨¶\Ä\Ó\áðþ\r+:IXgw†–¦µ\Å\Õ\åö\'7HYj{Œ¯À\Ñ\ãõ+=Oat†™¬¿\Ò\åø2FZn‚–ª¾\Ò\çû		%	:	O	d	y		¤	º	\Ï	\å	û\n\n\'\n=\nT\nj\n\n˜\n®\n\Å\n\Ü\nó\"9Qi€˜°\È\áù*C\\uŽ§À\Ùó\r\r\r&\r@\rZ\rt\rŽ\r©\r\Ã\r\Þ\rø.Id›¶\Ò\î	%A^z–³\Ï\ì	&Ca~›¹\×õ1OmŒª\É\è&Ed„£\Ã\ã#Ccƒ¤\Å\å\'Ij‹­\Îð4Vx›½\à&Il²\ÖúAe‰®\Ò÷@eŠ¯\Õú Ek‘·\Ý\Z\Z*\ZQ\Zw\Zž\Z\Å\Z\ì;cŠ²\Ú*R{£\ÌõGp™\Ã\ì@j”¾\é>i”¿\ê  A l ˜ \Ä ð!!H!u!¡!\Î!û\"\'\"U\"‚\"¯\"\Ý#\n#8#f#”#\Â#ð$$M$|$«$\Ú%	%8%h%—%\Ç%÷&\'&W&‡&·&\è\'\'I\'z\'«\'\Ü(\r(?(q(¢(\Ô))8)k))\Ð**5*h*›*\Ï++6+i++\Ñ,,9,n,¢,\×--A-v-«-\á..L.‚.·.\î/$/Z/‘/\Ç/þ050l0¤0\Û11J1‚1º1ò2*2c2›2\Ô3\r3F33¸3ñ4+4e4ž4\Ø55M5‡5\Â5ý676r6®6\é7$7`7œ7\×88P8Œ8\È99B99¼9ù:6:t:²:\ï;-;k;ª;\è<\'<e<¤<\ã=\"=a=¡=\à> >`> >\à?!?a?¢?\â@#@d@¦@\çA)AjA¬A\îB0BrBµB÷C:C}CÀDDGDŠD\ÎEEUEšE\ÞF\"FgF«FðG5G{GÀHHKH‘H\×IIcI©IðJ7J}J\ÄKKSKšK\âL*LrLºMMJM“M\ÜN%NnN·O\0OIO“O\ÝP\'PqP»QQPQ›Q\æR1R|R\ÇSS_SªSöTBTT\ÛU(UuU\ÂVV\\V©V÷WDW’W\àX/X}X\ËY\ZYiY¸ZZVZ¦Zõ[E[•[\å\\5\\†\\\Ö]\']x]\É^\Z^l^½__a_³``W`ª`üaOa¢aõbIbœbðcCc—c\ëd@d”d\ée=e’e\çf=f’f\èg=g“g\éh?h–h\ìiCišiñjHjŸj÷kOk§kÿlWl¯mm`m¹nnkn\Äooxo\Ñp+p†p\àq:q•qðrKr¦ss]s¸ttpt\Ìu(u…u\áv>v›vøwVw³xxnx\Ìy*y‰y\çzFz¥{{c{\Â|!||\á}A}¡~~b~\Â#„\å€G€¨\nkÍ‚0‚’‚ôƒWƒº„„€„\ã…G…«††r†×‡;‡ŸˆˆiˆÎ‰3‰™‰þŠdŠÊ‹0‹–‹üŒcŒÊ1˜ÿŽfŽÎ6žnÖ‘?‘¨’’z’\ã“M“¶” ”Š”ô•_•É–4–Ÿ—\n—u—\à˜L˜¸™$™™üšhšÕ›B›¯œœ‰œ÷dÒž@ž®ŸŸ‹Ÿú i Ø¡G¡¶¢&¢–££v£\æ¤V¤Ç¥8¥©¦\Z¦‹¦ý§n§\à¨R¨Ä©7©©ªª««u«\é¬\\¬Ð­D­¸®-®¡¯¯‹°\0°u°\ê±`±Ö²K²Â³8³®´%´œµµŠ¶¶y¶ð·h·\à¸Y¸Ñ¹J¹Âº;ºµ».»§¼!¼›½½¾\n¾„¾ÿ¿z¿õÀpÀ\ìÁgÁ\ã\Â_\Â\Û\ÃX\Ã\Ô\ÄQ\Ä\Î\ÅK\Å\È\ÆF\Æ\Ã\ÇAÇ¿\È=È¼\É:É¹\Ê8Ê·\Ë6Ë¶\Ì5Ìµ\Í5Íµ\Î6Î¶\Ï7Ï¸\Ð9Ðº\Ñ<Ñ¾\Ò?\ÒÁ\ÓD\Ó\Æ\ÔI\Ô\Ë\ÕN\Õ\Ñ\ÖU\Ö\Ø\×\\\×\à\Ød\Ø\è\Ùl\Ùñ\Úv\ÚûÛ€\ÜÜŠ\ÝÝ–\ÞÞ¢\ß)ß¯\à6\à½\áD\á\Ì\âS\â\Û\ãc\ã\ë\äs\äü\å„\æ\r\æ–\ç\ç©\è2\è¼\éF\é\Ð\ê[\ê\å\ëp\ëû\ì†\í\íœ\î(\î´\ï@\ï\ÌðXð\åñrñÿòŒóó§ô4ô\ÂõPõ\Þömöû÷Šøø¨ù8ù\ÇúWú\çûwüü˜ý)ýºþKþ\Üÿmÿÿÿ\í\0Adobe_CM\0ÿ\î\0Adobe\0d€\0\0\0ÿ\Û\0„\0			\n\r\r\rÿÀ\0\0 \0 \"\0ÿ\Ý\0\0\nÿ\Ä?\0\0\0\0\0\0\0\0\0\0	\n\0\0\0\0\0\0\0\0\0	\n\03\0!1AQa\"q2‘¡±B#$RÁb34r‚\ÑC%’Sð\áñcs5¢²ƒ&D“TdEÂ£t6\ÒU\âeò³„\Ã\Óu\ãóF\'”¤…´•\Ä\Ô\äô¥µ\Å\Õ\åõVfv†–¦¶\Æ\Ö\æö7GWgw‡—§·\Ç\×\ç÷\05\0!1AQaq\"2‘¡±B#ÁR\Ñð3$b\ár‚’CScs4ñ%¢²ƒ&5\Â\ÒD“T£dEU6te\âò³„\Ã\Óu\ãóF”¤…´•\Ä\Ô\äô¥µ\Å\Õ\åõVfv†–¦¶\Æ\Ö\æö\'7GWgw‡—§·\Çÿ\Ú\0\0\0?\0\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ð\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ñ\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ò\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ó\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ô\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Õ\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ö\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\×\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ð\ßI$—ô*I$’R’I$”¤’I%)$’IJI$’R’I$”¤’I%)$’IJI$’Sÿ\Ù8BIM!\0\0\0\0\0U\0\0\0\0\0\0\0A\0d\0o\0b\0e\0 \0P\0h\0o\0t\0o\0s\0h\0o\0p\0\0\0\0A\0d\0o\0b\0e\0 \0P\0h\0o\0t\0o\0s\0h\0o\0p\0 \0C\0S\06\0\0\0\08BIM\0\0\0\0\0\0\0\0ÿ\á\rhttp://ns.adobe.com/xap/1.0/\0<?xpacket begin=\"ï»¿\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?> <x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"Adobe XMP Core 5.3-c011 66.145661, 2012/02/06-14:56:27        \"> <rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"> <rdf:Description rdf:about=\"\" xmlns:xmp=\"http://ns.adobe.com/xap/1.0/\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:xmpMM=\"http://ns.adobe.com/xap/1.0/mm/\" xmlns:stEvt=\"http://ns.adobe.com/xap/1.0/sType/ResourceEvent#\" xmlns:photoshop=\"http://ns.adobe.com/photoshop/1.0/\" xmp:CreatorTool=\"Adobe Photoshop CS6 (Windows)\" xmp:CreateDate=\"2019-08-11T19:22:59+02:00\" xmp:MetadataDate=\"2019-08-11T19:22:59+02:00\" xmp:ModifyDate=\"2019-08-11T19:22:59+02:00\" dc:format=\"image/jpeg\" xmpMM:InstanceID=\"xmp.iid:CA6C62AA5CBCE911A4C2C3C73F4DE49E\" xmpMM:DocumentID=\"xmp.did:CA6C62AA5CBCE911A4C2C3C73F4DE49E\" xmpMM:OriginalDocumentID=\"xmp.did:CA6C62AA5CBCE911A4C2C3C73F4DE49E\" photoshop:ColorMode=\"3\" photoshop:ICCProfile=\"sRGB IEC61966-2.1\"> <xmpMM:History> <rdf:Seq> <rdf:li stEvt:action=\"created\" stEvt:instanceID=\"xmp.iid:CA6C62AA5CBCE911A4C2C3C73F4DE49E\" stEvt:when=\"2019-08-11T19:22:59+02:00\" stEvt:softwareAgent=\"Adobe Photoshop CS6 (Windows)\"/> </rdf:Seq> </xmpMM:History> </rdf:Description> </rdf:RDF> </x:xmpmeta>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 <?xpacket end=\"w\"?>ÿ\âXICC_PROFILE\0\0\0HLino\0\0mntrRGB XYZ \Î\0\0	\0\01\0\0acspMSFT\0\0\0\0IEC sRGB\0\0\0\0\0\0\0\0\0\0\0\0\0ö\Ö\0\0\0\0\0\Ó-HP  \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0cprt\0\0P\0\0\03desc\0\0„\0\0\0lwtpt\0\0ð\0\0\0bkpt\0\0\0\0\0rXYZ\0\0\0\0\0gXYZ\0\0,\0\0\0bXYZ\0\0@\0\0\0dmnd\0\0T\0\0\0pdmdd\0\0\Ä\0\0\0ˆvued\0\0L\0\0\0†view\0\0\Ô\0\0\0$lumi\0\0ø\0\0\0meas\0\0\0\0\0$tech\0\00\0\0\0rTRC\0\0<\0\0gTRC\0\0<\0\0bTRC\0\0<\0\0text\0\0\0\0Copyright (c) 1998 Hewlett-Packard Company\0\0desc\0\0\0\0\0\0\0sRGB IEC61966-2.1\0\0\0\0\0\0\0\0\0\0\0sRGB IEC61966-2.1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0XYZ \0\0\0\0\0\0óQ\0\0\0\0\ÌXYZ \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0XYZ \0\0\0\0\0\0o¢\0\08õ\0\0XYZ \0\0\0\0\0\0b™\0\0·…\0\0\ÚXYZ \0\0\0\0\0\0$ \0\0„\0\0¶\Ïdesc\0\0\0\0\0\0\0IEC http://www.iec.ch\0\0\0\0\0\0\0\0\0\0\0IEC http://www.iec.ch\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0desc\0\0\0\0\0\0\0.IEC 61966-2.1 Default RGB colour space - sRGB\0\0\0\0\0\0\0\0\0\0\0.IEC 61966-2.1 Default RGB colour space - sRGB\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0desc\0\0\0\0\0\0\0,Reference Viewing Condition in IEC61966-2.1\0\0\0\0\0\0\0\0\0\0\0,Reference Viewing Condition in IEC61966-2.1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0view\0\0\0\0\0¤þ\0_.\0\Ï\0\í\Ì\0\0\\ž\0\0\0XYZ \0\0\0\0\0L	V\0P\0\0\0W\çmeas\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0sig \0\0\0\0CRT curv\0\0\0\0\0\0\0\0\0\0\0\n\0\0\0\0\0#\0(\0-\02\07\0;\0@\0E\0J\0O\0T\0Y\0^\0c\0h\0m\0r\0w\0|\0\0†\0‹\0\0•\0š\0Ÿ\0¤\0©\0®\0²\0·\0¼\0Á\0\Æ\0\Ë\0\Ð\0\Õ\0\Û\0\à\0\å\0\ë\0ð\0ö\0û\r%+28>ELRY`gnu|ƒ‹’š¡©±¹Á\É\Ñ\Ù\á\éòú&/8AKT]gqz„Ž˜¢¬¶Á\Ë\Õ\à\ëõ\0!-8COZfr~Š–¢®º\Ç\Ó\à\ìù -;HUcq~Œš¨¶\Ä\Ó\áðþ\r+:IXgw†–¦µ\Å\Õ\åö\'7HYj{Œ¯À\Ñ\ãõ+=Oat†™¬¿\Ò\åø2FZn‚–ª¾\Ò\çû		%	:	O	d	y		¤	º	\Ï	\å	û\n\n\'\n=\nT\nj\n\n˜\n®\n\Å\n\Ü\nó\"9Qi€˜°\È\áù*C\\uŽ§À\Ùó\r\r\r&\r@\rZ\rt\rŽ\r©\r\Ã\r\Þ\rø.Id›¶\Ò\î	%A^z–³\Ï\ì	&Ca~›¹\×õ1OmŒª\É\è&Ed„£\Ã\ã#Ccƒ¤\Å\å\'Ij‹­\Îð4Vx›½\à&Il²\ÖúAe‰®\Ò÷@eŠ¯\Õú Ek‘·\Ý\Z\Z*\ZQ\Zw\Zž\Z\Å\Z\ì;cŠ²\Ú*R{£\ÌõGp™\Ã\ì@j”¾\é>i”¿\ê  A l ˜ \Ä ð!!H!u!¡!\Î!û\"\'\"U\"‚\"¯\"\Ý#\n#8#f#”#\Â#ð$$M$|$«$\Ú%	%8%h%—%\Ç%÷&\'&W&‡&·&\è\'\'I\'z\'«\'\Ü(\r(?(q(¢(\Ô))8)k))\Ð**5*h*›*\Ï++6+i++\Ñ,,9,n,¢,\×--A-v-«-\á..L.‚.·.\î/$/Z/‘/\Ç/þ050l0¤0\Û11J1‚1º1ò2*2c2›2\Ô3\r3F33¸3ñ4+4e4ž4\Ø55M5‡5\Â5ý676r6®6\é7$7`7œ7\×88P8Œ8\È99B99¼9ù:6:t:²:\ï;-;k;ª;\è<\'<e<¤<\ã=\"=a=¡=\à> >`> >\à?!?a?¢?\â@#@d@¦@\çA)AjA¬A\îB0BrBµB÷C:C}CÀDDGDŠD\ÎEEUEšE\ÞF\"FgF«FðG5G{GÀHHKH‘H\×IIcI©IðJ7J}J\ÄKKSKšK\âL*LrLºMMJM“M\ÜN%NnN·O\0OIO“O\ÝP\'PqP»QQPQ›Q\æR1R|R\ÇSS_SªSöTBTT\ÛU(UuU\ÂVV\\V©V÷WDW’W\àX/X}X\ËY\ZYiY¸ZZVZ¦Zõ[E[•[\å\\5\\†\\\Ö]\']x]\É^\Z^l^½__a_³``W`ª`üaOa¢aõbIbœbðcCc—c\ëd@d”d\ée=e’e\çf=f’f\èg=g“g\éh?h–h\ìiCišiñjHjŸj÷kOk§kÿlWl¯mm`m¹nnkn\Äooxo\Ñp+p†p\àq:q•qðrKr¦ss]s¸ttpt\Ìu(u…u\áv>v›vøwVw³xxnx\Ìy*y‰y\çzFz¥{{c{\Â|!||\á}A}¡~~b~\Â#„\å€G€¨\nkÍ‚0‚’‚ôƒWƒº„„€„\ã…G…«††r†×‡;‡ŸˆˆiˆÎ‰3‰™‰þŠdŠÊ‹0‹–‹üŒcŒÊ1˜ÿŽfŽÎ6žnÖ‘?‘¨’’z’\ã“M“¶” ”Š”ô•_•É–4–Ÿ—\n—u—\à˜L˜¸™$™™üšhšÕ›B›¯œœ‰œ÷dÒž@ž®ŸŸ‹Ÿú i Ø¡G¡¶¢&¢–££v£\æ¤V¤Ç¥8¥©¦\Z¦‹¦ý§n§\à¨R¨Ä©7©©ªª««u«\é¬\\¬Ð­D­¸®-®¡¯¯‹°\0°u°\ê±`±Ö²K²Â³8³®´%´œµµŠ¶¶y¶ð·h·\à¸Y¸Ñ¹J¹Âº;ºµ».»§¼!¼›½½¾\n¾„¾ÿ¿z¿õÀpÀ\ìÁgÁ\ã\Â_\Â\Û\ÃX\Ã\Ô\ÄQ\Ä\Î\ÅK\Å\È\ÆF\Æ\Ã\ÇAÇ¿\È=È¼\É:É¹\Ê8Ê·\Ë6Ë¶\Ì5Ìµ\Í5Íµ\Î6Î¶\Ï7Ï¸\Ð9Ðº\Ñ<Ñ¾\Ò?\ÒÁ\ÓD\Ó\Æ\ÔI\Ô\Ë\ÕN\Õ\Ñ\ÖU\Ö\Ø\×\\\×\à\Ød\Ø\è\Ùl\Ùñ\Úv\ÚûÛ€\ÜÜŠ\ÝÝ–\ÞÞ¢\ß)ß¯\à6\à½\áD\á\Ì\âS\â\Û\ãc\ã\ë\äs\äü\å„\æ\r\æ–\ç\ç©\è2\è¼\éF\é\Ð\ê[\ê\å\ëp\ëû\ì†\í\íœ\î(\î´\ï@\ï\ÌðXð\åñrñÿòŒóó§ô4ô\ÂõPõ\Þömöû÷Šøø¨ù8ù\ÇúWú\çûwüü˜ý)ýºþKþ\Üÿmÿÿÿ\î\0!Adobe\0d@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Û\0„\0ÿ\Â\0\0ú\0ú\0ÿ\Ä\0_\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	\0\0\0\0\0\0\0\0\0\0\0\0\0\0	\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0 \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0 \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0 ÿ\Ú\0\0\0\0®\Ù[µ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ú\0\0\0\0ÿ\Ú\0\0\0\0ÿ\Ú\0\0\0\0ÿ\Ú\0?\0\0ÿ\Ú\0?\0\0ÿ\Ú\0?\0\0ÿ\Ù',NULL,NULL,1),('andora','gNH0qKQ+tpa00CYHbkB02CNUJgg=','Andora','Andorovic','andora@gmail.com','glumica','Z',1234567890124,NULL,'kako se zovem?','andora',1),('djole','D39u6RSnNGdDm9+2hGCQrW0hctE=','djole','djole','djole@gmail.com','reper','M',2132205920124,NULL,NULL,NULL,1),('stefan','tCWwWgkop2iVqCOnqQNZ5Ps90iw=','stefan','stefan','stefan@gmail.com','ribar','M',2259205930124,NULL,NULL,NULL,1),('supervizor','OQEQxNtvQkzqhyKZWfA2ZkNoNyU=','supervizor','supervizor','supervizor@gmail.com','supervizor','M',2348693455615,NULL,NULL,NULL,1),('uros','ZnR8Ad+WLZK3lXcUMNWG/dGy0d8=','uros','uros','uros@gmail.com','reziser','M',2132205920111,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `username` varchar(40) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partija`
--

DROP TABLE IF EXISTS `partija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partija` (
  `idpartije` int(11) NOT NULL AUTO_INCREMENT,
  `username1` varchar(45) DEFAULT NULL,
  `username2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpartije`)
) ENGINE=InnoDB AUTO_INCREMENT=561 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partija`
--

LOCK TABLES `partija` WRITE;
/*!40000 ALTER TABLE `partija` DISABLE KEYS */;
/*!40000 ALTER TABLE `partija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revizijareci`
--

DROP TABLE IF EXISTS `revizijareci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `revizijareci` (
  `idrevizijareci` int(11) NOT NULL AUTO_INCREMENT,
  `idzgeosigre` int(11) DEFAULT NULL,
  `slovo` char(1) DEFAULT NULL,
  `tip` varchar(45) DEFAULT NULL,
  `tekst` varchar(45) DEFAULT NULL,
  `prihvaceno` tinyint(4) DEFAULT '0',
  `brpoenadodato` int(11) DEFAULT '4',
  `komedodajem` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrevizijareci`)
) ENGINE=InnoDB AUTO_INCREMENT=229 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revizijareci`
--

LOCK TABLES `revizijareci` WRITE;
/*!40000 ALTER TABLE `revizijareci` DISABLE KEYS */;
/*!40000 ALTER TABLE `revizijareci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vesanja`
--

DROP TABLE IF EXISTS `vesanja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vesanja` (
  `idvesanja` int(11) NOT NULL AUTO_INCREMENT,
  `rec` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idvesanja`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vesanja`
--

LOCK TABLES `vesanja` WRITE;
/*!40000 ALTER TABLE `vesanja` DISABLE KEYS */;
INSERT INTO `vesanja` VALUES (1,'ananas'),(2,'badminton'),(3,'dezodorans'),(4,'bioskop'),(5,'fascikla'),(6,'projekat'),(7,'olovka'),(8,'kreda'),(9,'avantura');
/*!40000 ALTER TABLE `vesanja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'projekat'
--

--
-- Dumping routines for database 'projekat'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-29 14:03:07

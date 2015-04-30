-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           5.6.12-log - MySQL Community Server (GPL)
-- Serveur OS:                   Win64
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Export de la structure de table dahouet. challenge
CREATE TABLE IF NOT EXISTS `challenge` (
  `ID_CHALL` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_CHALL` varchar(20) NOT NULL,
  `ANNEE` int(11) NOT NULL,
  `DATE_DEBUT` date NOT NULL,
  `DATE_FIN` date NOT NULL,
  PRIMARY KEY (`ID_CHALL`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.challenge: ~2 rows (environ)
DELETE FROM `challenge`;
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
INSERT INTO `challenge` (`ID_CHALL`, `NOM_CHALL`, `ANNEE`, `DATE_DEBUT`, `DATE_FIN`) VALUES
	(1, 'été', 2015, '2015-04-01', '2015-08-31'),
	(2, 'hiver', 2014, '2014-10-01', '2015-02-28');
/*!40000 ALTER TABLE `challenge` ENABLE KEYS */;


-- Export de la structure de table dahouet. classe
CREATE TABLE IF NOT EXISTS `classe` (
  `NUM_CLASSE` int(11) NOT NULL AUTO_INCREMENT,
  `NUM_SERIE` int(11) DEFAULT NULL,
  `NOM_CLASSE` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`NUM_CLASSE`),
  KEY `FK_classe_serie` (`NUM_SERIE`),
  CONSTRAINT `FK_classe_serie` FOREIGN KEY (`NUM_SERIE`) REFERENCES `serie` (`NUM_SERIE`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.classe: ~11 rows (environ)
DELETE FROM `classe`;
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
INSERT INTO `classe` (`NUM_CLASSE`, `NUM_SERIE`, `NOM_CLASSE`) VALUES
	(1, 1, 'CORSAIRE'),
	(2, 1, 'SURPRISE'),
	(3, 1, '8 METRES'),
	(4, 1, 'MARAUDEUR'),
	(5, 1, 'FIGARO'),
	(6, 2, 'FLYING FIFTEEN'),
	(7, 2, 'SOLING'),
	(8, 2, 'STAR'),
	(9, 2, 'TEMPEST'),
	(10, 2, 'YNGLING'),
	(11, 2, '5.5');
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;


-- Export de la structure de table dahouet. club
CREATE TABLE IF NOT EXISTS `club` (
  `NUM_CLUB` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_CLUB` varchar(20) NOT NULL,
  `ADRESSE_CLUB` varchar(50) NOT NULL,
  `TEL_CLUB` bigint(20) NOT NULL,
  PRIMARY KEY (`NUM_CLUB`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.club: ~3 rows (environ)
DELETE FROM `club`;
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
INSERT INTO `club` (`NUM_CLUB`, `NOM_CLUB`, `ADRESSE_CLUB`, `TEL_CLUB`) VALUES
	(1, 'club SM', '3 boulevard de la pine', 33611111111),
	(2, 'club échangiste', '69 avenue des roustons', 33655555555),
	(3, 'club sd stip tease', '38 rue des boobs', 33699999999);
/*!40000 ALTER TABLE `club` ENABLE KEYS */;


-- Export de la structure de table dahouet. commissaires
CREATE TABLE IF NOT EXISTS `commissaires` (
  `ID_COMMISSAIRE` int(11) NOT NULL,
  `COM_REG` varchar(15) NOT NULL,
  PRIMARY KEY (`ID_COMMISSAIRE`),
  CONSTRAINT `FK_commissaires_personne` FOREIGN KEY (`ID_COMMISSAIRE`) REFERENCES `personne` (`ID_PERSONNE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.commissaires: ~3 rows (environ)
DELETE FROM `commissaires`;
/*!40000 ALTER TABLE `commissaires` DISABLE KEYS */;
INSERT INTO `commissaires` (`ID_COMMISSAIRE`, `COM_REG`) VALUES
	(21, 'Avalanche\r'),
	(22, 'Gaia\r'),
	(23, 'Spira\r');
/*!40000 ALTER TABLE `commissaires` ENABLE KEYS */;


-- Export de la structure de table dahouet. commission_de_course
CREATE TABLE IF NOT EXISTS `commission_de_course` (
  `ID_COM` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PRES` int(11) NOT NULL,
  PRIMARY KEY (`ID_COM`),
  KEY `FK_commission_de_course_commissaires` (`ID_PRES`),
  CONSTRAINT `FK_commission_de_course_commissaires` FOREIGN KEY (`ID_PRES`) REFERENCES `commissaires` (`ID_COMMISSAIRE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.commission_de_course: ~2 rows (environ)
DELETE FROM `commission_de_course`;
/*!40000 ALTER TABLE `commission_de_course` DISABLE KEYS */;
INSERT INTO `commission_de_course` (`ID_COM`, `ID_PRES`) VALUES
	(1, 21),
	(2, 22);
/*!40000 ALTER TABLE `commission_de_course` ENABLE KEYS */;


-- Export de la structure de table dahouet. fait_partie2
CREATE TABLE IF NOT EXISTS `fait_partie2` (
  `ID_COM` int(11) NOT NULL,
  `ID_COMMISSAIRE` int(11) NOT NULL,
  PRIMARY KEY (`ID_COMMISSAIRE`),
  CONSTRAINT `FK_fait_partie2_commissaires` FOREIGN KEY (`ID_COMMISSAIRE`) REFERENCES `commissaires` (`ID_COMMISSAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.fait_partie2: ~3 rows (environ)
DELETE FROM `fait_partie2`;
/*!40000 ALTER TABLE `fait_partie2` DISABLE KEYS */;
INSERT INTO `fait_partie2` (`ID_COM`, `ID_COMMISSAIRE`) VALUES
	(1, 21),
	(2, 22),
	(1, 23);
/*!40000 ALTER TABLE `fait_partie2` ENABLE KEYS */;


-- Export de la structure de procedure dahouet. LISTE_EQUIPAGE
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `LISTE_EQUIPAGE`(IN `id_regate` INT, IN `id_voile` INT)
BEGIN
select membre_d_equipage.ID_MEMBRE, membre_d_equipage.NOM_MEMBRE, membre_d_equipage.NUM_LICENCE,regate.NOM_REG,regate.DATE_REGATE,voilier.NOM_VOILE,participation.ID_SKIPPER
from membre_d_equipage inner join participe on membre_d_equipage.ID_MEMBRE=participe.ID_MEMBRE
inner join participation on participe.ID_PART=participation.ID_PART
inner join regate on participation.CODE_RE = regate.CODE_RE
inner join voilier on participation.NUM_VOILE = voilier.NUM_VOILE
where regate.CODE_RE = id_regate and voilier.NUM_VOILE = id_voile
order by membre_d_equipage.ID_MEMBRE asc;
END//
DELIMITER ;


-- Export de la structure de procedure dahouet. LISTE_INTERVENTION
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `LISTE_INTERVENTION`(IN `debut_controle` DATE, IN `fin_controle` DATE, IN `num_challenge` INT)
BEGIN
select regate.NOM_REG,regate.DATE_REGATE,commissaires.NOM,commissaires.COM_REG, participation.STATUT_ARRIV from
regate inner join commission_de_course on regate.ID_COM = commission_de_course.ID_COM
inner join fait_partie2 on commission_de_course.ID_COM = fait_partie2.ID_COM
inner join commissaires on fait_partie2.ID_COMMISSAIRE = commissaires.ID_COMMISSAIRE
inner join participation on regate.CODE_RE = participation.CODE_RE
where regate.DATE_REGATE between debut_controle and fin_controle 
and regate.ID_CHALL = num_challenge
and participation.STATUT_ARRIV is not null;
END//
DELIMITER ;


-- Export de la structure de table dahouet. membre_d_equipage
CREATE TABLE IF NOT EXISTS `membre_d_equipage` (
  `ID_MEMBRE` int(11) NOT NULL AUTO_INCREMENT,
  `NUM_LICENCE` bigint(20) DEFAULT NULL,
  `ANNEE_LICENCE` int(11) DEFAULT NULL,
  `DATE_MEMBRE` date DEFAULT NULL,
  `POINTS_FFV` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_MEMBRE`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.membre_d_equipage: ~15 rows (environ)
DELETE FROM `membre_d_equipage`;
/*!40000 ALTER TABLE `membre_d_equipage` DISABLE KEYS */;
INSERT INTO `membre_d_equipage` (`ID_MEMBRE`, `NUM_LICENCE`, `ANNEE_LICENCE`, `DATE_MEMBRE`, `POINTS_FFV`) VALUES
	(1, 111111, 20160101, '1987-01-13', NULL),
	(2, 123456, 20160102, '1987-01-14', NULL),
	(3, 234567, 20160103, '1987-01-15', NULL),
	(4, 345678, 20160104, '1987-01-16', NULL),
	(5, 456789, 20160101, '1987-01-17', NULL),
	(6, 222222, 20160102, '1987-01-18', NULL),
	(7, 333333, 20160103, '1987-01-19', NULL),
	(8, 444444, 20160104, '1987-01-20', NULL),
	(9, 555555, 20160105, '1987-01-21', NULL),
	(10, 666666, 20160106, '1987-01-22', NULL),
	(11, 777777, 20160107, '1987-01-23', NULL),
	(12, 888888, 20160108, '1987-01-24', NULL),
	(13, 999999, 20160109, '1987-01-25', NULL),
	(14, 987654, 20160110, '1987-01-26', NULL),
	(15, 654321, 20160108, '1987-01-27', NULL);
/*!40000 ALTER TABLE `membre_d_equipage` ENABLE KEYS */;


-- Export de la structure de procedure dahouet. MOYENNE_DISTANCE
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `MOYENNE_DISTANCE`(IN `num_chall` INT)
BEGIN
select challenge.ID_CHALL,challenge.NOM_CHALL,
challenge.ANNEE,(sum(regate.DISTANCE)) /(count( regate.ID_CHALL)) as moyenne_distance
from challenge
inner join regate on challenge.ID_CHALL=regate.ID_CHALL
where challenge.ID_CHALL=num_chall;
END//
DELIMITER ;


-- Export de la structure de table dahouet. participation
CREATE TABLE IF NOT EXISTS `participation` (
  `ID_PART` int(11) NOT NULL AUTO_INCREMENT,
  `ID_SKIPPER` int(11) NOT NULL,
  `CODE_RE` int(11) NOT NULL,
  `NUM_VOILE` int(11) NOT NULL,
  `H_DEP` time DEFAULT NULL,
  `STATUT_DEP` char(3) DEFAULT NULL,
  `H_ARRIV` time DEFAULT NULL,
  `STATUT_ARRIV` char(3) DEFAULT NULL,
  `CLASSEMENT_FINAL` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_PART`),
  KEY `FK_participation_regate` (`CODE_RE`),
  KEY `FK_participation_membre_d_equipage` (`ID_SKIPPER`),
  KEY `FK_participation_voilier` (`NUM_VOILE`),
  CONSTRAINT `FK_participation_voilier` FOREIGN KEY (`NUM_VOILE`) REFERENCES `voilier` (`NUM_VOILE`),
  CONSTRAINT `FK_participation_regate` FOREIGN KEY (`CODE_RE`) REFERENCES `regate` (`CODE_RE`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.participation: ~20 rows (environ)
DELETE FROM `participation`;
/*!40000 ALTER TABLE `participation` DISABLE KEYS */;
INSERT INTO `participation` (`ID_PART`, `ID_SKIPPER`, `CODE_RE`, `NUM_VOILE`, `H_DEP`, `STATUT_DEP`, `H_ARRIV`, `STATUT_ARRIV`, `CLASSEMENT_FINAL`) VALUES
	(1, 1, 1, 1, '11:00:00', NULL, '15:00:00', NULL, NULL),
	(2, 4, 1, 2, '12:00:00', NULL, '16:00:00', NULL, NULL),
	(3, 7, 1, 3, '13:00:00', NULL, '17:00:00', 'DNF', NULL),
	(4, 10, 1, 4, '14:00:00', NULL, '18:00:00', NULL, NULL),
	(5, 13, 1, 5, '15:00:00', NULL, '19:00:00', NULL, NULL),
	(6, 1, 2, 1, '16:00:00', NULL, '20:00:00', NULL, NULL),
	(7, 4, 2, 2, '17:00:00', NULL, '21:00:00', NULL, NULL),
	(8, 7, 2, 3, '18:00:00', NULL, '22:00:00', 'DSQ', NULL),
	(9, 10, 2, 4, '19:00:00', NULL, '23:00:00', NULL, NULL),
	(10, 13, 2, 5, '20:00:00', NULL, '00:00:00', NULL, NULL),
	(11, 1, 3, 1, '21:00:00', NULL, '01:00:00', NULL, 3),
	(12, 4, 3, 2, '22:00:00', NULL, '02:00:00', NULL, 5),
	(13, 7, 3, 3, '23:00:00', NULL, '03:00:00', NULL, 1),
	(14, 10, 3, 4, '00:00:00', NULL, '04:00:00', NULL, 4),
	(15, 13, 3, 5, '01:00:00', NULL, '05:00:00', NULL, 2),
	(16, 1, 4, 1, '02:00:00', NULL, '06:00:00', NULL, 2),
	(17, 4, 4, 2, '03:00:00', NULL, '07:00:00', NULL, 5),
	(18, 7, 4, 3, '04:00:00', NULL, '08:00:00', NULL, 4),
	(19, 10, 4, 4, '05:00:00', NULL, '09:00:00', NULL, 1),
	(20, 13, 4, 5, '06:00:00', NULL, '10:00:00', NULL, 3);
/*!40000 ALTER TABLE `participation` ENABLE KEYS */;


-- Export de la structure de table dahouet. participe
CREATE TABLE IF NOT EXISTS `participe` (
  `ID_PART` int(11) NOT NULL,
  `ID_MEMBRE` int(11) NOT NULL,
  PRIMARY KEY (`ID_PART`,`ID_MEMBRE`),
  KEY `FK_participe_membre_d_equipage` (`ID_MEMBRE`),
  CONSTRAINT `FK_participe_membre_d_equipage` FOREIGN KEY (`ID_MEMBRE`) REFERENCES `membre_d_equipage` (`ID_MEMBRE`),
  CONSTRAINT `FK_participe_participation` FOREIGN KEY (`ID_PART`) REFERENCES `participation` (`ID_PART`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.participe: ~60 rows (environ)
DELETE FROM `participe`;
/*!40000 ALTER TABLE `participe` DISABLE KEYS */;
INSERT INTO `participe` (`ID_PART`, `ID_MEMBRE`) VALUES
	(1, 1),
	(6, 1),
	(11, 1),
	(16, 1),
	(1, 2),
	(6, 2),
	(11, 2),
	(16, 2),
	(1, 3),
	(6, 3),
	(11, 3),
	(16, 3),
	(2, 4),
	(7, 4),
	(12, 4),
	(17, 4),
	(2, 5),
	(7, 5),
	(12, 5),
	(17, 5),
	(2, 6),
	(7, 6),
	(12, 6),
	(17, 6),
	(3, 7),
	(8, 7),
	(13, 7),
	(18, 7),
	(3, 8),
	(8, 8),
	(13, 8),
	(18, 8),
	(3, 9),
	(8, 9),
	(13, 9),
	(18, 9),
	(4, 10),
	(9, 10),
	(14, 10),
	(19, 10),
	(4, 11),
	(9, 11),
	(14, 11),
	(19, 11),
	(4, 12),
	(9, 12),
	(14, 12),
	(19, 12),
	(5, 13),
	(10, 13),
	(15, 13),
	(20, 13),
	(5, 14),
	(10, 14),
	(15, 14),
	(20, 14),
	(5, 15),
	(10, 15),
	(15, 15),
	(20, 15);
/*!40000 ALTER TABLE `participe` ENABLE KEYS */;


-- Export de la structure de table dahouet. personne
CREATE TABLE IF NOT EXISTS `personne` (
  `ID_PERSONNE` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_PERSONNE` varchar(20) DEFAULT NULL,
  `PRENOM_PERS` varchar(20) DEFAULT NULL,
  `MAIL` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_PERSONNE`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.personne: ~22 rows (environ)
DELETE FROM `personne`;
/*!40000 ALTER TABLE `personne` DISABLE KEYS */;
INSERT INTO `personne` (`ID_PERSONNE`, `NOM_PERSONNE`, `PRENOM_PERS`, `MAIL`) VALUES
	(1, 'MONKEY D.', 'LUFFY', 'pirateking@grandline .net'),
	(2, 'DOROBONEKO', 'NAMI', 'catburglar@grandline.net'),
	(3, 'TONITONI', 'CHOPPER', 'tanuki@grandline.net'),
	(4, 'NEWGATE', 'EDWARD', 'whitebeard@newworld.com'),
	(5, 'PORTGAS', 'ACE', 'firefist@newworld.com'),
	(6, 'PICSOU', 'BALTHAZAR', 'moremoney@ducktown.dys'),
	(7, 'DUCK', 'DONALD', 'chochon@ducktown.dys'),
	(8, 'JONES', 'FLAGADA', 'jackass@ducktown.dys'),
	(9, 'LEROUX', 'SHANKS\r\n', 'onearm@yonkou.gouv'),
	(10, 'SOGEKI', 'YASSOP\r\n', 'sniper@yonkou.gouv'),
	(11, 'BECKMAN', 'BEN ', 'smatass@yonkou.gouv'),
	(12, 'JONES', 'DAVY ', 'kraken@atlantis.com'),
	(13, 'DECKEN', 'VANDER', 'stalker@atlantis.com'),
	(14, 'GYOJIN', 'ARLONG', 'sharl@atlantis.com'),
	(15, 'JEWELRY', 'BONNEY', 'bigeater@newworld.com'),
	(16, 'JOBS', 'STEEVE ', 'sjobs@apple.com'),
	(17, ' ZUCKERBERG', 'MARK\r\n', 'mzuck@facebook.com'),
	(18, 'BETANCOURT', 'INGRID ', 'ibeth@loreal.fr'),
	(19, 'TAPIE', 'BERNARD ', 'btapie@addidas.net'),
	(21, 'KRAMER', 'CID\r\n', 'ckramer@midgard.gouv'),
	(22, 'STEINER', 'EDWARD', 'esteiner@alexandria.fr'),
	(23, 'ZANAR', 'AURON', 'zauron@luca.com');
/*!40000 ALTER TABLE `personne` ENABLE KEYS */;


-- Export de la structure de table dahouet. proprietaire
CREATE TABLE IF NOT EXISTS `proprietaire` (
  `NUM_PROPR` int(11) NOT NULL,
  `NUM_CLUB` int(11) NOT NULL,
  `ADRESSE_PROPR` varchar(50) NOT NULL,
  `TEL_PROPR` bigint(20) NOT NULL,
  PRIMARY KEY (`NUM_PROPR`),
  KEY `FK_proprietaire_club` (`NUM_CLUB`),
  CONSTRAINT `FK_proprietaire_club` FOREIGN KEY (`NUM_CLUB`) REFERENCES `club` (`NUM_CLUB`),
  CONSTRAINT `FK_proprietaire_personne` FOREIGN KEY (`NUM_PROPR`) REFERENCES `personne` (`ID_PERSONNE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.proprietaire: ~4 rows (environ)
DELETE FROM `proprietaire`;
/*!40000 ALTER TABLE `proprietaire` DISABLE KEYS */;
INSERT INTO `proprietaire` (`NUM_PROPR`, `NUM_CLUB`, `ADRESSE_PROPR`, `TEL_PROPR`) VALUES
	(16, 3, '22 avenue des escrocs ENFER', 33612345678),
	(17, 1, '4 boulevard de la pub NEW YORK', 33559626715),
	(18, 1, '45 impasse alzheimer PARIS', 33229666666),
	(19, 3, '25 rue Bomettes MARSEILLE', 33198765432);
/*!40000 ALTER TABLE `proprietaire` ENABLE KEYS */;


-- Export de la structure de table dahouet. regate
CREATE TABLE IF NOT EXISTS `regate` (
  `CODE_RE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CHALL` int(11) NOT NULL,
  `ID_COM` int(11) NOT NULL,
  `NOM_REG` varchar(20) NOT NULL,
  `DATE_REGATE` date NOT NULL,
  `DISTANCE` decimal(6,3) DEFAULT NULL,
  `D_VENT` varchar(3) DEFAULT NULL,
  `I_VENT` smallint(6) DEFAULT NULL,
  `D_COURANT` varchar(3) DEFAULT NULL,
  `V_COURANT` smallint(6) DEFAULT NULL,
  `ETAT_MER` varchar(10) DEFAULT NULL,
  `CAP` varchar(3) DEFAULT NULL,
  `L_BORD` decimal(6,3) DEFAULT NULL,
  `COURUE` char(1) DEFAULT NULL,
  PRIMARY KEY (`CODE_RE`),
  KEY `FK_regate_commission_de_course` (`ID_COM`),
  KEY `FK_regate_challenge` (`ID_CHALL`),
  CONSTRAINT `FK_regate_challenge` FOREIGN KEY (`ID_CHALL`) REFERENCES `challenge` (`ID_CHALL`),
  CONSTRAINT `FK_regate_commission_de_course` FOREIGN KEY (`ID_COM`) REFERENCES `commission_de_course` (`ID_COM`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.regate: ~4 rows (environ)
DELETE FROM `regate`;
/*!40000 ALTER TABLE `regate` DISABLE KEYS */;
INSERT INTO `regate` (`CODE_RE`, `ID_CHALL`, `ID_COM`, `NOM_REG`, `DATE_REGATE`, `DISTANCE`, `D_VENT`, `I_VENT`, `D_COURANT`, `V_COURANT`, `ETAT_MER`, `CAP`, `L_BORD`, `COURUE`) VALUES
	(1, 1, 1, 'ST BRIEUC ', '2015-07-12', 10.500, 'S', 15, 'E', 12, 'calme', 'NE', 3.100, 'y'),
	(2, 1, 2, 'BREST', '2015-05-13', 12.200, 'N', 17, 'SE', 14, 'houleuse', 'S', 2.500, 'y'),
	(3, 2, 1, 'ST BRIEUC ', '2014-11-14', 11.600, 'NO', 29, 'ONO', 13, 'agitée', 'SO', 3.200, 'n'),
	(4, 2, 1, 'ST BRIEUC ', '2014-12-15', 13.100, 'SSE', 22, 'ESE', 16, 'houleuse', 'NNO', 1.200, 'n');
/*!40000 ALTER TABLE `regate` ENABLE KEYS */;


-- Export de la structure de table dahouet. serie
CREATE TABLE IF NOT EXISTS `serie` (
  `NUM_SERIE` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_SERIE` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`NUM_SERIE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.serie: ~2 rows (environ)
DELETE FROM `serie`;
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
INSERT INTO `serie` (`NUM_SERIE`, `NOM_SERIE`) VALUES
	(1, 'habitable'),
	(2, 'sport');
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;


-- Export de la structure de table dahouet. voilier
CREATE TABLE IF NOT EXISTS `voilier` (
  `NUM_VOILE` int(11) NOT NULL AUTO_INCREMENT,
  `NUM_CLASSE` int(11) NOT NULL,
  `NUM_PROPR` int(11) NOT NULL,
  `NOM_VOILE` varchar(50) NOT NULL,
  `COEFF` decimal(4,4) NOT NULL,
  PRIMARY KEY (`NUM_VOILE`),
  KEY `FK_voilier_proprietaire` (`NUM_PROPR`),
  KEY `FK_voilier_classe` (`NUM_CLASSE`),
  CONSTRAINT `FK_voilier_classe` FOREIGN KEY (`NUM_CLASSE`) REFERENCES `classe` (`NUM_CLASSE`),
  CONSTRAINT `FK_voilier_proprietaire` FOREIGN KEY (`NUM_PROPR`) REFERENCES `proprietaire` (`NUM_PROPR`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Export de données de la table dahouet.voilier: ~5 rows (environ)
DELETE FROM `voilier`;
/*!40000 ALTER TABLE `voilier` DISABLE KEYS */;
INSERT INTO `voilier` (`NUM_VOILE`, `NUM_CLASSE`, `NUM_PROPR`, `NOM_VOILE`, `COEFF`) VALUES
	(1, 1, 16, 'RED FORCE', 0.5690),
	(2, 3, 17, 'MOBY DICK', 0.7460),
	(3, 8, 18, 'FLYING DUTCHMAN', 0.6320),
	(4, 7, 19, 'SUNNY-GO', 0.3210),
	(5, 2, 16, 'MERRY-GO', 0.4560);
/*!40000 ALTER TABLE `voilier` ENABLE KEYS */;


-- Export de la structure de déclancheur dahouet. participation_before_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `participation_before_update` BEFORE UPDATE ON `participation` FOR EACH ROW BEGIN
declare nbpart int;
declare error condition for sqlstate '45001';


select count(old.NUM_VOILE) from participation where new.CODE_RE=CODE_RE
into nbpart;
if(new.CLASSEMENT_FINAL>nbpart)
then signal error
set message_text =' ┌П┐（︶︿︶）┌П┐ ', mysql_errno=9002;
end if; 
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Export de la structure de déclancheur dahouet. regate_before_delete
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `regate_before_delete` BEFORE DELETE ON `regate` FOR EACH ROW BEGIN
declare over date;
declare error condition for sqlstate '45001';
select challenge.DATE_FIN from challenge where old.ID_CHALL=challenge.ID_CHALL into over;
if (curdate()<=over) then 
signal error
set message_text='Le challenge est pas terminé Ducon!',mysql_errno=9002;
end if;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Export de la structure de déclancheur dahouet. regate_before_insert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `regate_before_insert` BEFORE INSERT ON `regate` FOR EACH ROW BEGIN
declare datedeb date;
declare datefin date;
declare error condition for sqlstate '45001';

select challenge.DATE_DEBUT into datedeb from challenge where 
new.ID_CHALL = challenge.ID_CHALL;
select challenge.DATE_FIN into datefin from challenge where 
new.ID_CHALL = challenge.ID_CHALL;
if( new.DATE_REGATE not BETWEEN datedeb and datefin)
then signal error
set message_text =' ┌П┐（︶︿︶）┌П┐ ', mysql_errno=9002;
end if; 

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Export de la structure de déclancheur dahouet. regate_before_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `regate_before_update` BEFORE UPDATE ON `regate` FOR EACH ROW BEGIN
declare datedeb date;
declare datefin date;
declare error condition for sqlstate '45001';

select challenge.DATE_DEBUT into datedeb from challenge where 
new.ID_CHALL = challenge.ID_CHALL;
select challenge.DATE_FIN into datefin from challenge where 
new.ID_CHALL = challenge.ID_CHALL;
if( new.DATE_REGATE not BETWEEN datedeb and datefin)
then signal error
set message_text =' ┌П┐（︶︿︶）┌П┐ ', mysql_errno=9002;
end if; 
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

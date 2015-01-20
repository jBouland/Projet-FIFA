-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 20 Janvier 2015 à 23:35
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `fifa`
--

-- --------------------------------------------------------

--
-- Structure de la table `arbitre`
--

CREATE TABLE IF NOT EXISTS `arbitre` (
  `idArbitre` int(11) NOT NULL AUTO_INCREMENT,
  `nomArbitre` text NOT NULL,
  `idPays` int(11) NOT NULL,
  PRIMARY KEY (`idArbitre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `championnat`
--

CREATE TABLE IF NOT EXISTS `championnat` (
  `idCompetition` int(11) NOT NULL AUTO_INCREMENT,
  `idPays` int(11) NOT NULL,
  `nomChampionnat` text NOT NULL,
  `saison` int(11) NOT NULL,
  `typeChampionnat` int(11) NOT NULL,
  PRIMARY KEY (`idCompetition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `coupe`
--

CREATE TABLE IF NOT EXISTS `coupe` (
  `idCompetition` int(11) NOT NULL AUTO_INCREMENT,
  `idPays` int(11) NOT NULL,
  `nomCoupe` text NOT NULL,
  `typeCoupe` int(11) NOT NULL,
  `saison` int(11) NOT NULL,
  PRIMARY KEY (`idCompetition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `coupeeurope`
--

CREATE TABLE IF NOT EXISTS `coupeeurope` (
  `idCompetition` int(11) NOT NULL AUTO_INCREMENT,
  `nomCoupeEurope` text NOT NULL,
  `saison` int(11) NOT NULL,
  PRIMARY KEY (`idCompetition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE IF NOT EXISTS `equipe` (
  `idEquipe` int(11) NOT NULL AUTO_INCREMENT,
  `idPays` int(11) NOT NULL,
  `nomEquipe` text NOT NULL,
  `classementAnneePrecedente` int(11) DEFAULT NULL,
  `vainqueurCoupe` int(11) DEFAULT NULL,
  `idChampionnat` int(11) NOT NULL,
  `idCoupe1` int(11) DEFAULT NULL,
  `idCoupe2` int(11) DEFAULT NULL,
  `idCoupeEurope` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEquipe`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=95 ;

--
-- Contenu de la table `equipe`
--

INSERT INTO `equipe` (`idEquipe`, `idPays`, `nomEquipe`, `classementAnneePrecedente`, `vainqueurCoupe`, `idChampionnat`, `idCoupe1`, `idCoupe2`, `idCoupeEurope`) VALUES
(1, 4, 'Paris', 1, 1, 0, NULL, NULL, NULL),
(2, 4, 'Monaco', 2, 0, 0, NULL, NULL, NULL),
(3, 4, 'Lille', 3, 0, 0, NULL, NULL, NULL),
(4, 4, 'Saint-Etienne', 4, 0, 0, NULL, NULL, NULL),
(5, 4, 'Lyon', 5, 0, 0, NULL, NULL, NULL),
(6, 4, 'Marseille', 6, 0, 0, NULL, NULL, NULL),
(7, 4, 'Bordeaux', 7, 0, 0, NULL, NULL, NULL),
(8, 4, 'Lorient', 8, 0, 0, NULL, NULL, NULL),
(9, 4, 'Toulouse', 9, 0, 0, NULL, NULL, NULL),
(10, 4, 'Bastia', 10, 0, 0, NULL, NULL, NULL),
(11, 4, 'Reims', 11, 0, 0, NULL, NULL, NULL),
(12, 4, 'Rennes', 12, 0, 0, NULL, NULL, NULL),
(13, 4, 'Nantes', 13, 0, 0, NULL, NULL, NULL),
(14, 4, 'Evian', 14, 0, 0, NULL, NULL, NULL),
(15, 4, 'Montpellier', 15, 0, 0, NULL, NULL, NULL),
(16, 4, 'Guingamp', 16, 1, 0, NULL, NULL, NULL),
(17, 4, 'Nice', 17, 0, 0, NULL, NULL, NULL),
(18, 4, 'Lens', 0, 0, 0, NULL, NULL, NULL),
(19, 4, 'Caen', 0, 0, 0, NULL, NULL, NULL),
(20, 4, 'Metz', 0, 0, 0, NULL, NULL, NULL),
(23, 8, 'Manchester City', 1, 0, 0, NULL, NULL, NULL),
(24, 8, 'Liverpool', 2, 0, 0, NULL, NULL, NULL),
(25, 8, 'Chelsea', 3, 0, 0, NULL, NULL, NULL),
(26, 8, 'Arsenal', 4, 0, 0, NULL, NULL, NULL),
(27, 8, 'Everton', 5, 0, 0, NULL, NULL, NULL),
(28, 8, 'Tottenham', 6, 0, 0, NULL, NULL, NULL),
(29, 8, 'Manchester United', 7, 0, 0, NULL, NULL, NULL),
(30, 8, 'Southampton', 8, 0, 0, NULL, NULL, NULL),
(31, 8, 'Stoke City', 9, 0, 0, NULL, NULL, NULL),
(32, 8, 'Newcastle', 10, 0, 0, NULL, NULL, NULL),
(33, 8, 'Crystal Palace', 11, 0, 0, NULL, NULL, NULL),
(34, 8, 'Swansea', 12, 0, 0, NULL, NULL, NULL),
(35, 8, 'West Ham', 13, 0, 0, NULL, NULL, NULL),
(36, 8, 'Sunderland', 14, 0, 0, NULL, NULL, NULL),
(37, 8, 'Aston Villa', 15, 0, 0, NULL, NULL, NULL),
(38, 8, 'Hull City', 16, 0, 0, NULL, NULL, NULL),
(39, 8, 'West Bromwich Albion', 17, 0, 0, NULL, NULL, NULL),
(42, 8, 'Burnley', 0, 0, 0, NULL, NULL, NULL),
(43, 8, 'Leicester', 0, 0, 0, NULL, NULL, NULL),
(44, 8, 'Queens Park Rangers', 0, 0, 0, NULL, NULL, NULL),
(45, 1, 'Munich', 1, 1, 0, NULL, NULL, NULL),
(46, 1, 'Dortmund', 2, 1, 0, NULL, NULL, NULL),
(47, 1, 'Schalke', 3, 0, 0, NULL, NULL, NULL),
(48, 1, 'Leverkusen', 4, 0, 0, NULL, NULL, NULL),
(49, 1, 'Wolfsburg', 5, 0, 0, NULL, NULL, NULL),
(50, 1, 'Monchengladbach', 6, 0, 0, NULL, NULL, NULL),
(51, 1, 'Mayence', 7, 0, 0, NULL, NULL, NULL),
(52, 1, 'Augsbourg', 8, 0, 0, NULL, NULL, NULL),
(53, 1, 'Hoffenheim', 9, 0, 0, NULL, NULL, NULL),
(54, 1, 'Hanovre', 10, 0, 0, NULL, NULL, NULL),
(55, 1, 'Berlin', 11, 0, 0, NULL, NULL, NULL),
(56, 1, 'Breme', 12, 0, 0, NULL, NULL, NULL),
(57, 1, 'Francfort', 13, 0, 0, NULL, NULL, NULL),
(58, 1, 'Fribourg', 14, 0, 0, NULL, NULL, NULL),
(59, 1, 'Stuttgart', 15, 0, 0, NULL, NULL, NULL),
(60, 1, 'Hambourg', 16, 0, 0, NULL, NULL, NULL),
(61, 1, 'Paderbon', 0, 0, 0, NULL, NULL, NULL),
(62, 1, 'Cologne', 0, 0, 0, NULL, NULL, NULL),
(63, 7, 'Juventus', 1, 1, 0, NULL, NULL, NULL),
(64, 7, 'AS Rome', 2, 0, 0, NULL, NULL, NULL),
(65, 7, 'Naples', 3, 1, 0, NULL, NULL, NULL),
(66, 7, 'Florence', 4, 0, 0, NULL, NULL, NULL),
(67, 7, 'Inter Milan', 5, 0, 0, NULL, NULL, NULL),
(68, 7, 'Parme', 6, 0, 0, NULL, NULL, NULL),
(69, 7, 'Torino', 7, 0, 0, NULL, NULL, NULL),
(70, 7, 'AC Milan', 8, 0, 0, NULL, NULL, NULL),
(71, 7, 'Lazio Rome', 9, 0, 0, NULL, NULL, NULL),
(72, 7, 'Vérone', 10, 0, 0, NULL, NULL, NULL),
(73, 7, 'Bergame', 11, 0, 0, NULL, NULL, NULL),
(74, 7, 'Genoe', 13, 0, 0, NULL, NULL, NULL),
(75, 7, 'Udinese', 14, 0, 0, NULL, NULL, NULL),
(76, 7, 'Sampdoria', 12, 0, 0, NULL, NULL, NULL),
(77, 7, 'Cagliari', 15, 0, 0, NULL, NULL, NULL),
(78, 7, 'Chievo Vérone', 16, 0, 0, NULL, NULL, NULL),
(79, 7, 'Sassuolo', 17, 0, 0, NULL, NULL, NULL),
(80, 7, 'Palerme', 0, 0, 0, NULL, NULL, NULL),
(81, 7, 'Genes', 0, 0, 0, NULL, NULL, NULL),
(82, 7, 'Empoli', 0, 0, 0, NULL, NULL, NULL),
(83, 6, 'Atletico Madrid', 1, 0, 0, NULL, NULL, NULL),
(84, 6, 'Barcelone', 2, 1, 0, NULL, NULL, NULL),
(85, 6, 'Real Madrid', 3, 1, 0, NULL, NULL, NULL),
(86, 6, 'Bilbao', 4, 0, 0, NULL, NULL, NULL),
(87, 6, 'Seville', 5, 0, 0, NULL, NULL, NULL),
(88, 6, 'Villarreal', 6, 0, 0, NULL, NULL, NULL),
(89, 6, 'Real Sociedad', 7, 0, 0, NULL, NULL, NULL),
(90, 6, 'Valence', 8, 0, 0, NULL, NULL, NULL),
(91, 6, 'Vigo', 9, 0, 0, NULL, NULL, NULL),
(92, 6, 'Levante', 10, 0, 0, NULL, NULL, NULL),
(93, 6, 'Malaga', 11, 0, 0, NULL, NULL, NULL),
(94, 6, 'Vallecano', 12, 0, 0, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `journee`
--

CREATE TABLE IF NOT EXISTS `journee` (
  `idJournee` int(11) NOT NULL AUTO_INCREMENT,
  `idCompetition` int(11) NOT NULL,
  `dateDebut` date DEFAULT NULL,
  `dateFin` date DEFAULT NULL,
  PRIMARY KEY (`idJournee`,`idCompetition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `match`
--

CREATE TABLE IF NOT EXISTS `match` (
  `idMatch` int(11) NOT NULL,
  `idJournee` int(11) NOT NULL,
  `idEquipe1` int(11) NOT NULL,
  `idEquipe2` int(11) NOT NULL,
  `scoreEquipe1` int(11) DEFAULT NULL,
  `scoreEquipe2` int(11) DEFAULT NULL,
  `dateMatch` int(11) DEFAULT NULL,
  `numPoule` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMatch`,`idJournee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

CREATE TABLE IF NOT EXISTS `pays` (
  `idPays` int(11) NOT NULL AUTO_INCREMENT,
  `nomPays` text NOT NULL,
  `nbEquipeLDC` int(11) NOT NULL,
  `nbEquipeEL` int(11) NOT NULL,
  PRIMARY KEY (`idPays`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `pays`
--

INSERT INTO `pays` (`idPays`, `nomPays`, `nbEquipeLDC`, `nbEquipeEL`) VALUES
(1, 'Allemagne', 4, 2),
(2, 'Belgique', 2, 2),
(3, 'Portugal', 3, 2),
(4, 'France', 2, 3),
(5, 'Pays-Bas', 2, 1),
(6, 'Espagne', 4, 2),
(7, 'Italie', 2, 4),
(8, 'Angleterre', 4, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

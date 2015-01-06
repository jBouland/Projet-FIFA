-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 06 Janvier 2015 à 08:58
-- Version du serveur :  5.6.21
-- Version de PHP :  5.6.3

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
  `idPays` int(11) NOT NULL,
`idArbitre` int(11) NOT NULL,
  `nomArbitre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE IF NOT EXISTS `equipe` (
  `idPays` int(11) NOT NULL,
`idEquipe` int(11) NOT NULL,
  `nomEquipe` text NOT NULL,
  `classementSaisonPrecedente` int(11) NOT NULL,
  `vainqueurCoupe` tinyint(1) NOT NULL,
  `ligue` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `equipe`
--

INSERT INTO `equipe` (`idPays`, `idEquipe`, `nomEquipe`, `classementSaisonPrecedente`, `vainqueurCoupe`, `ligue`) VALUES
(4, 1, 'Paris', 1, 1, 1),
(4, 2, 'Monaco', 2, 0, 1),
(4, 3, 'Lille', 3, 0, 1),
(4, 4, 'Saint-Etienne', 4, 0, 1),
(4, 5, 'Lyon', 5, 0, 1),
(4, 6, 'Marseille', 6, 0, 1),
(4, 7, 'Bordeaux', 7, 0, 1),
(4, 8, 'Lorient', 8, 0, 1),
(4, 9, 'Toulouse', 9, 0, 1),
(4, 10, 'Bastia', 10, 0, 1),
(4, 11, 'Reims', 11, 0, 1),
(4, 12, 'Rennes', 12, 0, 1),
(4, 13, 'Nantes', 13, 0, 1),
(4, 14, 'Evian', 14, 0, 1),
(4, 15, 'Montpellier', 15, 0, 1),
(4, 16, 'Guingamp', 16, 1, 1),
(4, 17, 'Nice', 17, 0, 1),
(4, 18, 'Lens', 0, 0, 1),
(4, 19, 'Caen', 0, 0, 1),
(4, 20, 'Metz', 0, 0, 1),
(8, 23, 'Manchester City', 1, 0, 1),
(8, 24, 'Liverpool', 2, 0, 1),
(8, 25, 'Chelsea', 3, 0, 1),
(8, 26, 'Arsenal', 4, 0, 1),
(8, 27, 'Everton', 5, 0, 1),
(8, 28, 'Tottenham', 6, 0, 1),
(8, 29, 'Manchester United', 7, 0, 1),
(8, 30, 'Southampton', 8, 0, 1),
(8, 31, 'Stoke City', 9, 0, 1),
(8, 32, 'Newcastle', 10, 0, 1),
(8, 33, 'Crystal Palace', 11, 0, 1),
(8, 34, 'Swansea', 12, 0, 1),
(8, 35, 'West Ham', 13, 0, 1),
(8, 36, 'Sunderland', 14, 0, 1),
(8, 37, 'Aston Villa', 15, 0, 1),
(8, 38, 'Hull City', 16, 0, 1),
(8, 39, 'West Bromwich Albion', 17, 0, 1),
(8, 42, 'Burnley', 0, 0, 1),
(8, 43, 'Leicester', 0, 0, 1),
(8, 44, 'Queens Park Rangers', 0, 0, 1),
(1, 45, 'Munich', 1, 1, 1),
(1, 46, 'Dortmund', 2, 1, 1),
(1, 47, 'Schalke', 3, 0, 1),
(1, 48, 'Leverkusen', 4, 0, 1),
(1, 49, 'Wolfsburg', 5, 0, 1),
(1, 50, 'Monchengladbach', 6, 0, 1),
(1, 51, 'Mayence', 7, 0, 1),
(1, 52, 'Augsbourg', 8, 0, 1),
(1, 53, 'Hoffenheim', 9, 0, 1),
(1, 54, 'Hanovre', 10, 0, 1),
(1, 55, 'Berlin', 11, 0, 1),
(1, 56, 'Breme', 12, 0, 1),
(1, 57, 'Francfort', 13, 0, 1),
(1, 58, 'Fribourg', 14, 0, 1),
(1, 59, 'Stuttgart', 15, 0, 1),
(1, 60, 'Hambourg', 16, 0, 1),
(1, 61, 'Paderbon', 0, 0, 1),
(1, 62, 'Cologne', 0, 0, 1),
(7, 63, 'Juventus', 1, 1, 1),
(7, 64, 'AS Rome', 2, 0, 1),
(7, 65, 'Naples', 3, 1, 1),
(7, 66, 'Florence', 4, 0, 1),
(7, 67, 'Inter Milan', 5, 0, 1),
(7, 68, 'Parme', 6, 0, 1),
(7, 69, 'Torino', 7, 0, 1),
(7, 70, 'AC Milan', 8, 0, 1),
(7, 71, 'Lazio Rome', 9, 0, 1),
(7, 72, 'Vérone', 10, 0, 1),
(7, 73, 'Bergame', 11, 0, 1),
(7, 74, 'Genoe', 13, 0, 1),
(7, 75, 'Udinese', 14, 0, 1),
(7, 76, 'Sampdoria', 12, 0, 1),
(7, 77, 'Cagliari', 15, 0, 1),
(7, 78, 'Chievo Vérone', 16, 0, 1),
(7, 79, 'Sassuolo', 17, 0, 1),
(7, 80, 'Palerme', 0, 0, 1),
(7, 81, 'Genes', 0, 0, 1),
(7, 82, 'Empoli', 0, 0, 1),
(6, 83, 'Atletico Madrid', 1, 0, 1),
(6, 84, 'Barcelone', 2, 1, 1),
(6, 85, 'Real Madrid', 3, 1, 1),
(6, 86, 'Bilbao', 4, 0, 1),
(6, 87, 'Seville', 5, 0, 1),
(6, 88, 'Villarreal', 6, 0, 1),
(6, 89, 'Real Sociedad', 7, 0, 1),
(6, 90, 'Valence', 8, 0, 1),
(6, 91, 'Vigo', 9, 0, 1),
(6, 92, 'Levante', 10, 0, 1),
(6, 93, 'Malaga', 11, 0, 1),
(6, 94, 'Vallecano', 12, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

CREATE TABLE IF NOT EXISTS `pays` (
`idPays` int(11) NOT NULL,
  `nomPays` text NOT NULL,
  `nbEquipeLDC` int(11) NOT NULL,
  `nbEquipeEL` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

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

--
-- Index pour les tables exportées
--

--
-- Index pour la table `arbitre`
--
ALTER TABLE `arbitre`
 ADD PRIMARY KEY (`idArbitre`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
 ADD PRIMARY KEY (`idEquipe`);

--
-- Index pour la table `pays`
--
ALTER TABLE `pays`
 ADD PRIMARY KEY (`idPays`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `arbitre`
--
ALTER TABLE `arbitre`
MODIFY `idArbitre` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
MODIFY `idEquipe` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=95;
--
-- AUTO_INCREMENT pour la table `pays`
--
ALTER TABLE `pays`
MODIFY `idPays` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

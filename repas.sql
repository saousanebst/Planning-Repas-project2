-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 03 mai 2024 à 00:41
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `repas`
--

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

CREATE TABLE `account` (
  `type_compte` enum('admin','user') NOT NULL,
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `lastname` varchar(40) NOT NULL,
  `password` varchar(120) NOT NULL,
  `firstname` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`type_compte`, `id`, `email`, `lastname`, `password`, `firstname`) VALUES
('user', 5, 'test.mail.com', 'Bardou', '123456', 'Hedieh'),
('admin', 6, 'test1.mail.com', 'BASTAOUI', '987654', 'Saousane');

-- --------------------------------------------------------

--
-- Structure de la table `food`
--

CREATE TABLE `food` (
  `id` int(11) NOT NULL,
  `creneau` enum('Petit_déjeuner','Déjeuner','Goûter','Dîner') NOT NULL,
  `date_debut` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `food_recettes`
--

CREATE TABLE `food_recettes` (
  `repas_id` int(11) NOT NULL,
  `recettes_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

CREATE TABLE `ingredient` (
  `id` int(11) NOT NULL,
  `label_ingredient` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ingredient`
--

INSERT INTO `ingredient` (`id`, `label_ingredient`) VALUES
(1, 'Pâte à pizza'),
(2, 'Sauce tomate'),
(3, 'Fromage rapé'),
(4, 'Eau pétillante'),
(5, 'Citrons'),
(6, 'Viande haché'),
(7, 'Fromage cheddar'),
(8, 'Cornichon'),
(9, 'Salade'),
(10, 'Tomate'),
(11, 'Glace au chocolat'),
(12, 'Farine'),
(13, 'Oeufs'),
(14, 'Lait'),
(15, 'Fraise'),
(16, 'Framboise ');

-- --------------------------------------------------------

--
-- Structure de la table `recipe`
--

CREATE TABLE `recipe` (
  `id` int(11) NOT NULL,
  `label_recipe` varchar(50) NOT NULL,
  `type_recette` enum('Entree','Plat','Dessert','Boisson') NOT NULL,
  `photo_recipe` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `recipe`
--

INSERT INTO `recipe` (`id`, `label_recipe`, `type_recette`, `photo_recipe`) VALUES
(1, 'Pizza', 'Entree', 'mask-group-9.png'),
(2, 'Martinez', 'Boisson', 'mask-group-10.png'),
(3, 'Citronnade', 'Boisson', 'mask-group-12.png'),
(4, 'Cheesecake speculoos', 'Dessert', 'mask-group-11.png'),
(5, 'Cheese Burger', 'Plat', 'mask-group-14.png'),
(6, 'Glace au Chocolat', 'Dessert', 'mask-group-13.png'),
(7, 'Pancakes', 'Dessert', 'mask-group-15.png');

-- --------------------------------------------------------

--
-- Structure de la table `recipe_instruction`
--

CREATE TABLE `recipe_instruction` (
  `id` int(11) NOT NULL,
  `quantity_ingredient` int(11) NOT NULL,
  `unite` enum('gramme','millilitre','quantite') NOT NULL,
  `ingredient` int(11) DEFAULT NULL,
  `recette` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_q0uja26qgu1atulenwup9rxyr` (`email`);

--
-- Index pour la table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `food_recettes`
--
ALTER TABLE `food_recettes`
  ADD UNIQUE KEY `UK_jk276l55wwhhjjjeewjgex0rg` (`recettes_id`),
  ADD KEY `FK5djmr7l9aklqwnecwmjp69sha` (`repas_id`);

--
-- Index pour la table `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `recipe`
--
ALTER TABLE `recipe`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `recipe_instruction`
--
ALTER TABLE `recipe_instruction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhe5edqr2l77ph6s0a40blsnt` (`ingredient`),
  ADD KEY `FKjvhwbc4e4c6lyodo41duuv7w5` (`recette`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `food`
--
ALTER TABLE `food`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `recipe`
--
ALTER TABLE `recipe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `recipe_instruction`
--
ALTER TABLE `recipe_instruction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `food_recettes`
--
ALTER TABLE `food_recettes`
  ADD CONSTRAINT `FK5djmr7l9aklqwnecwmjp69sha` FOREIGN KEY (`repas_id`) REFERENCES `food` (`id`),
  ADD CONSTRAINT `FK6peaytvbwf1o2wvdpvp6vu9x9` FOREIGN KEY (`recettes_id`) REFERENCES `recipe` (`id`);

--
-- Contraintes pour la table `recipe_instruction`
--
ALTER TABLE `recipe_instruction`
  ADD CONSTRAINT `FKhe5edqr2l77ph6s0a40blsnt` FOREIGN KEY (`ingredient`) REFERENCES `ingredient` (`id`),
  ADD CONSTRAINT `FKjvhwbc4e4c6lyodo41duuv7w5` FOREIGN KEY (`recette`) REFERENCES `recipe` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

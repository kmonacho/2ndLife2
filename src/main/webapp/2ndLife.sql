CREATE DATABASE 2ndLife2;
USE 2ndLife2;
CREATE TABLE `article` (
	`id` int(255) not null,
	`titre` varchar(255) NOT NULL,
	`description` mediumtext NOT NULL, 
	`adresse` varchar(100) NOT NULL, 
	`vendeur` varchar(100) NOT NULL, 
	`categorie` varchar(40) NOT NULL, 
	`prix` double NOT NULL, 
	`dateMEV` varchar(50) NOT NULL, 
	`img` varchar(255) NOT NULL, 
	`img2` varchar(255) NOT NULL, 
	`img3` varchar(255) NOT NULL, 
PRIMARY KEY (`id`),
UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB 
DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

 CREATE TABLE `login` (
	`username` varchar(150) NOT NULL,
	`password` varchar(150) NOT NULL, 
	`email` varchar(200) NOT NULL, 
	`prenom` varchar(200) NOT NULL, 
	`nom` varchar(200) NOT NULL, 
	`adresse` varcjar(1000) NOT NULL,
PRIMARY KEY (`username`),
UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `login` VALUES ('tom','yam','monachonk@gmail.com','Thomas','Grand', 'Ch. des Bruyères 11, 1007 Lausanne'),
('Stéphane','1Password$','monachonk@gmail.com','Silvain','Staufli','Av. Vinet 10, 1012 Lausanne'),
('Jazz','7Password&','monachonk@gmail.com','Nicolas','Geraldi', 'Rue de Cour 145, 1007 Lausanne');

 
 
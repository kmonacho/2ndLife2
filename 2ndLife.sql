CREATE DATABASE 2ndLife;
USE 2ndLife;
CREATE TABLE `article` (
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
PRIMARY KEY (`titre`),
UNIQUE KEY `titre` (`titre`)
) ENGINE=InnoDB 
DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `article` VALUES ('Lamborghini Countach 500S Wolf','Modèle neuf, Kit monté par maquettiste. Livré avec vitrine du fabricant.','Av. de la Gare 6, 1006 Lausanne.','Stéphane Goric','Véhicules',1950,'30.07.2023','lamborghini-countach-500s.jpg',
'lamborghini-countach-500s.jpg','lamborghini-countach-500s.jpg'),
('Perfecto similicuir','Veste style perfecto, polyester effet similicuir, poches, fermeture éclair,surpiqûre, 52cm de longueur. Neuf portée 1x, stockée dans une armoire.',
'Rue St-George 8, 1014 Lausanne.','Ivan Gérard','mode',10,'10.05.2023','perfecto-similicuir.jpg',
'perfecto-similicuir-1.jpg','perfecto-similicuir-2.jpg'),('BMW R1200 GS Rally 2018','Prix Moto expertisée seulement : CHF 13\'500 .- non négociable. Prix équipements seulement : CHF 1\'500.- non négociable. Prix Moto et équipements tout compris : CHF 14\'500 non négociable. BMW R1200 GS Rally, ABS PRO, tous les packs de conduite, 
 phares LED, shifter PRO, Top Case, tous les services fait chez BMW. Pot Akrapovic et pot d\'origine, sabot moteur changé,
 réhausseur de guidon Rizoma, châssis bas, selle basse, filtre à air amélioré, clignotants LED, protège phare Lone Rider, 
 extension béquille latérale, BMW Navigator VI. Prix d\'achat moto neuve tout compris : CHF 26\'300.-.Equipements :
 2 Casques Nexx TM \(57-58\) avec 1 intercomm Nexx, tenue BMW Enduro Guard \(veste T25 et pantalon T50\), bottes Forma Terra T44 
 (perso 42.5-43), bottes Rev\'It Discovery H2O T44, blouson BMW Venting T56, jeans BMW City T50, basket BMW T43, 
 basket Style Martin T42, basket TCX T42, Gilet Dainese D air Airbag TXL, gants hiver IXS Gore-tex TXL, gants BMW Gore-tex 
 Enduro double couche T10, gant été DXR T10, gant été Five5 Stunt Evo T10, sous-vêtements techniques hiver et été BMW Dainese 
 Craft, Motobags Lone Rider avec sacs étanches et lanières de rechange, tente Lone Rider, bâche de protection moto.',
 'Rue du Clos 105, 1300 Yvoire.','Arman Nozi','véhicule',13500,'01.03.2023','bmw-r1200-gs-rally-2018.jpg',
 'bmw-r1200-gs-rally-2018-1.jpg','bmw-r1200-gs-rally-2018-3.jpg'),('TV LG Plasma 50PQ2000',
 'TV LG Plasma, année 2010. En parfait état de fonctionnement. Petit défaut sur la télécommande uniquement (cf photo).',
 'Boulevard de Grancy 34, 1007 Lausanne.','Jean Anouvo','informatique',400,'17.02.2023','tv-lg-plasma-50pq2000.jpg',
 'tv-lg-plasma-50pq2000-1.jpg','tv-lg-plasma-50pq2000-2.jpg'),('ski atomic','skis avec fixation. La longueur est de 198 cm',
 'Rue de la Tour 23, 1005 Lausanne.','Stéphane Jasoni','Sport',159,'20.10.2022','ski-atomic.jpg','ski-atomic 8-1.jpg',
 'ski-atomic 8-2.jpg'),('Armoire','2 armoires modernes à portes coulissantes dans un très bon état (prix est pour 1 armoire).',
 'Rte de Genève 88, 1010 Lausanne','Cécil Vererli','menageEtMaison',220,'12.08.2019','armoire.jpg','armoire-1.jpg',
 'armoire-1.jpg'),('Grill Barbecue avec brûleur latéral',
 'Barbecue avec brûleur latéral. Si vous aimez gâter votre famille et vos invités avec des grillades, le barbecue à gaz ETNA est exactement ce qu\'il vous faut. Grâce aux quatre brûleurs réglables individuellement, vous pouvez répartir la chaleur de manière optimale sur la grille. Le thermomètre dans le couvercle vous permet de toujours garder un œil sur la température. La plaque de cuisson latérale pratique permet de préparer des sauces et des accompagnements. Savourez une viande parfaitement cuite et des légumes savoureux grâce à ce barbecue à gaz moderne!',
 'Avenue Vinet 12, 1009 Lausanne','Yvan Stockli','menageEtMaison',350,'17.12.2021','grill-barbecue-avec-bruleur-lateral.jpg',
 'grill-barbecue-avec-bruleur-lateral-1.jpg','grill-barbecue-avec-bruleur-lateral-2.jpg'),
 ('Lenovo ThinkPad X260','Win 11, i5-6300, 256GB SSD, 8GB RAM. Das Gerät bietet für die allermeisten "normalen" Benutzer ausreichend Leistung mit seinem i5-6300U Prozessor, 8GB RAM und der schnellen und 256GB grossen SSD. Die Full-HD-Auflösung \(1920x1080 Pixel\) gewährleisten ein produktives Arbeiten.',
 'Avenue de Cour 22, 1006 Lausanne','Armau Amonzi','Ordinateurs',420,'10.05.2023',
 'lenovo-thinkpad-x260.jpg','lenovo-thinkpad-x260-1.jpg',
 'lenovo-thinkpad-x260-2.jpg');
 
 CREATE TABLE `login` (
	`username` varchar(150) NOT NULL,
	`password` varchar(150) NOT NULL, 
	`email` varchar(200) NOT NULL, 
	`nom` varchar(200) NOT NULL, 
	`prenom` varchar(200) NOT NULL, 
PRIMARY KEY (`username`),
UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `login` VALUES ('tom','yam','monachonk@gmail.com','Thomas','Grand'),
('Stéphane','1Password$','monachonk@gmail.com','Silvain','Staufli'),
('Jazz','7Password&','monachonk@gmail.com','Nicolas','Geraldi');
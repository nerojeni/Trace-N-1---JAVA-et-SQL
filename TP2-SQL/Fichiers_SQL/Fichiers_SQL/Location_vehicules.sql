
-- Création de la table "Clients"
CREATE TABLE Clients (
    ID_Client INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(50),
    Prénom VARCHAR(50),
    Adresse VARCHAR(100),
    Numéro_Téléphone VARCHAR(20)
);

-- Création de la table "Véhicules"
CREATE TABLE Véhicules (
    ID_Véhicule INT PRIMARY KEY AUTO_INCREMENT,
    Marque VARCHAR(50),
    Modèle VARCHAR(50),
    Année_Fabrication INT,
    Plaque_Immatriculation VARCHAR(20),
    Prix_Loc_Journée DECIMAL(10, 2)
);

-- Création de la table "Employés"
CREATE TABLE Employés (
    ID_Employé INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(50),
    Prénom VARCHAR(50),
    Poste VARCHAR(50),
    Salaire DECIMAL(10, 2)
);

-- Création de la table "Locations"
CREATE TABLE Locations (
    ID_Location INT PRIMARY KEY AUTO_INCREMENT,
    ID_Client INT,
    ID_Véhicule INT,
    ID_Employé INT,
    Date_Début DATE,
    Date_Fin DATE,
    Coût_Total DECIMAL(10, 2),
    FOREIGN KEY (ID_Client) REFERENCES Clients(ID_Client),
    FOREIGN KEY (ID_Véhicule) REFERENCES Véhicules(ID_Véhicule),
    FOREIGN KEY (ID_Employé) REFERENCES Employés(ID_Employé)
);

-- Insertion de données dans la table "Clients"
INSERT INTO Clients (Nom, Prénom, Adresse, Numéro_Téléphone)
VALUES
    ('Dupont', 'Jean', '123 Rue de Paris', '01-23-45-67-89'),
    ('Martin', 'Marie', '456 Avenue des Roses', '02-34-56-78-90'),
    ('Durand', 'Paul', '789 Boulevard du Soleil', '03-45-67-89-01'),
    ('Lefebvre', 'Sophie', '1010 Rue de la Mer', '04-56-78-90-12'),
    ('Garcia', 'Pierre', '555 Avenue de la Lune', '05-67-89-01-23'),
    ('Moreau', 'Céline', '999 Rue de la Montagne', '06-78-90-12-34'),
    ('Petit', 'Luc', '123 Avenue des Étoiles', '07-89-01-23-45'),
    ('Roux', 'Emma', '333 Rue de la Forêt', '08-90-12-34-56');

-- Insertion de données dans la table "Véhicules"
INSERT INTO Véhicules (Marque, Modèle, Année_Fabrication, Plaque_Immatriculation, Prix_Loc_Journée)
VALUES
    ('Toyota', 'Corolla', 2020, 'AB 123 CD', 50.00),
    ('Honda', 'Civic', 2019, 'EF 456 GH', 45.00),
    ('Ford', 'Focus', 2021, 'IJ 789 KL', 55.00),
    ('Nissan', 'Altima', 2020, 'MN 123 OP', 48.00),
    ('Volkswagen', 'Jetta', 2019, 'QR 456 ST', 47.00),
    ('Chevrolet', 'Malibu', 2022, 'UV 789 WX', 60.00),
    ('Hyundai', 'Elantra', 2021, 'YZ 123 AB', 52.00),
    ('Kia', 'Forte', 2020, 'CD 456 EF', 49.00);

-- Insertion de données dans la table "Employés"
INSERT INTO Employés (Nom, Prénom, Poste, Salaire)
VALUES
    ('Dubois', 'Marc', 'Agent de location', 3000.00),
    ('Leroy', 'Laura', 'Gestionnaire de comptes', 4000.00),
    ('Fontaine', 'Alex', 'Agent de location', 3100.00),
    ('Lecomte', 'Sophie', 'Gestionnaire de comptes', 4100.00),
    ('Boucher', 'Thomas', 'Agent de location', 3050.00),
    ('Rousseau', 'Marie', 'Gestionnaire de comptes', 4200.00),
    ('Martin', 'Paul', 'Agent de location', 3150.00),
    ('Gagnon', 'Julie', 'Gestionnaire de comptes', 4300.00);

-- Insertion de données dans la table "Locations"
INSERT INTO Locations (ID_Client, ID_Véhicule, ID_Employé, Date_Début, Date_Fin, Coût_Total)
VALUES
    (1, 1, 1, '2023-09-10', '2023-09-15', 250.00),
    (2, 3, 2, '2023-09-11', '2023-09-14', 180.00),
    (3, 2, 3, '2023-09-12', '2023-09-17', 275.00),
    (4, 5, 4, '2023-09-13', '2023-09-16', 220.00),
    (5, 4, 5, '2023-09-14', '2023-09-19', 260.00),
    (6, 7, 6, '2023-09-15', '2023-09-18', 240.00),
    (7, 6, 7, '2023-09-16', '2023-09-21', 310.00),
    (8, 8, 8, '2023-09-17', '2023-09-20', 280.00);

SELECT ID_Location, ID_Véhicule, ID_Employé, Date_Début, Date_Fin, Coût_Total FROM Locations WHERE ID_Client = 3 ;
SELECT * FROM clients;

-- Création de la table "Comptes"
CREATE TABLE IF NOT EXISTS Comptes (
    Numéro_Compte VARCHAR(10) PRIMARY KEY,
    Titulaire VARCHAR(100),
    Solde DECIMAL(10, 2)
);

-- Insertion de quelques comptes de test
INSERT INTO Comptes (Numéro_Compte, Titulaire, Solde) VALUES
    ('100001', 'John Doe', 5000.0),
    ('100002', 'Jane Smith', 3500.0),
    ('100003', 'Alice Johnson', 7500.0),
    ('100004', 'Bob Williams', 6200.0),
    ('100005', 'Eva Davis', 4300.0),
    ('100006', 'Michael Brown', 8800.0),
    ('100007', 'Olivia Lee', 3000.0),
    ('100008', 'David Wilson', 4100.0),
    ('100009', 'Sophia Miller', 6500.0),
    ('100010', 'Liam Anderson', 7700.0);


-- Création de la table "Transactions"
CREATE TABLE IF NOT EXISTS Transactions (
    ID_Transaction INT PRIMARY KEY AUTO_INCREMENT,
    Numéro_Compte_Source VARCHAR(10),
    Numéro_Compte_Cible VARCHAR(10),
    Montant DECIMAL(10, 2),
    Date_Transaction DATE,
    FOREIGN KEY (Numéro_Compte_Source) REFERENCES Comptes(Numéro_Compte),
    FOREIGN KEY (Numéro_Compte_Cible) REFERENCES Comptes(Numéro_Compte)
);

-- Exemple d'insertion de transactions
INSERT INTO Transactions (Numéro_Compte_Source, Numéro_Compte_Cible, Montant, Date_Transaction) VALUES
    ('100001', '100002', 500.0, '2023-09-15'),
    ('100003', '100004', 800.0, '2023-09-16'),
    ('100002', '100005', 300.0, '2023-09-17'),
    ('100006', '100001', 1000.0, '2023-09-18'),
    ('100007', '100008', 200.0, '2023-09-19'),
    ('100009', '100010', 600.0, '2023-09-20'),
    ('100004', '100003', 400.0, '2023-09-21'),
    ('100005', '100001', 700.0, '2023-09-22'),
    ('100010', '100009', 900.0, '2023-09-23'),
    ('100008', '100007', 150.0, '2023-09-24');

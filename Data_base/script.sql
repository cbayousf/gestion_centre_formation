-- Table Étudiant
CREATE TABLE etudiant (
    ID_Etudiant INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(50),
    Prénom VARCHAR(50),
    Email VARCHAR(100),
    Téléphone VARCHAR(20)
);

INSERT INTO etudiant (Nom, Prénom, Email, Téléphone) VALUES
('Benali', 'Youssef', 'youssef.benali@gmail.com', '0601010203'),
('El Khoury', 'Sara', 'sara.khoury@yahoo.com', '0612345678'),
('Ait Taleb', 'Nour', 'nour.ait@gmail.com', '0622233445');


-- Table Enseignant
CREATE TABLE Enseignant (
    ID_Enseignant INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(50),
    Prénom VARCHAR(50),
    Email VARCHAR(100),
    Spécialité VARCHAR(100)
);

INSERT INTO Enseignant (Nom, Prénom, Email, Spécialité) VALUES
('Lamrani', 'Hassan', 'h.lamrani@cf.ma', 'Java'),
('Bourhim', 'Latifa', 'latifa.b@cf.ma', 'Base de données'),
('Draoui', 'Omar', 'omar.draoui@cf.ma', 'Web Development');

-- Table Module
CREATE TABLE Module (
    ID_Module INT PRIMARY KEY AUTO_INCREMENT,
    Nom_Module VARCHAR(100),
    Description TEXT,
    Durée INT -- en heures
);

INSERT INTO Module (Nom_Module, Description, Durée) VALUES
('Programmation Java', 'Cours complet sur la programmation orientée objet en Java', 40),
('Base de Données', 'Introduction et manipulation des SGBD avec MySQL', 30),
('Développement Web', 'HTML, CSS, JavaScript pour créer des sites dynamiques', 35);

-- Table Inscription
CREATE TABLE Inscription (
    ID_Inscription INT PRIMARY KEY AUTO_INCREMENT,
    Statut VARCHAR(30),
    ID_Etudiant INT,
    ID_Module INT,
    Date_Inscription DATE,
    FOREIGN KEY (ID_Etudiant) REFERENCES etudiant(ID_Etudiant),
    FOREIGN KEY (ID_Module) REFERENCES Module(ID_Module)
);

INSERT INTO Inscription (Statut, ID_Etudiant, ID_Module, Date_Inscription) VALUES
('Validée', 1, 1, '2025-01-15'),
('En cours', 2, 2, '2025-02-01'),
('Annulée', 3, 3, '2025-03-05');

-- Table Cours
CREATE TABLE Cours (
    ID_Cours INT PRIMARY KEY AUTO_INCREMENT,
    Date_Cours DATE,
    ID_Module INT,
    ID_Enseignant INT,
    FOREIGN KEY (ID_Module) REFERENCES Module(ID_Module),
    FOREIGN KEY (ID_Enseignant) REFERENCES Enseignant(ID_Enseignant)
);

INSERT INTO Cours (Date_Cours, ID_Module, ID_Enseignant) VALUES
('2025-01-20', 1, 1),
('2025-02-05', 2, 2),
('2025-03-10', 3, 3);

-- Table Certificat
CREATE TABLE Certificat (
    ID_Certificat INT PRIMARY KEY AUTO_INCREMENT,
    Date_Génération DATE,
    ID_Etudiant INT,
    ID_Module INT,
    FOREIGN KEY (ID_Etudiant) REFERENCES etudiant(ID_Etudiant),
    FOREIGN KEY (ID_Module) REFERENCES Module(ID_Module)
);

INSERT INTO Certificat (Date_Génération, ID_Etudiant, ID_Module) VALUES
('2025-03-01', 1, 1),
('2025-04-01', 2, 2);
-- Pas de certificat pour l’étudiant 3 car inscription annulée

-- Table Enseigne (Affectation des enseignants aux modules)
CREATE TABLE Affectation (
    ID_E INT PRIMARY KEY AUTO_INCREMENT,
    ID_Module INT,
    ID_Enseignant INT,
    Date_Affectation DATE,
    FOREIGN KEY (ID_Module) REFERENCES Module(ID_Module),
    FOREIGN KEY (ID_Enseignant) REFERENCES Enseignant(ID_Enseignant)
);
INSERT INTO Affectation (ID_Module, ID_Enseignant, Date_Affectation) VALUES
(1, 1, '2025-01-10'),
(2, 2, '2025-01-12'),
(3, 3, '2025-01-15');

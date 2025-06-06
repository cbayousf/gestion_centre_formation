-- Table Étudiant
CREATE TABLE etudiant (
    ID_Etudiant INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(50),
    Prenom VARCHAR(50),
    Email VARCHAR(100),
    Telephone VARCHAR(20)
);

INSERT INTO etudiant (Nom, Prenom, Email, Telephone) VALUES
('Benali', 'Youssef', 'youssef.benali@gmail.com', '0601010203'),
('El Khoury', 'Sara', 'sara.khoury@yahoo.com', '0612345678'),
('Ait Taleb', 'Nour', 'nour.ait@gmail.com', '0622233445');


-- Table Enseignant
CREATE TABLE Enseignant (
    ID_Enseignant INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    email VARCHAR(100),
    specialite VARCHAR(100)
);

INSERT INTO Enseignant (nom, prenom, email, specialite) VALUES
('Lamrani', 'Hassan', 'h.lamrani@cf.ma', 'Java'),
('Bourhim', 'Latifa', 'latifa.b@cf.ma', 'Base de données'),
('Draoui', 'Omar', 'omar.draoui@cf.ma', 'Web Development');

-- Table Module
CREATE TABLE ModuleFormation (
    ID_Module INT PRIMARY KEY AUTO_INCREMENT,
    Nom_Module VARCHAR(100),
    Description TEXT,
    Duree INT -- en heures
);

INSERT INTO moduleFormation (Nom_Module, Description, Duree) VALUES
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
    FOREIGN KEY (ID_Etudiant) REFERENCES etudiant(ID_Etudiant) ON DELETE CASCADE,
    FOREIGN KEY (ID_Module) REFERENCES ModuleFormation(ID_Module) ON DELETE CASCADE
);

INSERT INTO Inscription (Statut, ID_Etudiant, ID_Module, Date_Inscription) VALUES
('Validée', 1, 1, '2025-01-15'),
('En cours', 2, 2, '2025-02-01'),
('Annulée', 3, 3, '2025-03-05');

-- a modifier 
-- Table Cours
CREATE TABLE Cours (
    ID_Cours INT PRIMARY KEY AUTO_INCREMENT,
    Nom_Cours VARCHAR(20),
    Date_Cours DATE,
    ID_Module INT,
    FOREIGN KEY (ID_Module) REFERENCES ModuleFormation(ID_Module) ON DELETE CASCADE
);

INSERT INTO Cours (Nom_Cours, Date_Cours, ID_Module) VALUES 
('Java Avancé', '2025-01-20', 1), 
('Bases de Données', '2025-02-05', 2), 
('Développement Web', '2025-03-10', 3);

-- Table Certificat
CREATE TABLE Certificat (
    ID_Certificat INT PRIMARY KEY AUTO_INCREMENT,
    Date_Generation DATE,
    ID_Etudiant INT,
    ID_Module INT,
    FOREIGN KEY (ID_Etudiant) REFERENCES etudiant(ID_Etudiant) ON DELETE CASCADE,
    FOREIGN KEY (ID_Module) REFERENCES ModuleFormation(ID_Module) ON DELETE CASCADE
);

INSERT INTO Certificat (Date_Generation, ID_Etudiant, ID_Module) VALUES
('2025-03-01', 1, 1),
('2025-04-01', 2, 2);
-- Pas de certificat pour l’étudiant 3 car inscription annulée

-- Table Enseigne (Affectation des enseignants aux modules)
CREATE TABLE Affectation (
    ID_E INT PRIMARY KEY AUTO_INCREMENT,
    ID_Module INT,
    ID_Enseignant INT,
    Date_Affectation DATE,
    FOREIGN KEY (ID_Module) REFERENCES ModuleFormation(ID_Module) ON DELETE CASCADE,
    FOREIGN KEY (ID_Enseignant) REFERENCES Enseignant(ID_Enseignant) ON DELETE CASCADE
);
INSERT INTO Affectation (ID_Module, ID_Enseignant, Date_Affectation) VALUES
(1, 1, '2025-01-10'),
(2, 2, '2025-01-12'),
(3, 3, '2025-01-15');

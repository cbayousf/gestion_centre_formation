<?php
// Connexion à la base de données
try {
    $pdo = new PDO("mysql:host=localhost;dbname=centre_formation;charset=utf8", "root", "");
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    die("Erreur de connexion : " . $e->getMessage());
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST['username'];
    $email = $_POST['email'];
    $password = $_POST['password'];

    // Requête SQL pour chercher l'utilisateur
    $stmt = $pdo->prepare("SELECT * FROM utilisateurs WHERE nom = ? AND email = ?");
    $stmt->execute([$username, $email]);
    $user = $stmt->fetch();

    if ($user && password_verify($password, $user['mot_de_passe'])) {
        // Connexion réussie → redirection
        header("Location: ../interphase_etudiant/etudiant.html");
        exit();
    } else {
        echo "<script>alert('Nom, email ou mot de passe incorrect'); window.history.back();</script>";
    }
}
?>
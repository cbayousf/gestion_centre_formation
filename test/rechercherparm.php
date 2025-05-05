<?php
// rechercherparModule.php

error_reporting(E_ALL);
ini_set('display_errors', 1);

// Connexion à la base de données
$pdo = new PDO("mysql:host=localhost;dbname=centre_formation;charset=utf8", "root", "");

// Récupère le terme de recherche depuis la barre de recherche (GET)
$terme = $_GET['q'] ?? '';

// Si le terme est vide, on arrête
if (empty($terme)) {
    $resultats = [];
} else {
    // Requête SQL pour chercher dans ModuleFormation
    $stmt = $pdo->prepare("SELECT * FROM ModuleFormation WHERE Nom_Module LIKE ? OR Description LIKE ?");
    $stmt->execute(["%$terme%", "%$terme%"]);
    $resultats = $stmt->fetchAll(PDO::FETCH_ASSOC);
}
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Résultats de recherche - Dream & Learn</title>
    <link rel="stylesheet" href="stylee.css">

    <!-- Style interne pour améliorer l'affichage -->
    <style>
        body {
            background-color: #fdf8f3;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #333;
            margin: 0;
        }

        header {
            background-color: white;
            padding: 15px 30px;
            border-bottom: 1px solid #ddd;
        }

        .logo-small {
            display: flex;
            align-items: center;
        }

        .logo-small img {
            width: 30px;
            height: 30px;
        }

        .logo-small span {
            font-weight: bold;
            font-size: 18px;
            margin-left: 10px;
            color: #4a2c5d;
        }

        .sign-in-btn {
            background-color: #4a2c5d;
            color: white;
            padding: 8px 20px;
            border-radius: 20px;
            text-decoration: none;
            font-weight: 500;
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        main {
            padding: 40px 0;
        }

        .container {
            max-width: 1200px;
            margin: auto;
            padding: 0 20px;
        }

        .section-header {
            text-align: center;
            margin-bottom: 30px;
        }

        .section-header h2 {
            font-size: 28px;
            color: #4a2c5d;
            margin-bottom: 10px;
        }

        .tracks-description {
            text-align: center;
            font-style: italic;
            color: #666;
            margin-bottom: 30px;
        }

        .tracks-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }

        .track-card {
            background-color: white;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            width: 300px;
            transition: transform 0.3s ease;
            overflow: hidden;
        }

        .track-card:hover {
            transform: translateY(-5px);
        }

        .track-image {
            width: 100%;
            height: 150px;
            object-fit: cover;
        }

        .track-content {
            padding: 20px;
        }

        .track-category {
            color: #e86c25;
            font-size: 14px;
            margin-bottom: 5px;
        }

        .track-title {
            font-size: 18px;
            margin-bottom: 10px;
            color: #4a2c5d;
        }

        .join-btn {
            display: inline-block;
            background-color: #e86c25;
            color: white;
            padding: 10px 25px;
            border-radius: 25px;
            text-decoration: none;
            font-weight: bold;
            margin-top: 10px;
            transition: background-color 0.3s ease;
        }

        .join-btn:hover {
            background-color: #bf5b1a;
        }

        .back-link {
            display: block;
            text-align: center;
            margin: 40px auto;
            color: #4a2c5d;
            font-weight: bold;
            text-decoration: none;
            font-size: 16px;
        }

        .back-link:hover {
            text-decoration: underline;
        }

        .no-result {
            text-align: center;
            font-size: 18px;
            color: #666;
            margin-top: 40px;
        }
    </style>
</head>
<body>

<!-- Header -->
<header>
    <div class="container">
        <nav class="navbar">
            <div class="logo-small">
                <img src="../images/logo.png" alt="Logo Dream & Learn">
                <span>Dream & Learn</span>
            </div>

        </nav>
    </div>
</header>

<!-- Section principale -->
<main>
    <section class="search-results">
        <div class="container">
            <div class="section-header">
                <h2>Résultats pour « <?= htmlspecialchars($terme) ?> »</h2>
            </div>

            <?php if (!empty($resultats)): ?>
                <p class="tracks-description">
                    Modules correspondants trouvés dans notre centre.
                </p>
                <div class="tracks-container">
                    <?php foreach ($resultats as $module): ?>
                        <div class="track-card">
                            <img src="images/info.png" alt="Logo du module" class="track-image">
                            <div class="track-content">
                                <div class="track-category">Module #<?= $module['ID_Module'] ?></div>
                                <h3 class="track-title"><?= htmlspecialchars($module['Nom_Module']) ?></h3>
                                <p><?= htmlspecialchars($module['Description']) ?></p>
                                <p><strong>Durée :</strong> <?= $module['Duree'] ?> heures</p>
                                <a href="details_module.php?id=<?= $module['ID_Module'] ?>" class="join-btn">Voir détails</a>
                            </div>
                        </div>
                    <?php endforeach; ?>
                </div>
            <?php else: ?>
                <p class="no-result">
                    Aucun module trouvé pour « <?= htmlspecialchars($terme) ?> ».
                </p>
            <?php endif; ?>

            <br />
            <a href="../index.html" class="back-link">← Retour à l'accueil</a>
        </div>
    </section>
</main>

</body>
</html>
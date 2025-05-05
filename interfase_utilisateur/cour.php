<?php
// Activer l'affichage des erreurs PHP
error_reporting(E_ALL);
ini_set('display_errors', 1);

// Récupérer l'ID du module depuis l'URL
$idModule = isset($_GET['id']) ? intval($_GET['id']) : 0;

if ($idModule <= 0) {
    die("<p style='color:red;'>⚠️ ID Module invalide.</p>");
}

// Chemin vers le projet
$project_root = realpath(dirname(__FILE__) . '/../../');

// Appel au programme Java
$command = "java -cp \"{$project_root}/bin;{$project_root}/lib/mysql-connector-j-9.3.0.jar\" php.GetCoursByModuleApp " . escapeshellarg($idModule);
exec($command . " 2>&1", $output, $return_var);

// Parser la sortie Java
$coursList = [];

if ($return_var === 0) {
    foreach ($output as $line) {
        $data = explode(";", $line);
        if (count($data) === 4) {
            $coursList[] = [
                'id' => $data[0],
                'nom' => $data[1],
                'date' => $data[2],
                'duree' => $data[3] . "h"
            ];
        }
    }
} else {
    echo "<pre>Erreur lors de la récupération des cours : \n" . implode("\n", $output) . "</pre>";
}
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cours du Module <?= htmlspecialchars($idModule) ?></title>
    <link rel="stylesheet" href="styleCour.css">
</head>
<body>

<div class="background-elements">
    <div class="bg-element ruler"></div>
    <div class="bg-element laptop"></div>
    <div class="bg-element lightbulb"></div>
    <div class="bg-element flask"></div>
    <div class="bg-element triangle"></div>
    <div class="bg-element compass"></div>
    <div class="bg-element globe"></div>
</div>

<section class="formation-section">
    <div class="circle-bg"></div>
    
    <div class="section-header">
        <h2 class="section-title">Cours du Module <?= htmlspecialchars($idModule) ?></h2>
        <img src="images/ilistr5.png" class="table-icon" alt="Icone cours">
    </div>

    <!-- Bouton pour ajouter un cours à ce module -->
    <button>
        <a href="addCours.html" class="add-button">Ajouter un Cours</a>
    </button>

    <table>
        <thead>
            <tr>
                <th>ID_Cours</th>
                <th>Nom_Cours</th>
                <th>Date_Cours</th>
                <th>Durée</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <?php if (!empty($coursList)): ?>
                <?php foreach ($coursList as $cours): ?>
                    <tr>
                        <td>
                            <img src="images/ilistr5.png" alt="Avatar" class="avatar">
                            <?= htmlspecialchars($cours['id']) ?>
                        </td>
                        <td><?= htmlspecialchars($cours['nom']) ?></td>
                        <td><?= htmlspecialchars($cours['date']) ?></td>
                        <td><?= htmlspecialchars($cours['duree']) ?></td>
                        <td class="action-buttons">
                            <button class="edit-btn">
                                <a href="updateCours.php?id=<?= $cours['id'] ?>">✏️</a>
                            </button>
                            <button class="delete-btn">🗑️</button>
                        </td>
                    </tr>
                <?php endforeach; ?>
            <?php else: ?>
                <tr>
                    <td colspan="5" style="text-align:center;">Aucun cours trouvé pour ce module.</td>
                </tr>
            <?php endif; ?>
        </tbody>
    </table>
</section>

</body>
</html>
<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

$idCours = isset($_GET['id']) ? intval($_GET['id']) : 0;

$cours = [];

if ($idCours > 0) {
    $project_root = realpath(dirname(__FILE__) . '/../../');

    // Commande pour appeler Java
    $command = "java -cp \"{$project_root}/bin;{$project_root}/lib/mysql-connector-j-9.3.0.jar\" php.GetCoursApp " . escapeshellarg($idCours);

    exec($command, $output, $return_var);

    if ($return_var === 0 && count($output) >= 4) {
        $cours = [
            'id' => $output[0],
            'nom' => $output[1],
            'date' => $output[2],
            'module' => $output[3]
        ];
    } else {
        echo "<p style='color:red;'>❌ Erreur lors de la récupération des données du cours.</p>";
        echo "<pre>" . implode("\n", $output) . "</pre>";
    }
}
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier un Cours</title>
    <link rel="stylesheet" href="styleUpdate.css">
</head>
<body>

<div class="background-elements">
    <div class="bg-element ruler"></div>
    <div class="bg-element flask"></div>
    <div class="bg-element triangle"></div>
    <div class="bg-element globe"></div>
</div>

<div class="cadre">
    <div class="container">
        <h1 class="page-title">Modifier un Cours</h1>

        <div class="update-section">
            <div class="form-container">

                <?php if (!empty($cours)) { ?>
                    <form action="php/updateCoursHandler.php" method="post">
                        <input type="hidden" name="id_cours" value="<?= htmlspecialchars($cours['id']) ?>">

                        <div class="form-row">
                            <div class="form-group">
                                <label for="nom_cours" class="form-label">Nom du Cours :</label>
                                <input type="text" id="nom_cours" name="nom_cours" class="form-input"
                                       value="<?= htmlspecialchars($cours['nom']) ?>" required />
                            </div>

                            <div class="form-group">
                                <label for="date_cours" class="form-label">Date du Cours :</label>
                                <input type="date" id="date_cours" name="date_cours" class="form-input"
                                       value="<?= htmlspecialchars($cours['date']) ?>" required />
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group">
                                <label for="id_module" class="form-label">ID Module :</label>
                                <input type="number" id="id_module" name="id_module" class="form-input"
                                       value="<?= htmlspecialchars($cours['module']) ?>" required />
                            </div>
                        </div>

                        <button type="submit" class="update-btn">Mettre à jour le Cours</button>
                    </form>
                <?php } else { ?>
                    <p style="color:red;">❌ Aucun cours trouvé avec cet ID.</p>
                <?php } ?>

            </div>

            <div class="image-container">
                <img src="images/ilistr6.png" alt="Illustration Modification Cours" class="student-image" />
            </div>
        </div>
    </div>
</div>

<div class="curved-arrow"></div>
</body>
</html>
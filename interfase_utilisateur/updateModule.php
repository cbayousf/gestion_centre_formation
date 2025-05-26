<?php
// Récupérer l'ID de l'étudiant depuis l'URL
$id = $_GET['id'] ?? null;

if (!$id) {
    die("❌ ID non fourni.");
}

// Chemin du projet
$project_root = realpath(dirname(__FILE__) . '/..');

// Appel du programme Java pour récupérer l’étudiant par ID
$command = 'java -cp "' . $project_root . '/bin;' . $project_root . '/lib/mysql-connector-j-9.3.0.jar" php.ModuleByIdApp '. escapeshellarg($id);

exec($command . " 2>&1", $output, $return_var);

if ($return_var !== 0 || empty($output)) {
    die("❌ Impossible de charger les données de module.");
}

$data = explode(";", $output[0]);

if (count($data) < 5) {
    die("❌ Données incomplètes.");
}

// Debugging logs
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Module</title>
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
        <h1 class="page-title">update Module</h1>
        
        <div class="update-section">
                <form action="php/saveModule.php" method="post" class="form-container">
                <input type="hidden" name="module_id" value="<?= htmlspecialchars($data[0]) ?>" />

                <div class="form-row">
                    <div class="form-group">
                        <label class="form-label">Nom_Cours :</label>
                        <input type="text" name="nom" class="form-input" value="<?= htmlspecialchars($data[1]) ?>" required />
                    </div>

                    <div class="form-group">
                        <label class="form-label">Date_Cours :</label>
                        <input type="date" name="date" class="form-input" value="<?= htmlspecialchars($data[2]) ?>" required />
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label class="form-label">ID_Module :</label>
                        <input type="text" name="id_module" class="form-input" value="<?= htmlspecialchars($data[3]) ?>" required />
                    </div>
                </div>

                <button type="submit" class="update-btn">Update Cours</button>
            </form>
            <div class="image-container">
                <img src="images/ilistr6.png" alt="teacher Registration Illustration" class="student-image" />
            </div>
        </div>
    </div>
    </div>
    <div class="curved-arrow"></div>
</body>
</html>
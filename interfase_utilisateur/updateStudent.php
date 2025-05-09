<?php
// Récupérer l'ID de l'étudiant depuis l'URL
$id = $_GET['id'] ?? null;

if (!$id) {
    die("❌ ID non fourni.");
}

// Chemin du projet
$project_root = realpath(dirname(__FILE__) . '/..');

// Appel du programme Java pour récupérer l’étudiant par ID
$command = 'java -cp "' . $project_root . '/bin;' . $project_root . '/lib/mysql-connector-j-9.3.0.jar" php.GetStudentByIdApp '. escapeshellarg($id);

exec($command . " 2>&1", $output, $return_var);

if ($return_var !== 0 || empty($output)) {
    die("❌ Impossible de charger les données de l’étudiant.");
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
    <title>Modifier Étudiant</title>
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
            <h1 class="page-title">Modifier l’Étudiant</h1>

            <div class="update-section">
                <!-- Formulaire -->
                <form action="php/saveStudent.php" method="post" class="form-container">
                    <!-- Champ caché pour l'ID -->
                    <input type="hidden" name="student_id" value="<?= htmlspecialchars($data[0]) ?>" />

                    <!-- Ligne Nom et Prénom -->
                    <div class="form-row">
                        <div class="form-group">
                            <label class="form-label">Nom :</label>
                            <input type="text" name="nom" class="form-input" value="<?= htmlspecialchars($data[1]) ?>" required />
                        </div>

                        <div class="form-group">
                            <label class="form-label">Prénom :</label>
                            <input type="text" name="prenom" class="form-input" value="<?= htmlspecialchars($data[2]) ?>" required />
                        </div>
                    </div>

                    <!-- Ligne Email et Téléphone -->
                    <div class="form-row">
                        <div class="form-group">
                            <label class="form-label">Email :</label>
                            <input type="email" name="email" class="form-input" value="<?= htmlspecialchars($data[3]) ?>" required />
                        </div>

                        <div class="form-group">
                            <label class="form-label">Téléphone :</label>
                            <input type="tel" name="telephone" class="form-input" value="<?= htmlspecialchars($data[4]) ?>" />
                        </div>
                    </div>

                    <!-- Bouton de mise à jour -->
                    <button type="submit" class="update-btn">Mettre à jour</button>
                </form>

                <!-- Image illustrative -->
                <div class="image-container">
                    <img src="images/ilistr6.png" alt="Student Registration Illustration" class="student-image" />
                </div>
            </div>
        </div>
    </div>
    <div class="curved-arrow"></div>
</body>
</html>
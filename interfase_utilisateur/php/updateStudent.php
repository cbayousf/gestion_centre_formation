<?php
$id = $_GET['id'] ?? null;

if (!$id) {
    die("❌ ID non fourni.");
}
$project_root = realpath(dirname(__FILE__) . '/../../');
// Charger l'étudiant depuis Java
$command = 'java -cp "' . $project_root . '/bin;' . $project_root . '/lib/mysql-connector-j-9.3.0.jar" php.GetStudentByIdApp '. escapeshellarg($id);
exec($command . " 2>&1", $output, $return_var);

if ($return_var !== 0 || count($output) < 1) {
    die("❌ Impossible de charger l'étudiant.");
}

$data = explode(";", $output[0]);

if (count($data) < 5) {
    die("❌ Données incomplètes.");
}
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Modifier Étudiant</title>
</head>
<body>
    <h2>Modifier l'étudiant</h2>
    <form action="saveStudent.php" method="post">
        <input type="hidden" name="id" value="<?= htmlspecialchars($data[0]) ?>">
        <label>Nom : <input type="text" name="nom" value="<?= htmlspecialchars($data[1]) ?>"></label><br>
        <label>Prénom : <input type="text" name="prenom" value="<?= htmlspecialchars($data[2]) ?>"></label><br>
        <label>Email : <input type="email" name="email" value="<?= htmlspecialchars($data[3]) ?>"></label><br>
        <label>Téléphone : <input type="text" name="telephone" value="<?= htmlspecialchars($data[4]) ?>"></label><br>
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
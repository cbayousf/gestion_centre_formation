<?php
$id = $_POST['student_id'] ?? null;
$nom = $_POST['nom'] ?? null;
$prenom = $_POST['prenom'] ?? null;
$email = $_POST['email'] ?? null;
$telephone = $_POST['telephone'] ?? null;

if (!$id || !$nom || !$prenom || !$email || !$telephone) {
    die("❌ Tous les champs sont requis.");
}

$project_root = realpath(dirname(__FILE__) . '/../../');
    $command = 'java -cp "' . $project_root . '/bin;' . $project_root . '/lib/mysql-connector-j-9.3.0.jar" php.UpdateStudentApp '
    . escapeshellarg($id) . ' '
    . escapeshellarg($nom) . ' '
    . escapeshellarg($prenom) . ' '
    . escapeshellarg($email) . ' '
    . escapeshellarg($telephone);
exec($command . " 2>&1", $output, $return_var);

if ($return_var === 0) {
    echo "✅ Étudiant mis à jour avec succès !";
} else {
    echo "❌ Erreur lors de la mise à jour : " . implode("<br>", $output);
}
?>
<br><a href="../etulisateur.php">Retour à la liste</a>
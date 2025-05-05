<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

$idCours = $_POST['id_cours'] ?? '';
$nomCours = $_POST['nom_cours'] ?? '';
$dateCours = $_POST['date_cours'] ?? '';
$idModule = $_POST['id_module'] ?? '';

if (!$idCours || !$nomCours || !$dateCours || !$idModule) {
    die("<p style='color:orange;'>⚠️ Tous les champs doivent être remplis.</p>");
}

$project_root = realpath(dirname(__FILE__) . '/../../');

$command = "java -cp \"{$project_root}/bin;{$project_root}/lib/mysql-connector-j-9.3.0.jar\" php.UpdateCoursApp "
    . escapeshellarg($idCours) . " "
    . escapeshellarg($nomCours) . " "
    . escapeshellarg($dateCours) . " "
    . escapeshellarg($idModule);

exec("$command 2>&1", $output, $return_var);

if ($return_var === 0) {
    echo "<p style='color:green;'>✅ Cours mis à jour avec succès.</p>";
    header("Location: ../etulisateur.php");
    exit();
} else {
    echo "<p style='color:red;'>❌ Erreur lors de la mise à jour du cours (code: $return_var).</p>";
    echo "<pre>" . implode("\n", $output) . "</pre>";
}
?>
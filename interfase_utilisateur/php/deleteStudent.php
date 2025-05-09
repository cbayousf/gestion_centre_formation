<?php
$id = $_GET['id'] ?? null;

if (!$id) {
    die("❌ ID non fourni.");
}

$project_root = realpath(dirname(__FILE__) . '/../../');
$command = 'java -cp "' . $project_root . '/bin;' . $project_root . '/lib/mysql-connector-j-9.3.0.jar" php.DeleteStudentApp ' . escapeshellarg($id) ;
exec($command . " 2>&1", $output, $return_var);

if ($return_var === 0) {
    echo "✅ Étudiant supprimé !";
} else {
    echo "❌ Erreur : " . implode("<br>", $output);
}
?>
<br><a href="../etulisateur.php">Retour</a>
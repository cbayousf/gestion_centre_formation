<?php
$module_id = $_POST['module_id'] ?? null;
$nom = $_POST['nom'] ?? null;
$date = $_POST['date'] ?? null;
$id_module = $_POST['id_module'] ?? null;

if (!$id || !$nom || !$date || !$id_module) {
    die("❌ Tous les champs sont requis.");
}

$project_root = realpath(dirname(__FILE__) . '/../../');
$command = 'java -cp "' . $project_root . '/bin;' . $project_root . '/lib/mysql-connector-j-9.3.0.jar" php.UpdateModuleApp '
    . escapeshellarg($module_id) . ' '
    . escapeshellarg($nom) . ' '
    . escapeshellarg($date) . ' '
    . escapeshellarg($id_module);
exec($command . " 2>&1", $output, $return_var);

if ($return_var === 0) {
    echo "✅ module mis à jour avec succès !";
} else {
    echo "❌ Erreur lors de la mise à jour : " . implode("<br>", $output);
}
?>
<br><a href="../etulisateur.php">Retour à la liste</a>
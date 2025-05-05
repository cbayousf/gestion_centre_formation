<?php 
error_reporting(E_ALL); 
ini_set('display_errors', 1);

// Récupère les données du formulaire 
$nom_cours = $_POST['nom_cours'] ?? '';
$date_cours = $_POST['date_cours'] ?? '';
$id_module = $_POST['id_module'] ?? '';

// Validation des champs
if (!empty($nom_cours) && !empty($date_cours) && is_numeric($id_module)) {
    // Déterminez le chemin racine du projet
    $project_root = realpath(dirname(__FILE__) . '/../../');

    // Commande Java à exécuter
    $command = 'java -cp "' . $project_root . '/bin;' . $project_root . '/lib/mysql-connector-j-9.3.0.jar" php.addCoursApp '
        . escapeshellarg($nom_cours) . ' '
        . escapeshellarg($date_cours) . ' '
        . escapeshellarg($id_module);

    // Exécution + capture des erreurs Java
    exec("$command 2>&1", $output, $return_var);

    if ($return_var === 0) {
        header("Location: ../etulisateur.html"); // Rediriger en cas de succès
        exit();
    } else {
        echo "<p style='color:red;'>❌ Erreur lors de l'ajout du cours (code: $return_var).</p>";
        echo "<pre>" . implode("\n", $output) . "</pre>";
        exit();
    }
} else {
    echo "<p style='color:orange;'>⚠️ Tous les champs doivent être remplis correctement.</p>";
    exit();
}
?>
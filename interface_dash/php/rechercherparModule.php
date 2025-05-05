<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

// Récupère le terme de recherche depuis le formulaire
$terme = $_GET['q'] ?? '';

if (!empty($terme)) {
    // Commande pour exécuter RechercheModuleApp.class
    $project_root = realpath(dirname(__FILE__) . '/../../');
    // $command = 'java -cp "' . $project_root . '/bin;' . $project_root . '/lib/mysql-connector-j-9.3.0.jar" php.RechercheModuleApp '
    // . escapeshellarg($terme);
    $command = 'java -Dfile.encoding=UTF-8 -cp "' . $project_root . '/bin;' . $project_root . '/lib/mysql-connector-j-9.3.0.jar" php.RechercheModuleApp '
    . escapeshellarg($terme);

    // Exécution + capture des erreurs
    exec("$command 2>&1", $output, $return_var);

    echo "<h3>Commande exécutée :</h3><pre>$command</pre>";
    echo "<h3>Sortie complète :</h3>";
    echo "<pre>" . implode("\n", $output) . "</pre>";

    if ($return_var === 0 && !empty($output)) {
        echo "<p style='color:green;'>✅ Module trouvé.</p>";
    } else {
        echo "<p style='color:red;'>❌ Aucun module trouvé ou erreur lors de la recherche.</p>";
    }
} else {
    echo "<p style='color:orange;'>⚠️ Veuillez entrer un nom de module à rechercher.</p>";
}
?>

<!-- Lien retour -->
<a href="../index.html">← Retour à l'accueil</a>
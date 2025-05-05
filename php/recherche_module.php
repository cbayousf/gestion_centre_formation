<?php
if (isset($_POST['module'])) {
    $module = escapeshellarg($_POST['module']);

    // Exécuter le programme Java
    $cmd = "java -cp /chemin/vers/classes RechercheParModule " . $module;
    $output = shell_exec($cmd);

    echo "<h3>Résultats pour le module : " . htmlspecialchars($_POST['module']) . "</h3>";
    echo "<pre>$output</pre>";
} else {
    echo "Aucun module spécifié.";
}
?>



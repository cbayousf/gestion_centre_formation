<?php 
error_reporting(E_ALL); 
ini_set('display_errors', 1);

// Récupère les données du formulaire 
$nom_module = $_POST['nom']; 
$description = $_POST['description']; 
$duree = $_POST['duree']; 

// INSÉREZ LE CODE DE DÉBOGAGE ICI
// Avant d'exécuter la commande
echo "<p>Répertoire de travail: " . getcwd() . "</p>";
echo "<p>Le fichier EtudiantApp.class existe: " . (file_exists('bin/php/EtudiantApp.class') ? 'Oui' : 'Non') . "</p>";
// Listez les fichiers dans bin/php
echo "<p>Contenu du dossier bin/php:</p><pre>";
if (is_dir('bin/php')) {
    $files = scandir('bin/php');
    print_r($files);
} else {
    echo "Le dossier bin/php n'existe pas!";
}
echo "</pre>";
// FIN DU CODE DE DÉBOGAGE

if (!empty($nom_module) && !empty($description) && is_numeric($duree))  {
    // Commande corrigée pour appeler Java
    // Remplacez la ligne de commande par:
    // Déterminez le chemin racine du projet
    $project_root = realpath(dirname(__FILE__) . '/../../');
    $command = 'java -cp "' . $project_root . '/bin;' . $project_root . '/lib/mysql-connector-j-9.3.0.jar" php.addModuleAppp '
    . escapeshellarg($nom_module) . ' '
    . escapeshellarg($description) . ' '
    . escapeshellarg($duree);
    
    // Exécution + capture des erreurs Java
    exec("$command 2>&1", $output, $return_var);
    
    echo "<h3>Commande exécutée :</h3><pre>$command</pre>";
    echo "<h3>Sortie complète :</h3>";
    echo "<pre>" . implode("\n", $output) . "</pre>";
    
    if ($return_var === 0) {
        echo "<p style='color:green;'>✅ Module ajouté avec succès.</p>";
        header("Location: ../etulisateur.php");
        exit();
    } else {
        echo "<p style='color:red;'>❌ Erreur lors de l'ajout de module (code: $return_var).</p>";
    }
} else {
    echo "<p style='color:orange;'>⚠️ Tous les champs doivent être remplis.</p>";
}
?>
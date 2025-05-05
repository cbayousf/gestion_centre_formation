<!DOCTYPE html>
    <html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>Résultats de la recherche</title>
        <link rel="stylesheet" href="../resultat-style.css"> <!-- Fichier CSS personnalisé -->
    </head>
    <body>
    
    <header class="site-header">
        <div class="container">
            <h1> Résultats de la recherche</h1>
        </div>
    </header>
    
    <main class="result-container">
        <div class="container">
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
            $command = 'java -Dfile.encoding=UTF-8 -cp "' . $project_root . '/bin;' . $project_root . '/lib/mysql-connector-j-9.3.0.jar" php.RechercheApp '
            . escapeshellarg($terme);
        
            exec("$command 2>&1", $output, $return_var);
    
            echo "<div class='output-box'>";
            echo "<h3>Résultat :</h3>";
            echo "<pre>" . implode("\n", $output) . "</pre>";
            echo "</div>";
    
            if ($return_var === 0 && !empty($output)) {
                echo "<p class='success'>✅ Module trouvé.</p>";
            } else {
                echo "<p class='error'>❌ Aucun module trouvé ou erreur lors de la recherche.</p>";
            }
        } else {
            echo "<p class='warning'>⚠️ Veuillez entrer un nom de module à rechercher.</p>";
        }
    ?>


<!-- Lien retour -->
        <div class="back-btn">
            <a href="../etudiant.html">← Retour à l'accueil</a>
        </div>
    </div>
</main>

</body>
</html>

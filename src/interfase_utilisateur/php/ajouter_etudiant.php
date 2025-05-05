<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

// Récupère les données du formulaire
$nom = $_POST['nom'];
$prenom = $_POST['prenom'];
$email = $_POST['email'];
$telephone = $_POST['telephone'];

if (!empty($nom) && !empty($prenom) && !empty($email) && !empty($telephone)) {

    // Chemin vers java (facultatif si java est dans le PATH)
    $javaPath = "java"; // ou "\"C:\\Program Files\\Java\\jdk1.8.0_291\\bin\\java.exe\"";

    // Commande mise à jour avec le package php.EtudiantApp
    $command = "java -cp \"../bin;../lib/mysql-connector-j-9.3.0.jar\" php.EtudiantApp \"$nom\" \"$prenom\" \"$email\" \"$telephone\"";

    // Exécution + capture des erreurs Java
    exec("$command 2>&1", $output, $return_var);

    echo "<h3>Commande exécutée :</h3><pre>$command</pre>";
    echo "<h3>Sortie complète :</h3><pre>";
    print_r($output);
    echo "</pre>";

    if ($return_var === 0) {
        echo "<p style='color:green;'>✅ Étudiant ajouté avec succès.</p>";
        header("Location: success.html");
        exit();
    } else {
        echo "<p style='color:red;'>❌ Erreur lors de l'ajout de l'étudiant (code: $return_var).</p>";
    }

} else {
    echo "<p style='color:orange;'>⚠️ Tous les champs doivent être remplis.</p>";
}
?>
<?php
function getAllProf() {
    $project_root = realpath(dirname(__FILE__) . '/../../');

    // Appel du programme Java
    $command = "java -cp \"{$project_root}/bin;{$project_root}/lib/mysql-connector-j-9.3.0.jar\" php.ListProfApp";
    exec($command . " 2>&1", $output, $return_var);

    $profs = [];

    if ($return_var === 0) {
        foreach ($output as $line) {
            $data = explode(";", $line);
            if (count($data) === 5) { // ✅ Passage à 5 colonnes
                $profs[] = [
                    'id' => $data[0],
                    'nom' => $data[1],
                    'prenom' => $data[2],
                    'email' => $data[3],
                    'specialite' => $data[4] // ✅ Maintenant inclus
                ];
            }
        }
    } else {
        echo "<pre>Erreur lors de la récupération des profs : \n" . implode("\n", $output) . "</pre>";
    }

    return $profs;
}
?>
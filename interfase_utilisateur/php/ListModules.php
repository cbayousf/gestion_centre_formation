<?php
function getAllModules() {
    $project_root = realpath(dirname(__FILE__) . '/../../');

    // Appel du programme Java
    $command = "java -cp \"{$project_root}/bin;{$project_root}/lib/mysql-connector-j-9.3.0.jar\" php.ListModulesApp";
    exec($command . " 2>&1", $output, $return_var);

    $modules = [];

    if ($return_var === 0) {
        foreach ($output as $line) {
            $data = explode(";", $line);
            if (count($data) === 4) {
                $modules[] = [
                    'id' => $data[0],
                    'nom' => $data[1],
                    'description' => $data[2],
                    'duree' => $data[3] . "h"
                ];
            }
        }
    } else {
        echo "<pre>Erreur lors de la récupération des modules : \n" . implode("\n", $output) . "</pre>";
    }

    return $modules;
}
?>
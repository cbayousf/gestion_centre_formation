<?php
function getCoursByModule($idModule) {
   $project_root = realpath(dirname(__FILE__) . '/../../');
    $command = 'java -cp "' . $project_root . '/bin;' . $project_root . '/lib/mysql-connector-j-9.3.0.jar" php.GetCoursByModuleApp "' . escapeshellarg($idModule);
    exec($command . " 2>&1", $output, $return_var);

    $coursList = [];

    if ($return_var === 0) {
        foreach ($output as $line) {
            $data = explode(";", $line);
            if (count($data) === 4) {
                $coursList[] = [
                    'id' => $data[0],
                    'nom' => $data[1],
                    'date' => $data[2],
                    'duree' => $data[3]
                ];
            }
        }
    } else {
        echo "<pre>Erreur lors de la récupération des cours : \n" . implode("\n", $output) . "</pre>";
    }

    return $coursList;
}
?>
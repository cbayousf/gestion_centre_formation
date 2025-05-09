<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Store - Gestion</title>
    <link rel="stylesheet" href="styleUtilisateur.css">
</head>
<body>
    <div class="background-elements">
        <div class="bg-element ruler"></div>
        <div class="bg-element laptop"></div>
        <div class="bg-element lightbulb"></div>
        <div class="bg-element protractor"></div>
        <div class="bg-element compass"></div>
    </div>

    <div class="container">
        <header>
            <div class="logo">
                    <img src="images/ilogo.png" alt="Book Icon">
                <div class="logo-text">Book Store</div>
            </div>
            
            <div class="search-bar">
                <i class="search-icon">🔍</i>
                <input type="text" placeholder="Search for a location...">
                <button class="continue-btn">Continue</button>
            </div>
            <nav class="main-nav">
                <a href="#" class="active">Home</a>
                <a href="#student-area">student area</a>
                <a href="#teachers-area">Teachers area</a>
                <a href="#formation">formation</a>
            </nav>
            
        </header>
        
        <!-- Student Area Section -->
          <?php
            require_once 'php/ListEtudiant.php';
            $etudiants = getAlletudiant();
            ?>
        <section id="student-area" class="section student-section">
            <div class="circle-bg"></div>
            <div class="section-header">
                <h2 class="section-title">student area</h2>
                <img src="images/ilist1.png" alt="Student Icon" class="person-icon">
            </div>
            
            <button class="add-button">
                <a href="addStudent.html">ADD NEW STUDENT</a>
                <span class="arrow-icon">➜</span>
            </button>
            
            <table>
                <thead>
                    <tr>
                        <th>ID_student</th>
                        <th>Name</th>
                        <th>Enroll Number</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                   <?php if (!empty($etudiants)): ?>
                            <?php foreach ($etudiants as $etudiant): ?>
                                <tr>
                                    <td>
                                        <img src="images/ilistr4.png" alt="Teacher Avatar" class="avatar">
                                        <?= htmlspecialchars($etudiant['id']) ?>
                                    </td>
                                   <td><?= htmlspecialchars($etudiant['nom']) ?></td>
                                    <td><?= htmlspecialchars($etudiant['prenom']) ?></td> <!-- ou "Numéro d'inscription" si tu en as un -->
                                    <td><?= htmlspecialchars($etudiant['email']) ?></td>
                                    <td><?= htmlspecialchars($etudiant['telephone']) ?></td>
                                    <td class="action-buttons">
                                        <button class="edit-btn"><a href="updateStudent.php?id=<?= htmlspecialchars($etudiant['id']) ?>">✏️</a></button>
                                        <button class="delete-btn">
                                            <a href="php/deleteStudent.php?id=<?= htmlspecialchars($etudiant['id']) ?>" onclick="return confirm('Êtes-vous sûr ?')">🗑️</a>
                                        </button>
                                    </td>
                                </tr>
                            <?php endforeach; ?>
                        <?php else: ?>
                            <tr>
                                <td colspan="6" style="text-align:center;">Aucun enseignant trouvé.</td>
                            </tr>
                        <?php endif; ?> 
                </tbody>
            </table>
        </section>
        
            <!-- Teachers Area Section -->
             <?php
            require_once 'php/ListProf.php';
            $profs = getAllprof();
            ?>
            <section id="teachers-area" class="section teachers-section">
                <div class="circle-bg"></div>
                <div class="section-header">
                    <h2 class="section-title">Teachers Area</h2>
                    <img src="images/ilistr3.png" alt="Teacher Icon" class="person-icon">
                </div>

                <button class="add-button">
                    <a href="addTeacher.html">ADD NEW TEACHER</a>
                    <span class="arrow-icon">➜</span>
                </button>

                <table>
                    <thead>
                        <tr>
                            <th>ID_teacher</th>
                            <th>Name</th>
                            <th>Enroll Number</th>
                            <th>Email</th>
                            <th>Speciality</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php if (!empty($profs)): ?>
                            <?php foreach ($profs as $prof): ?>
                                <tr>
                                    <td>
                                        <img src="images/ilistr4.png" alt="Teacher Avatar" class="avatar">
                                        <?= htmlspecialchars($prof['id']) ?>
                                    </td>
                                   <td><?= htmlspecialchars($prof['nom']) ?></td>
                                    <td><?= htmlspecialchars($prof['prenom']) ?></td> <!-- ou "Numéro d'inscription" si tu en as un -->
                                    <td><?= htmlspecialchars($prof['email']) ?></td>
                                    <td><?= htmlspecialchars($prof['specialite']) ?></td>
                                    <td class="action-buttons">
                                        <button class="edit-btn"><a href="updateTeacher.php?id=<?= htmlspecialchars($prof['id']) ?>">✏️</a></button>
                                         <button class="delete-btn">
                                            <a href="php/deleteTeacher.php?id=<?= htmlspecialchars($prof['id']) ?>" onclick="return confirm('Êtes-vous sûr ?')">🗑️</a>
                                        </button>
                                    </td>
                                </tr>
                            <?php endforeach; ?>
                        <?php else: ?>
                            <tr>
                                <td colspan="6" style="text-align:center;">Aucun enseignant trouvé.</td>
                            </tr>
                        <?php endif; ?>
                    </tbody>
                </table>
            </section>
        
        <!-- Formation Section -->
                    <?php
            require_once 'php/ListModules.php';
            $modules = getAllModules();
            ?>
            <section id="formation" class="section formation-section">
                <div class="circle-bg"></div>
                <div class="section-header">
                    <h2 class="section-title">formation</h2>
                    <img src="images/ilistr5.png" alt="Books Icon" class="books-icon">
                </div>

                <button class="add-button">
                    <a href="addModule.html">ADD NEW module</a>
                    <span class="arrow-icon">➜</span>
                </button>

                <table>
                    <thead>
                        <tr>
                            <th>ID_Module</th>
                            <th>Nom_Module</th>
                            <th>Description</th>
                            <th>Durée</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php if (!empty($modules)): ?>
                            <?php foreach ($modules as $module): ?>
                                <tr>
                                    <td>
                                        <img src="images/ilistr5.png" alt="Module Icon" class="avatar">
                                        <?= htmlspecialchars($module['id']) ?>
                                    </td>
                                    <td><a href="cour.php?id=<?= htmlspecialchars($module['id']) ?>"><?= htmlspecialchars($module['nom']) ?></a></td>
                                    <td><?= htmlspecialchars($module['description']) ?></td>
                                    <td><?= htmlspecialchars($module['duree']) ?></td>
                                    <td class="action-buttons">
                                        <button class="edit-btn"><a href="updateModule.php?id=<?= $module['id'] ?>">✏️</a></button>
                                        <button class="delete-btn">
                                            <a href="php/deleteModule.php?id=<?= htmlspecialchars($module['id']) ?>" onclick="return confirm('Êtes-vous sûr ?')">🗑️</a>
                                        </button>
                                    </td>
                                </tr>
                            <?php endforeach; ?>
                        <?php else: ?>
                            <tr>
                                <td colspan="5" style="text-align:center;">Aucun module trouvé.</td>
                            </tr>
                        <?php endif; ?>
                    </tbody>
                </table>
            </section>
    </div>
</body>
</html>
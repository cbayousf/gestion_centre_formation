package app;
import dao.EtudiantDAO;
import model.Etudiant;
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AjouterEtudiantApp extends Application {

    private TextField nomField = new TextField();
    private TextField prenomField = new TextField();
    private TextField emailField = new TextField();
    private TextField telephoneField = new TextField();

    private EtudiantDAO etudiantDAO = new EtudiantDAO();

    @Override
    public void start(Stage primaryStage) {
        Label title = new Label("Ajouter un Étudiant");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(new Label("Nom :"), 0, 0);
        grid.add(nomField, 1, 0);

        grid.add(new Label("Prénom :"), 0, 1);
        grid.add(prenomField, 1, 1);

        grid.add(new Label("Email :"), 0, 2);
        grid.add(emailField, 1, 2);

        grid.add(new Label("Téléphone :"), 0, 3);
        grid.add(telephoneField, 1, 3);

        Button addButton = new Button("Ajouter");
        addButton.setOnAction(e -> ajouter());

        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(title, grid, addButton);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Ajouter Étudiant");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void ajouter() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailField.getText();
        String telephone = telephoneField.getText();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || telephone.isEmpty()) {
            showAlert("Erreur", "Tous les champs doivent être remplis.");
            return;
        }

        Etudiant etudiant = new Etudiant(nom, prenom, email, telephone);
        etudiantDAO.ajouterEtudiant(etudiant);

        showAlert("Succès", "Étudiant ajouté avec succès !");
        clearFields();
    }

    private void clearFields() {
        nomField.clear();
        prenomField.clear();
        emailField.clear();
        telephoneField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
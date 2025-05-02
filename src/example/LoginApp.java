package example;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage stage) {
        // === Styles simples (inline) ===
        String textFieldStyle = "-fx-padding: 10; -fx-border-color: #ddd; -fx-border-radius: 6;";
        String buttonStyle = "-fx-background-color: #4a2c5d; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;";

        // === Formulaire ===
        VBox form = new VBox(15);
        form.setPadding(new Insets(20));

        Label titleLabel = new Label("Login into your account");
        titleLabel.setFont(Font.font(18));

        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setStyle(textFieldStyle);

        TextField emailField = new TextField();
        emailField.setPromptText("E-mail");
        emailField.setStyle(textFieldStyle);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle(textFieldStyle);

        Hyperlink forgotLink = new Hyperlink("Forgot password?");
        forgotLink.setStyle("-fx-font-size: 12px;");

        Button loginBtn = new Button("Log in now");
        loginBtn.setStyle(buttonStyle + "-fx-min-width: 100;");
        loginBtn.setOnAction(e -> {
            if (nameField.getText().isEmpty() || emailField.getText().isEmpty()) {
                showAlert("Erreur", "Veuillez remplir tous les champs.");
            } else {
                showAlert("Succès", "Bienvenue, " + nameField.getText() + " !");
                stage.close(); // Ferme la fenêtre après connexion
            }
        });

        form.getChildren().addAll(
                titleLabel,
                new Label("Form"),
                nameField,
                emailField,
                passwordField,
                forgotLink,
                loginBtn
        );

        // === Illustration (simulée par un texte ou image si ajoutée) ===
        VBox illustration = new VBox();
        illustration.setAlignment(Pos.CENTER);
        illustration.setMinWidth(300);
        illustration.setStyle("-fx-background-color: #eee; -fx-border-color: #ccc;");
        illustration.getChildren().add(new Label("Illustration ici"));

        // === Layout principal ===
        HBox root = new HBox(20, form, illustration);
        root.setPadding(new Insets(40));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #fdf3ef;");

        Scene scene = new Scene(root, 800, 500);
        stage.setTitle("Dream & Learn - Login");
        stage.setScene(scene);
        stage.show();
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
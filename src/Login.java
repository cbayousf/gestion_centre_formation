
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création d'une grille pour disposer les éléments
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));
        grid.setStyle("-fx-background-color: #fdf3ef;");  // Fond de la page

        // Texte de bienvenue
        Text welcomeText = new Text("Bienvenue");
        welcomeText.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-fill: #2d2d2d;");
        grid.add(welcomeText, 0, 0, 2, 1);

        // Champ pour le nom
        TextField nameField = new TextField();
        nameField.setPromptText("Nom");
        nameField.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-padding: 10px;");
        grid.add(nameField, 0, 1, 2, 1);

        // Champ pour l'email
        TextField emailField = new TextField();
        emailField.setPromptText("E-mail");
        emailField.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-padding: 10px;");
        grid.add(emailField, 0, 2, 2, 1);

        // Champ pour le mot de passe
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Mot de passe");
        passwordField.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-padding: 10px;");
        grid.add(passwordField, 0, 3, 2, 1);

        // Lien pour mot de passe oublié
        Text forgotPassword = new Text("Mot de passe oublié ?");
        forgotPassword.setStyle("-fx-font-size: 12px; -fx-fill: #666;");
        forgotPassword.setOnMouseClicked(e -> System.out.println("Redirection vers la page de réinitialisation"));
        grid.add(forgotPassword, 1, 4);

        // Bouton de connexion
        Button loginButton = new Button("Se connecter");
        loginButton.setStyle("-fx-background-color: #4a2c5d; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 15px;");
        loginButton.setOnAction(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                System.out.println("Veuillez remplir tous les champs");
            } else {
                System.out.println("Connexion réussie pour : " + name);
            }
        });
        grid.add(loginButton, 0, 5, 2, 1);

        // // Ajouter une illustration (image)
        // Image image = new Image("images/login.png");  // Remplacer par le bon chemin de l'image
        // ImageView imageView = new ImageView(image);
        // imageView.setFitWidth(300);
        // imageView.setPreserveRatio(true);
        // grid.add(imageView, 2, 0, 1, 6);

        // Créer la scène et ajouter au stage
        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setTitle("Page de Connexion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


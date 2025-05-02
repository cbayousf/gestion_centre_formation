

// public class Main extends Application {
//     public static void main(String[] args) {
//         // 🔧 Activer le rendu logiciel dès le lancement
//         System.setProperty("prism.order", "sw");

//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Hello JavaFX");
//         primaryStage.setScene(new Scene(new Label("Coucou Hasnae ❤️"), 300, 200));
//         primaryStage.show();
//     }
// }


// public class Main extends Application {
//     public static void main(String[] args) {
//         System.setProperty("prism.order", "sw");
//         System.setProperty("prism.verbose", "true");
//         System.setProperty("java.awt.headless", "false");
//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("JavaFX Test Software");
//         primaryStage.setScene(new Scene(new Label("Bienvenue Hasnae 🎉"), 300, 200));
//         primaryStage.show();
//     }
// }
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// public class Main extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         // Création d'un champ de texte
//         TextField nameField = new TextField();
//         nameField.setPromptText("Entrez votre nom");

//         // Création d'un bouton
//         Button greetButton = new Button("Saluer");
//         greetButton.setOnAction(e -> {
//             String name = nameField.getText();
//             System.out.println("Bienvenue, " + name);
//         });

//         // Mise en place du layout
//         VBox vbox = new VBox(nameField, greetButton);
//         vbox.setSpacing(10);

//         // Création de la scène
//         Scene scene = new Scene(vbox, 300, 200);

//         // Initialisation de la fenêtre
//         primaryStage.setTitle("Bienvenue dans l'application !");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }


// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.layout.StackPane;
// import javafx.stage.Stage;

// public class Main extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         Button btn = new Button("Hello, JavaFX!");
//         btn.setOnAction(e -> System.out.println("Button clicked!"));

//         StackPane root = new StackPane();
//         root.getChildren().add(btn);

//         Scene scene = new Scene(root, 300, 250);
//         primaryStage.setTitle("JavaFX App");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.GridPane;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Text;
// import javafx.stage.Stage;

// public class Main extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         // Création d'une grille pour disposer les éléments
//         GridPane grid = new GridPane();
//         grid.setVgap(10);
//         grid.setHgap(10);
//         grid.setStyle("-fx-background-color: #f2f2f2; -fx-padding: 20;");

//         // Texte de bienvenue
//         Text welcomeText = new Text("Bienvenue");
//         welcomeText.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-fill: #2d2d2d;");
//         grid.add(welcomeText, 0, 0, 2, 1);

//         // Champ pour le login
//         TextField loginField = new TextField();
//         loginField.setPromptText("Entrez votre login");
//         loginField.setStyle("-fx-background-color: white; -fx-border-color: #cccccc; -fx-padding: 10;");
//         grid.add(loginField, 0, 1, 2, 1);

//         // Champ pour le mot de passe
//         PasswordField passwordField = new PasswordField();
//         passwordField.setPromptText("Entrez votre mot de passe");
//         passwordField.setStyle("-fx-background-color: white; -fx-border-color: #cccccc; -fx-padding: 10;");
//         grid.add(passwordField, 0, 2, 2, 1);

//         // Bouton de connexion
//         Button loginButton = new Button("Se connecter");
//         loginButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10;");
//         grid.add(loginButton, 0, 3, 2, 1);

//         // Action au clic sur le bouton de connexion
//         loginButton.setOnAction(e -> {
//             String login = loginField.getText();
//             String password = passwordField.getText();
//             // Logique de validation des informations (par exemple, vérifier si les champs sont non vides)
//             if (login.isEmpty() || password.isEmpty()) {
//                 System.out.println("Login ou mot de passe manquant");
//             } else {
//                 System.out.println("Connexion réussie avec : " + login);
//             }
//         });

//         // Créer la scène et ajouter au stage
//         Scene scene = new Scene(grid, 400, 300, Color.WHITE);
//         primaryStage.setTitle("Page de Connexion");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }


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

public class Main extends Application {

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


// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.GridPane;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Text;
// import javafx.stage.Stage;

// public class Main extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         // Création d'une grille pour disposer les éléments
//         GridPane grid = new GridPane();
//         grid.setVgap(10);
//         grid.setHgap(10);
//         grid.setPadding(new Insets(20));
//         grid.setStyle("-fx-background-color: #fdf3ef;");  // Fond de la page

//         // Texte de bienvenue
//         Text welcomeText = new Text("Bienvenue");
//         welcomeText.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-fill: #2d2d2d;");
//         grid.add(welcomeText, 0, 0, 2, 1);

//         // Champ pour le nom
//         TextField nameField = new TextField();
//         nameField.setPromptText("Nom");
//         nameField.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-padding: 10px;");
//         grid.add(nameField, 0, 1, 2, 1);

//         // Champ pour l'email
//         TextField emailField = new TextField();
//         emailField.setPromptText("E-mail");
//         emailField.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-padding: 10px;");
//         grid.add(emailField, 0, 2, 2, 1);

//         // Champ pour le mot de passe
//         PasswordField passwordField = new PasswordField();
//         passwordField.setPromptText("Mot de passe");
//         passwordField.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-padding: 10px;");
//         grid.add(passwordField, 0, 3, 2, 1);

//         // Lien pour mot de passe oublié
//         Text forgotPassword = new Text("Mot de passe oublié ?");
//         forgotPassword.setStyle("-fx-font-size: 12px; -fx-fill: #666;");
//         forgotPassword.setOnMouseClicked(e -> System.out.println("Redirection vers la page de réinitialisation"));
//         grid.add(forgotPassword, 1, 4);

//         // Bouton de connexion
//         Button loginButton = new Button("Se connecter");
//         loginButton.setStyle("-fx-background-color: #4a2c5d; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 15px;");
//         loginButton.setOnAction(e -> {
//             String name = nameField.getText();
//             String email = emailField.getText();
//             String password = passwordField.getText();
//             if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
//                 System.out.println("Veuillez remplir tous les champs");
//             } else {
//                 System.out.println("Connexion réussie pour : " + name);
//             }
//         });
//         grid.add(loginButton, 0, 5, 2, 1);

//         // Créer la scène et ajouter au stage
//         Scene scene = new Scene(grid, 600, 400);
//         primaryStage.setTitle("Page de Connexion");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

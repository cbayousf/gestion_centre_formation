package app.example;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Dashboard extends Application {

    // === Couleurs du thème ===
    private static final String COLOR_PRIMARY = "#4a2c5d";
    private static final String COLOR_ORANGE = "#e86c25";
    private static final String BG_SIDEBAR = "#fff0e6";
    private static final String BG_HEADER = "#ffffff";

    @Override
    public void start(Stage stage) {
        // === HEADER ===
        HBox header = createHeader();

        // === SIDEBAR ===
        VBox sidebar = createSidebar();

        // === CONTENT ===
        VBox content = createContent();

        // === LAYOUT PRINCIPAL ===
        HBox mainLayout = new HBox(10, sidebar, content);
        VBox root = new VBox(header, mainLayout);

        Scene scene = new Scene(root, 1000, 700);
        stage.setTitle("Dream & Learn - Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    // === HEADER ===
    private HBox createHeader() {
        ImageView logoImg = new ImageView(new Image("file:images/logo.png"));
        logoImg.setFitWidth(30);
        logoImg.setFitHeight(30);

        Label logoText = new Label("Dream & Learn");
        logoText.setFont(Font.font("Segoe UI", FontWeight.BOLD, 18));
        logoText.setTextFill(Color.web(COLOR_PRIMARY));

        HBox header = new HBox(10, logoImg, logoText);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(15, 30, 15, 30));
        header.setStyle("-fx-background-color: " + BG_HEADER + "; -fx-border-color: #ddd; -fx-border-width: 0 0 1px 0;");
        return header;
    }

    // === SIDEBAR ===
    private VBox createSidebar() {
        VBox menu = new VBox(20);
        menu.setPadding(new Insets(30, 20, 20, 20));
        menu.setStyle("-fx-background-color: " + BG_SIDEBAR + ";");

        menu.getChildren().addAll(
                createMenuItem("Profile", "images/user.png"),
                createMenuItem("Courses", "images/chart.png"),
                createMenuItem("Settings", "images/settings.png")
        );

        return menu;
    }

    private HBox createMenuItem(String title, String iconPath) {
        ImageView icon = new ImageView(new Image("file:" + iconPath));
        icon.setFitWidth(24);
        icon.setFitHeight(24);

        Label label = new Label(title);
        label.setFont(Font.font(14));

        HBox item = new HBox(10, icon, label);
        item.setStyle("-fx-padding: 10; -fx-cursor: hand;");
        item.setAlignment(Pos.CENTER_LEFT);

        item.setOnMouseEntered(e -> item.setStyle("-fx-padding: 10; -fx-cursor: hand; -fx-background-color: #ffe0cc;"));
        item.setOnMouseExited(e -> item.setStyle("-fx-padding: 10; -fx-cursor: hand;"));

        return item;
    }

    // === CONTENU PRINCIPAL ===
    private VBox createContent() {
        Label title = new Label("Welcome to your Dashboard!");
        title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 28));
        title.setTextFill(Color.web(COLOR_PRIMARY));

        Label subtitle = new Label("Start managing your courses and learning progress.");
        subtitle.setFont(Font.font(18));
        subtitle.setTextFill(Color.GREY);

        VBox content = new VBox(20, title, subtitle);
        content.setAlignment(Pos.TOP_LEFT);
        content.setPadding(new Insets(40));
        content.setStyle("-fx-background-color: white;");

        return content;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

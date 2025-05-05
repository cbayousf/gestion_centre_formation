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

public class DreamAndLearn extends Application {

    // === Couleurs du thème ===
    private static final String COLOR_PRIMARY = "#4a2c5d";
    private static final String COLOR_ORANGE = "#e86c25";
    private static final String BG_HERO = "#fff0e6";
    private static final String BG_FOOTER = "#fff0e6";

    @Override
    public void start(Stage stage) {
        // === HEADER ===
        HBox header = createHeader();

        // === HERO SECTION ===
        VBox heroSection = createHeroSection();

    // === SEARCH BAR ===
VBox searchSection = createSearchSection();  // ✅ Maintenant c'est bon 

        // === TRACKS SECTION ===
        VBox tracksSection = createTracksSection();

        // === FOOTER ===
        VBox footer = createFooter();

        // === LAYOUT PRINCIPAL ===
        VBox root = new VBox(
                header,
                heroSection,
                searchSection,
                tracksSection,
                footer
        );
        root.setSpacing(0);
        root.setStyle("-fx-background-color: #fdf8f3;");

        Scene scene = new Scene(root, 1000, 800);
        stage.setTitle("Dream & Learn - Your trusted partner in learning");
        stage.setScene(scene);
        stage.show();
    }

    // === HEADER ===
    private HBox createHeader() {
        // Logo
        ImageView logoImg = new ImageView(new Image("file:images/logo.png"));
        logoImg.setFitWidth(30);
        logoImg.setFitHeight(30);

        Label logoText = new Label("Dream & Learn");
        logoText.setFont(Font.font("Segoe UI", FontWeight.BOLD, 18));
        HBox logo = new HBox(5, logoImg, logoText);
        logo.setAlignment(Pos.CENTER_LEFT);

        // Navigation
        HBox navLinks = new HBox(30,
                new Hyperlink("About us"),
                new Hyperlink("Course"),
                new Hyperlink("Contact us")
        );
        navLinks.setAlignment(Pos.CENTER);

        // Bouton Sign In
        Button signInBtn = new Button("Sign in");
        signInBtn.setStyle("-fx-background-color: " + COLOR_PRIMARY + "; -fx-text-fill: white; -fx-padding: 8px 20px; -fx-border-radius: 20px; -fx-background-radius: 20px;");
        signInBtn.setCursor(javafx.scene.Cursor.HAND);

        HBox navbar = new HBox(20, logo, navLinks, signInBtn);
        navbar.setAlignment(Pos.CENTER);
        navbar.setPadding(new Insets(20));
        navbar.setStyle("-fx-background-color: white;");

        return navbar;
    }

    // === HERO SECTION ===
    private VBox createHeroSection() {
        Label mainLogo = new Label("Dream & Learn");
        mainLogo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 38));
        mainLogo.setTextFill(Color.web(COLOR_ORANGE));

        VBox heroText = new VBox(
                new Label("Welcome to Dream & Learn,"),
                new Label("your trusted partner in learning."),
                new Label("We help you grow your skills,"),
                new Label("and achieve your career goals."),
                new Label(),
                new Label("At Dream & Learn, we believe:"),
                new Label("every dream deserves the right tools."),
                new Label("That's why we offer training that is:"),
                new Label("high-quality,"),
                new Label("accessible,"),
                new Label("practical,"),
                new Label("and suited to today's world.")
        );
        heroText.setSpacing(10);
        heroText.setMinWidth(400);

        VBox heroContent = new VBox(20, mainLogo, heroText);
        heroContent.setMinWidth(500);

        ImageView heroImage = new ImageView(new Image("file:images/image.png"));
        heroImage.setFitWidth(500);
        heroImage.setPreserveRatio(true);

        HBox hero = new HBox(heroContent, heroImage);
        hero.setSpacing(50);
        hero.setPadding(new Insets(50));
        hero.setStyle("-fx-background-color: " + BG_HERO + ";");
        hero.setAlignment(Pos.TOP_CENTER);

        VBox heroWrapper = new VBox(hero);
        heroWrapper.setPadding(new Insets(0, 0, 30, 0));
        return heroWrapper;
    }

    // === SEARCH SECTION ===
private VBox createSearchSection() {
    TextField searchInput = new TextField();
    searchInput.setPromptText("Search for a location...");
    searchInput.setStyle("-fx-padding: 15px; -fx-padding-left: 40px; -fx-font-size: 16px; -fx-border-color: transparent; -fx-background-color: white; -fx-background-radius: 25px;");
    searchInput.setMaxWidth(600);

    Button searchBtn = new Button("Continue");
    searchBtn.setStyle("-fx-background-color: " + COLOR_PRIMARY + "; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px; -fx-padding: 10px 25px; -fx-border-radius: 25px; -fx-background-radius: 25px;");
    searchBtn.setCursor(javafx.scene.Cursor.HAND);

    HBox searchContainer = new HBox(10, searchInput, searchBtn);
    searchContainer.setAlignment(Pos.CENTER);

    VBox container = new VBox(searchContainer);
    container.setPadding(new Insets(30));
    container.setStyle("-fx-background-color: " + COLOR_PRIMARY + "; -fx-border-radius: 10px;");
    
    return container; // ✅ C'est bon maintenant
    }
// === TRACKS SECTION ===
    private VBox createTracksSection() {
        Label sectionTitle = new Label("Our Tracks");
        sectionTitle.setFont(Font.font("Segoe UI", FontWeight.BOLD, 28));
        sectionTitle.setTextFill(Color.BLACK);

        ImageView lightBulb = new ImageView(new Image("file:images/lamp.png"));
        lightBulb.setFitWidth(80);
        lightBulb.setFitHeight(80);
        lightBulb.setLayoutX(-40);
        lightBulb.setLayoutY(-10);

        StackPane titleWithIcon = new StackPane(lightBulb, sectionTitle);
        titleWithIcon.setAlignment(Pos.CENTER_LEFT);

        ImageView curvedArrow = new ImageView(new Image("file:images/curved.png"));
        curvedArrow.setFitWidth(80);
        curvedArrow.setFitHeight(80);

        HBox sectionHeader = new HBox(titleWithIcon, curvedArrow);
        sectionHeader.setSpacing(10);
        sectionHeader.setAlignment(Pos.CENTER_LEFT);

        Label description = new Label("At Dream & Learn, we offer several training programs tailored to your professional goals and level.");
        description.setWrapText(true);
        description.setMaxWidth(800);
        description.setStyle("-fx-font-style: italic; -fx-text-fill: #666;");
        description.setAlignment(Pos.CENTER);

        VBox tracksContainer = new VBox(20,
                createTrackCard("Design & Création", "images/design.png"),
                createTrackCard("Business & Entrepreneurship", "images/business.png"),
                createTrackCard("Programmation & Informatique", "images/info.png")
        );
        tracksContainer.setAlignment(Pos.CENTER);
        tracksContainer.setSpacing(20);

        VBox section = new VBox(30, sectionHeader, description, tracksContainer);
        section.setPadding(new Insets(40));
        return section;
    }

    // === TRACK CARD ===
    private HBox createTrackCard(String title, String imagePath) {
        ImageView trackImage = new ImageView(new Image("file:" + imagePath));
        trackImage.setFitWidth(100);
        trackImage.setFitHeight(200);
        trackImage.setPreserveRatio(false);

        Label category = new Label("TRACK " + (title.contains("Design") ? "01" : title.contains("Business") ? "02" : "03"));
        category.setTextFill(Color.web(COLOR_ORANGE));
        category.setFont(Font.font(14));

        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font(18));

        Label rating = new Label("★★★★★");
        rating.setTextFill(Color.web(COLOR_ORANGE));

        Button joinBtn = new Button("Join Course");
        joinBtn.setStyle("-fx-background-color: " + COLOR_ORANGE + "; -fx-text-fill: white; -fx-padding: 10px 25px; -fx-border-radius: 25px; -fx-background-radius: 25px;");
        joinBtn.setCursor(javafx.scene.Cursor.HAND);

        VBox content = new VBox(5, category, titleLabel, rating, joinBtn);
        content.setPadding(new Insets(20));

        HBox card = new HBox(trackImage, content);
        card.setStyle("-fx-background-color: white; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 5); -fx-border-radius: 15px;");
        return card;
    }

    // === FOOTER ===
    private VBox createFooter() {
        Label footerLogo = new Label("Dream & Learn");
        footerLogo.setFont(Font.font(24));

        Label footerDescription = new Label("We believe in the power of playful learning to spark creativity, develop critical thinking, and nurture imagination.");
        footerDescription.setWrapText(true);
        footerDescription.setMaxWidth(250);
        footerDescription.setStyle("-fx-font-size: 14px; -fx-text-fill: #666;");

        VBox contactItems = new VBox(10,
                createContactItem("images/email.png", "hello@dreamandlearn.com"),
                createContactItem("images/tele.png", "+91 91813 23 2309"),
                createContactItem("images/loca.png", "Somewhere in the World")
        );

        VBox footerLogoSection = new VBox(20, footerLogo, footerDescription, contactItems);
        footerLogoSection.setMaxWidth(250);

        VBox linksSection = new VBox(20,
                createFooterColumn("Course", new String[]{"Special Features", "Awards and Recognitions", "History"}),
                createFooterColumn("About Us", new String[]{"Our Mission", "Our Vision", "Information"}),
                createFooterColumn("Contact Us", new String[]{"Map & Direction"})
        );
        linksSection.setSpacing(30);

        HBox footerTop = new HBox(50, footerLogoSection, linksSection);
        footerTop.setPadding(new Insets(40));
        footerTop.setAlignment(Pos.TOP_LEFT);

        Separator separator1 = new Separator();
        separator1.setPrefHeight(2);
        separator1.setStyle("-fx-background-color: black;");

        HBox footerBottom = new HBox(20,
                createPolicies(),
                createSocialIcons()
        );
        footerBottom.setPadding(new Insets(20));
        footerBottom.setAlignment(Pos.CENTER);

        Separator separator2 = new Separator();
        separator2.setPrefHeight(2);
        separator2.setStyle("-fx-background-color: black;");

        VBox footer = new VBox(separator1, footerTop, separator2, footerBottom);
        footer.setStyle("-fx-background-color: " + BG_FOOTER + "; -fx-padding: 0 5% 0 5%;");
        return footer;
    }

    private HBox createContactItem(String iconPath, String text) {
        ImageView icon = new ImageView(new Image("file:" + iconPath));
        icon.setFitWidth(20);
        icon.setFitHeight(20);

        Label label = new Label(text);
        label.setWrapText(true);

        return new HBox(10, icon, label);
    }

    private VBox createFooterColumn(String title, String[] items) {
        VBox column = new VBox(10);
        column.setMinWidth(150);

        Label heading = new Label(title);
        heading.setFont(Font.font(18));

        VBox menu = new VBox(10);
        for (String item : items) {
            menu.getChildren().add(new Hyperlink(item));
        }
        menu.setStyle("-fx-text-fill: #333;");

        column.getChildren().addAll(heading, menu);
        return column;
    }

    private HBox createPolicies() {
        return new HBox(20,
                new Hyperlink("Terms of Service"),
                new Hyperlink("Privacy Policy"),
                new Hyperlink("Cookie Policy")
        );
    }

    private HBox createSocialIcons() {
        return new HBox(15,
                new ImageView(new Image("file:images/fcb.png")),
                new ImageView(new Image("file:images/twitter.png")),
                new ImageView(new Image("file:images/Linkedin.png"))
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
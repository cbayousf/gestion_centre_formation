import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

import model.Enseignan;
import dao.EnseignantDAO;
import model.Etudiant;
import dao.EtudiantDAO;
import model.Cours;
import dao.CoursDAO;
import model.ModuleFormation;
import dao.ModuleFormationDAO;

public class Mainacc {

    public static void main(String[] args) throws IOException {
        // Création du serveur HTTP qui écoute sur le port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Contexte pour gérer la recherche des enseignants
        server.createContext("/api/enseignants/recherche", exchange -> {
            try {
                String method = exchange.getRequestMethod();
                if ("GET".equals(method)) {
                    // Récupérer l'ID de l'enseignant depuis la requête
                    String query = exchange.getRequestURI().getQuery();
                    String idParam = null;
                    if (query != null && query.startsWith("id=")) {
                        idParam = query.substring(3);  // Extraire l'ID
                    }

                    if (idParam != null) {
                        int idEnseignant = Integer.parseInt(idParam);
                        Enseignant enseignant = rechercherEnseignant(idEnseignant);
                        if (enseignant != null) {
                            String json = String.format(
                                "{\"id\":%d, \"nom\":\"%s\", \"prenom\":\"%s\", \"email\":\"%s\", \"specialite\":\"%s\"}",
                                enseignant.getIdEnseignant(), enseignant.getNom(), enseignant.getPrenom(),
                                enseignant.getEmail(), enseignant.getSpecialite());
                            sendJsonResponse(exchange, json);
                        } else {
                            sendJsonResponse(exchange, "{\"error\":\"Enseignant non trouvé\"}", 404);
                        }
                    } else {
                        sendJsonResponse(exchange, "{\"error\":\"ID de l'enseignant manquant\"}", 400);
                    }
                } else {
                    sendJsonResponse(exchange, "{\"error\":\"Méthode non autorisée\"}", 405);
                }
            } catch (Exception e) {
                e.printStackTrace();
                sendJsonResponse(exchange, "{\"error\":\"Erreur interne\"}", 500);
            }
        });

        // Contexte pour gérer la recherche des cours
        server.createContext("/api/cours/recherche", exchange -> {
            try {
                String method = exchange.getRequestMethod();
                if ("GET".equals(method)) {
                    String query = exchange.getRequestURI().getQuery();
                    String idParam = null;
                    if (query != null && query.startsWith("id=")) {
                        idParam = query.substring(3);
                    }

                    if (idParam != null) {
                        int idCours = Integer.parseInt(idParam);
                        Cours cours = rechercherCours(idCours);
                        if (cours != null) {
                            String json = String.format(
                                "{\"id\":%d, \"nom\":\"%s\", \"date\":\"%s\", \"moduleId\":%d}",
                                cours.getIdCours(), cours.getNomCours(), cours.getDateCours(), cours.getIdModule());
                            sendJsonResponse(exchange, json);
                        } else {
                            sendJsonResponse(exchange, "{\"error\":\"Cours non trouvé\"}", 404);
                        }
                    } else {
                        sendJsonResponse(exchange, "{\"error\":\"ID du cours manquant\"}", 400);
                    }
                } else {
                    sendJsonResponse(exchange, "{\"error\":\"Méthode non autorisée\"}", 405);
                }
            } catch (Exception e) {
                e.printStackTrace();
                sendJsonResponse(exchange, "{\"error\":\"Erreur interne\"}", 500);
            }
        });

        // Contexte pour gérer la recherche des modules
        server.createContext("/api/modules/recherche", exchange -> {
            try {
                String method = exchange.getRequestMethod();
                if ("GET".equals(method)) {
                    String query = exchange.getRequestURI().getQuery();
                    String idParam = null;
                    if (query != null && query.startsWith("id=")) {
                        idParam = query.substring(3);
                    }

                    if (idParam != null) {
                        int idModule = Integer.parseInt(idParam);
                        ModuleFormation module = chercherModule(idModule);
                        if (module != null) {
                            String json = String.format(
                                "{\"id\":%d, \"nom\":\"%s\", \"description\":\"%s\", \"duree\":%d}",
                                module.getIdModule(), module.getNomModule(), module.getDescription(), module.getDuree());
                            sendJsonResponse(exchange, json);
                        } else {
                            sendJsonResponse(exchange, "{\"error\":\"Module non trouvé\"}", 404);
                        }
                    } else {
                        sendJsonResponse(exchange, "{\"error\":\"ID du module manquant\"}", 400);
                    }
                } else {
                    sendJsonResponse(exchange, "{\"error\":\"Méthode non autorisée\"}", 405);
                }
            } catch (Exception e) {
                e.printStackTrace();
                sendJsonResponse(exchange, "{\"error\":\"Erreur interne\"}", 500);
            }
        });

        // Démarrer le serveur
        server.setExecutor(null); // Utiliser l'exécuteur par défaut
        server.start();
        System.out.println("✅ Serveur démarré sur http://localhost:8080/");
    }

    // Méthode pour envoyer une réponse JSON
    private static void sendJsonResponse(HttpExchange exchange, String json) throws IOException {
        sendJsonResponse(exchange, json, 200);
    }

    // Méthode pour envoyer une réponse JSON avec code d'état HTTP
    private static void sendJsonResponse(HttpExchange exchange, String json, int statusCode) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, json.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(json.getBytes(StandardCharsets.UTF_8));
        }
    }

    // Méthodes de recherche existantes pour Cours, Module et Enseignant (déjà implémentées)
    // public static Cours rechercherCours(int idCours) { /* Implémentation déjà donnée */ }
    // public static ModuleFormation chercherModule(int id) { /* Implémentation déjà donnée */ }
    // public static Enseignant rechercherEnseignant(int idEnseignant) { /* Implémentation déjà donnée */ }
}

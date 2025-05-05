import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model66.Etudiant;
import dao.EtudiantDAO;

public class Main {

    private static final EtudiantDAO etudiantDAO = new EtudiantDAO();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // API CRUD pour les étudiants
        server.createContext("/api/etudiants", exchange -> {
            try {
                String method = exchange.getRequestMethod();
                if ("GET".equals(method)) {
                    List<Etudiant> etudiants = etudiantDAO.listerTous();
                    StringBuilder json = new StringBuilder("[");
                    for (int i = 0; i < etudiants.size(); i++) {
                        Etudiant e = etudiants.get(i);
                        json.append(String.format(
                            "{\"id\":%d, \"nom\":\"%s\", \"prenom\":\"%s\", \"email\":\"%s\", \"telephone\":\"%s\"}",
                            e.getID_Etudiant(), e.getNom(), e.getPrenom(), e.getEmail(), e.getTelephone()
                        ));
                        if (i < etudiants.size() - 1) json.append(",");
                    }
                    json.append("]");
                    sendJsonResponse(exchange, json.toString());
                } else if ("POST".equals(method)) {
                    InputStreamReader reader = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
                    StringBuilder body = new StringBuilder();
                    int c;
                    while ((c = reader.read()) != -1) body.append((char) c);
                    System.out.println("Reçu : " + body);

                    Pattern pattern = Pattern.compile("\"nom\":\"([^\"]+)\",\\s*\"prenom\":\"([^\"]+)\",\\s*\"email\":\"([^\"]+)\",\\s*\"telephone\":\"([^\"]+)\"");
                    Matcher matcher = pattern.matcher(body);
                    if (matcher.find()) {
                        Etudiant e = new Etudiant();
                        e.setNom(matcher.group(1));
                        e.setPrenom(matcher.group(2));
                        e.setEmail(matcher.group(3));
                        e.setTelephone(matcher.group(4));
                        etudiantDAO.ajouterEtudiant(e);
                        sendJsonResponse(exchange, "{\"status\":\"success\"}");
                    } else {
                        sendJsonResponse(exchange, "{\"error\":\"Invalid JSON format\"}", 400);
                    }
                } else {
                    sendJsonResponse(exchange, "{\"error\":\"Method not allowed\"}", 405);
                }
            } catch (Exception e) {
                e.printStackTrace();
                sendJsonResponse(exchange, "{\"error\":\"Internal server error\"}", 500);
            }
        });

        // Servir les fichiers statiques (HTML, CSS, images)
        server.createContext("/", exchange -> {
            String path = exchange.getRequestURI().getPath();
            if ("/".equals(path)) path = "/index.html";

            File file = new File("www" + path);
            if (!file.exists()) {
                exchange.sendResponseHeaders(404, 0);
                exchange.getResponseBody().close();
                return;
            }

            exchange.getResponseHeaders().set("Content-Type", getContentType(file.getName()));
            exchange.sendResponseHeaders(200, file.length());

            try (OutputStream os = exchange.getResponseBody();
                 FileInputStream fs = new FileInputStream(file)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fs.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        });

        server.setExecutor(null);
        server.start();
        System.out.println("✅ Serveur démarré sur http://localhost:8080/");
    }

    private static void sendJsonResponse(HttpExchange exchange, String json, int statusCode) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, json.length());
        OutputStream os = exchange.getResponseBody();
        os.write(json.getBytes(StandardCharsets.UTF_8));
        os.close();
    }

    private static void sendJsonResponse(HttpExchange exchange, String json) throws IOException {
        sendJsonResponse(exchange, json, 200);
    }

    private static String getContentType(String fileName) {
        if (fileName.endsWith(".html")) return "text/html";
        if (fileName.endsWith(".css")) return "text/css";
        if (fileName.endsWith(".js")) return "application/javascript";
        if (fileName.endsWith(".png")) return "image/png";
        if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) return "image/jpeg";
        return "application/octet-stream";
    }
}
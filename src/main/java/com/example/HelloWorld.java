package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HelloWorld { // Matches your filename exactly
    public static void main(String[] args) throws Exception {
        // Bind to port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", (exchange) -> {
            String response = "<h1>Success!</h1><p>Java Web Server is live on GCP VM.</p><p>Deployed via Jenkins Pipeline.</p>";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        System.out.println("Web Server started on port 8080...");
        server.setExecutor(null);
        server.start();
    }
}
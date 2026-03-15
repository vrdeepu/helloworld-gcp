package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HelloWorld { // Matches your filename exactly
    public static void main(String[] args) throws Exception {
        // Bind to port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);

        server.createContext("/", (exchange) -> {
            String response = "<h1>Success!</h1><p>Java Web Server is live on GCP VM.</p>";

            // Explicitly define as long to satisfy the method signature
            long responseLength = response.getBytes().length;

            exchange.sendResponseHeaders(200, (long) response.getBytes().length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        System.out.println("Web Server started on port 8081...");
        server.setExecutor(null);
        server.start();
    }
}
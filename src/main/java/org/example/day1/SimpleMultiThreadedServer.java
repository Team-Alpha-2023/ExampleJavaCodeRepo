package org.example.day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleMultiThreadedServer {

    public static void main(String[] args) {
        int port = 9095;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleRequest(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            if(out.equals("/ttt./")){
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n" +
                        "\r\n" +
                        "<html><body>" +
                        "<h1>ttt</h1>" +
                        "</body></html>";
            }else if(out.equals("/aaa")){
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n" +
                        "\r\n" +
                        "<html><body>" +
                        "<h1>aaaaa</h1>" +
                        "</body></html>";
            }

            // Process the request
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n" +
                    "\r\n" +
                    "<html><body>" +
                    "<h1>ABCD</h1>" +
                    "</body></html>";

            out.println(response);
        }

        clientSocket.close();
    }
}

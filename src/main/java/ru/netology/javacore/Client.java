package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        User user = new User();
        user.addTask("ADD", "Почитать");
        final String HOST = "localhost";
        final int PORT = 8989;
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            out.println(gson.toJson(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

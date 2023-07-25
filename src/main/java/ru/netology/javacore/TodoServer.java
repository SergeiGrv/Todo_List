package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    protected int port;

    protected Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(8989);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    System.out.println("New connection accepted");
                    String word = in.readLine();
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    User user  = gson.fromJson(word, User.class);
                    todos.addTask(user.task);
                    System.out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }

    }
}

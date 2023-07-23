package ru.netology.javacore;

public class User {

    protected String type;

    protected String task;

    public void addTask(String type, String task) {
        this.type = type;
        this.task = task;
    }
}

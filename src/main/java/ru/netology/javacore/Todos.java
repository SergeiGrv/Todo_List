package ru.netology.javacore;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Todos {

    public String[] tasks = new String[7];

    public void addTask(String task) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                tasks[i] = task;
                break;
            } else if (tasks[i].equals(task)) {
                break;
            }
        }
    }

    public void removeTask(String task) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].equals(task)) {
                tasks[i] = null;
                break;
            }
        }
    }

    public String getAllTasks() {
        return Arrays.stream(tasks)
                .filter(Objects::nonNull)
                .collect(Collectors.joining("\n"));
    }

}

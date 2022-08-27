package com.epam.rd.autotasks;

public class TaskCarousel {
    private final int capacity;
    private final Task[] tasks;
    private int taskCount = 0;
    private int currentIndex = 0;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        tasks = new Task[capacity];
    }

    public boolean addTask(Task task) {
        if (task != null && !task.isFinished() && !isFull()) {
            while (tasks[currentIndex] != null && !isEmpty()) {
                currentIndex++;
                if (currentIndex == capacity) currentIndex = 0;
            }
            tasks[currentIndex] = task;
            currentIndex++;
            taskCount++;
            return true;
        } else return false;
    }

    public boolean execute() {
        if (isEmpty()) return false;
        currentIndex++;
        if (currentIndex >= capacity) currentIndex = 0;
        while (tasks[currentIndex] == null && !isEmpty()) {
            currentIndex++;
            if (currentIndex == capacity) currentIndex = 0;
        }

        if (!tasks[currentIndex].isFinished()) {
            tasks[currentIndex].execute();
            if (tasks[currentIndex].isFinished()) {
                taskCount--;
                tasks[currentIndex] = null;
            }
            return true;
        } else {
            tasks[currentIndex] = null;
            return false;
        }
    }

    public boolean isFull() {
        return taskCount == capacity;
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        for (Task element : tasks) {
            if (element != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }
}

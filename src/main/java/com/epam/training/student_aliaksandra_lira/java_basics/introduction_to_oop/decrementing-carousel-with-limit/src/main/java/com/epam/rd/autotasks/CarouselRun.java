package com.epam.rd.autotasks;

public class CarouselRun {
    protected final int capacity;
    protected int[] container;
    protected int currentIndex = 0;

    public CarouselRun(int capacity, int[] container) {
        this.capacity = capacity;
        this.container = container;
    }

    public int next() {
        if (currentIndex == capacity) currentIndex = 0;
        if (isFinished()) return -1;
        int cache = container[currentIndex];
        while (cache == 0) {
            currentIndex++;
            if (currentIndex == capacity) currentIndex = 0;
            cache = container[currentIndex];
        }
        container[currentIndex]--;
        currentIndex++;
        return cache;
    }

    public boolean isFinished() {
        boolean isFinished = true;
        for (int element : container) {
            if (element != 0) {
                isFinished = false;
                break;
            }
        }
        return isFinished;
    }
}

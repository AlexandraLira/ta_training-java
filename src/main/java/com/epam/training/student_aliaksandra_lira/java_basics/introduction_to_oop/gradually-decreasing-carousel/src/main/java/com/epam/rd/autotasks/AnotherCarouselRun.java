package com.epam.rd.autotasks;

public class AnotherCarouselRun extends CarouselRun {
    protected int decrement = 1;

    public AnotherCarouselRun(int capacity, int[] container) {
        super(capacity, container);
    }

    @Override
    public int next() {
        if (currentIndex == capacity) {
            currentIndex = 0;
            decrement++;
        }
        if (isFinished()) return -1;
        int cache = container[currentIndex];
        while (cache == 0) {
            currentIndex++;
            if (currentIndex == capacity) {
                currentIndex = 0;
                decrement++;
            }
            cache = container[currentIndex];
        }
        container[currentIndex] -= decrement;
        if (container[currentIndex] < 0) container[currentIndex] = 0;
        currentIndex++;
        return cache;
    }
}


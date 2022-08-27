package com.epam.rd.autotasks;

public class AnotherCarouselRun extends CarouselRun {
    public AnotherCarouselRun(int capacity, int[] container) {
        super(capacity, container);
    }

    @Override
    public int next() {
        if (currentIndex == capacity) currentIndex = 0;
        if (isFinished()) return -1;
        int cache = container[currentIndex];
        while (cache == 0) {
            currentIndex++;
            if (currentIndex == capacity) currentIndex = 0;
            cache = container[currentIndex];
        }
        container[currentIndex] = container[currentIndex] / 2;
        currentIndex++;
        return cache;
    }

}

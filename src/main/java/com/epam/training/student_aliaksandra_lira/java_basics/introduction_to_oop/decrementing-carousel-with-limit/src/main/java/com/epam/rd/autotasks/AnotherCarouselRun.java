package com.epam.rd.autotasks;

public class AnotherCarouselRun extends CarouselRun {
    private final int actionLimit;
    private int nextMethodExecutionCount;

    public AnotherCarouselRun(int capacity, int[] container, int actionLimit) {
        super(capacity, container);
        this.actionLimit = actionLimit;
    }

    @Override
    public int next() {
        if (nextMethodExecutionCount != actionLimit) {
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
            nextMethodExecutionCount++;
            if (nextMethodExecutionCount == actionLimit) container = new int[capacity];
            return cache;
        } else {
            return -1;
        }
    }

}

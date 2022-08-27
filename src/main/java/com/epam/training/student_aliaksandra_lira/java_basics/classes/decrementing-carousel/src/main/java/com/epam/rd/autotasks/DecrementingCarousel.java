package com.epam.rd.autotasks;

public class DecrementingCarousel {
    private final int capacity;
    private final int[] container;
    private int elementCount = 0;
    private int runCount = 0;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        container = new int[capacity];
    }

    public boolean addElement(int element) {
        if (element > 0 && elementCount < capacity && runCount == 0) {
            container[elementCount] = element;
            elementCount++;
            return true;
        } else return false;
    }

    public CarouselRun run() {
        if (runCount == 0) {
            CarouselRun carouselRun = new CarouselRun(capacity, container);
            runCount++;
            return carouselRun;
        } else return null;
    }
}

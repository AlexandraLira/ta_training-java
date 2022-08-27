package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public AnotherCarouselRun run() {
        if (runCount == 0) {
            AnotherCarouselRun anotherCarouselRun = new AnotherCarouselRun(capacity, container);
            runCount++;
            return anotherCarouselRun;
        } else return null;
    }

}

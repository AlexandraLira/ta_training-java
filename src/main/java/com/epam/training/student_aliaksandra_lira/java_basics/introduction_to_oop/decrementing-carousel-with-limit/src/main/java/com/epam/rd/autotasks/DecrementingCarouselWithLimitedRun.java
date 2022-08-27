package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel {
    private final int actionLimit;

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }

    @Override
    public CarouselRun run() {
        if (runCount == 0) {
            CarouselRun carouselRun = new AnotherCarouselRun(capacity, container, actionLimit);
            runCount++;
            return carouselRun;
        } else return null;
    }
}

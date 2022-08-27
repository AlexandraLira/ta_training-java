package com.epam.rd.autotasks;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    private int degrees;

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    public static Direction ofDegrees(int degrees) {
        while (degrees < 0) degrees += 360;
        while (degrees >= 360) degrees -= 360;
        for (Direction direction : Direction.values()) {
            if (degrees == direction.degrees) return direction;
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        Direction closestDegrees = null;
        int difference;
        int closest = 360;
        while (degrees < 0) degrees += 360;
        while (degrees >= 360) degrees -= 360;
        for (Direction direction : Direction.values()) {
            difference = Math.abs(degrees - direction.degrees);
            if (difference < closest) {
                closest = difference;
                closestDegrees = direction;
            }
        }
        return closestDegrees;
    }

    public Direction opposite() {
        while (degrees < 0) degrees += 360;
        while (degrees >= 360) degrees -= 360;
        int oppositeOfDegress = (degrees + 180);
        return ofDegrees(oppositeOfDegress);
    }

    public int differenceDegreesTo(Direction direction) {
        int difference = Math.abs(degrees - direction.degrees);
        if (difference > 180) {
            difference = 360 - difference;
        }
        return difference;
    }
}

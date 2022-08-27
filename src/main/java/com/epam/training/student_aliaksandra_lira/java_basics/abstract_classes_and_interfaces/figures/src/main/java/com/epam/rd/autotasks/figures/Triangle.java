package com.epam.rd.autotasks.figures;

import java.util.Arrays;
import java.util.Comparator;

class Triangle extends Figure {
    private final Point a, b, c;
    private final Point[] array;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        array = new Point[]{a, b, c};
    }

    @Override
    public double area() {
        return Math.abs(0.5 * ((c.getX() - a.getX()) * (b.getY() - a.getY()) -
                (c.getY() - a.getY()) * (b.getX() - a.getX())));
    }

    @Override
    public String pointsToString() {
        return String.format("(%s,%s)(%s,%s)(%s,%s)", a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY());
    }

    @Override
    public String toString() {
        return String.format("Triangle[(%s,%s)(%s,%s)(%s,%s)]", a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY());
    }

    @Override
    public Point leftmostPoint() {
        Comparator<Point> comparator = (point1, point2) -> (int) (point1.getX() - point2.getX());
        Arrays.sort(array, comparator);
        return array[0];
    }
}

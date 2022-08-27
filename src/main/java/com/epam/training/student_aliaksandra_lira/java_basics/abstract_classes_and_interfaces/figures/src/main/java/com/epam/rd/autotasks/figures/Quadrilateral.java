package com.epam.rd.autotasks.figures;

import java.util.Arrays;
import java.util.Comparator;

class Quadrilateral extends Figure {

    private final Point a, b, c, d;
    private final Point[] array;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        array = new Point[]{a, b, c, d};
    }

    @Override
    public double area() {
        return Math.abs((a.getX() - b.getX()) * (a.getY() + b.getY()) +
                (b.getX() - c.getX()) * (b.getY() + c.getY()) +
                (c.getX() - d.getX()) * (c.getY() + d.getY()) +
                (d.getX() - a.getX()) * (d.getY() + a.getY())) / 2;
    }

    @Override
    public String pointsToString() {
        return String.format("(%s,%s)(%s,%s)(%s,%s)(%s,%s)", a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY(), d.getX(), d.getY());
    }

    @Override
    public String toString() {
        return String.format("Quadrilateral[(%s,%s)(%s,%s)(%s,%s)(%s,%s)]", a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY(), d.getX(), d.getY());
    }

    @Override
    public Point leftmostPoint() {
        Comparator<Point> comparator = (point1, point2) -> (int) (point1.getX() - point2.getX());
        Arrays.sort(array, comparator);
        return array[0];
    }
}

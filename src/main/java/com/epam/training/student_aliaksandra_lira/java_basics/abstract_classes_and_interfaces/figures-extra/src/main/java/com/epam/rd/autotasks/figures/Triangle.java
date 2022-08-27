package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private final Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (nullCheck() || area() == 0) throw new IllegalArgumentException();
    }

    public double area() {
        return Math.abs(0.5 * ((c.getX() - a.getX()) * (b.getY() - a.getY()) -
                (c.getY() - a.getY()) * (b.getX() - a.getX())));
    }

    @Override
    public Point centroid() {
        double x = (a.getX() + b.getX() + c.getX()) / 3.0;
        double y = (a.getY() + b.getY() + c.getY()) / 3.0;
        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        double areaDelta = Math.abs(area() - ((Triangle) figure).area());
        double centroidDeltaX = Math.abs(centroid().getX() - figure.centroid().getX());
        double centroidDeltaY = Math.abs(centroid().getY() - figure.centroid().getY());
        return getClass() == figure.getClass() && areaDelta < ERROR_DELTA &&
                centroidDeltaX < ERROR_DELTA && centroidDeltaY < ERROR_DELTA;

    }

    private boolean nullCheck() {
        return a == null || b == null || c == null;
    }
}

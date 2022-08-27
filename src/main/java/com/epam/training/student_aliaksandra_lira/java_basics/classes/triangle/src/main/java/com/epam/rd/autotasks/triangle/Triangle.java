package com.epam.rd.autotasks.triangle;

class Triangle {
    Point a, b, c;
    double aSide;
    double bSide;
    double cSide;

    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException();
        }
        if ((a.getX() - b.getX()) * (c.getY() - b.getY()) - (a.getY() - b.getY()) * (c.getX() - b.getX()) == 0)
            throw new IllegalArgumentException();

        this.aSide = a.getX() - b.getX();
        this.bSide = a.getY() - b.getY();
        this.cSide = Math.sqrt(this.aSide * this.aSide + this.bSide * this.bSide);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        return Math.abs(0.5 * ((c.getX() - a.getX()) * (b.getY() - a.getY()) -
                (c.getY() - a.getY()) * (b.getX() - a.getX())));
    }

    public Point centroid() {
        double x = (a.getX() + b.getX() + c.getX()) / 3.0;
        double y = (a.getY() + b.getY() + c.getY()) / 3.0;
        return new Point(x, y);
    }

}

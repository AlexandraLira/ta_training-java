package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Quadrilateral extends Figure {

    private final Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if (nullCheck() || !isConvex() || isDegenerate() || area() == 0)
            throw new IllegalArgumentException();
    }

    public double area() {
        return Math.abs((a.getX() - b.getX()) * (a.getY() + b.getY()) +
                (b.getX() - c.getX()) * (b.getY() + c.getY()) +
                (c.getX() - d.getX()) * (c.getY() + d.getY()) +
                (d.getX() - a.getX()) * (d.getY() + a.getY())) / 2;
    }

    @Override
    public Point centroid() {
        Point centreABC = new Triangle(a, b, c).centroid();
        Point centreADC = new Triangle(a, d, c).centroid();
        Point centreABD = new Triangle(a, b, d).centroid();
        Point centreCBD = new Triangle(c, b, d).centroid();
        return intersection(centreABC, centreADC, centreABD, centreCBD);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        double areaDelta = Math.abs(area() - ((Quadrilateral) figure).area());
        double centroidDeltaX = Math.abs(centroid().getX() - figure.centroid().getX());
        double centroidDeltaY = Math.abs(centroid().getY() - figure.centroid().getY());
        return getClass() == figure.getClass() &&
                areaDelta < ERROR_DELTA &&
                centroidDeltaX < ERROR_DELTA &&
                centroidDeltaY < ERROR_DELTA;
    }

    private Point intersection(Point start1, Point end1, Point start2, Point end2) {
        double denominator = (end2.getY() - start2.getY()) *
                (end1.getX() - start1.getX()) - (end2.getX() - start2.getX()) *
                (end1.getY() - start1.getY());
        if (denominator == 0) {
            return null;
        }
        double u1 = ((end2.getX() - start2.getX()) *
                (start1.getY() - start2.getY()) - (end2.getY() - start2.getY()) *
                (start1.getX() - start2.getX())) / denominator;
        double u2 = ((end1.getX() - start1.getX()) *
                (start1.getY() - start2.getY()) - (end1.getY() - start1.getY()) *
                (start1.getX() - start2.getX())) / denominator;
        if (!(u1 >= 0 && u1 <= 1) || !(u2 >= 0 && u2 <= 1)) {
            return null;
        }
        double x = start1.getX() + u1 * (end1.getX() - start1.getX());
        double y = start1.getY() + u1 * (end1.getY() - start1.getY());
        return new Point(x, y);
    }

    private boolean nullCheck() {
        return a == null || b == null || c == null || d == null;
    }

    private boolean isConvex() {
        double areaABC = new Triangle(a, b, c).area();
        double areaADC = new Triangle(a, d, c).area();
        double areaABD = new Triangle(a, b, d).area();
        double areaCBD = new Triangle(c, b, d).area();
        return areaABC + areaADC == areaABD + areaCBD;
    }

    private boolean isDegenerate() {
        double AB = sqrt(pow((b.getX() - a.getX()), 2) + pow((b.getY() - a.getY()), 2));
        double BC = sqrt(pow((c.getX() - b.getX()), 2) + pow((c.getY() - b.getY()), 2));
        double CD = sqrt(pow((d.getX() - c.getX()), 2) + pow((d.getY() - c.getY()), 2));
        double DA = sqrt(pow((a.getX() - d.getX()), 2) + pow((a.getY() - d.getY()), 2));
        return AB + BC + CD < DA && BC + CD + DA < AB && CD + DA + AB < BC && DA + AB + BC < CD;
    }
}

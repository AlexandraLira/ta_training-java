package com.epam.rd.autotasks.segments;

class Segment {

    private final Point start;
    private final Point end;

    public Segment(Point start, Point end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException();
        }
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.end = end;

    }

    double length() {
        double xDistance = Math.pow(start.getX() - end.getX(), 2);
        double yDistance = Math.pow(start.getY() - end.getY(), 2);
        return Math.sqrt(xDistance + yDistance);
    }

    Point middle() {
        return new Point((start.getX() + end.getX()) / 2,
                (start.getY() + end.getY()) / 2);
    }

    Point intersection(Segment another) {
        double dx1 = end.getX() - start.getX();
        double dy1 = end.getY() - start.getY();
        double dx2 = another.end.getX() - another.start.getX();
        double dy2 = another.end.getY() - another.start.getY();
        double dxx = start.getX() - another.start.getX();
        double dyy = start.getY() - another.start.getY();
        double div, t, s;

        div = dy2 * dx1 - dx2 * dy1;
        if (Math.abs(div) < 1.0e-10) return null;

        t = (dx1 * dyy - dy1 * dxx) / div;
        if (t < 0 || t > 1.0) return null;

        s = (dx2 * dyy - dy2 * dxx) / div;
        if (s < 0 || s > 1.0) return null;

        return new Point(start.getX() + s * dx1, start.getY() + s * dy1);
    }
}

package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private final Point centre;
    private final double radius;

    public Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
        if (this.radius <= 0 || this.centre == null) throw new IllegalArgumentException();
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public Point centroid() {
        return centre;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return getClass() == figure.getClass() &&
                Math.abs(radius - ((Circle) figure).radius) < ERROR_DELTA &&
                Math.abs(centre.getX() - ((Circle) figure).centre.getX()) < ERROR_DELTA &&
                Math.abs(centre.getY() - ((Circle) figure).centre.getY()) < ERROR_DELTA;
    }
}

package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private final Point centre;
    private final double radius;

    public Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;

    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public Point leftmostPoint() {
        return new Point(centre.getX() - radius, centre.getY());
    }

    @Override
    public String pointsToString() {
        return String.format("(%s,%s)", centre.getX(), centre.getY());
    }

    @Override
    public String toString() {
        return String.format("Circle[(%s,%s)%s]", centre.getX(), centre.getY(), radius);
    }
}

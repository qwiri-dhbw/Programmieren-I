package io.d2a.dhbw._20220214.clazz;

public class Point {

    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(final double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(final double y) {
        this.y = y;
    }

    public double distanceToOrigin() {
        return Math.sqrt((this.x * this.x) + (this.y * this.y));
    }

    public Point mirrorX() {
        return new Point(-this.x, this.y);
    }

    public Point mirrorY() {
        return new Point(this.x, -this.y);
    }

    public Point mirrorOrigin() {
        return new Point(-this.x, -this.y);
    }

    public double distance(final Point b) {
        final double dX = Math.abs(this.x - b.x);
        final double dY = Math.abs(this.y - b.y);

        return Math.sqrt((dX * dX) + (dY * dY));
    }

    @Override
    public String toString() {
        return "Point{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
}

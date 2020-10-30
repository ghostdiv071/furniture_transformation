package com.company;

public class Vector2 {

    private double x, y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2 add(Vector2 vector) {
        return new Vector2(x + vector.getX(),
                y + vector.getY());
    }

    public Vector2 multiply(double number) {
        return new Vector2(x * number,
                y * number);
    }

    public Vector2 normalized() {
        double length = Math.sqrt(x * x + y * y);
        if (Math.abs(length) < 1e-15)
            return new Vector2(0, 0);
        return new Vector2(x / length, y / length);
    }
}

package com.company;

public class ScreenConverter {

    private double rX, rY, rW, rH;
    private int sW, sH;

    public ScreenConverter(double rX, double rY, double rW, double rH, int sW, int sH) {
        this.rX = rX;
        this.rY = rY;
        this.rW = rW;
        this.rH = rH;
        this.sW = sW;
        this.sH = sH;
    }

    public double getrX() {
        return rX;
    }

    public void setrX(double rX) {
        this.rX = rX;
    }

    public double getrY() {
        return rY;
    }

    public void setrY(double rY) {
        this.rY = rY;
    }

    public double getrW() {
        return rW;
    }

    public void setrW(double rW) {
        this.rW = rW;
    }

    public double getrH() {
        return rH;
    }

    public void setrH(double rH) {
        this.rH = rH;
    }

    public int getsW() {
        return sW;
    }

    public void setsW(int sW) {
        this.sW = sW;
    }

    public int getsH() {
        return sH;
    }

    public void setsH(int sH) {
        this.sH = sH;
    }

    public ScreenPoint r2s(Vector2 vector) {
        int i = (int) ((vector.getX() - rX) * sW / rW);
        int j = (int) ((rY - vector.getY()) * sH / rH);
        return new ScreenPoint(i, j);
    }

    public Vector2 s2r(ScreenPoint point) {
        double x = rX + point.getI() * rW / sW;
        double y = rY - point.getJ() * rH / sH;
        return new Vector2(x, y);
    }
}

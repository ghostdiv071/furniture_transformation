package com.company;

public class Element {

    private Vector2 p1, p2;

    public Element(Vector2 p1, Vector2 p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Vector2 getP1() {
        return p1;
    }

    public void setP1(Vector2 p1) {
        this.p1 = p1;
    }

    public Vector2 getP2() {
        return p2;
    }

    public void setP2(Vector2 p2) {
        this.p2 = p2;
    }
}

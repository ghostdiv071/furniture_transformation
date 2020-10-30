package com.company;

public class Furniture {

    private Element leg, back, surface, edge;

    public Furniture(Element leg, Element back, Element surface, Element dist2Edge) {
        this.leg = leg;
        this.back = back;
        this.surface = surface;
        this.edge = dist2Edge;
    }

    public Element getLeg() {
        return leg;
    }

    public void setLeg(Element leg) {
        this.leg = leg;
    }

    public Element getBack() {
        return back;
    }

    public void setBack(Element back) {
        this.back = back;
    }

    public Element getSurface() {
        return surface;
    }

    public void setSurface(Element surface) {
        this.surface = surface;
    }

    public Element getEdge() {
        return edge;
    }

    public void setEdge(Element edge) {
        this.edge = edge;
    }

}

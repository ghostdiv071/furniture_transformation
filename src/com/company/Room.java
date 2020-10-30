package com.company;

import java.awt.*;

public class Room {

    private Furniture furniture;
    private Furniture initial, finish;

    public Room(Furniture initialState, Furniture finalState) {
        this.initial = initialState;
        this.finish = finalState;
        this.furniture = initialState;
    }

    public void  update(double coefficient) {
        furniture.setBack(changePiece(initial.getBack(), finish.getBack(), coefficient));
        furniture.setEdge(changePiece(initial.getEdge(), finish.getEdge(), coefficient));
        furniture.setLeg(changePiece(initial.getLeg(), finish.getLeg(), coefficient));
        furniture.setSurface(changePiece(initial.getSurface(),
                finish.getSurface(), coefficient)
        );
    }

    private Element changePiece(Element el1, Element el2, double c) {
        double px1 = el1.getP1().getX() + c*(el2.getP1().getX() - el1.getP1().getX());
        double py1 = el1.getP1().getY() + c*(el2.getP1().getY() - el1.getP1().getY());
        Vector2 v1 = new Vector2(px1, py1);
        double px2 = el1.getP2().getX() + c*(el2.getP2().getX() - el1.getP2().getX());
        double py2 = el1.getP2().getY() + c*(el2.getP2().getY() - el1.getP2().getY());
        Vector2 v2 = new Vector2(px2, py2);
        return new Element(v1, v2);
    }

    public void draw(Graphics2D graphics, ScreenConverter converter) {
        drawElement(graphics, furniture.getBack(), converter);
        drawElement(graphics, furniture.getSurface(), converter);
        drawElement(graphics, furniture.getLeg(), converter);
        drawElement(graphics,
                new Element(furniture.getSurface().getP2(),
                new Vector2(furniture.getSurface().getP2().getX(),
                        furniture.getLeg().getP1().getY())
                ), converter);
        drawElement(graphics, furniture.getEdge(), converter);
        drawElement(graphics, new Element(furniture.getSurface().getP2(),
                new Vector2(furniture.getSurface().getP2().getX() +
                        (furniture.getEdge().getP2().getX() -
                        furniture.getEdge().getP1().getX()),
                        furniture.getEdge().getP1().getY())), converter
        );
    }

    private void drawElement(Graphics2D g, Element el, ScreenConverter sc) {
        ScreenPoint p1 = sc.r2s(el.getP1());
        ScreenPoint p2 = sc.r2s(el.getP2());
        g.setColor(Color.WHITE);
        g.drawLine(p1.getI(), p1.getJ(), p2.getI(), p2.getJ());
    }

}

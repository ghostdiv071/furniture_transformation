package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements ActionListener {

    private ScreenConverter converter;
    private Room room;
    private long time;
    private Timer timer;

    private static final int delay = 40;
    private static final int duration = 50;

    public DrawPanel() {
        super();
        converter = new ScreenConverter(-5,5,
                10, 10, 500, 500
        );
        room = new Room(setTable(), setChair());
        time = System.currentTimeMillis();
        timer = new Timer(delay,this);
        timer.start();
    }

    @Override
    public void paint(Graphics graphics) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        room.draw(graphics2D, converter);
        graphics.drawImage(image,0,0,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long newTime = System.currentTimeMillis();
        double coefficient = (newTime - time)*0.001/duration;
        if (coefficient != 1) {
            room.update(coefficient);
            repaint();
        }
    }

    private Furniture setChair() {
        Element leg = new Element(new Vector2(-4,1), new Vector2(-4,2));
        Element back = new Element(new Vector2(-3,2), new Vector2(-3,3));
        Element surface = new Element(new Vector2(-4,2), new Vector2(-3,2));
        Element edge = new Element(new Vector2(-4,2), new Vector2(-4,2));
        return new Furniture(leg, back, surface, edge);
    }

    private Furniture setTable() {
        Element leg = new Element(new Vector2(1,1), new Vector2(1,2));
        Element back = new Element(new Vector2(3,2), new Vector2(3,2));
        Element surface = new Element(new Vector2(1,2), new Vector2(3,2));
        Element edge = new Element(new Vector2(0,2), new Vector2(1,2));
        return new Furniture(leg, back, surface, edge);
    }
}

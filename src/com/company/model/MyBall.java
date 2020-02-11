package com.company.model;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MyBall extends Ellipse2D.Double {
    private int value;
    private Color color;
    private double newX=1;
    private double newY=-0.5;

    public MyBall(){
        super();
        width=20;
        height=20;
    }

    public void newPosition(){
      setX(x+newX);
      setY(y+newY);
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }

    public double getNewX() {
        return newX;
    }

    public void setNewX(double newX) {
        this.newX = newX;
    }

    public double getNewY() {
        return newY;
    }

    public void setNewY(double newY) {
        this.newY = newY;
    }

    @Override
    public double getX() {
        return super.getX();
    }
    @Override
    public double getY() {
        return super.getY();
    }


}

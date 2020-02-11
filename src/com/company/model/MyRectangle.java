package com.company.model;

import com.company.controller.MyFrame;

import javax.lang.model.element.NestingKind;
import java.awt.*;


public class MyRectangle extends Rectangle {
    private int id;
    private NestingKind name;
    private int value;
    private Color color;

    public MyRectangle(){
        super(1300/10,850/10);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NestingKind getName() {
        return name;
    }

    public void setName(NestingKind name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}

package com.company.controller;

import com.company.model.Partition;
import com.company.model.MyBall;
import com.company.model.MyRectangle;
import com.company.presentation.Navigator;
import com.company.presentation.NavigatorImp;
import com.company.presentation.ShapeGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CustomPaint extends JPanel {

    private Rectangle rectangle;
    private Partition partition = Partition.BOTTOM;
    private MyBall ball;
    private ArrayList<MyRectangle> rectangleArrayList = new ArrayList<>();
    private ShapeGenerator shapeGenerator;
    private NavigatorImp navigator;

    public CustomPaint() {
        super();
        shapeGenerator = new ShapeGenerator();
        rectangleArrayList = shapeGenerator.panelInitialize();
        ball = shapeGenerator.ballGenerator();
        navigator=new Navigator();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        rectangleArrayList.forEach(x -> {
            g2d.setColor(x.getColor());
            g2d.fill(x);
        });
        g2d.setColor(Color.black);
        g2d.fill(ball);
    }

    public void moveBall() {
        navigator.navigate(ball);
        ball.newPosition();

        repaint();
    }

    public void autoNavigator() {
        
        if (ball.x >= 1300)
            partition = Partition.RIGHT;
        if (ball.x <= 0)
            partition = Partition.LEFT;
        if (ball.y <= 0)
            partition = Partition.UPPER;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void setRectangleArrayList(ArrayList<MyRectangle> rectangleArrayList) {
        this.rectangleArrayList = rectangleArrayList;
        repaint();
    }

    public void resetBall() {
        ball = shapeGenerator.ballGenerator();
        partition=Partition.BOTTOM;
        repaint();
    }

    public MyBall getBall() {
        return ball;
    }
}

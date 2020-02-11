package com.company.presentation;

import com.company.model.MyBall;
import com.company.model.MyRectangle;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

public class ShapeGenerator {
    private Random random;
    private ArrayList<MyRectangle> shapes = new ArrayList<>();

    public ShapeGenerator() {
        random = new Random();
    }

    public ArrayList<MyRectangle> panelInitialize() {

        for (int i = 0; i < 11; i++) {
            MyRectangle rect = new MyRectangle();
            if (i > 0)
                rect.x = 133 * i;
            rect.setColor(Color.RED);
            rect.setValue(random.nextInt(25));
            if (random.nextBoolean())
                shapes.add(rect);
        }
        return shapes;
    }

    public MyBall ballGenerator() {
        MyBall ball = new MyBall();
        ball.x = (float) 1300 / 2;
        ball.y = 775;
        return ball;
    }
}

package com.company.presentation;

import com.company.model.MyBall;

public class Navigator implements NavigatorImp {

    @Override
    public MyBall navigate(MyBall ball) {
        System.out.println(ball.getNewX());
        if (ball.x+ball.getNewX()>=1300 || ball.x+ball.getNewX()<=0)
            ball.setNewX(-ball.getNewX());

        if (ball.y+ball.getNewY()<=0)
            ball.setNewY(-ball.getNewY());

        return ball;
    }
}

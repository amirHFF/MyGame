package com.company.controller;

import com.company.model.MyBall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    private CustomPaint paint;
    private MyBall ball;
    private Timer timer;
    private JButton Go, again;
    private JTextField t1, t2;
    private JPanel southPanel = new JPanel();

    public MyFrame() {
        super("This is my game");
        getContentPane().setLayout(new BorderLayout());

        paint = new CustomPaint();

        paint.setRectangle(new Rectangle(20, 20, 50, 60));
        paint.repaint();
        getContentPane().add(paint, BorderLayout.CENTER);

        Go = new JButton("GO");
        getContentPane().add(southPanel, BorderLayout.SOUTH);
        t1 = new JTextField();
        t1.setPreferredSize(new Dimension(50, 20));
        t2 = new JTextField();
        t2.setPreferredSize(new Dimension(50, 20));
        again = new JButton("again");
        southPanel.add(Go);
        southPanel.add(again);
        southPanel.add(t1);
        southPanel.add(t2);
        southPanel.setLayout(new FlowLayout());

        again.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                paint.resetBall();
            }
        });
        Go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paint.autoNavigator();
                paint.moveBall();
            }
        });
    }

}

package com.bolosea.algorithm.chapter2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author pineapple
 * @create 2018-07-04 17:54
 **/
public class AlgoFrame extends JFrame{
    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title,int width,int height){
        super(title);
        this.canvasWidth = width;
        this.canvasHeight = height;
        //this.setSize(width,height);
        AlgoCanvas canvas = new AlgoCanvas();
        this.setContentPane(canvas);
        pack();
        this.setVisible(true);
        //设置窗口大小不能拖拉
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public AlgoFrame(String title){

        this(title,1024,768);
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            //开启双缓存
            super(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;

            //开启抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            AlgoVisHelper.setColor(g2d,Color.MAGENTA);
            AlgoVisHelper.fillCircle(g2d,canvasWidth/2,canvasHeight/2,200);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth,canvasHeight);
        }
    }

}

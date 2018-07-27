package com.bolosea.algorithm.chapter2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AlgoController {
    private Circle[] circles;
    private AlgoFrame frame;
    //是否运动
    private boolean isAnimated = true;

    public AlgoController(int sceneWidth,int sceneHeight,int N){
        circles = new Circle[N];
        int R = 50;
        for(int i = 0 ; i < N ; i ++ ) {
            int x = (int)(Math.random()*(sceneWidth-2*R)) + R;
            int y = (int)(Math.random()*(sceneHeight-2*R)) + R;
            int vx = (int)(Math.random()*11) - 5;
            int vy = (int)(Math.random()*11) - 5;
            circles[i] = new Circle(x, y, R, vx, vy);
        }
        frame = new AlgoFrame("",sceneWidth,sceneHeight);
		frame.addKeyListener(new AlgoKeyListener());
        new Thread(() -> {
            run();
        }).start();
    }

    public void run(){
        while(true) {
            // 绘制数据
            frame.render(circles);
            AlgoVisHelper.pause(10);
            if (isAnimated) {
	            // 更新数据
	            for (Circle circle : circles) {
		            circle.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight());
	            }
            }
        }
    }
    private class AlgoKeyListener extends KeyAdapter{
	    @Override
	    public void keyPressed(KeyEvent e) {
		    if (e.getKeyChar() == ' '){
		    	isAnimated = !isAnimated;
		    }
	    }
    }
}

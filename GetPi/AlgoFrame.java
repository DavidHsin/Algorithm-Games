import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;

public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    // 设置自己的数据
    private Circle circle;				//首先创建一个圆
    private LinkedList<Point> points;	//其次，创建很多点
    public void render(Circle circle, LinkedList<Point> points){
        this.circle = circle;
        this.points = points;
        repaint();
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            // 绘制自己的数据data
            AlgoVisHelper.setStrokeWidth(g2d, 3);	//将圆的线条宽度设为3
            AlgoVisHelper.setColor(g2d, AlgoVisHelper.Blue);
            AlgoVisHelper.strokeCircle(g2d, circle.getX(), circle.getY(), circle.getR());
            
            //绘制所有的点
            for(int i = 0; i < points.size(); i++) {
            	Point p = points.get(i);
            	if(circle.contain(p)) {
            		AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);		//如果这个点在圆内，就设置为红色
            	}else {
            		AlgoVisHelper.setColor(g2d, AlgoVisHelper.Green);	//反之，就设置为绿色
            	}
            	AlgoVisHelper.fillCircle(g2d, p.x, p.y, 3);	//用一个实心小圆来表示这个点
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}



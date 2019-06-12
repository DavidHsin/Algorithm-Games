import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

class AlgoFrame extends JFrame {
	
	//设置private是因为，在初始化之后，不可以让外部用户改变窗口的长和宽
	private int canvasWidth;
	private int canvasHeight;
	
	public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
		
		super(title);										//设置窗口的title
		
		//此处的this都可以省略
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		
		AlgoCanvas canvas = new AlgoCanvas();
//		canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
		this.setContentPane(canvas);//设置canvas为内容面板
		pack();						//对加载的内容进行整理
		
		this.setResizable(false);							//不允许用户自行改变窗口大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//原本点击关闭窗口是隐藏，现在是关闭
		
		this.setVisible(true);								//把窗口显示出来
	}
	
	//只传来一个窗口标题，那就默认窗口大小
	public AlgoFrame(String title) {
		this(title, 600, 600);
	}
	
	//如果外部用户想要知道窗口的长和宽，可以通过访问get函数来实现
	public int getCanvasWidth() {
		return canvasWidth;
	}
	
	public int getCanvasHeight() {
		return canvasHeight;
	}
	
	//对内容面板进行绘制
	private class AlgoCanvas extends JPanel {
		
		@Override
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			//使用Graphics2D绘图
			Graphics2D g2d = (Graphics2D)g;
			
			//改变空心圆线条的粗细
			int strokeWidth = 5;			//默认是1，现在设置为10
			g2d.setStroke(new BasicStroke(strokeWidth));
			
			g2d.setColor(Color.red);		//改变线条的颜色
			Ellipse2D circle = new Ellipse2D.Double(50, 50, 300, 300);
			g2d.draw(circle);
			
			//绘制一个实心圆，并改变颜色
			g2d.setColor(Color.blue);
			Ellipse2D circle2 = new Ellipse2D.Double(50, 50, 300, 300);
			g2d.fill(circle2);
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth, canvasHeight);
		}
	}
}

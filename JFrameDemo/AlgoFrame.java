import java.awt.*;
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
		
		public AlgoCanvas() {
			super(true);	//boolean isDoubleBuffered: true(支持双缓存机制)
		}
		
		@Override
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			//使用Graphics2D绘图
			Graphics2D g2d = (Graphics2D)g;
			
			//抗锯齿
			RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.addRenderingHints(hints);
			
			//调用绘制工具辅助函数
			AlgoVisHelper.setStrokeWidth(g2d, 5);
			
			//具体绘制
			AlgoVisHelper.setColor(g2d, Color.blue);
			AlgoVisHelper.fillCircle(g2d, canvasWidth / 2, canvasHeight / 2, 200);
			
			AlgoVisHelper.setColor(g2d, Color.red);
			AlgoVisHelper.strokeCircle(g2d, canvasWidth / 2, canvasHeight / 2, 200);
			
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth, canvasHeight);
		}
	}
}

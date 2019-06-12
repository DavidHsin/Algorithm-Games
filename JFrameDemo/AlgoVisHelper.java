import java.awt.*;
import java.awt.geom.Ellipse2D;

//算法绘制的辅助函数，将它设置成类似于Math函数的形式，直接调用Math.abs()
public class AlgoVisHelper {
	
	private AlgoVisHelper() {}
	
	//设置画笔的粗细
	public static void setStrokeWidth(Graphics2D g2d, int w) {
		int strokeWidth = 5;			//默认是1，现在设置为10
		g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));	
	}
	
	//设置线条颜色
	public static void setColor(Graphics2D g2d, Color color) {
		g2d.setColor(color);
	}
	
	//在x和y这两个像素点上，绘制一个半径为r的空心圆
	public static void strokeCircle(Graphics2D g2d, int x, int y, int r) {
		//对于屏幕坐标系而言，原点在左上角的位置，2*r就是直径
		Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
		g2d.draw(circle);
	}
	
	//同样创建一个实心圆
	public static void fillCircle(Graphics2D g2d, int x, int y, int r) {
		//对于屏幕坐标系而言，原点在左上角的位置，2*r就是直径
		Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
		g2d.fill(circle);
	}
	
	//设置sleep
	public static void pause(int t) {
		try {
			Thread.sleep(t);
		}
		
		catch(InterruptedException e) {
			System.out.println("Error in sleeping.");
		}
	}
}

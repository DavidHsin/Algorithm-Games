import java.awt.Point;

public class Circle {
	
	//设置圆心的坐标x, y和半径r
	private int x, y, r;
	
	public Circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getR() {
		return r;
	}
	
	//返回这个p点是否在圆内
	public boolean contain(Point p) {
		return Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2) <= r * r;
	}
}

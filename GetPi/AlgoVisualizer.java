import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class AlgoVisualizer {
	
	private static int DELAY = 40;

    // 创建自己的数据
	private Circle circle;
	private LinkedList<Point> points;
    private AlgoFrame frame;    // 视图
    private int N;				//用户自定义打进去多少点

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){
    	
    	//因为内部是一个圆，所以创建成一个正方形的窗口
    	if(sceneWidth != sceneHeight) {
    		throw new IllegalArgumentException("This demo must be run in a square.");
    	}

        // 初始化数据
    	this.N = N;
        circle = new Circle(sceneWidth / 2, sceneHeight / 2, sceneWidth / 2);
        points = new LinkedList<Point>();

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Get Pi with Monte Carlo", sceneWidth, sceneHeight);
            
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        // 编写自己的动画逻辑
    	for(int i = 0; i < N; i++) {
    		frame.render(circle, points);
    		AlgoVisHelper.pause(DELAY);
    		
    		//随机创建坐标值
    		int x = (int)(Math.random() * frame.getCanvasWidth());
    		int y = (int)(Math.random() * frame.getCanvasHeight());
    		
    		Point p = new Point(x, y);
    		points.add(p);
    	}
    }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10000;

        // 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}

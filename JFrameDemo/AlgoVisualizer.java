import java.awt.EventQueue;

//充当控制层controller的工作，同时控制数据和视图
public class AlgoVisualizer {
	
	private Circle[] circles;
	private AlgoFrame frame;
	
	public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
		
		//初始化数据部分
		circles = new Circle[N];
		int R = 50;
		for(int i = 0; i < N; i++) {
			int x = (int)(Math.random() * (sceneWidth - 2 * R)) + R;
			int y = (int)(Math.random() * (sceneWidth - 2 * R)) + R;
			int vx = (int)(Math.random() * 11) - 5;
			int vy = (int)(Math.random() * 11) - 5;
			circles[i] = new Circle(x, y, R, vx, vy);
		}
		
		//初始化Frame
		//把GUI创建的代码放进新的线程（事件分发线程）中
		EventQueue.invokeLater(() -> {
			frame = new AlgoFrame("welcome", sceneWidth, sceneHeight);
			
			new Thread(() -> {
				run();
			}).start();
		});
				
	}
	
	//将动画逻辑进行封装
	private void run() {
		
		while(true) {	//设置为死循环
			//绘制数据
			frame.render(circles);
			AlgoVisHelper.pause(20);
			
			//更新数据
			for(Circle circle: circles) {
				circle.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight());
			}
		}
	}
}

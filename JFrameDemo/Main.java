import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		int sceneWidth = 500;
		int sceneHeight = 500;
		
		//设置circles的数据
		int N = 10;							//画10个圆
		Circle[] circles = new Circle[N];
		int R = 50;
		for(int i = 0; i < N; i++) {
			int x = (int)(Math.random() * (sceneWidth - 2 * R)) + R;
			int y = (int)(Math.random() * (sceneWidth - 2 * R)) + R;
			int vx = (int)(Math.random() * 11) - 5;
			int vy = (int)(Math.random() * 11) - 5;
			circles[i] = new Circle(x, y, R, vx, vy);
		}
		
		
		//把GUI创建的代码放进新的线程（事件分发线程）中
		EventQueue.invokeLater(() -> {
			AlgoFrame frame = new AlgoFrame("welcome", sceneWidth, sceneHeight);
			
			new Thread(() -> {
				while(true) {	//设置为死循环
					//绘制数据
					frame.render(circles);
					AlgoVisHelper.pause(20);
					
					//更新数据
					for(Circle circle: circles) {
						circle.move(0, 0, sceneWidth, sceneHeight);
					}
				}
			}).start();
			
		});
		
	}
}

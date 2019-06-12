/**
 * 实现MVC结构：
 * MVC模式（Model–view–controller）是软件工程中的一种软件架构模式，
 * 把软件系统分为三个基本部分：模型（Model）、视图（View）和控制器（Controller）。
 * 
 * */
public class Main {

	public static void main(String[] args) {
		
		int sceneWidth = 500;
		int sceneHeight = 500;
		int N = 10;							//画10个圆
		
		//直接调用封装好的控制器
		AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
		
		
	}
}

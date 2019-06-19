import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {

    //创建自己的数据
	private static int DELAY = 10;
    private int[] money;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
    	money = new int[100];
    	for(int i = 0; i < money.length; i++) {
    		money[i] = 100;		//初始化每个人手里都有100块钱
    	}
    	

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        // 编写自己的动画逻辑
    	while(true) {
    		frame.render(money);	   //第一步，根据当前money数量进行绘制
    		AlgoVisHelper.pause(DELAY);//第二步，每次绘制结束之后停顿常量DELAY
    		
    		//更新逻辑
    		for(int i = 0; i < money.length; i++) {					//i代表每一个人，每次要给对方一块钱
    			if(money[i] > 0) {									//设置没有人欠钱
    				int j = (int)(Math.random() * money.length);	//让第i个人给第j个人一块钱
    				money[i] -= 1;
    				money[j] += 1;
    			}
    		}
    	}
    }


    public static void main(String[] args) {

        int sceneWidth = 1000;
        int sceneHeight = 800;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}

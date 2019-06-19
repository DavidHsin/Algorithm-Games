import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class AlgoVisualizer {

    //创建自己的数据
	private static int DELAY = 40;
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
    		
    		//可以加一个排序功能，这样就可以看出来分布
    		Arrays.sort(money);
    		
    		frame.render(money);	   //第一步，根据当前money数量进行绘制
    		AlgoVisHelper.pause(DELAY);//第二步，每次绘制结束之后停顿常量DELAY
    		
    		//更新逻辑，也可以每50轮游戏进行一次模拟，加一层for循环
    		//现在动画模拟的速度是不加这层for循环的50倍
    		for(int k = 0; k < 50; k++) {
	    		for(int i = 0; i < money.length; i++) {				//i代表每一个人，每次要给对方一块钱
	    			//if(money[i] > 0) {							//把for循环去掉，就代表某个人负债，即当前的财富为负值
	    			int j = (int)(Math.random() * money.length);	//让第i个人给第j个人一块钱
	    			money[i] -= 1;
	    			money[j] += 1;
	    			//}
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

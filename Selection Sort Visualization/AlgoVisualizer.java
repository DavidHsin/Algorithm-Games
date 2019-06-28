import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {
	
	private static int DELAY = 100;

    // TODO: 创建自己的数据
    private SelectionSortData data;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        // 初始化数据
        data = new SelectionSortData(N, sceneHeight);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Selection Sort Visualization", sceneWidth, sceneHeight);
            
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
    	
    	frame.render(data);
    	AlgoVisHelper.pause(DELAY);
    	
        // 编写自己的动画逻辑
    	for(int i = 0; i < data.N(); i++) {
    		int minIndex = i;
    		for(int j = i + 1; j < data.N(); j++) {
    			if(data.get(j) < data.get(minIndex)) {
    				minIndex = j;
    			}
    		}
    		data.swap(i, minIndex);
    		frame.render(data);
        	AlgoVisHelper.pause(DELAY);	//在数据进行swap之后进行渲染
    	}
    	
    	frame.render(data);
    	AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}

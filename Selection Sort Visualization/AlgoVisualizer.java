import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {
	
	private static int DELAY = 80;

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
    	
    	setData(0, -1, -1);
    	
        // 编写自己的动画逻辑
    	for(int i = 0; i < data.N(); i++) {
    		int minIndex = i;
    		setData(i, -1, minIndex);
    		
    		for(int j = i + 1; j < data.N(); j++) {
    			setData(i, j, minIndex);
    			if(data.get(j) < data.get(minIndex)) {
    				minIndex = j;
    				setData(i, j, minIndex);
    			}
    		}
    		data.swap(i, minIndex);
    		setData(i + 1, -1, -1);
    	}
    	
    	setData(data.N(), -1, -1);
    }
    
    private void setData(int orderedIndex, int currentCompareIndex, int currentMinIndex) {
    	data.orderedIndex = orderedIndex;
    	data.currentCompareIndex = currentCompareIndex;
    	data.currentMinIndex = currentMinIndex;
    	
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

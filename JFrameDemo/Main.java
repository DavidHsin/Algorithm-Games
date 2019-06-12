import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		//把GUI创建的代码放进新的线程（事件分发线程）中
		EventQueue.invokeLater(() -> {
			AlgoFrame frame = new AlgoFrame("welcome", 500, 500);
			//AlgoFrame frame = new AlgoFrame("Welcome", 500, 500);
		});
		
	}
}

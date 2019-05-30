import javax.swing.JFrame;

public class AlgoFrame extends JFrame {
	
	//设置private是因为，在初始化之后，不可以让外部用户改变窗口的长和宽
	private int canvasWidth;
	private int canvasHeight;
	
	public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
		
		super(title);										//设置窗口的title
		
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		
		this.setSize(canvasWidth, canvasHeight);			//设定窗口的大小
		this.setResizable(false);							//不允许用户自行改变窗口大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//原本点击关闭窗口是隐藏，现在是关闭
		this.setVisible(true);								//把窗口显示出来
	}
	
	//只传来一个窗口标题，那就默认窗口大小
	public AlgoFrame(String title) {
		this(title, 1920, 1080);
	}
	
	//如果外部用户想要知道窗口的长和宽，可以通过访问get函数来实现
	public int getCanvasWidth() {
		return canvasWidth;
	}
	
	public int getCanvasHeight() {
		return canvasHeight;
	}
}

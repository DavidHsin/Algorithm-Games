import java.awt.*;
import javax.swing.*;

public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    // TODO: 设置自己的数据
    private int[] money;				//每个人手里的钱
    public void render(int[] money){
        this.money = money;
        repaint();
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            
            int w = canvasWidth / money.length;					//设置柱状图的每一个矩形的宽度
            for(int i = 0; i < money.length; i++) {				//每个人的钱都绘制柱状图
            	//这里区分出不同，当某个人的财富大于0的时候
            	if(money[i] > 0) {
            		AlgoVisHelper.setColor(g2d, AlgoVisHelper.Blue);	//设置颜色
                	AlgoVisHelper.fillRectangle(g2d, i * w + 1, canvasHeight / 2 - money[i], w - 1, money[i]);
            	}else if(money[i] < 0) {
            		//当某个人财富小于0，即负债的时候
            		AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
            		AlgoVisHelper.fillRectangle(g2d, i * w + 1, canvasHeight / 2, w - 1, -money[i]);
            	}
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}



import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			AlgoFrame frame = new AlgoFrame("welcome");
			//AlgoFrame frame = new AlgoFrame("Welcome", 500, 500);
		});
		
	}
}

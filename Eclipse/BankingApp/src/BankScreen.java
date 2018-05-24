import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javafx.scene.text.Text;

public class BankScreen {

	private JFrame frame;
	private JTextField name1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankScreen window = new BankScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BankScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		name1 = new JTextField("Name");
		
		frame.add(name1);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
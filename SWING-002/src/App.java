import java.io.IOException;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainFrame();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		});
	}

}
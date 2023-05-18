import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	JButton computeBtn, exitBtn;
	JPanel buttonPanel;
	
	MainFrame(){
	super("Sample Dialog");
	
	BorderLayout layout = new BorderLayout();
	
	buttonPanel = new JPanel();
	buttonPanel.setBorder(BorderFactory.createEtchedBorder());
	
	computeBtn = new JButton();
	computeBtn.setText("Compute");
	
	exitBtn = new JButton();
	exitBtn.setText("Quit");
	
	exitBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}
	});
	buttonPanel.add(exitBtn);
	buttonPanel.add(computeBtn);
	
	setLayout(layout);
	
	add(buttonPanel, BorderLayout.CENTER);
	
	setSize(800, 600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	setResizable(false);
	setLocation(0,0);
	}
}

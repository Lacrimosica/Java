import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.activation.ActivationGroupID;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutFocusTraversalPolicy;
import javax.swing.SpringLayout;

public class GUI implements ActionListener{

	
	int count = 0;
	JLabel label;
	JFrame frame = new JFrame();
	JPanel panel;
	JButton button;
	
	
	public GUI() {
		frame = new JFrame();
		panel = new JPanel();
		
		button = new JButton("click me");
		button.addActionListener( this);
		label = new JLabel("Number of clicks: ");
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(1,0));
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI");
		frame.pack();
		frame.setVisible(true);
		panel.add(button);
		panel.add(label);
		
	}
	
	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		count++;
		label.setText("Number of clicks :" + count) ;
		
	}

}

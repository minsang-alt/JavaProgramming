package pr11;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class The2ndQues extends JFrame{
	
	public The2ndQues() {
		setTitle("JTextField and JComboBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JTextField text = new JTextField(10);
		JComboBox<String> combo = new JComboBox<String>();
		
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				combo.addItem(t.getText());
				t.setText("");
			}
			
		});
		
		
		c.add(text);
		c.add(combo);
		
		setSize(350,150);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new The2ndQues();

	}

}

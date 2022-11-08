package pr11;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class JavaPractice extends JFrame{

	private JCheckBox [] btnOper = new JCheckBox[2]; 
	private JButton btn = new JButton("test button");
	public JavaPractice() {
		setTitle("checkBox Practice frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JCheckBox enable = new JCheckBox("버튼 비활성화");
		JCheckBox unvisible = new JCheckBox("버튼 감추기");
		btnOper[0] = enable;
		btnOper[1] = unvisible;
		btnOper[0].addItemListener(new MyItemListener());
		btnOper[1].addItemListener(new MyItemListener());
		c.add(btnOper[0]);
		c.add(btnOper[1]);
		c.add(btn);
		
		setSize(250,150);
		setVisible(true);
		
	}
	
	class MyItemListener implements ItemListener{
		
		public void itemStateChanged(ItemEvent e)
		{
			if(e.getStateChange()==ItemEvent.SELECTED)
			{
				//비활성화 체크박스를 체크한경우
				if(e.getItem()==btnOper[0])
				{
					btn.setEnabled(false);
				}
				//버튼을 보이지않게 체크한 경우
				else {
					btn.setVisible(false);
				}
			}
			else
			{
				if(e.getItem()==btnOper[0])
				{
					btn.setEnabled(true);
				}
				else {
					btn.setVisible(true);
				}
			}
		}
	}
	
	public static void main(String[] args) {
			
			new JavaPractice();
		
	}

}

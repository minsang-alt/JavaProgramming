package pr11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;

import javax.swing.*;

public class The8thQues extends JFrame{
	private JRadioButton [] radio = new JRadioButton[2];
	private ImageIcon[] image = {
			new ImageIcon("zero.png"),
			new ImageIcon("one.png"),
			new ImageIcon("three.png")
	};
	private String [] text = {"left","right"};
	private JLabel imageLabel = new JLabel();
	//움직이는 방향 왼쪽 디폴트
	private int direction = -1;
	public  The8thQues() {
		setTitle("image Gallery Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel radioPanel =new JPanel();
		
		ButtonGroup g = new ButtonGroup();
		
		for(int i=0; i<radio.length; i++)
		{
			radio[i] = new JRadioButton(text[i]);
			g.add(radio[i]);
			radioPanel.add(radio[i]);
			radio[i].addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e)
				{
					if(e.getStateChange()==ItemEvent.DESELECTED)return;
					if(radio[0].isSelected()) {//left가 선택된 경우 
						direction=-1;
						
					}
					else {
						direction = 1;
					}
				}
			});
		}
		radio[0].setSelected(true);
		c.add(radioPanel,BorderLayout.NORTH);
		c.add(imageLabel,BorderLayout.CENTER);
		imageLabel.setIcon(image[0]);
		imageLabel.addMouseListener(new MouseAdapter() {
			int index = 0;
			public void mouseClicked(MouseEvent e)
			{
				
				if(direction==-1)
				{
					index--;
					if(index<0) {
						//만약 인덱스가 -1이면 제일 뒷장으로 인덱스 변경
						index=image.length-1;
						imageLabel.setIcon(image[index]);
					}
					else {
					imageLabel.setIcon(image[index%(image.length)]);
					}
				}
				else {
					//오른쪽으로 가야할때
					index++;
					imageLabel.setIcon(image[index%(image.length)]);
				}
			}
		});
		setSize(500,500);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
			new The8thQues();
		
	}

}

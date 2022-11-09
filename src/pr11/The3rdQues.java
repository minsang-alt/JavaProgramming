package pr11;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class The3rdQues extends JFrame {
	
	private JTextField [] res = new JTextField[8];
	private String[] money = {"오만원","만원","천원","500원","100원","50원","10원","1원"};
	private int [] divisionMoney = {50000,10000,1000,500,100,50,10,1};
	
	public The3rdQues(){
		setTitle("Money Changer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout(30,30));
		c.add(new NorthPanel(),BorderLayout.NORTH);
		c.add(new CenterPanel(),BorderLayout.CENTER);
		setSize(400,300);
		setVisible(true);
	}
	class NorthPanel extends JPanel{
		public NorthPanel(){
			setLayout(new FlowLayout());
			JLabel la = new JLabel("금액");
			JTextField text = new JTextField(20);
			JButton calc = new JButton("계산");
			calc.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					String sumMoney = text.getText();
					//아무것도 입력한게 없으면 리턴
					if(sumMoney.equals(""))return;
					else {
						int mny = Integer.parseInt(sumMoney);
						if(mny>0)
						{
							
							
							for(int i=0; i<res.length; i++)
							{
								res[i].setText(Integer.toString(mny/divisionMoney[i]));
								mny = mny % divisionMoney[i];
								
							}
							
							
						}
					}
				}
			});
				
		
			add(la);
			add(text);
			add(calc);
			
		}
	}
	class CenterPanel extends JPanel{
		public CenterPanel() {
			setLayout(null);
			for(int i=0; i<res.length; i++)
			{
				JLabel la = new JLabel(money[i]);
				//오른쪽 정렬
				la.setHorizontalAlignment(JLabel.RIGHT);
				la.setSize(50,20);
				la.setLocation(70,10+(i*20));
				
		
				res[i] = new JTextField(5);
				//가운데 정렬
				res[i].setHorizontalAlignment(JLabel.CENTER);
				res[i].setSize(70,20);
				res[i].setLocation(140,10+(i*20));
				add(la);
				add(res[i]);
				
			}
			
		}
	}
	public static void main(String[] args) {
		new The3rdQues();

	}

}

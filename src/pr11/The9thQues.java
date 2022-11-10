package pr11;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class The9thQues extends JFrame{
	private ImageIcon scissorIcon = new ImageIcon("scissor.jpg");
	private ImageIcon rockIcon = new ImageIcon("rock.jpg");
	private ImageIcon paperIcon = new ImageIcon("paper.jpg");
	
	
	//0은 가위,1은 바위 2는 보
	private JButton [] gameImageButton = new JButton[3];
	private JLabel[] gameImageLabel = new JLabel[3];
	private JLabel img1 = new JLabel();
	private JLabel section1 = new JLabel();
	private JLabel section2 = new JLabel();
	private JLabel img2 = new JLabel();
	public The9thQues() {
		
		//가위바위보 라벨 생성
		gameImageLabel[0] = new JLabel(scissorIcon);
		gameImageLabel[1] = new JLabel(rockIcon);
		gameImageLabel[2] = new JLabel(paperIcon);
		
		
		setTitle("가위 바위 보 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new selectButtonPanel(),BorderLayout.NORTH);
		
		
		
		
		c.add(new ResultPanel(),BorderLayout.CENTER);
		
		
		setSize(500,500);
		setVisible(true);
	}
	class ResultPanel extends JPanel{
		public ResultPanel()
		{
			setBackground(Color.yellow);
			add(img1);
			add(section1);
			add(img2);
			add(section2);
			
		}
	}
	//가위바위보 선택 J패널
	class selectButtonPanel extends JPanel{
		public selectButtonPanel() {
			ButtonActionListener listener = new ButtonActionListener();
			gameImageButton[0] = new JButton(scissorIcon);
			gameImageButton[0].addActionListener(listener);
			gameImageButton[1] = new JButton(rockIcon);
			gameImageButton[1].addActionListener(listener);
			gameImageButton[2] = new JButton(paperIcon);
			gameImageButton[2].addActionListener(listener);
			
			setBackground(Color.gray);
			add(gameImageButton[0]);
			add(gameImageButton[1]);
			add(gameImageButton[2]);
			
			
			
		}
	}
	
	class ButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			
			JButton b = (JButton)e.getSource();
			
			if(b==gameImageButton[0])
			{
				battleGame(0);
			}
			else if(b==gameImageButton[1])
			{
				battleGame(1);
			}
			else {
				battleGame(2);
			}
		}
	}
	
	public void battleGame(int index)
	{
		int comIndex = (int)(Math.random()*3);
		

		//무승부
		if(index==comIndex)
		{
			img1.setIcon(gameImageLabel[index].getIcon());
			section1.setText("me");
			img2.setIcon(gameImageLabel[comIndex].getIcon());
			section2.setText("com Same!!!");
			
			
		}//사용자가 이기는 경우
		else if((index==0&&comIndex==2) || (index==1&&comIndex==0) || (index==2&&comIndex==1) ) {
			img1.setIcon(gameImageLabel[index].getIcon());
			section1.setText("me");
			img2.setIcon(gameImageLabel[comIndex].getIcon());
			section2.setText("com 사용자가 이겼습니다!!!");
			
		}//컴이 이기는 경우
		else
		{
			img1.setIcon(gameImageLabel[index].getIcon());
			section1.setText("me");
			img2.setIcon(gameImageLabel[comIndex].getIcon());
			section2.setText("com 컴퓨터가 이겼습니다!!!");
			
			
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new The9thQues();
	}

}

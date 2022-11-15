package pr13;

import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
class WordList{
	private Vector<String> wordVector = new Vector<String>();
	public WordList() {
		try {
			Scanner scanner = new Scanner(new FileReader("words.txt"));
			while(scanner.hasNext()) {
				String word = scanner.nextLine();
				wordVector.add(word);
			}
		}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
		
	}
	public String getWord() {
		int index = (int)(Math.random()*wordVector.size());
		return wordVector.get(index);
	}
}
public class FallingWords extends JFrame{
	//단어장 받기
	private WordList wordList = new WordList();
	
	 
	//ground패널에 붙일 라벨들
	private JLabel checkLabel = new JLabel("");
	private JLabel wordLabel = new JLabel("이곳에 단어가 등장합니다");
	
	//떨어지는 위치
	private int x,y;
	//답을 입력하는 텍스트 필드
	private JTextField inputField = new JTextField(20);
	private GroundPanel groundPanel  = new GroundPanel();
	
	public FallingWords() {
		this.wordList = new WordList();
		setTitle("떨어지는 단어 맞추기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		Container c= getContentPane();
		c.add(groundPanel,BorderLayout.CENTER);
		
		JPanel inputPanel = new JPanel();
		inputPanel.add(inputField);
		inputField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JTextField t = (JTextField)e.getSource();
				if(t.getText().equals("그만"))System.exit(0);
				if(t.getText().equals(wordLabel.getText())) {
					
					checkLabel.setText("성공");
					t.setText("");
					groundPanel.getLabel();
					groundPanel.repaint();
				}
				else {
					checkLabel.setText("실패");
					t.setText("");
				}
			}
		});
		inputPanel.setBackground(Color.gray);
		inputPanel.add(inputField,BorderLayout.SOUTH);
		c.add(inputPanel,BorderLayout.SOUTH);
		
		
		
		setSize(300,200);
		setVisible(true);
		
		
	}
	class GroundPanel extends JPanel implements Runnable{
		private long delay=500;
		public GroundPanel() {
			setLayout(null);
			checkLabel.setBounds(0,0,100,20);
			add(checkLabel);
			//ground의 패널의 크기를 지정하여 무작위값을 가져올수있도록 함
			setSize(300,100);
			//setBackground(Color.YELLOW);
			
			getLabel();
				
				
				
				Thread th = new Thread(this);
				th.start();
		}
		public void getLabel() {
			x=(int)(this.getWidth()*Math.random());
			y=0;
			System.out.println(x+","+getWidth());
			wordLabel.setText(wordList.getWord());
			wordLabel.setBounds(x,y,200,20);
			add(wordLabel);
		}
		@Override
		public void run()
		{
			while(true)
			{
				y+=10;
				if(y>this.getHeight()) {
					//wordLabel.setVisible(false);
					getLabel();
					this.repaint();
				}
				wordLabel.setLocation(x,y);
				
				
				try {
					Thread.sleep(delay);
					
				}
				catch(InterruptedException e)
				{
					return;
				}
						
			}
		}
	}
	public static void main(String[] args) {
		
		new FallingWords();
		
	}

}

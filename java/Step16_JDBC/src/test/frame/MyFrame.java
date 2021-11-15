package test.frame;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	//run 했을때 실행순서가 시작되는 main 메소드
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		f.setSize(800,500);
		f.setLocation(100,100);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

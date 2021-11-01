package test_main;
//1. 필요한 클래스를 import한다.
import javax.swing.JFrame;

public class MainClass04 {
	public static void main(String[] args) {
		//2. import된 클래스로 객체를 생성하고
		JFrame f = new JFrame();
		//3. 객체의 method들의 도움을 받아서 원하는 목적을 달성한다.
		f.setTitle("나의프레임");
		f.setBounds(100,100,500,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

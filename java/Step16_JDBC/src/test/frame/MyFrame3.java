package test.frame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame3 extends JFrame{
   //생성자
   public MyFrame3() {
      setSize(800, 500);
      setLocation(100, 100);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      //FlowLayout 객체 전달하기
      setLayout(new FlowLayout(FlowLayout.LEFT));
      //버튼을 만들어서 
      JButton btn1=new JButton("버튼1");
      JButton btn2=new JButton("버튼2");
      JButton btn3=new JButton("버튼3");
      
      //프레임에 추가하기 
      add(btn1);
      add(btn2);
      add(btn3);
      
      setVisible(true);
   }
   
   //run 했을때 실행순서가 시작되는 main 메소드 
   public static void main(String[] args) {
      new MyFrame3();
   }
}






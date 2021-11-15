package test.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame4 extends JFrame{
   //생성자
   public MyFrame4() {
      setSize(800, 500);
      setLocation(100, 100);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      //FlowLayout 객체 전달하기
      setLayout(new BorderLayout());
      //버튼을 만들어서 
      JButton btn1=new JButton("버튼1");
      JButton btn2=new JButton("버튼2");
      JButton btn3=new JButton("버튼3");
      JButton btn4=new JButton("버튼4");
      
      
      //프레임에 추가하기 
      add(btn1,BorderLayout.NORTH);
      add(btn2,BorderLayout.WEST);
      add(btn3,BorderLayout.EAST);
      add(btn4,BorderLayout.SOUTH);
      
      setVisible(true);
   }
   
   //run 했을때 실행순서가 시작되는 main 메소드 
   public static void main(String[] args) {
      new MyFrame4();
   }
}






package test.frame;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame{
   //생성자
   public MyFrame2() {
      setSize(800, 500);
      setLocation(100, 100);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      //프레임의 레이아웃 메니저를 사용하지 않기 때문에 UI 를 절대 좌표에 직접 배치해야 한다.
      setLayout(null);
      //버튼을 만들어서 
      JButton btn1=new JButton("버튼1");
      btn1.setLocation(10, 10);
      btn1.setSize(100, 30);
      //프레임에 추가하기 
      add(btn1);
      
      JButton btn2=new JButton("버튼2");
      btn2.setLocation(120, 10);
      btn2.setSize(100, 30);
      
      JButton btn3=new JButton("버튼3");
      btn3.setLocation(10, 50);
      btn3.setSize(100, 30);
      
      add(btn2);
      add(btn3);
      
   }
   
   //run 했을때 실행순서가 시작되는 main 메소드 
   public static void main(String[] args) {
      new MyFrame2();
   }
}






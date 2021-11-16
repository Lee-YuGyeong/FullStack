package test.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import test.mypac.CountRunnable;
import test.mypac.DownloadThread;

public class Frame09 extends JFrame implements ActionListener{
   
   //생성자
   public Frame09() {
      setTitle("Frame06");
      setBounds(100, 100, 800, 500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new FlowLayout());
      
      JTextField inputText=new JTextField(10);
      add(inputText);
      
      JButton btn1=new JButton("눌러보셈");
      add(btn1);
      btn1.addActionListener(this);
      
      setVisible(true);
   }
   
   
   public static void main(String[] args) {
      new Frame09();
   }


   @Override
   public  void  actionPerformed(ActionEvent e) {
      System.out.println("버튼을 눌렀네요!");
      
      new Thread(()->{
    	  int count=0;
    	  while(true) {
		         try {
		            Thread.sleep(1000);
		         } catch (InterruptedException e2) {
		            e2.printStackTrace();
		         }
		         count++; //카운트를 증가 시킨다.
		         System.out.println("현재 카운트:"+count);
		         if(count==10) break;// 카운트가 10이 되면 반복문 탈출 => run()메소드종료  => 스레드 종료를 의미 
		      }
      }).start();
      
      
      System.out.println("actionPerformed() 메소드가 종료 됩니다.");
   }
   
}







package test.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import test.mypac.DownloadThread;

public class Frame02 extends JFrame implements ActionListener{
   
   //생성자
   public Frame02() {
      setTitle("Frame02");
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
      new Frame02();
   }


   @Override
   public void actionPerformed(ActionEvent e) {
      System.out.println("버튼을 눌렀네요!");
      
    //새로운 스레드에서 다운로드 작업을 시킨다.
      new DownloadThread().start();
      
      System.out.println("actionPerformed() 메소드가 종료 됩니다.");
   }
   

   
}







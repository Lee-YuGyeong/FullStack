package test.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import test.mypac.DownloadThread;

public class Frame04 extends JFrame implements ActionListener{
   
   //생성자
   public Frame04() {
      setTitle("Frame04");
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
      new Frame04();
   }


   @Override
   public  void  actionPerformed(ActionEvent e) {
      System.out.println("버튼을 눌렀네요!");
      //익명의 내부 클래스를 이용해서 객체 생성후 새로운 작업단위를 시작한다. 
      
      Thread t=new Thread() {
         @Override
         public void run() {
            //완료하는데 10초가 걸리는 작업을 한다고 가정하자
            try {
               Thread.sleep(10000);
               System.out.println("다운로드가 완료 되었습니다");
            } catch (InterruptedException e1) {
               e1.printStackTrace();
            }
         }
      };
      t.start();
      System.out.println("actionPerformed() 메소드가 종료 됩니다.");
   }
   
}







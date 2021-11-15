package test.frame;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame5 extends JFrame{
   //생성자
   public MyFrame5() {
      setSize(800, 500);
      setLocation(100, 100);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      //FlowLayout 객체 전달하기
      setLayout(new FlowLayout());
      
      JButton sendBtn=new JButton("전송");
      add(sendBtn);
      JButton deleteBtn=new JButton("삭제");
      add(deleteBtn);
      JButton updateBtn=new JButton("수정");
      add(updateBtn);
      
      //ActionListener 인터페이스 type 의 참조값 얻어내기
      ActionListener listener=new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println("전송합니다.");
         }
      };
      
      //전송 버튼이 눌러졌을때 특정 객체의 특정 메소드가 호출되게 하는 방법은?
      sendBtn.addActionListener(listener);
      
      deleteBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println("삭제합니다.");
         }
      });
      
      updateBtn.addActionListener((e)->{
         System.out.println("수정 합니다.");
      });
      
      setVisible(true);
   }
   
   //run 했을때 실행순서가 시작되는 main 메소드 
   public static void main(String[] args) {
      new MyFrame5();
   }
}






package test.frame;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame6 extends JFrame implements ActionListener{
   //생성자
   public MyFrame6() {
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
      //버튼에 리스너 등록하기 
      sendBtn.addActionListener(this);
      deleteBtn.addActionListener(this);
      updateBtn.addActionListener(this);
      //버튼에 action command 설정하기
      sendBtn.setActionCommand("send");
      deleteBtn.setActionCommand("delete");
      updateBtn.setActionCommand("update");
      
      setVisible(true);
   }
   
   //run 했을때 실행순서가 시작되는 main 메소드 
   public static void main(String[] args) {
      new MyFrame6();
   }
   
   //ActionListener 인터페이스를 구현해서 강제로 Override 한 메소드 
   @Override
   public void actionPerformed(ActionEvent e) {
      //이벤트가 발생한 버튼에 설정된 action command 읽어오기 
      String command=e.getActionCommand();
      if(command.equals("send")) {
         System.out.println("전송합니다.");
      }else if(command.equals("delete")) {
         System.out.println("삭제합니다.");
      }else if(command.equals("update")) {
         System.out.println("수정합니다.");
      }
   }
}






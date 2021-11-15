package test.frame;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame7 extends JFrame implements ActionListener{
	//필드 정의하기
	private JTextField inputMsg;
	
   //생성자
   public MyFrame7() {
      setSize(800, 500);
      setLocation(100, 100);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      //FlowLayout 객체 전달하기
      setLayout(new FlowLayout());
      
      //문자열을 입력할수 있는 UI 
      inputMsg=new JTextField(10);
      add(inputMsg);
      
      //전송버튼
      JButton sendBtn=new JButton("전송");
      sendBtn.setActionCommand("send");
      sendBtn.addActionListener(this);
      add(sendBtn);
      
      //삭제버튼
      JButton deleteBtn = new JButton("삭제");
      deleteBtn.setActionCommand("delete");
      deleteBtn.addActionListener(this);
      add(deleteBtn);
      
      setVisible(true);
   }
   
   //run 했을때 실행순서가 시작되는 main 메소드 
   public static void main(String[] args) {
      new MyFrame7();
   }
   
   //ActionListener 인터페이스를 구현해서 강제로 Override 한 메소드 
   @Override
   public void actionPerformed(ActionEvent e) {
      //이벤트가 발생한 버튼에 설정된 action command 읽어오기 
      String command=e.getActionCommand();
      if(command.equals("send")) {
         //JTextField에 입력한 문자열 읽어오기
    	  String msg = inputMsg.getText();
    	  JOptionPane.showMessageDialog(this, msg);
      }else if (command.equals("delete")) {
    	  //빈 문자열을 넣어주어서 삭제하기
    	  inputMsg.setText("");
      }
   }
}






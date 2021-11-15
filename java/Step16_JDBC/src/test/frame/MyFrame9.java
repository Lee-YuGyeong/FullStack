package test.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MyFrame9 extends JFrame implements ActionListener, KeyListener{
   //필요한 필드 정의하기 
   private JTextField inputName;
   private DefaultListModel<String> model;
   private JList jList;
   //생성자
   public MyFrame9() {
      setSize(800, 500);
      setLocation(100, 100);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      //BorderLayout 객체 전달하기
      setLayout(new BorderLayout());
      
      //페널에 추가할 UI 를 미리 만든다.
      JLabel label=new JLabel("추가할 이름입력");
      inputName=new JTextField(10);
      JButton addBtn=new JButton("추가");
      addBtn.setActionCommand("add");
      addBtn.addActionListener(this);
      //삭제 버튼 
      JButton deleteBtn=new JButton("삭제");
      deleteBtn.setActionCommand("delete");
      deleteBtn.addActionListener(this);
      
      
      //페널에 UI 를 추가하고 
      JPanel topPanel=new JPanel();
      topPanel.add(label);
      topPanel.add(inputName);
      topPanel.add(addBtn);
      topPanel.add(deleteBtn);
      
      //페널째로 프레임의 상단에 추가하기
      add(topPanel, BorderLayout.NORTH);
      
      //목록을 출력할 UI 
      jList=new JList<>();
      //JList 에 출력할 데이터를 가지고 있는 모델 객체 
      model=new DefaultListModel<>();
      model.addElement("김구라");
      model.addElement("해골");
      model.addElement("원숭이");
      //모델을 JList 에 연결하기 
      jList.setModel(model);
      
      //스크롤 페널에 JList 넣어주기
      JScrollPane sc=new JScrollPane(jList,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      
      //프레임에 스크롤 페널 추가하기 
      add(sc, BorderLayout.CENTER);
      
      //JTextField 에 키 리스너 등록하기 
      inputName.addKeyListener(this);
      
      setVisible(true);
   }
   
   //run 했을때 실행순서가 시작되는 main 메소드 
   public static void main(String[] args) {
      new MyFrame9();
   }
   
   //ActionListener 인터페이스를 구현해서 강제로 Override 한 메소드 
   @Override
   public void actionPerformed(ActionEvent e) {
      //이벤트가 발생한 버튼에 설정된 action command 읽어오기 
      String command=e.getActionCommand();
      if(command.equals("add")) {
         //JTextField 에 입력한 문자열을 읽어와서 DefaultListModel 객체에 추가해야 한다. 
         String name=inputName.getText();
         model.addElement(name);
         inputName.setText("");
      }else if(command.equals("delete")) {
         //JList 의 메소드를 이용해서 선택된 행을 알아낸다.
         int index=jList.getSelectedIndex();
         //만일 선택된 인덱스가 있다면 
         if(index >= 0) {
            //모델에서 해당 인덱스를 삭제한다. 
            model.remove(index);
         }
         
      }
   }

   @Override
   public void keyPressed(KeyEvent e) {
      //눌러진 키의 코드값을 읽어와서 
      int code=e.getKeyCode();
      //엔터키의 코드값인지 확인한다. 
      if(code == KeyEvent.VK_ENTER) {//만일 엔터키를 눌렀다면
         //JTextField 에 입력한 문자열을 읽어와서 DefaultListModel 객체에 추가해야 한다. 
         String name=inputName.getText();
         model.addElement(name);
         inputName.setText("");
      }
      
   }

   @Override
   public void keyReleased(KeyEvent e) {
      //System.out.println("keyReleased");
   }

   @Override
   public void keyTyped(KeyEvent e) {
      //System.out.println("keyTyped");
   }
}






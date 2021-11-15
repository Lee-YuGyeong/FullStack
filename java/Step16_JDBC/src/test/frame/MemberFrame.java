package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import test.dao.MemberDao;
import test.dto.MemberDto;
/*
 * 1. 실제 DB에 있는 회원 정보를 JList에 출력해보세요.
 * 
 * 2. 이름과 주소를 각각의 JTextField에 입력한 후 추가버튼을 누르면 DB에 실제로 추가되고
 * 	  JList의 내용도 업데이트 되도록 해 보세요.
 * 
 * 3. 특정 row를 선택한 상태에서 삭제 버튼을 누르면 DB에서 실제로 삭제도되고
 *    JList의 내용도 업데이트 되도록 해보세요.
 *    
 *    - hint
 *    MemberDao 객체를 활용하세요.
 *    
 *    DefaultListMedel 객체의 .clear() 메소드를 호출하면 모델데이터가 전체 삭제된다.
 *    
 *    JList의 내용을 업데이트하려면
 *    모델객체의 .clear() 메소드를 호출 후 다시 전체 데이터를 .addElement() 하면된다.
 */
public class MemberFrame extends JFrame implements ActionListener{
	   //필요한 필드 정의하기 
	private JTextField inputName;
	private JTextField inputAddr;
	private DefaultListModel<String> model;
	private JList jList;
	
	
	
	public MemberFrame() {
		
	      setSize(800, 500);
	      setLocation(100, 100);
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	      //BorderLayout 객체 전달하기
	      setLayout(new BorderLayout());
	      
	      //페널에 추가할 UI 를 미리 만든다.
	      JLabel label=new JLabel("추가할 이름입력");
	      inputName=new JTextField(20);
	      inputAddr=new JTextField(20);
	      
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
	      topPanel.add(inputAddr);
	      topPanel.add(addBtn);
	      topPanel.add(deleteBtn);
	      
	      //페널째로 프레임의 상단에 추가하기
	      add(topPanel, BorderLayout.NORTH);
	      
	      //목록을 출력할 UI 
	      jList=new JList<>();
	      //JList 에 출력할 데이터를 가지고 있는 모델 객체 
	      model=new DefaultListModel<>();
	      setList();
	      
	      //모델을 JList 에 연결하기 
	      jList.setModel(model);
	      
	      //스크롤 페널에 JList 넣어주기
	      JScrollPane sc=new JScrollPane(jList,
	            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	      
	      //프레임에 스크롤 페널 추가하기 
	      add(sc, BorderLayout.CENTER);
	      
	      
	      setVisible(true);
	      
	}
	public static void main(String[] args) {
		 new MemberFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	      //이벤트가 발생한 버튼에 설정된 action command 읽어오기 
	      String command=e.getActionCommand();
	      if(command.equals("add")) {
	         //JTextField 에 입력한 문자열을 읽어와서 DefaultListModel 객체에 추가해야 한다. 
	         String name=inputName.getText();
	         String addr=inputAddr.getText();
	         addMemberDto(new MemberDto(0,name,addr));
	         inputName.setText("");
	         inputAddr.setText("");
	      }else if(command.equals("delete")) {
	         //JList 의 메소드를 이용해서 선택된 행을 알아낸다.
	         int index=jList.getSelectedIndex();
	         //만일 선택된 인덱스가 있다면 
	         if(index >= 0) {
	            //모델에서 해당 인덱스를 삭제한다. 
	        	
	        	System.out.println(model.get(index));
	         }
	         
	      }
		
	}
	
	public void setList() {
		model.clear();
		
	      MemberDao dao = new MemberDao();
	      List<MemberDto> list = new ArrayList<>();
	      list = dao.getList();
	      
	      
	      for(MemberDto tmp:list) {
	    	  model.addElement("이름 : " + tmp.getName() + "    주소 : " + tmp.getAddr());
	      }
	}
	
	public void addMemberDto(MemberDto dto) {
		MemberDao dao = new MemberDao();
		dao.insert(dto);
		setList();
	}
	
	public void deleteMemberDto(int num) {
		MemberDao dao = new MemberDao();
		dao.delete(num);
		setList();
	}
	
}

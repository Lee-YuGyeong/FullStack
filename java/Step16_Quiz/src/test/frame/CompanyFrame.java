package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.CompanyDao;
import test.dto.CompanyDto;


public class CompanyFrame extends JFrame implements ActionListener, PropertyChangeListener{

	JTextField inputEname,inputJob;
	JTable table;
	DefaultTableModel model;
	List<CompanyDto> companys;
	
	public CompanyFrame(){
		 setTitle("사원정보");
		 setSize(800, 500);
	      setLocation(100, 100);
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	      //BorderLayout 객체 전달하기
	      setLayout(new BorderLayout());
	      
	      //필요한 UI 객체를 생성해서 
	      JLabel labelName=new JLabel("이름");
	      JLabel labelAddr=new JLabel("직책");
	      inputEname=new JTextField(10);
	      inputJob=new JTextField(10);
	      JButton addBtn=new JButton("추가");
	      JButton deleteBtn=new JButton("삭제");
	      JButton refreshBtn = new JButton("새로고침");
	      
	      //페널에 추가한 후 
	      JPanel topPanel=new JPanel();
	      topPanel.add(labelName);
	      topPanel.add(inputEname);
	      topPanel.add(labelAddr);
	      topPanel.add(inputJob);
	      topPanel.add(addBtn);
	      topPanel.add(deleteBtn);
	      topPanel.add(refreshBtn);
	      //프레임의 상단에 페널을 배치한다.
	      add(topPanel, BorderLayout.NORTH);
	      //버튼에 리스너 등록
	      addBtn.addActionListener(this);
	      deleteBtn.addActionListener(this);
	      refreshBtn.addActionListener(this);
	      //버튼에 action command 설정
	      addBtn.setActionCommand("add");
	      deleteBtn.setActionCommand("delete");
	      refreshBtn.setActionCommand("refresh");
	      
	      //표형식으로 정보를 출력하기 위한 JTable
	      table=new JTable();
	      //테이블의 칼럼명을 String[] 로 준비하기
	      String[] colNames= {"사원 번호", "사원 이름", "직책", "입사일"};
	      //테이블에 출력할 데이터를 가지고 있는 DefaultTableModel
	      model=new DefaultTableModel(colNames, 0) {
	    	  //인자로 전달되는 행(row), 열(column) 수정 가능 여부를 리턴하는 메소드
	    	  @Override
	    	public boolean isCellEditable(int row, int column) {
	    		  //0번 칼럼만 수정 불가능하도록 false를 리턴해주고
	    		if(column == 0 || column==3) {
	    			return false;
	    		}else {
	    			//나머지는 모두 수정 가능하도록 true를 리턴한다.
	    			return true;
	    		}
	    		
	    	}
	      };
	      //모델을 테이블에 연결
	      table.setModel(model);
	      //스크롤이 가능하도록 
	      JScrollPane sc=new JScrollPane(table);
	      //프레임의 가운데에 배치
	      add(sc, BorderLayout.CENTER);
	      //테이블에 회원 목록 출력하기
	      showMembers();
	      
	      //테이블 셀에 수정작업이 일어났는지 감시할 리스너 등록 
	      table.addPropertyChangeListener(this);
	      
	      autoRefresh();
	      
	      setVisible(true);
	}
	
	public static void main(String[] args) {
		new CompanyFrame();
	}

	public void showMembers() {
	      //DB 에서 회원 목록을 얻어와서 
	      companys=new CompanyDao().getList();
	      for(CompanyDto tmp:companys) {
	         //테이블 row 에 출력할 데이터를 순서대로 담은 Object[] 객체를 준비해서 
	         Object[] row= {tmp.getEmpno(),tmp.getEname(),tmp.getJob(),tmp.getHiredate()};
	         //모델에 추가한다. 
	         model.addRow(row);
	      }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("add")) {
			addAction();
		}else if(e.getActionCommand().equals("delete")) {
			deleteAction();
		}else if(e.getActionCommand().equals("refresh")) {
			model.setRowCount(0);
			showMembers();
		}
		
	}

	private void deleteAction() {
	      //선택된 row 의 인덱스를 얻어와서 
	      int index=table.getSelectedRow();
	      if(index == -1)return;
	      //DB 에서 삭제하고
	      CompanyDto dto = new CompanyDto();
	      dto.setEmpno(companys.get(index).getEmpno());
	      new CompanyDao().delete(dto);
	      //다시 출력
	      model.setRowCount(0);
	      showMembers();
		
	}

	private void addAction() {
	      //1. 입력한 이름과 주소를 읽어온다.
	      String ename=inputEname.getText();
	      String job=inputJob.getText();
	      //2. DB 에 저장한다.
	      CompanyDto dto=new CompanyDto();
	      dto.setEname(ename);
	      dto.setJob(job);
	      //작업의 성공여부를 리턴 받는다. 
	      boolean isSuccess=new CompanyDao().insert(dto);
	      
	      if(isSuccess) {
	         JOptionPane.showMessageDialog(this, "저장 했습니다.");
	         //행의 갯수를 강제로 0 로 만들고 
	         model.setRowCount(0);
	         //다시 출력하기
	         showMembers();
	      }else {
	         JOptionPane.showMessageDialog(this, "저장 실패!");
	      }
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	      System.out.println("propertyChange()");
	      System.out.println(evt.getPropertyName());
	      if(evt.getPropertyName().equals("tableCellEditor")) {
	         //선택된 row 의 index 를 얻어와서 
	         int index=table.getSelectedRow();
	         //인덱스에 해당하는 model 에서 입력된 이름과 주소를 읽어온다. 
	         int empno=(int)model.getValueAt(index, 0); //0번째 인덱스의 번호를 읽어온다. 
	         String ename=(String)model.getValueAt(index, 1); //1번째 인덱스의 이름을 읽어온다.
	         String job=(String)model.getValueAt(index, 2); //2번째 인덱스의 주소를 읽어온다.
	         String hiredate=(String)model.getValueAt(index, 3); //3번째 인덱스의 입사일을 읽어온다.
	         //DB 에 수정 반영
	         CompanyDto dto=new CompanyDto(empno,ename,job,hiredate);
	         new CompanyDao().update(dto);
	      }
		
	}
	
	//주기적으로 refresh 하는 메소드
	public void autoRefresh() {
		new Thread() {
			@Override
			public void run() {
				while(true) {
					
					try {
						Thread.sleep(30000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					model.setRowCount(0);
					showMembers();
				}
			}
		}.start();
	}
}

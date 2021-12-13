package pack;

import other.MyInfo;
import other2.OutFileInter;

public class MessageImpl implements MessageInter {
	private String name1,name2;	//Constructor injection용 
	private int year;
	private MyInfo myInfo;
	
	private String spec;	//Setter injection용 
	private OutFileInter fileInter;
	
	public MessageImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public MessageImpl(String name1,String name2, int year, MyInfo myInfo) {
		this.name1 = name1;
		this.name2 = name2;
		this.year = year;
		this.myInfo = myInfo;
	}
	
	public void setSpec(String spec) {	//Setter injection
		this.spec = spec;
	}
	
	public void setFileInter(OutFileInter fileInter) {
		this.fileInter = fileInter;
	}
	
	public void sayHi() {	//출력 담당 메소드
		String msg = name1 + " " + name2 + "\n" + 
					(year +21)+ "년\n" +
					myInfo.myData();
		
		msg = msg +"\n" + spec;
		
		System.out.println(msg);
		
		//msg를 파일로 출력
		fileInter.outFile(msg);
		
	}
}

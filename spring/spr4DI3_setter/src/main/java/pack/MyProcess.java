package pack;

//이번 예제는 setter injection 연습
public class MyProcess {
	private int nai;	//기본형 멤버 변수 (멤버 필드) 
	private String name;//참조형 멤버 변수 (멤버 필드)
	private MemberData memberData;	//참조형 멤버변수(멤버필드) - 클래스의 포함관계
	
	public MyProcess() {
		// 생성자에 내용이 없는 경우 생략 가능
	}
	
	public void setNai(int nai) { //setter
		this.nai = nai;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMemberData(MemberData memberData) {
		this.memberData = memberData;
	}
	
	public void displayData() {
		System.out.println("이름은 " + name + "," + " 나이는 " + nai + 
				", 별명은 " + memberData.processName()+
				", 취미는 " + memberData.processHobby());
	}
	
}

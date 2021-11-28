package test.member.dto;

public class MemberDto {
	private int num;
	private String name;
	private String addr;
	//디폴트 생성자
	public MemberDto() {}
	//인자로 모든 값을 전달 받는 생성자
	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
	//모든 필드에 setter, getter 메소드 만들기 
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	
}

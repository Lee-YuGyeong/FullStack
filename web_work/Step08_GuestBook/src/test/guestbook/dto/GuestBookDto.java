package test.guestbook.dto;

public class GuestBookDto {
	private int num;		//글번호
	private String writer;	//작성자
	private String title;	//제목
	private String content;	//내용
	private String pwd;		//비밀번호
	private String regdate;	//등록일
	
	//디폴트 생성자
	public GuestBookDto() {}

	public GuestBookDto(int num, String writer, String title, String content, String pwd, String regdate) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.pwd = pwd;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}

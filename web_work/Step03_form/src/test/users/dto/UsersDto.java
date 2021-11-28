package test.users.dto;

public class UsersDto {
	private String nick;
	private String email;
	private String concern;
	private String lan;
	private String comm;
	
	//디폴트 생성자
	public UsersDto() {}

	public UsersDto(String nick, String email, String concern, String lan, String comm) {
		super();
		this.nick = nick;
		this.email = email;
		this.concern = concern;
		this.lan = lan;
		this.comm = comm;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConcern() {
		return concern;
	}

	public void setConcern(String concern) {
		this.concern = concern;
	}

	public String getLan() {
		return lan;
	}

	public void setLan(String lan) {
		this.lan = lan;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}


	
}

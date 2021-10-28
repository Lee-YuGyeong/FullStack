package test.mypac;
/*
 * 뉴스의 제목, 내용, 작성자를
 * 객체 혹은 클래스에 담고싶다.
 * 
 * 어디에 담는게 맞는것일까?
 */
public class News {

	/*
	 *  제목의 필드명 : title
	 *  data type : String
	 *  static or non-static : 
	 */
	public String title;
	public String content;
	public String writer;
	
	public void showInfo() {
		System.out.println("제목:"+this.title);
		System.out.println("제목:"+this.content);
		System.out.println("제목:"+this.writer);
	}
	
}

package test.mypac;
public class box {

	//필드
	private Apple item;
	
	//메소드
	public void push(Apple item) {
		this.item = item;
	}
	//과일을 빼내는 메소드
	public Apple pull() {
		return item;
	}
	
}
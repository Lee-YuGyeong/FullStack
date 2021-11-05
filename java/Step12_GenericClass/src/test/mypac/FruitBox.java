package test.mypac;

public class FruitBox<T> {

	//필드
	private T item;
	
	//메소드
	public void push(T item) {
		this.item = item;
	}
	//과일을 빼내는 메소드
	public T pull() {
		return item;
	}
	
}

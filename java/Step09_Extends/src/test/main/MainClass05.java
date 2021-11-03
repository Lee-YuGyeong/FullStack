package test.main;

import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass05 {
	public static void main(String[] args) {
		//집에는 구형 전화기만 있다.
		Phone p1 = new Phone();
		
		/*
		 * 어린 자녀가 스마트폰이 갖고 싶다고 조른다.
		 * 
		 * 이번달 생활비가 쪼들리는데 뭔가 방법이 없을까?
		 * 
		 * 아하! 구형 전화기를 주면서 스마트폰이라고 우기면서 스마트폰의 사용설명서를 주자
		 * 
		 */
		
		SmartPhone p2 = (SmartPhone) p1; //ClassCastException 발생!
		p2.doInternet();
		
	}
}

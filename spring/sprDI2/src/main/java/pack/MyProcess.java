package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//클래스가 또 다른 클래스를 불러다 사용 : 포함관계
//객체의 주소는 생성자 주입을 사용
public class MyProcess implements MyInter{
	private MoneyInter inter;	//클래스의 포함관계
	private int re[];
	
	public MyProcess(MoneyInter inter) {
		// TODO Auto-generated constructor stub
		this.inter = inter;
	}
	
	public void inputMoney() {
		// 키보드로 금액 입력
		try {
			InputStreamReader reader = new InputStreamReader(System.in);
			BufferedReader breader = new BufferedReader(reader);
			int myMoney = 0;
			
			System.out.print("금액 입력 : ");	
			String data = breader.readLine();	//"23450"
			myMoney = Integer.parseInt(data);	//23450
			re = inter.calcMoney(myMoney);	// 연산 결과를 1차원 배열로 반환
			
		} catch (Exception e) {
			System.out.println("inputMoney err : " + e);
		}
	}
	
	public void showResult() {
		StringBuffer sb = new StringBuffer();	// "만원 : "+ re[0] + "천원 : "+ re[1] ... 하면 메모리 소모가 큼
		sb.append("만원 : "+ re[0] + "\n");
		sb.append("천원 : "+ re[1] + "\n");
		sb.append("백원 : "+ re[2] + "\n");
		sb.append("십원 : "+ re[3] + "\n");
		sb.append("일원 : "+ re[4]);
		System.out.println(sb.toString());
	}
}

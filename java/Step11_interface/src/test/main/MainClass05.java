package test.main;

import test.mypac.Drill;

public class MainClass05 {
	public static void main(String[] args) {
		
		Drill d1 = ()->{
			System.out.println("아무데나 구멍을 뚫어요!");
		};
		
		useDrill(d1);
		
		useDrill(()->{
			System.out.println("어디를 뚫지??");
		});

	}
	public static void useDrill(Drill d) {
		d.hole();
	}
}

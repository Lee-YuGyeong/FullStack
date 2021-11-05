package test.main;

import test.mypac.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		
		Drill d1 = new Drill() {
			
			@Override
			public void hole() {
				System.out.println("벽에 구멍을 뚫어요");
				
			}
		};
		
		useDrill(d1);
		useDrill(new Drill() {
			
			@Override
			public void hole() {
				System.out.println("핸드폰에 구멍을 뚫어요");
				
			}
		});
		
	}
	public static void useDrill(Drill d) {
		d.hole();
	}
}

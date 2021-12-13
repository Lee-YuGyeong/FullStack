package pack;

public class MoneyCalc implements MoneyInter {
	public int[] calcMoney(int money) {
		//money 값을 만원, 천원, 백원, 십원, 일원 단위로 분리해 배열로 반환
		int re[] = new int[5];
		re[0] = money / 10000;
		re[1] = money % 10000 / 1000;
		re[2] = money % 10000 % 1000 / 100;
		re[3] = money % 10000 % 1000 % 100 / 10;
		re[4] = money % 10000 % 1000 % 100 % 10;
		
		return re;
	}
}

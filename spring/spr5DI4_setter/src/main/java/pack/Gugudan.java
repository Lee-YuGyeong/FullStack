package pack;

public class Gugudan {
	public int[] guguCalc(int dan) {
		int[] cal = new int[9];
		for(int i = 0; i < 9; i++) {
			cal[i] = dan * (i+1);
		}
		return cal;
	}
}

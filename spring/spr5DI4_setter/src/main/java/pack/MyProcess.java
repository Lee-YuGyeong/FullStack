package pack;

public class MyProcess {
	private String name;
	private int dan;
	private Gugudan gugudan;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	public void setGugudan(Gugudan gugudan) {
		this.gugudan = gugudan;
	}
	
	public void displayGugudan() {
		int[] result = gugudan.guguCalc(dan);
		String ss = "";
		
		for(int i=0;i<result.length;i++) {
			ss+=dan+" * " + (i+1) + " = " + result[i] + "\n";
		}
		System.out.println("작성자 : " + name + "\n" + dan + "구구단 결과\n" + ss);
	}
}

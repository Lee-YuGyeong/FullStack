package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		//java에서 배열은 한번 만들어지면 방의 갯수를 늘리거나 줄일 수 없다.
		int[] nums = {10,20,30};
		//방이 들어있는 데이터를 수정가능
		nums[0] = 999;
		
		//배열을 생성하는 시점에 값을 넣지 않고 나중에 넣고 싶으면?
		int[] myNums = {0,0,0,0,0};
		for(int i=0;i<5;i++) {
			myNums[i] = 100*i;
		}
		//참조 데이터 type배열의 빈값은 null을 이용해서 만든다.
		String[] msgs = {null,null,null,null,null};
		for(int i=0;i<5;i++) {
			msgs[i] = "김구라" +i;
		}
	}
}

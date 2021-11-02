package test.main;

import test.mypac.Computer;
import test.mypac.Cpu;
import test.mypac.Memory;

public class MainClass05 {
	public static void main(String[] args) {
		//1. Computer type 을 담을 수 있는 방 5개짜리 빈 배열객체를 생성해서 
		// 그 참조값을 coms 라는 이름의 지역변수에 담아 보세요
		Computer[] coms = new Computer[5];
		//2. 반복문 돌면서 coms 배열의 모든방에 각각다른 Computer객체의 참조값을 넣어보세요.
		for(int i=0;i<coms.length;i++) {
			coms[i] = new Computer(new Cpu(),new Memory());
		}
		//3. 반복문 돌면서 coms배열안에 있는 Computer객체의 참조값을 하나씩 참조해서
		//doGame() 메소드를 호출해보세요.
		for(Computer tmp:coms) {
			tmp.doGame();
		}
	}
}

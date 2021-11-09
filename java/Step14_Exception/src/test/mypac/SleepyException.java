package test.mypac;

public class SleepyException extends Exception{
	
	//예외 메세지를 생성자의 인자로 전달받아서 부모 생성자에 전달하기
	public SleepyException(String msg) {
		super(msg);
	}

}

package aa.bb.cc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)	//XML을 읽을 때 어느 클래스에 담을지 결정
public class XmlMessage {
	private String name;
	private String age;
	
	public XmlMessage(String name,String age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAge() {
		return age;
	}
	
	
}

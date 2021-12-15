package aa.bb.cc;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class HelloModel {	//시간대별 인사 문구를 작성해 반환하는 클래스
	public String getHi() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(hour >= 6 && hour <=10) {
			return "좋은 아침";
		}else if(hour >= 12 && hour <=15) {
			return "점심 잘 드셨나요";
		}else {
			return "안녕하세요?";
		}
				
				
	}

}

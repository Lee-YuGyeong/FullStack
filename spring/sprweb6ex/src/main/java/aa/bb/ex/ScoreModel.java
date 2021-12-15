package aa.bb.ex;

import org.springframework.stereotype.Component;

@Component
public class ScoreModel {
	public int totalCal(ScoreBean scoreBean) {
		int total = scoreBean.getKor() + scoreBean.getEng() + scoreBean.getMath();
		return total;
	}

	public double avgCal(ScoreBean scoreBean) {
		double avg = (scoreBean.getKor() + scoreBean.getEng() + scoreBean.getMath()) / 3.0;
		return avg;
	}
}

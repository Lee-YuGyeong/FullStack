package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;

@Service
public class BusinessImpl implements BusinessInter {
	@Autowired
	private JikwonInter jikwonInter;

	public void dataList(int[] num) {
		List<JikwonDto> list = jikwonInter.selectBubun(num);
		
		int count=0;
		for (JikwonDto dto : list) {
			System.out.println(dto.getJikwon_no() + " " + dto.getJikwon_name() + " " + dto.getJikwon_jik());
			count+=1;
		}
		System.out.println("건수 : " + count);
	}
}

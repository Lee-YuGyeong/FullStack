package pack.acorn.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.acorn.www.SangpumDto;
import pack.acorn.www.SangpumInter;

//@Service
@Service("businessImpl")
public class BusinessImpl implements BusinessInter{
	@Autowired
	private SangpumInter sangpumInter;
	
	public void dataList() {
		ArrayList<SangpumDto> list = sangpumInter.selectList();
		
		for(SangpumDto s:list) {
			System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan());
		}
	}
}

package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.DataDao;
import pack.model.SangpumDto;

@Controller
public class SangpumController {

	@Autowired
	private DataDao dataDao;
	
	@GetMapping("sangpum") //@RequestMapping("sangpum")
	@ResponseBody
	public Map<String, Object> abc(){
		List<SangpumDto> sangpumAll = dataDao.sangpumList();	// 상품 자료 모두 읽기
		
		List<Map<String, String>> datalist = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;	// 한 레코드씩 읽어 Map type 객체로 처리
		
		for(SangpumDto s:sangpumAll) {
			data = new HashMap<String, String>();
			data.put("code",s.getCode());
			data.put("sang",s.getSang());
			data.put("su",s.getSu());
			data.put("dan",s.getDan());
			datalist.add(data);
		}
		
		Map<String,Object> sangpumsMap = new HashMap<String, Object>();
		sangpumsMap.put("datas",datalist);
		return sangpumsMap;
	}
	
}

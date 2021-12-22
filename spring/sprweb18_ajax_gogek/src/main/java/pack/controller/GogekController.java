package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.GogekDaoInter;
import pack.model.GogekDto;

@Controller
public class GogekController {

	@Autowired
	private GogekDaoInter daoInter;
	
	@GetMapping("gogeklist")
	@ResponseBody
	public Map getGogek() {
		ArrayList<GogekDto> dbList = daoInter.getList();
		
		List<Map<String, Object>> datas = new ArrayList<Map<String,Object>>();
		Map<String, Object> data = null;
		for(GogekDto tmp : dbList) {
			data = new HashMap<String,Object>();
			data.put("gogek_no",tmp.getGogek_no());
			data.put("gogek_name",tmp.getGogek_name());
			data.put("gogek_tel",tmp.getGogek_tel());
			data.put("gogek_jumin",tmp.getGogek_jumin());
			data.put("gogek_damsano",tmp.getGogek_damsano());
			datas.add(data);
		}
		
		Map<String, Object> gogekData = new HashMap<String, Object>();
		gogekData.put("datas",datas);
		return gogekData;
	}
	
}

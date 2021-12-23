package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class JikwonController {

	@Autowired
	private DataDao dataDao;
	
	@RequestMapping(value = "jikwoninfo", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> jikwonProcess(@RequestParam("buser_no") String buser_no){
		
		
		List<Map<String, String>> jikList = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		
		for(JikwonDto j:dataDao.jikwonList(buser_no)) {
			data = new HashMap<String, String>();
			data.put("sabun",j.getJikwon_no());
			data.put("irum",j.getJikwon_name());
			data.put("jik",j.getJikwon_jik());
			jikList.add(data);
		}
		//System.out.println(jikList);
		
		Map<String, Object> jikwonDatas = new HashMap<String, Object>();
		jikwonDatas.put("datas",jikList);
		return jikwonDatas;
	}
	
}

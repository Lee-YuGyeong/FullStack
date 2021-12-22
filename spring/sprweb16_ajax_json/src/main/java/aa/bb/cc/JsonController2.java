package aa.bb.cc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("list2")
public class JsonController2 {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map getJsons() {
		List<Map<String, String>> dataList = new ArrayList();
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("name","한국인");
		data.put("age","22");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name","이기승");
		data.put("name","27");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name","임지윤");
		data.put("name","25");
		dataList.add(data);
		
		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("datas",dataList);
		return data2;
	}
}

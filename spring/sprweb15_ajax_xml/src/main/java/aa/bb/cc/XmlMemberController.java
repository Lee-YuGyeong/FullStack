package aa.bb.cc;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XmlMemberController {

	@RequestMapping(value = "member_xml", method = RequestMethod.GET)
	public String formback() {
		return "myform"; // jsp 파일을 forwarding(해당 파일을 클라이언트 브라우저에 push)
	}

	@RequestMapping(value = "member_xml", method = RequestMethod.POST)
	@ResponseBody
	public XmlMessageList abc(@RequestParam("name") String name, @RequestParam("age") String age) {

		return getXml(name,age);
	}

	public XmlMessageList getXml(String name, String age) {
		List<XmlMessage> msg = Arrays.asList(new XmlMessage(name, age), new XmlMessage("oscar", "22"),
				new XmlMessage("한국인", "32"));
		return new XmlMessageList(msg);
	}
}

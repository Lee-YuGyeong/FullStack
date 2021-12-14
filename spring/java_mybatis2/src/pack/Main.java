package pack;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		int[] num = {10,30};
		List<JikwonDto> list = DataDao.getInstance().selectBubun(num);
		
		for(JikwonDto dto:list) {
			System.out.println(dto.getJikwon_no() + " " + dto.getJikwon_name() + " " + dto.getJikwon_jik());
		}
		
	}

}

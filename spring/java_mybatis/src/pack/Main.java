package pack;

import java.util.List;

public class Main {
	public static void main(String args[]) throws Exception {
		DataDao dataDao = DataDao.getInstance();
		
		/*
		System.out.println("자료 추가 ---");
		SangpumDto dto2 = new SangpumDto();
		dto2.setCode("11");
		dto2.setSang("볼펜2");
		dto2.setSu("19");
		dto2.setDan("1000");
		dataDao.insData(dto2);
		*/
		
		/*
		System.out.println("자료 수정 ---");
		SangpumDto dto3 = new SangpumDto();
		dto3.setCode("10");
		dto3.setSang("지우개");
		dataDao.upData(dto3);
		*/
		
		/*
		System.out.println("자료 삭제 ---");
		String code = "10";
		int imsi = dataDao.delData(code);
		if(imsi > 0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		*/
		
		System.out.println("전체 자료 읽기 ---");
		//List<SangpumDto> list = dataDao.selectAll();
		List<SangpumDto> list = DataDao.getInstance().selectAll();
		System.out.println(list.size());
		
		for(SangpumDto kbs:list) {
			System.out.println(kbs.getCode() + " " + kbs.getSang() + " " + 
					kbs.getSu() + " " + kbs.getDan());
		}
		
		System.out.println("\n부분 자료 1개 읽기 ---");
		
		String sbs = "2";
		SangpumDto dto = DataDao.getInstance().selectBubun(sbs);
		System.out.println(dto.getCode() + " " + dto.getSang() + " " + 
				dto.getSu() + " " + dto.getDan());
		
		
	}
}

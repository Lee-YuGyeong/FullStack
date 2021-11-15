package test.main;

import java.util.ArrayList;
import java.util.List;

import test.dao.CompanyDao;
import test.dto.CompanyDto;

public class MainClass17 {
	public static void main(String[] args) {
		/* company 테이블에 사원정보를 관리하는 프로그래밍을 해보세요.
		 * 1. CompanyDto를 만드세요
		 * 
		 * 2. CompanyDao를 만드세요.
		 * 입력, 수정, 삭제, 한명의 정보 불러오기, 사원 목록 불러오기
		 * 기능을 만들면 됩니다.
		 * 
		 * 3. 각각의 기능을 테스트 할 수 있는 main 메소드를 만들어서 테스트해보세요.
		 * 
		 */
		
		CompanyDao dao = new CompanyDao();
		
		
		CompanyDto dto1 = new CompanyDto();
		dto1.setEname("이00");
		dto1.setJob("개발");
		
		boolean isSuccess = dao.insert(dto1);
		if(isSuccess) {
			System.out.println("삽입 성공");
		}else {
			System.out.println("삽입 실패");
		}
		
		
		CompanyDto dto2 = new CompanyDto();
		dto2.setEmpno(1);
		dto2.setEname("최00");
		dto2.setJob("전산");
		
		boolean isSuccess2 = dao.update(dto2);
		if(isSuccess2) {
			System.out.println("갱신 성공");
		}else {
			System.out.println("갱신 실패");
		}
		
		
		
		CompanyDto dto3 = new CompanyDto();
		dto3.setEmpno(4);
		
		boolean isSuccess3 = dao.delete(dto3);
		if(isSuccess3) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
		
		
		CompanyDto dto4  = dao.getData(1);
		if(dto4!=null) {
			System.out.println(dto4.getEmpno() + " | " + dto4.getEname() + " | " +dto4.getJob() + " | " +dto4.getHiredate());
		}else {
			System.out.println("조회 내역이 없습니다.");
		}
		
		
		
		List<CompanyDto> list = new ArrayList<>();
		list = dao.getList();
		if(list.size()==0) {
			System.out.println("조회 내역이 없습니다.");
		}else {
			for(CompanyDto tmp:list) {
				System.out.println(tmp.getEmpno() + " | " + tmp.getEname() + " | " +tmp.getJob() + " | " +tmp.getHiredate());
			}
		}

	}
}


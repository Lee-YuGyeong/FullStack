package pack.business;

import pack.DataDao;
import pack.DataDaoImpl;

//생성자로 private 멤버에 값 주기
//DI(Dependency Injection : 의존성 주입)
public class SelectServiceImpl implements SelectService{
	private String name = "tom";
	private DataDao dataDao;	//클래스의 포함관계
	
	public SelectServiceImpl(DataDao dataDao) {
		this.dataDao = dataDao;
	}
	
	public void selectProcess() {
		// TODO Auto-generated method stub
		System.out.println("비지니스 로직 영역에서 selectProcess 수행");
		dataDao.selectData();
	}

}

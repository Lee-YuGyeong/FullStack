package pack.controller;

public class SangpumBean {	//컨트롤러에서 사용되는 폼빈
	//수정 삭제 추가 작업이 있다면 code,sang,su,dan 도 적어주어야함.
	private String searchValue;
	
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
	public String getSearchValue() {
		return searchValue;
	}

}

package test.company.dto;

public class CompanyDto {
	private int empno;
	private String ename;
	private String job;
	private String hiredate;
	
	
	public CompanyDto() {
		super();
	}



	public CompanyDto(int empno, String ename, String job, String hiredate) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
	}


	public int getEmpno() {
		return empno;
	}


	public void setEmpno(int empno) {
		this.empno = empno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public String getHiredate() {
		return hiredate;
	}


	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	
	
	
}

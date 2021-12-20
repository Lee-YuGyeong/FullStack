package pack.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository("dataSource")
public class MyDataSource extends DriverManagerDataSource {
	public MyDataSource() {
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		setUsername("scott");
		setPassword("tiger");
	}
}
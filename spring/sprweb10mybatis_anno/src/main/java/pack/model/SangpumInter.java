package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pack.controller.SangpumBean;

public interface SangpumInter {
	List list() throws DataAccessException;
	List search(SangpumBean bean) throws DataAccessException;
}

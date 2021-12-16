package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import pack.controller.SangpumBean;

public interface SangpumAnnoInter {		// Mybatis Annotation
	@Select("select * from sangdata order by code asc")
	public List<SangpumDto> selectDataAll();

	@Select("select code,sang,su,dan from sangdata where sang like '%' || #{searchValue} || '%'")
	public List<SangpumDto> selectSearch(SangpumBean bean);

}

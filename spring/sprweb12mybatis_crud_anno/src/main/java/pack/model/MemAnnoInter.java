package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pack.controller.MemBean;

public interface MemAnnoInter {
	@Select("select num,name,addr from mem order by num asc")
	public List<MemDto> getDataAll();
	
	@Select("select * from mem where num=#{num}")
	public MemDto selectPart(String num);
	
	@Insert("insert into mem values(#{num},#{name},#{addr})")
	public int insertData(MemBean bean);
	
	@Update("update mem set name=#{name},addr=#{addr} where num=#{num}")
	public int updateData(MemBean bean);
	
	@Delete("delete from mem where num=#{num}")
	public int deleteData(String num);
}

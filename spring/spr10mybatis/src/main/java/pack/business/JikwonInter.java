package pack.business;

import java.util.List;

import pack.model.JikwonDto;

public interface JikwonInter {
	List<JikwonDto> selectBubun(int[] num);
}

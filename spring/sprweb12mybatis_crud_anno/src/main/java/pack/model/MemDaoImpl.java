package pack.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class MemDaoImpl implements MemDaoInter {
	@Autowired
	private MemAnnoInter annoInter;

	@Override
	public List<MemDto> getDataAll() {
		return annoInter.getDataAll();
	}

	@Override
	public boolean insertData(MemBean bean) {
		int re = annoInter.insertData(bean);

		if (re > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public MemDto selectPart(String num) {
		return annoInter.selectPart(num);
	}

	@Override
	public boolean updateData(MemBean bean) {
		int re = annoInter.updateData(bean);

		if (re > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteData(String num) {
		int re = annoInter.deleteData(num);

		if (re > 0) {
			return true;
		} else {
			return false;
		}
	}
}

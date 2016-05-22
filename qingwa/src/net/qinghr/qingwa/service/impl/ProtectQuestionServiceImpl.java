package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.ProtectQuestionDAO;
import net.qinghr.qingwa.service.ProtectQuestionService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.ProtectQuestion;
@Transactional
@Service("protectQuestionService")
public class ProtectQuestionServiceImpl implements ProtectQuestionService {
	@Resource
	private ProtectQuestionDAO protectQuestionDAO;

	@Override
	public void save(ProtectQuestion object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ProtectQuestion object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ProtectQuestion object) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProtectQuestion findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProtectQuestion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProtectQuestion> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProtectQuestion> findAll(Pager pager, ProtectQuestion object) {
		// TODO Auto-generated method stub
		return null;
	}

}

package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.UserProtectQuestionDAO;
import net.qinghr.qingwa.service.UserProtectQuestionService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.UserProtectQuestion;
@Transactional
@Service("userProtectQuestionService")
public class UserProtectQuestionServiceImpl implements
		UserProtectQuestionService {
	@Resource
	private UserProtectQuestionDAO userProtectQuestionDAO;

	@Override
	public void save(UserProtectQuestion object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UserProtectQuestion object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(UserProtectQuestion object) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserProtectQuestion findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserProtectQuestion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserProtectQuestion> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserProtectQuestion> findAll(Pager pager,
			UserProtectQuestion object) {
		// TODO Auto-generated method stub
		return null;
	}

}

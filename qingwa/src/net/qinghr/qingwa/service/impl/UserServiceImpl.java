package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.UserDAO;
import net.qinghr.qingwa.service.UserService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.User;
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDAO userDAO;

	@Override
	public void save(User object) {
		userDAO.save(object);
		
	}

	@Override
	public void delete(User object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User object) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll(Pager pager, User object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByAccount(Object account) {
		// TODO Auto-generated method stub
		return userDAO.findByAccount(account);
	}

	@Override
	public User findByAccountAndpassword(String account, String password) {
		return userDAO.findByAccountAndpassword(account, password);
	}
}

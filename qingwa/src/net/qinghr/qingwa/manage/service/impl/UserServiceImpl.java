package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jboss.weld.servlet.ApplicationBeanStore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.UserDAO;
import net.qinghr.qingwa.manage.service.UserServiceManage;
import net.qinghr.qingwa.service.UserService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.User;
@Transactional
@Service("userServiceManage")
public class UserServiceImpl implements UserServiceManage {
	@Resource
	private UserDAO userDAO;

	public User login(String userName,String passWord)
	{		
		return null;
	}
	@Override
	public void save(User object) {
		// TODO Auto-generated method stub
		
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
	public void update(User user) {
		// TODO Auto-generated method stub
		userDAO.update(user);
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public List<User> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return userDAO.findAll(pager);
	}

	@Override
	public List<User> findAll(Pager pager, User user) {
		// TODO Auto-generated method stub
		return userDAO.findAll(pager, user);
	}

	@Override
	public List<User> findByExample(User user) {
		return userDAO.findByExample(user);
	}

	@Override
	public void update(String ids) {
		// TODO Auto-generated method stub
		userDAO.update(ids);
	}
}

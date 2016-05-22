package net.qinghr.qingwa.dao;

import java.util.List;

import net.qinghr.qingwa.common.CommonDAO;
import net.qinghr.qingwa.vo.User;

public interface UserDAO extends CommonDAO<User> {
	List<User> findByAccount(Object account);
	List<User> findByExample(User instance);
	User findByAccountAndpassword(String account,String password);
	void update(String ids);
}

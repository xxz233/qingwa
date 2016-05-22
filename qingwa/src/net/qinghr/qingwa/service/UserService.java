package net.qinghr.qingwa.service;

import java.util.List;

import net.qinghr.qingwa.vo.User;

public interface UserService extends CommonService<User> {
	List<User> findByAccount(Object account);
	User findByAccountAndpassword(String account,String password);
}

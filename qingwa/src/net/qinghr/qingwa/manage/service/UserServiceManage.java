package net.qinghr.qingwa.manage.service;

import java.util.List;

import net.qinghr.qingwa.common.CommonService;
import net.qinghr.qingwa.vo.User;

public interface UserServiceManage extends CommonService<User> {
	List<User> findByExample(User instance);
	void update(String ids);
}

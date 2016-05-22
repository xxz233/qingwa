package net.qinghr.qingwa.test.manage;
import java.util.List;

import net.qinghr.qingwa.manage.service.UserServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.util.SpringUtil;
import net.qinghr.qingwa.vo.User;

import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest
{
	private UserServiceManage userServiceManage;
	@Before
	public void init()
	{
		userServiceManage = SpringUtil.getBean("userServiceManage",UserServiceManage.class);
	}
	@Test
	public void test()
	{
		Pager pager = new Pager();
		User user = new User();
		user.setUserName("明");
		user.setAccount("");
		user.setEnable(true);
		user.setType(false);
		pager.setPageSize(10);
		pager.setPageNo(2);
		//userServiceManage.update("1,3,4,5");
//		List<User> users = userServiceManage.findByExample(user);
		List<User> users = userServiceManage.findAll(pager,user);
		for (User user2 : users)
		{
			System.out.println(user2.getId()+"               "+user2.getAccount()+"               "+user2.getUserName());
		}
	}
}

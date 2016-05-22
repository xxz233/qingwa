package net.qinghr.qingwa.test.manage;

import java.sql.Timestamp;
import java.util.Set;

import net.qinghr.qingwa.manage.service.AdminServiceManage;
import net.qinghr.qingwa.util.SpringUtil;
import net.qinghr.qingwa.vo.Admin;
import net.qinghr.qingwa.vo.ManageMenu;

import org.junit.Before;
import org.junit.Test;

public class AdminTest {

	
	private AdminServiceManage adminManage;
	@Before
	public void setUp() throws Exception {
		adminManage = SpringUtil.getBean("adminServiceManage", AdminServiceManage.class); 
		
	}

	@Test
	public void test() {
		Admin admin  = new Admin();
		Timestamp startDateTime = null;
		Timestamp endDateTime = null;
//		List<Admin> admins = new ArrayList<Admin>();
		Admin admins = new Admin();
		admins = adminManage.findById(1);
		Set<ManageMenu> manageMenu = admins.getManageMenus();
		
		System.out.println(manageMenu.size());	
		for (ManageMenu manageMenu2 : manageMenu) {
			System.out.println(manageMenu2.getTitle()+"####");
		}
	}

}

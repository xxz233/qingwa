package net.qinghr.qingwa.test.manage;

import java.util.List;

import net.qinghr.qingwa.manage.service.AdminServiceManage;
import net.qinghr.qingwa.util.SpringUtil;
import net.qinghr.qingwa.vo.Admin;

import org.junit.Before;
import org.junit.Test;

public class AdminServiceImplTest {
	private AdminServiceManage adminServiceManage;
	@Before
	public void init(){
		adminServiceManage = SpringUtil.getBean("adminServiceManage", AdminServiceManage.class);
	}
	@Test
	public void test(){
	
	}
}

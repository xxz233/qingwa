package net.qinghr.qingwa.manage.service;

import java.sql.Timestamp;
import java.util.List;

import net.qinghr.qingwa.common.CommonService;
import net.qinghr.qingwa.vo.Admin;
public interface AdminServiceManage extends CommonService<Admin> {

	Admin findByAccountAndpassword(String account,String password);
	void update(String ids);
	List<Admin> findAll(Admin admin,Boolean flag);
	List<Admin> findAll(Admin admin,Boolean flag,Timestamp startDate,Timestamp endDate);
}

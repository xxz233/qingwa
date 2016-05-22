package net.qinghr.qingwa.dao;

import java.sql.Timestamp;
import java.util.List;

import net.qinghr.qingwa.common.CommonDAO;
import net.qinghr.qingwa.vo.Admin;

public interface AdminDAO extends CommonDAO<Admin> {
	Admin findByAccountAndpassword(String account,String password);
	void update(String ids);
	List<Admin> findAll(Admin admin,Boolean flag);
	List<Admin> findAll(Admin admin,Boolean flag,Timestamp startDate,Timestamp endDate);
}

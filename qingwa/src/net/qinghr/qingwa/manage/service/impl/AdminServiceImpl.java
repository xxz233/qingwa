package net.qinghr.qingwa.manage.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.AdminDAO;
import net.qinghr.qingwa.manage.service.AdminServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.util.SpringUtil;
import net.qinghr.qingwa.vo.Admin;
import net.qinghr.qingwa.vo.ManageMenu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service("adminServiceManage")
public class AdminServiceImpl implements AdminServiceManage {
	@Resource
	private AdminDAO adminDAO;

	@Override
	public void save(Admin admin) {
		// TODO Auto-generated method stub
		adminDAO.save(admin);
	}

	@Override
	public void delete(Admin admin) {
		

	}
	/**
	 * 获得ID，删除单选行
	 * 陈先顺
	 */
	@Override
	public void delete(Integer id) {

		adminDAO.delete(id);
	}

	@Override
	public void update(Admin object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Admin findById(Integer id) {
		return adminDAO.findById(id);
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 设置分页，查询Adimin表里面的条数信息
	 * 陈先顺
	 */
	@Override
	public List<Admin> findAll(Pager pager) {
		
		List<Admin> admins = new ArrayList<Admin>();
		
		admins = adminDAO.findAll(pager);
		
		return admins;
	}

	@Override
	public List<Admin> findAll(Pager pager, Admin object) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ͨ���ʺţ����뵽��ݿ��ѯ���޴˹���Ա
	 * ����˳
	 */
	@Override
	public Admin findByAccountAndpassword(String account, String password) {
		
		Admin admin = null;

		admin = adminDAO.findByAccountAndpassword(account, password);

		return admin;
	}
	@Override
	public void update(String ids) {
		// TODO Auto-generated method stub
		adminDAO.update(ids);
	}
	@Override
	public List<Admin> findAll(Admin admin, Boolean flag) {
		// TODO Auto-generated method stub
		return adminDAO.findAll(admin, flag);
	}

	@Override
	public List<Admin> findAll(Admin admin, Boolean flag, Timestamp startDate,
			Timestamp endDate) {
		// TODO Auto-generated method stub
		List<Admin> admins = new ArrayList<Admin>();
		admins = adminDAO.findAll(admin, flag, startDate, endDate);
		return admins;
	}
	
}

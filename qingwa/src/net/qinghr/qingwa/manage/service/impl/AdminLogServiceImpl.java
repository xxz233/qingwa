package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.AdminLogDAO;
import net.qinghr.qingwa.manage.service.AdminLogServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.AdminLog;
@Transactional
@Service("adminLogServiceManage")
public class AdminLogServiceImpl implements AdminLogServiceManage {
	@Resource
	private AdminLogDAO adminLogDAO;

	@Override
	public void save(AdminLog object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(AdminLog object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AdminLog object) {
		// TODO Auto-generated method stub

	}

	@Override
	public AdminLog findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminLog> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminLog> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminLog> findAll(Pager pager, AdminLog object) {
		// TODO Auto-generated method stub
		return null;
	}
}

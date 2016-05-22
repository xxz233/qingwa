package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.ManageMenuDAO;
import net.qinghr.qingwa.manage.service.ManageMenuServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.ManageMenu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service("manageMenuServiceManage")
public class ManageMenuServiceImpl implements ManageMenuServiceManage {
	@Resource
	private ManageMenuDAO manageMenuDAO;

	@Override
	public void save(ManageMenu object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ManageMenu object) {
		// TODO Auto-generated method stub

	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ManageMenu object) {
		// TODO Auto-generated method stub

	}

	@Override
	public ManageMenu findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 findAll������ѯ�����к�̨�˵���Ϣ
	 ����˳
	 */
	@Override
	public List<ManageMenu> findAll() {
		// TODO Auto-generated method stub

		List<ManageMenu> ManageMenus;

		ManageMenus = manageMenuDAO.findAll();

		return ManageMenus;
	}

	@Override
	public List<ManageMenu> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ManageMenu> findAll(Pager pager, ManageMenu object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ManageMenu> findByAdminId(Integer id) {
		// TODO Auto-generated method stub
		return manageMenuDAO.findByAdminId(id);
	}
}

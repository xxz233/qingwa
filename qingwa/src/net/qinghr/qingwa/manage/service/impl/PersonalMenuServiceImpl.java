package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.PersonalMenuDAO;
import net.qinghr.qingwa.manage.service.PersonalMenuServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.PersonalMenu;
@Transactional
@Service("personalMenuServiceManage")
public class PersonalMenuServiceImpl implements PersonalMenuServiceManage {
	@Resource
	private PersonalMenuDAO personalMenuDAO;

	@Override
	public void save(PersonalMenu object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(PersonalMenu object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(PersonalMenu object) {
		// TODO Auto-generated method stub

	}

	@Override
	public PersonalMenu findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonalMenu> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonalMenu> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonalMenu> findAll(Pager pager, PersonalMenu object) {
		// TODO Auto-generated method stub
		return null;
	}

}

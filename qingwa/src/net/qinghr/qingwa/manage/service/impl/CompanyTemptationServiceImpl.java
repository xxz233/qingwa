package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.CompanyTemptationDAO;
import net.qinghr.qingwa.manage.service.CompanyTemptationServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyTemptation;
@Transactional
@Service("companyTemptationServiceManage")
public class CompanyTemptationServiceImpl implements CompanyTemptationServiceManage {
	@Resource
	private CompanyTemptationDAO companyTemptationDAO;

	@Override
	public void save(CompanyTemptation object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyTemptation object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CompanyTemptation object) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyTemptation findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyTemptation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyTemptation> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyTemptation> findAll(Pager pager, CompanyTemptation object) {
		// TODO Auto-generated method stub
		return null;
	}


}

package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.CompanyExperienceDAO;
import net.qinghr.qingwa.manage.service.CompanyExperienceServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyExperience;
@Transactional
@Service("companyExperienceServiceManage")
public class CompanyExperienceServiceImpl implements CompanyExperienceServiceManage {
	@Resource
	private CompanyExperienceDAO companyExperienceDAO;
	
	@Override
	public void save(CompanyExperience object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyExperience object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CompanyExperience object) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyExperience findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyExperience> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyExperience> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyExperience> findAll(Pager pager, CompanyExperience object) {
		// TODO Auto-generated method stub
		return null;
	}
}

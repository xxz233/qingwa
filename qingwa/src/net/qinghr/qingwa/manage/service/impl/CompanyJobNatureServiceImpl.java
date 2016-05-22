package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.CompanyJobNatureDAO;
import net.qinghr.qingwa.manage.service.CompanyJobNatureServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyJobNature;
@Transactional
@Service("companyJobNatureServiceManage")
public class CompanyJobNatureServiceImpl implements CompanyJobNatureServiceManage {
	@Resource
	private CompanyJobNatureDAO companyJobNatureDAO;

	@Override
	public void save(CompanyJobNature object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyJobNature object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CompanyJobNature object) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyJobNature findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyJobNature> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyJobNature> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyJobNature> findAll(Pager pager, CompanyJobNature object) {
		// TODO Auto-generated method stub
		return null;
	}

}

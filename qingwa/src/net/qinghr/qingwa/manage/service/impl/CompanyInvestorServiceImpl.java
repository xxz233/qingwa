package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.CompanyInvestorDAO;
import net.qinghr.qingwa.manage.service.CompanyInvestorServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyInvestor;
@Transactional
@Service("companyInvestorServiceManage")
public class CompanyInvestorServiceImpl implements CompanyInvestorServiceManage {
	@Resource
	private CompanyInvestorDAO companyInvestorDAO;

	@Override
	public void save(CompanyInvestor object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyInvestor object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CompanyInvestor object) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyInvestor findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyInvestor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyInvestor> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyInvestor> findAll(Pager pager, CompanyInvestor object) {
		// TODO Auto-generated method stub
		return null;
	}

}

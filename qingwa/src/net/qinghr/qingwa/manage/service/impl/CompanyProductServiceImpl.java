package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.CompanyProductDAO;
import net.qinghr.qingwa.manage.service.CompanyProductServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyProduct;
@Transactional
@Service("companyProductServiceManage")
public class CompanyProductServiceImpl implements CompanyProductServiceManage {
	@Resource
	private CompanyProductDAO companyProductDAO;

	@Override
	public void save(CompanyProduct object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyProduct object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CompanyProduct object) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyProduct findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyProduct> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyProduct> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyProduct> findAll(Pager pager, CompanyProduct object) {
		// TODO Auto-generated method stub
		return null;
	}


}

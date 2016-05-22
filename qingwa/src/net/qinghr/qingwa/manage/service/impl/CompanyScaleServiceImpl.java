package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.CompanyScaleDAO;
import net.qinghr.qingwa.manage.service.CompanyScaleServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyScale;
@Transactional
@Service("companyScaleServiceManage")
public class CompanyScaleServiceImpl implements CompanyScaleServiceManage {
	@Resource
	private CompanyScaleDAO companyScaleDAO;
	
	@Override
	public void save(CompanyScale object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyScale object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CompanyScale object) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyScale findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyScale> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyScale> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyScale> findAll(Pager pager, CompanyScale object) {
		// TODO Auto-generated method stub
		return null;
	}
}

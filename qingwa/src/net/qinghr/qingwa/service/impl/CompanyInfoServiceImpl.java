package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.CompanyInfoDAO;
import net.qinghr.qingwa.service.CompanyInfoService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyInfo;
@Transactional
@Service("companyInfoService")
public class CompanyInfoServiceImpl implements CompanyInfoService {
	@Resource
	private CompanyInfoDAO companyInfoDAO;

	@Override
	public void save(CompanyInfo object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyInfo object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CompanyInfo object) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyInfo findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyInfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyInfo> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyInfo> findAll(Pager pager, CompanyInfo object) {
		// TODO Auto-generated method stub
		return null;
	}

}

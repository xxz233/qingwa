package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.CompanyJobDAO;
import net.qinghr.qingwa.service.CompanyJobService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyJob;
@Transactional
@Service("companyJobService")
public class CompanyJobServiceImpl implements CompanyJobService {
	@Resource
	private CompanyJobDAO companyJobDAO;

	@Override
	public void save(CompanyJob object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyJob object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CompanyJob object) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyJob findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyJob> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyJob> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyJob> findAll(Pager pager, CompanyJob object) {
		// TODO Auto-generated method stub
		return null;
	}

}

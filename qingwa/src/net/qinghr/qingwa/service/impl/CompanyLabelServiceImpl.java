package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.CompanyLabelDAO;
import net.qinghr.qingwa.service.CompanyLabelService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyLabel;
@Transactional
@Service("companyLabelService")
public class CompanyLabelServiceImpl implements CompanyLabelService {
	@Resource
	private CompanyLabelDAO companyLabelDAO;

	@Override
	public void save(CompanyLabel object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyLabel object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CompanyLabel object) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyLabel findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyLabel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyLabel> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyLabel> findAll(Pager pager, CompanyLabel object) {
		// TODO Auto-generated method stub
		return null;
	}

}

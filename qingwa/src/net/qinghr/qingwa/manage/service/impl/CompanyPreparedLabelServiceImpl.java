package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.CompanyPreparedLabelDAO;
import net.qinghr.qingwa.manage.service.CompanyPreparedLabelServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyPreparedLabel;
@Transactional
@Service("companyPreparedLabelServiceManage")
public class CompanyPreparedLabelServiceImpl implements
		CompanyPreparedLabelServiceManage {
	@Resource
	private CompanyPreparedLabelDAO companyPreparedLabelDAO;

	@Override
	public void save(CompanyPreparedLabel object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyPreparedLabel object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CompanyPreparedLabel object) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyPreparedLabel findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyPreparedLabel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyPreparedLabel> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyPreparedLabel> findAll(Pager pager,
			CompanyPreparedLabel object) {
		// TODO Auto-generated method stub
		return null;
	}

}

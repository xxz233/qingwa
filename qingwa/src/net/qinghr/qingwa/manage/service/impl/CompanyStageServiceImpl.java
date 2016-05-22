package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.CompanyStageDAO;
import net.qinghr.qingwa.manage.service.CompanyStageServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyStage;
@Transactional
@Service("companyStageServiceManage")
public class CompanyStageServiceImpl implements CompanyStageServiceManage {
	@Resource
	private CompanyStageDAO companyStageDAO;

	@Override
	public void save(CompanyStage object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyStage object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CompanyStage object) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyStage findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyStage> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyStage> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyStage> findAll(Pager pager, CompanyStage object) {
		// TODO Auto-generated method stub
		return null;
	}


}

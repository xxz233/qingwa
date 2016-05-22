package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.CompanyFoundTeamDAO;
import net.qinghr.qingwa.service.CompanyFoundTeamService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyFoundTeam;
@Transactional
@Service("companyFoundTeamService")
public class CompanyFoundTeamServiceImpl implements CompanyFoundTeamService {
	@Resource
	private CompanyFoundTeamDAO companyFoundTeamDAO;

	@Override
	public void save(CompanyFoundTeam object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyFoundTeam object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CompanyFoundTeam object) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyFoundTeam findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyFoundTeam> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyFoundTeam> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyFoundTeam> findAll(Pager pager, CompanyFoundTeam object) {
		// TODO Auto-generated method stub
		return null;
	}

}

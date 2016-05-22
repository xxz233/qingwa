package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.DegreeDAO;
import net.qinghr.qingwa.service.DegreeService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Degree;
@Transactional
@Service("degreeService")
public class DegreeServiceImpl implements DegreeService {
	@Resource
	private DegreeDAO degreeDAO;

	@Override
	public void save(Degree object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Degree object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Degree object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Degree findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Degree> findAll() {
		List<Degree> digrees = degreeDAO.findAll();
		return digrees;
	}

	@Override
	public List<Degree> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Degree> findAll(Pager pager, Degree object) {
		// TODO Auto-generated method stub
		return null;
	}

}

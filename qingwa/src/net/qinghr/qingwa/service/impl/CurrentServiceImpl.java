package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.CurrentDAO;
import net.qinghr.qingwa.service.CurrentService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Current;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("currentService")
public class CurrentServiceImpl implements CurrentService {
	@Resource
	private CurrentDAO currentDAO;
	@Override
	public void save(Current object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Current object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Current object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Current findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Current> findAll() {
		List<Current> currents = currentDAO.findAll();
		return currents;
	}

	@Override
	public List<Current> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Current> findAll(Pager pager, Current object) {
		// TODO Auto-generated method stub
		return null;
	}
}

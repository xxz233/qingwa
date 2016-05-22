package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.IndustryDAO;
import net.qinghr.qingwa.service.IndustryService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Industry;
@Transactional
@Service("industryService")
public class IndustryServiceImpl implements IndustryService {
	@Resource
	private IndustryDAO industryDAO;

	@Override
	public void save(Industry object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Industry object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Industry object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Industry findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Industry> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Industry> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Industry> findAll(Pager pager, Industry object) {
		// TODO Auto-generated method stub
		return null;
	}

}

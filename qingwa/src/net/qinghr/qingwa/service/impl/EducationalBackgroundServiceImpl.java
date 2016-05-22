package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.EducationalBackgroundDAO;
import net.qinghr.qingwa.service.EducationalBackgroundService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.EducationalBackground;
@Transactional
@Service("educationalBackgroundService")
public class EducationalBackgroundServiceImpl implements
		EducationalBackgroundService {
	@Resource
	private EducationalBackgroundDAO educationalBackgroundDAO;

	@Override
	public void save(EducationalBackground object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(EducationalBackground object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(EducationalBackground object) {
		// TODO Auto-generated method stub

	}

	@Override
	public EducationalBackground findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EducationalBackground> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EducationalBackground> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EducationalBackground> findAll(Pager pager,
			EducationalBackground object) {
		// TODO Auto-generated method stub
		return null;
	}

}

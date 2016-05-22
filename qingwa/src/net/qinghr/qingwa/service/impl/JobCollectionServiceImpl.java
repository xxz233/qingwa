package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.JobCollectionDAO;
import net.qinghr.qingwa.service.JobCollectionService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.JobCollection;
@Transactional
@Service("jobCollectionService")
public class JobCollectionServiceImpl implements JobCollectionService {
	@Resource
	private JobCollectionDAO jobCollectionDAO;

	@Override
	public void save(JobCollection object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(JobCollection object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(JobCollection object) {
		// TODO Auto-generated method stub

	}

	@Override
	public JobCollection findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobCollection> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobCollection> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobCollection> findAll(Pager pager, JobCollection object) {
		// TODO Auto-generated method stub
		return null;
	}

}

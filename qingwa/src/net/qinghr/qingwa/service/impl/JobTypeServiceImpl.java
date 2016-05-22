package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.JobTypeDAO;
import net.qinghr.qingwa.service.JobTypeService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.util.SpringUtil;
import net.qinghr.qingwa.vo.JobType;
@Transactional
@Service("jobTypeService")
public class JobTypeServiceImpl implements JobTypeService {
	@Resource
	private JobTypeDAO jobTypeDAO;
	
	@Override
	public void save(JobType object) {
		// TODO Auto-generated method stub

	}
	@Override
	public void delete(JobType object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(JobType object) {
		// TODO Auto-generated method stub

	}

	@Override
	public JobType findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobType> findAll() {
		// TODO Auto-generated method stub
		return jobTypeDAO.findAll();
	}

	@Override
	public List<JobType> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobType> findAll(Pager pager, JobType object) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		JobTypeService j = SpringUtil.getBean("jobTypeService", JobTypeService.class);
		j.findAll();
	}
}

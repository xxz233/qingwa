package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.JobSubscriberDAO;
import net.qinghr.qingwa.manage.service.JobSubscriberServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.JobSubscriber;
@Transactional
@Service("jobSubscriberServiceManage")
public class JobSubscriberServiceImpl implements JobSubscriberServiceManage {
	@Resource
	private JobSubscriberDAO jobSubscriberDAO;

	@Override
	public void save(JobSubscriber object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(JobSubscriber object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(JobSubscriber object) {
		// TODO Auto-generated method stub

	}

	@Override
	public JobSubscriber findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSubscriber> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSubscriber> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSubscriber> findAll(Pager pager, JobSubscriber object) {
		// TODO Auto-generated method stub
		return null;
	}

}

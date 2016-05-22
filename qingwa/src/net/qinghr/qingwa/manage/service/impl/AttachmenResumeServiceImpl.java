package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.AttachmenResumeDAO;
import net.qinghr.qingwa.manage.service.AttachmenResumeServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.AttachmenResume;
@Transactional
@Service("attachmenResumeServiceManage")
public class AttachmenResumeServiceImpl implements AttachmenResumeServiceManage {
	@Resource
	private AttachmenResumeDAO attachmenResumeDAO;

	@Override
	public void save(AttachmenResume object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(AttachmenResume object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AttachmenResume object) {
		// TODO Auto-generated method stub

	}

	@Override
	public AttachmenResume findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttachmenResume> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttachmenResume> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttachmenResume> findAll(Pager pager, AttachmenResume object) {
		// TODO Auto-generated method stub
		return null;
	}
}

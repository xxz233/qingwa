package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.ResumeStatusDAO;
import net.qinghr.qingwa.manage.service.ResumeStatusServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.ResumeStatus;
@Transactional
@Service("resumeStatusServiceManage")
public class ResumeStatusServiceImpl implements ResumeStatusServiceManage {
	@Resource
	private ResumeStatusDAO resumeStatusDAO;

	@Override
	public void save(ResumeStatus object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ResumeStatus object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ResumeStatus object) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResumeStatus findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResumeStatus> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResumeStatus> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResumeStatus> findAll(Pager pager, ResumeStatus object) {
		// TODO Auto-generated method stub
		return null;
	}

}

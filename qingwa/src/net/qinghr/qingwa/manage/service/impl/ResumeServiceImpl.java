package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.ResumeDAO;
import net.qinghr.qingwa.manage.service.ResumeServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Resume;
@Transactional
@Service("resumeServiceManage")
public class ResumeServiceImpl implements ResumeServiceManage {
	@Resource
	private ResumeDAO resumeDAO;
	
	@Override
	public void save(Resume object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Resume object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Resume object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Resume findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resume> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resume> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resume> findAll(Pager pager, Resume object) {
		// TODO Auto-generated method stub
		return null;
	}
}

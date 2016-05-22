package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.ResumeDAO;
import net.qinghr.qingwa.service.ResumeService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Resume;
@Transactional
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
	@Resource
	private ResumeDAO resumeDAO;

	@Override
	public void save(Resume object) {

	}

	@Override
	public void delete(Resume object) {

	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public void update(Resume object) {
		resumeDAO.update(object);
	}

	@Override
	public Resume findById(Integer id) {
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

	@Override
	public Resume findByUserId(Integer id) {
		Resume resume = null;
		resume = resumeDAO.findByUserId(id);
		return resume;
	}

}

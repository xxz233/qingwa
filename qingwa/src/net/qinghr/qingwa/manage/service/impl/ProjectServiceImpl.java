package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.ProjectDAO;
import net.qinghr.qingwa.manage.service.ProjectServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Project;
@Transactional
@Service("projectServiceManage")
public class ProjectServiceImpl implements ProjectServiceManage {
	@Resource
	private ProjectDAO projectDAO;
	
	@Override
	public void save(Project object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Project object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Project object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Project findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findAll(Pager pager, Project object) {
		// TODO Auto-generated method stub
		return null;
	}

}

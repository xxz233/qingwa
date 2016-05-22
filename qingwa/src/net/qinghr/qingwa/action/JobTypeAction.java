package net.qinghr.qingwa.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.JobTypeService;
import net.qinghr.qingwa.vo.JobType;
@Controller("jobTypeAction")
@Scope("prototype")
public class JobTypeAction extends BaseAction<JobType> implements CommonAction {
	@Resource
	private JobTypeService jobTypeService;

	@Override
	public String findAll() {
		List<JobType> jobTypes = jobTypeService.findAll();
		this.getRequest().setAttribute("jobTypes", jobTypes);
		return null;
	}

	@Override
	public String findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String batchDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findPage() {
		// TODO Auto-generated method stub
		return null;
	}

}

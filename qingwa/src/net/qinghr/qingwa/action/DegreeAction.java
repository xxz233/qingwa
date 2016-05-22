package net.qinghr.qingwa.action;


import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.DegreeService;
import net.qinghr.qingwa.vo.Degree;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller("degreeAction")
@Scope("prototype")
public class DegreeAction extends BaseAction<Degree> implements CommonAction {
	@Resource
	private DegreeService degreeService;

	@Override
	public String findAll() {
		List<Degree> degrees = degreeService.findAll();
		this.getRequest().setAttribute("degrees", degrees);
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

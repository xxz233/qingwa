package net.qinghr.qingwa.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.PersonalSalaryService;
import net.qinghr.qingwa.vo.PersonalSalary;
@Controller("personalSalaryAction")
@Scope("prototype")
public class PersonalSalaryAction extends BaseAction<PersonalSalary> implements
		CommonAction {
	@Resource
	private PersonalSalaryService personalSalaryService;

	@Override
	public String findAll() {
		List<PersonalSalary> personalSalarys = personalSalaryService.findAll();
		this.getRequest().setAttribute("personalSalarys", personalSalarys);
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

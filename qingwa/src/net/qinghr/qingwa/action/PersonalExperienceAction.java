package net.qinghr.qingwa.action;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.PersonalExperienceService;
import net.qinghr.qingwa.vo.PersonalExperience;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller("personalExperienceAction")
@Scope("prototype")
public class PersonalExperienceAction extends BaseAction<PersonalExperience>
		implements CommonAction {
	@Resource
	private PersonalExperienceService personalExperienceService;

	@Override
	public String findAll() {
		List<PersonalExperience> personalExperiences = personalExperienceService.findAll();
		this.getRequest().setAttribute("personalExperiences", personalExperiences);
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

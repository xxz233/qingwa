package net.qinghr.qingwa.action;

import javax.annotation.Resource;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.ResumeService;
import net.qinghr.qingwa.vo.Resume;
import net.qinghr.qingwa.vo.User;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller("resumeAction")
@Scope("prototype")
public class ResumeAction extends BaseAction<Resume> implements CommonAction {
	@Resource
	private ResumeService resumeService;

	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findById() {
		
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		resumeService.update(getModel());
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
	public void findByUserId(){
//		Resume resume = resumeService.findByUserId(((User)this.getSession().getAttribute("user")).getId());
		Resume resume = resumeService.findByUserId(1);
		this.getRequest().setAttribute("resume", resume);
	}
	/**
	 * 修改简历名称
	 */
	public void updateTitle(){
		Resume resume = resumeService.findByUserId(getModel().getId());
		resume.setTitle(getModel().getTitle());
		resumeService.update(resume);
	}
	public void updateBasic(){
		
		Resume resume = resumeService.findByUserId(getModel().getId());
		resume.setUserName(getModel().getUserName());
		resume.setSex(getModel().getSex());
		resume.setDegree(getModel().getDegree());
		resume.setPersonalExperience(getModel().getPersonalExperience());
		resume.setCurrent(getModel().getCurrent());
		resume.setTel(getModel().getTel());
		resume.setEmail(getModel().getEmail());
		System.out.println(getModel().getPersonalExperience().getId());
		System.out.println(getModel().getPersonalExperience().getTitle());
		resumeService.update(resume);
	}

}

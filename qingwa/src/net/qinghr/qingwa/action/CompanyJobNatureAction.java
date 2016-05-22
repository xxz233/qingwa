package net.qinghr.qingwa.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.CompanyJobNatureService;
import net.qinghr.qingwa.vo.CompanyJobNature;
@Controller("companyJobNatureAction")
@Scope("prototype")
public class CompanyJobNatureAction extends BaseAction<CompanyJobNature> implements CommonAction {
	@Resource
	private CompanyJobNatureService companyJobNatureService;

	@Override
	public String findAll() {
		List<CompanyJobNature> companyJobNatures = companyJobNatureService.findAll();
		this.getRequest().setAttribute("companyJobNatures", companyJobNatures);
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

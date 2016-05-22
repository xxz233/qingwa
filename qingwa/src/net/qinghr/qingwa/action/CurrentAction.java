package net.qinghr.qingwa.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.CurrentService;
import net.qinghr.qingwa.vo.Current;

@Controller("currentAction")
@Scope("prototype")
public class CurrentAction extends BaseAction<Current> implements CommonAction {
	
	@Resource
	private CurrentService currentService;
	@Override
	public String findAll() {
		List<Current> currents = currentService.findAll();
		this.getRequest().setAttribute("currents", currents);
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

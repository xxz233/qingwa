package net.qinghr.qingwa.action;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.AreaService;
import net.qinghr.qingwa.vo.Area;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller("areaAction")
@Scope("prototype")
public class AreaAction extends BaseAction<Area> implements CommonAction {
	@Resource
	private AreaService areaService;

	@Override
	public String findAll() {
		List<Area> areas = areaService.findAll();
		this.getRequest().setAttribute("areas", areas);
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

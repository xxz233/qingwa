package net.qinghr.qingwa.manage.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.manage.service.ManageMenuServiceManage;
import net.qinghr.qingwa.vo.Admin;
import net.qinghr.qingwa.vo.ManageMenu;
@SuppressWarnings("serial")
@Controller("manageMenuActionManage")
@Scope("prototype")
public class ManageMenuActionManage extends BaseAction<ManageMenu> implements
		CommonAction {
	@Resource
	private ManageMenuServiceManage manageMenuServiceManage;

	/**
	 * 根据管理员id获得可以管理的菜单
	 */
	@Override
	public String findAll() {
		try {
			List<ManageMenu> menus = manageMenuServiceManage.findByAdminId(((Admin)this.getSession().getAttribute("admin")).getId());

			this.getRequest().setAttribute("menus", menus);

			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
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

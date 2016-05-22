package net.qinghr.qingwa.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.PersonalMenuService;
import net.qinghr.qingwa.vo.PersonalMenu;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller("personalMenuAction")
@Scope("prototype")
public class PersonalMenuAction extends BaseAction<PersonalMenu> implements
		CommonAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4951009177931100467L;
	@Resource
	private PersonalMenuService personalMenuService;
	/**
	 * 根据用户类型返回指定的个人菜单
	 * @return
	 */
	public String findByType(){
		List<PersonalMenu> personalMenus = personalMenuService.findByType((Object)this.getModel().getType());
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] {"id","sort","type","enable"});
		JSONArray jsonArray = JSONArray.fromObject(personalMenus,config);
		this.getResponse().setContentType("text/javascript;charset=utf-8");//设置MIME类型为json，编码为utf-8
		try {
			this.getResponse().getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String findAll() {
		// TODO Auto-generated method stub
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

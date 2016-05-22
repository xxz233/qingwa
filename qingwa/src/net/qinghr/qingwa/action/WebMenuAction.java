package net.qinghr.qingwa.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.WebMenuService;
import net.qinghr.qingwa.vo.WebMenu;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
@Controller("webMenuAction")
@Scope("prototype")
public class WebMenuAction extends BaseAction<WebMenu> implements CommonAction {
	/**
	 *  张子明
	 */
	private static final long serialVersionUID = -4691623490736773879L;
	@Resource
	private WebMenuService webMenuService;
	/**
	 * 根据用户类型和菜单位置获取菜单
	 * @return
	 */
	public String findByTypeAndPosition(){
		List<WebMenu> webMenus = webMenuService.findByTypeAndPosition((Object)this.getModel().getType(), (Object)this.getModel().getPosition());
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] {"id","sort","type","position","enable"});
		JSONArray jsonArray = JSONArray.fromObject(webMenus,config);
		this.getResponse().setContentType("text/javascript;charset=utf-8");
		try {
			this.getResponse().getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String findByPosition(){
		List<WebMenu> webMenus = webMenuService.findByPosition((Object)this.getModel().getPosition());
		this.getRequest().setAttribute("webMenus",webMenus);
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

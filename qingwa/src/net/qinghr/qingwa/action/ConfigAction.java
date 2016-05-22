package net.qinghr.qingwa.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.ConfigService;
import net.qinghr.qingwa.vo.Config;
@Controller("configAction")
@Scope("prototype")
public class ConfigAction extends BaseAction<Config> implements CommonAction {
	/**
	 * 张子明
	 */
	private static final long serialVersionUID = -5836996398927775432L;
	@Resource
	private ConfigService configService;
	
	public String findByConfigKey(){
		Config config = configService.findByConfigKey((Object)this.getModel().getConfigKey());
		this.getRequest().setAttribute("config", config);
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

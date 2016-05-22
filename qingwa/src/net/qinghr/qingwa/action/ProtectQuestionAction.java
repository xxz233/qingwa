package net.qinghr.qingwa.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.ProtectQuestionService;
import net.qinghr.qingwa.vo.ProtectQuestion;
@Controller("protectQuestionAction")
@Scope("prototype")
public class ProtectQuestionAction extends BaseAction<ProtectQuestion>
		implements CommonAction {
	@Resource
	private ProtectQuestionService protectQuestionService;

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

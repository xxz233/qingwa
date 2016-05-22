package net.qinghr.qingwa.manage.action;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.manage.service.UserServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.User;
@Controller("userActionManage")
@Scope("prototype")
public class UserActionManage extends BaseAction<User> implements CommonAction {
	@Resource
	private UserServiceManage userServiceManage;
	private Integer pageNo;
	private String ids;
	private String flag;
	private String startDate;
	private String endDate;
	private boolean isReSet;
	public void setReSet(boolean isReSet) {
		this.isReSet = isReSet;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	@Override
	public String findAll() {
		System.out.println("要搜索的账号是"+this.getModel().getAccount());
		System.out.println("你要搜索的范围是"+flag);
		Boolean isNull = false;
		Date sDate = null;
		Date eDate = null;
		Timestamp startDateTime=null;
		Timestamp endDateTime=null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			if(!startDate.equals(""))
			{
				sDate = sdf.parse(startDate);
				startDateTime = new Timestamp(sDate.getTime());
			}
			if(!endDate.equals(""))
			{
				eDate = sdf.parse(endDate);
				endDateTime = new Timestamp(eDate.getTime());
			}
			System.out.println("开始时间"+sDate+"，，结束时间"+eDate);
			isNull = true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("转换日期格式失败");
		}
		this.getSession().setAttribute("flag", flag);
		if(isNull)
		{
			this.getSession().setAttribute("startDate", sDate);
			this.getSession().setAttribute("endDate", eDate);
		}
		Pager pager = new Pager();
		if(isReSet)
		{
			pager.setPageNo(1);
		}
		pager.setPageSize(10);
		if(pageNo==null||pageNo<=0)
		{
			pageNo = 1;
		}
		pager.setPageNo(pageNo);
		pager.setDataCount(userServiceManage.findAll().size());
		List<User> usersManageList = userServiceManage.findAll(pager,this.getModel());
		this.getRequest().setAttribute("usersManageList", usersManageList);
		this.getSession().setAttribute("user",this.getModel());
		this.getSession().setAttribute("pager", pager);
		return "content";
	}
	@Override
	public String findById() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		//ids = id+ids;
		System.out.println("删除的id为"+ids);
		userServiceManage.update(ids);
		return null;
	}
	@Override
	public String update() {
		// TODO Auto-generated method stub
		System.out.println("删除的id为"+ids);
		this.getModel().setId(Integer.parseInt(ids));
		userServiceManage.update(this.getModel());
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
	@Override
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}
}

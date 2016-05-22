package net.qinghr.qingwa.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.annotation.Resource;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.manage.service.AdminServiceManage;
import net.qinghr.qingwa.util.Code;
import net.qinghr.qingwa.vo.Admin;
import net.qinghr.qingwa.vo.ManageMenu;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller("adminActionManage")
@Scope("prototype")
public class AdminActionManage extends BaseAction<Admin> implements CommonAction {
	@Resource
	private AdminServiceManage adminServiceManage;
	private String code;
	private Boolean flag;//是否显示全部
	public void setCode(String code) {
		this.code = code;
	}
	public  void getCodePig()
	{
		Code.changeCode();
	}
	
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	/**
	 * 登录
	 * @throws IOException
	 */
	public void findByAccountAndpassword() throws IOException
	{
		if(code.equalsIgnoreCase((String)this.getSession().getAttribute("CheckCode")))//�ж���֤��
		{

			Admin admin = adminServiceManage.findByAccountAndpassword(this.getModel().getAccount(), this.getModel().getPassword());

			if(admin!=null)
			{
				this.getSession().setAttribute("admin", admin);
				PrintWriter out = this.getResponse().getWriter();
				out.write("cg");
			}
			else
			{
				PrintWriter out = this.getResponse().getWriter();
				out.write("cw");
			}
		}
		else
		{
			PrintWriter out = this.getResponse().getWriter();
			out.write("yzmcw");
		}

	}
	private String startDate;
	private String endDate;

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * 根据条件查询用户
	 * 陈先顺
	 */
	@Override
	public String findAll() {
		Timestamp startDateTime = null;
		Timestamp endDateTime = null;

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy",Locale.CHINESE);
		List<Admin> admins = new ArrayList<Admin>();
		System.out.println(startDate);
		System.out.println(endDate);
		if(startDate!=null&&!startDate.equals(""))
		{
			if(endDate!=null&&!endDate.equals(""))
			{
					try {
						Date timeDate = dateFormat.parse(startDate);
						Date timeEnd = dateFormat.parse(endDate);
						
						startDateTime = new Timestamp(timeDate.getTime());
						endDateTime = new Timestamp(timeEnd.getTime());
		
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					admins= adminServiceManage.findAll(this.getModel(), flag, startDateTime, endDateTime);
				
			}
			else
			{
				endDateTime = new Timestamp(new Date().getTime());
				try {
					Date timeDate = dateFormat.parse(startDate);
					startDateTime = new Timestamp(timeDate.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				admins= adminServiceManage.findAll(this.getModel(), flag, startDateTime, endDateTime);
			}
			
		}
		else if(endDate!=null&&!endDate.equals(""))
		{
			startDateTime = new Timestamp(new Date().getTime());
			startDateTime = null;
			
			try {
				Date timeEnd = dateFormat.parse(endDate);
				endDateTime = new Timestamp(timeEnd.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			admins = adminServiceManage.findAll(this.getModel(), flag, startDateTime, endDateTime);
		}
		else
		{
			admins = adminServiceManage.findAll(this.getModel(), flag);
		}
		this.getRequest().setAttribute("admins",admins);
		return null;
	}
	
	@Override
	public String findById() {
		Admin admin = new Admin();
		
		admin = adminServiceManage.findById(this.getModel().getId());

		Set<ManageMenu> manageMenu = admin.getManageMenus();

		this.getRequest().setAttribute("manageMenu", manageMenu);
		try {
			this.getResponse().getOutputStream().print("update");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获得ID，删除单选行
	 * 陈先顺
	 */
	@Override
	public String delete() {
		adminServiceManage.delete(this.getModel().getId());
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	private String ids;
	
	public void setIds(String ids) {
		this.ids = ids;
	}
	/**
	 * 通过jsp传输过帐号，密码，是否超级管理员，管理权限，添加到数据库
	 * 陈先顺
	 * @throws IOException 
	 */
	@Override
	public String save() throws IOException {
		// TODO Auto-generated method stub
		
		Set<ManageMenu> manageMenus = new HashSet<ManageMenu>();
		String[] idArr = ids.split(",");
		for (String idStr : idArr) {
			ManageMenu manageMenu = new ManageMenu();
			manageMenu.setId(Integer.parseInt(idStr));
			manageMenus.add(manageMenu);
		}
		Admin admin = new Admin();

		admin.setAccount(this.getModel().getAccount());
		admin.setPassword(this.getModel().getPassword());
		admin.setIsSuper(this.getModel().getIsSuper());
		admin.setManageMenus(manageMenus);

		adminServiceManage.save(admin);

		this.getResponse().getOutputStream().print("ok");

		return null;
	}
	private String adminIds;
	
	public void setAdminIds(String adminIds) {
		this.adminIds = adminIds;
	}
	@Override
	public String batchDelete() {
		// TODO Auto-generated method stub
		adminServiceManage.update(adminIds);
		return null;
	}
	@Override
	public String findPage() {
		// TODO Auto-generated method stub
		return null;
	}

}

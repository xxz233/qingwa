package net.qinghr.qingwa.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.Cookie;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.service.ConfigService;
import net.qinghr.qingwa.service.UserService;
import net.qinghr.qingwa.util.ClientAddressUtil;
import net.qinghr.qingwa.util.Code;
import net.qinghr.qingwa.util.EmailUtil;
import net.qinghr.qingwa.vo.Config;
import net.qinghr.qingwa.vo.User;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> implements CommonAction {
	/**
	 * 张子明
	 */
	private static final long serialVersionUID = -1779305746882884952L;
	@Resource
	private UserService userService;
	@Resource
	private ConfigService configService;
	private String autoLogin;//是否记住用户名
	public void setAutoLogin(String autoLogin) {
		this.autoLogin = autoLogin;
	}
	public void findByAccount(){
		System.out.println(this.getModel().getAccount());
		
		List<User> users = userService.findByAccount(this.getModel().getAccount());
		if(users.size()==0){
			try {
				this.getResponse().getOutputStream().print("ok");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 用户注册by zhang
	 * @return
	 */
	public String registe(){
		//生成字符串
		String code = Code.getRandomChar();
		StringBuilder sb = new StringBuilder();
		sb.append(this.getRequest().getRequestURL().toString().split("qingwa")[0])
		.append("qingwa/validate/")
		.append(code)
		.append(".html");
		System.out.println("生成用户的邮件验证地址："+sb.toString());
		//在数据库的用户表创建记录
		this.getModel().setCode(code);
		this.getModel().setLoginIp(ClientAddressUtil.getIp(this.getRequest()));
		Timestamp tt = new Timestamp(System.currentTimeMillis()); 
		this.getModel().setLoginTime(tt);
		this.getModel().setIsValidate(false);
		this.getModel().setCount(1);
		userService.save(this.getModel());
		final Config smtpHost = configService.findByConfigKey("smtpHost");
		final Config licenseCode = configService.findByConfigKey("licenseCode");
		final Config serverEmail = configService.findByConfigKey("serverEmail");
		Config emailFirstForReg = configService.findByConfigKey("emailFirstForReg");
		Config emailLastForReg = configService.findByConfigKey("emailLastForReg");
		final Config subjectForReg = configService.findByConfigKey("subjectForReg");
		final String content = emailFirstForReg.getConfigValue() + sb.toString() + emailLastForReg.getConfigValue();
		System.out.println(content);
		//开始一个邮件发送线程
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					EmailUtil.sendMessage(smtpHost.getConfigValue(), serverEmail.getConfigValue(), licenseCode.getConfigValue(), getModel().getAccount(), subjectForReg.getConfigValue(), content, "text/html;charset=gb2312");
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}).start();
		//3秒后返回
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 用户登录by zhang
	 * @return
	 */
	public String login(){
		User user = userService.findByAccountAndpassword(this.getModel().getAccount(),this.getModel().getPassword());
		if(user!=null){
			this.getSession().setAttribute("user", user);
			//判断是否勾选了记住我
			if(autoLogin.equals("1")){
				Cookie cookie = new Cookie("account",user.getAccount());
				cookie.setPath("/");
				cookie.setMaxAge(60*24*60*60*7);
				this.getResponse().addCookie(cookie);
			}
			try {
				this.getResponse().getOutputStream().print("ok");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public String exit(){
		this.getSession().invalidate();
		return "index";
	}
	@Override
	public String findAll() {
		System.out.println("获得所有用户");
		return "userList";
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

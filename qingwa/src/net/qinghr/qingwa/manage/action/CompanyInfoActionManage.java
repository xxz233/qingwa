package net.qinghr.qingwa.manage.action;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.common.BaseAction;
import net.qinghr.qingwa.common.CommonAction;
import net.qinghr.qingwa.manage.service.CompanyInfoServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyInfo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller("companyInfoActionManage")
@Scope("prototype")
public class CompanyInfoActionManage extends BaseAction<CompanyInfo> implements
		CommonAction {
	@Resource
	private CompanyInfoServiceManage companyInfoServiceManage;
	
	private Integer pageNo;

	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	private Integer companyId;
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	/**
	 * 设置分页
	 * 关联查询公司部分信息
	 * 陈文
	 */
	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		Pager pager = new Pager();
		
		if(pageNo==null)
		{
			pageNo = 1;
		}
		pager.setPageNo(pageNo);
		pager.setPageSize(5);pager.setDataCount((int) companyInfoServiceManage.getResultCount());
		
		List<CompanyInfo> companyInfos = companyInfoServiceManage.findAll(pager);
		
		this.getRequest().setAttribute("companyInfos", companyInfos);
		this.getRequest().setAttribute("pager", pager);
		
		return null;
	}
	
	/**
	 * 关联查询显示公司全部信息
	 * 陈文
	 */
	@Override
	public String findById() {
		CompanyInfo oneCompanyInfo = companyInfoServiceManage.findById(companyId);  /*oneCompanyInfo为单个公司简介*/

		this.getRequest().setAttribute("oneCompany", oneCompanyInfo);
		
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 审核通过
	 * 陈文
	 */
	@Override
	public String update() {
		CompanyInfo companyInfo = new CompanyInfo();
		
		companyInfo.setId(companyId);	
		companyInfoServiceManage.update(companyInfo);
		
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

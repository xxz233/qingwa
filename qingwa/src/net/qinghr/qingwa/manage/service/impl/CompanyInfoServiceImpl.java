package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.CompanyInfoDAO;
import net.qinghr.qingwa.manage.service.AdminServiceManage;
import net.qinghr.qingwa.manage.service.CompanyInfoServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyInfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service("companyInfoServiceManage")
public class CompanyInfoServiceImpl implements CompanyInfoServiceManage {
	@Resource
	private CompanyInfoDAO companyInfoDAO;

	@Override
	public void save(CompanyInfo object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CompanyInfo object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 审核通过
	 * 陈文
	 */
	@Override
	public void update(CompanyInfo object) {
		companyInfoDAO.update(object);
	}

	/**
	 * 关联查询显示公司全部信息
	 * 陈文
	 */
	@Override
	public CompanyInfo findById(Integer id) {
		CompanyInfo companyInfo = companyInfoDAO.findById(id);
		
		return companyInfo;
	}

	@Override
	public List<CompanyInfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 设置分页
	 * 关联查询公司部分信息
	 * 陈文
	 */
	@Override
	public List<CompanyInfo> findAll(Pager pager) {
		List<CompanyInfo>  companyInfos = companyInfoDAO.findAll();
		companyInfos = companyInfoDAO.findAll(pager);
		
		return companyInfos;
	}

	@Override
	public List<CompanyInfo> findAll(Pager pager, CompanyInfo object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getResultCount() {
		// TODO Auto-generated method stub
		Integer count;
		count = (int) companyInfoDAO.getResultCount();
		return count;
	}

	@Override
	public long getResultCount(CompanyInfo companyInfo) {
		return 0;
		}
	}

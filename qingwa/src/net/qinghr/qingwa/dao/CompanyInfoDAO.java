package net.qinghr.qingwa.dao;

import net.qinghr.qingwa.common.CommonDAO;
import net.qinghr.qingwa.vo.CompanyInfo;

public interface CompanyInfoDAO extends CommonDAO<CompanyInfo> {
	long getResultCount();
	long getResultCount(CompanyInfo companyInfo);
}

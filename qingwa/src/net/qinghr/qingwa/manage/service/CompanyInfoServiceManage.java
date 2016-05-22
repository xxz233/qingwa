package net.qinghr.qingwa.manage.service;

import net.qinghr.qingwa.common.CommonService;
import net.qinghr.qingwa.vo.Article;
import net.qinghr.qingwa.vo.CompanyInfo;

public interface CompanyInfoServiceManage extends CommonService<CompanyInfo> {
	long getResultCount();
	long getResultCount(CompanyInfo companyInfo);
}

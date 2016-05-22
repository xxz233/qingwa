package net.qinghr.qingwa.manage.service;

import net.qinghr.qingwa.common.CommonService;
import net.qinghr.qingwa.vo.Article;

public interface ArticleServiceManage extends CommonService<Article> {
	long getResultCount();
	long getResultCount(Article article);
}

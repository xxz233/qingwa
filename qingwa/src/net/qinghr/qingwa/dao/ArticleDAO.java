package net.qinghr.qingwa.dao;

import net.qinghr.qingwa.common.CommonDAO;
import net.qinghr.qingwa.vo.Article;

public interface ArticleDAO extends CommonDAO<Article> {
	long getResultCount();
	long getResultCount(Article article);
}

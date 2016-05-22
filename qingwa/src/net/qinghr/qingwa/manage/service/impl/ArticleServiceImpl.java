package net.qinghr.qingwa.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.ArticleDAO;
import net.qinghr.qingwa.manage.service.ArticleServiceManage;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Article;
@Transactional
@Service("articleServiceManage")
public class ArticleServiceImpl implements ArticleServiceManage {
	@Resource
	private ArticleDAO articleDAO;

	@Override
	public void save(Article object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Article object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Article object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Article findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findAll(Pager pager, Article object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getResultCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getResultCount(Article article) {
		// TODO Auto-generated method stub
		return 0;
	}

}

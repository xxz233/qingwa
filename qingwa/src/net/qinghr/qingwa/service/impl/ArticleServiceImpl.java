package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.ArticleDAO;
import net.qinghr.qingwa.service.ArticleService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Article;
@Transactional
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
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

}

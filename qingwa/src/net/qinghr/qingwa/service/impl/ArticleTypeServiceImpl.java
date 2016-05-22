package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.ArticleTypeDAO;
import net.qinghr.qingwa.service.ArticleTypeService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.ArticleType;
@Transactional
@Service("articleTypeService")
public class ArticleTypeServiceImpl implements ArticleTypeService {
	@Resource
	private ArticleTypeDAO articleTypeDAO;

	@Override
	public void save(ArticleType object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ArticleType object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ArticleType object) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArticleType findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleType> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleType> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleType> findAll(Pager pager, ArticleType object) {
		// TODO Auto-generated method stub
		return null;
	}

}

package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.ArticleDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Article;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Article entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.Article
 * @author MyEclipse Persistence Tools
 */
@Repository("articleDAO")
public class ArticleDAOImpl implements ArticleDAO{
	private static final Logger log = LoggerFactory.getLogger(ArticleDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String KEY_WORD = "keyWord";
	public static final String DESCRIPTION = "description";
	public static final String INFO = "info";
	public static final String VIEW = "view";
	public static final String AGREE = "agree";
	public static final String IS_TOP = "isTop";
	public static final String SHOW_INDEX = "showIndex";
	public static final String PIC = "pic";
	public static final String SMALL_PIC = "smallPic";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Article transientInstance) {
		log.debug("saving Article instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Article persistentInstance) {
		log.debug("deleting Article instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Article findById(java.lang.Integer id) {
		log.debug("getting Article instance with id: " + id);
		try {
			Article instance = (Article) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Article", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Article instance) {
		log.debug("finding Article instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Article")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Article instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Article as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByKeyWord(Object keyWord) {
		return findByProperty(KEY_WORD, keyWord);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByInfo(Object info) {
		return findByProperty(INFO, info);
	}

	public List findByView(Object view) {
		return findByProperty(VIEW, view);
	}

	public List findByAgree(Object agree) {
		return findByProperty(AGREE, agree);
	}

	public List findByIsTop(Object isTop) {
		return findByProperty(IS_TOP, isTop);
	}

	public List findByShowIndex(Object showIndex) {
		return findByProperty(SHOW_INDEX, showIndex);
	}

	public List findByPic(Object pic) {
		return findByProperty(PIC, pic);
	}

	public List findBySmallPic(Object smallPic) {
		return findByProperty(SMALL_PIC, smallPic);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Article instances");
		try {
			String queryString = "from Article";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Article merge(Article detachedInstance) {
		log.debug("merging Article instance");
		try {
			Article result = (Article) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Article instance) {
		log.debug("attaching dirty Article instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Article instance) {
		log.debug("attaching clean Article instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ArticleDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (ArticleDAOImpl) ctx.getBean("ArticleDAO");
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
	public long getResultCount(Article object) {
		// TODO Auto-generated method stub
		return 0;
	}
}
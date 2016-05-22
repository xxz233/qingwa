package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.CompanyScaleDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyScale;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * Companyscale entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.CompanyScale
 * @author MyEclipse Persistence Tools
 */
@Repository("companyScaleDAO")
public class CompanyScaleDAOImpl implements CompanyScaleDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CompanyScaleDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String SORT = "sort";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(CompanyScale transientInstance) {
		log.debug("saving Companyscale instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompanyScale persistentInstance) {
		log.debug("deleting Companyscale instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompanyScale findById(java.lang.Integer id) {
		log.debug("getting Companyscale instance with id: " + id);
		try {
			CompanyScale instance = (CompanyScale) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Companyscale", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompanyScale instance) {
		log.debug("finding Companyscale instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Companyscale")
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
		log.debug("finding Companyscale instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Companyscale as model where model."
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

	public List findBySort(Object sort) {
		return findByProperty(SORT, sort);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Companyscale instances");
		try {
			String queryString = "from Companyscale";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyScale merge(CompanyScale detachedInstance) {
		log.debug("merging Companyscale instance");
		try {
			CompanyScale result = (CompanyScale) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompanyScale instance) {
		log.debug("attaching dirty Companyscale instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompanyScale instance) {
		log.debug("attaching clean Companyscale instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyScaleDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyScaleDAOImpl) ctx.getBean("CompanyscaleDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CompanyScale object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CompanyScale> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyScale> findAll(Pager pager, CompanyScale object) {
		// TODO Auto-generated method stub
		return null;
	}
}
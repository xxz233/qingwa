package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.CompanyProductDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyProduct;

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
 * Companyproduct entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.CompanyProduct
 * @author MyEclipse Persistence Tools
 */
@Repository("companyProductDAO")
public class CompanyProductDAOImpl implements CompanyProductDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CompanyProductDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String PIC = "pic";
	public static final String URL = "url";
	public static final String DIRECTION = "direction";
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

	public void save(CompanyProduct transientInstance) {
		log.debug("saving Companyproduct instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompanyProduct persistentInstance) {
		log.debug("deleting Companyproduct instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompanyProduct findById(java.lang.Integer id) {
		log.debug("getting Companyproduct instance with id: " + id);
		try {
			CompanyProduct instance = (CompanyProduct) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Companyproduct", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompanyProduct instance) {
		log.debug("finding Companyproduct instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Companyproduct")
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
		log.debug("finding Companyproduct instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Companyproduct as model where model."
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

	public List findByPic(Object pic) {
		return findByProperty(PIC, pic);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByDirection(Object direction) {
		return findByProperty(DIRECTION, direction);
	}

	public List findBySort(Object sort) {
		return findByProperty(SORT, sort);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Companyproduct instances");
		try {
			String queryString = "from Companyproduct";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyProduct merge(CompanyProduct detachedInstance) {
		log.debug("merging Companyproduct instance");
		try {
			CompanyProduct result = (CompanyProduct) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompanyProduct instance) {
		log.debug("attaching dirty Companyproduct instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompanyProduct instance) {
		log.debug("attaching clean Companyproduct instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyProductDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyProductDAOImpl) ctx.getBean("CompanyproductDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CompanyProduct object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CompanyProduct> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyProduct> findAll(Pager pager, CompanyProduct object) {
		// TODO Auto-generated method stub
		return null;
	}
}
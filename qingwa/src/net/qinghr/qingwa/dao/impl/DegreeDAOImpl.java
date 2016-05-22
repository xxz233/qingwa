package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.DegreeDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Degree;

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
 * Digree entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.Degree
 * @author MyEclipse Persistence Tools
 */
@Repository("degreeDAO")
public class DegreeDAOImpl implements DegreeDAO{
	private static final Logger log = LoggerFactory.getLogger(DegreeDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String SORT = "sort";
	public static final String ENABLE = "enable";
	@Resource()
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Degree transientInstance) {
		log.debug("saving Digree instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Degree persistentInstance) {
		log.debug("deleting Digree instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Degree findById(java.lang.Integer id) {
		log.debug("getting Digree instance with id: " + id);
		try {
			Degree instance = (Degree) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Digree", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Degree instance) {
		log.debug("finding Digree instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Digree")
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
		log.debug("finding Digree instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Digree as model where model."
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
/**
 * 宋建伟
 * 查找学历以sort排序
 */
	public List findAll() {
		try {
			String queryString = "from Degree where enable = true order by sort";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Degree merge(Degree detachedInstance) {
		log.debug("merging Digree instance");
		try {
			Degree result = (Degree) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Degree instance) {
		log.debug("attaching dirty Digree instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Degree instance) {
		log.debug("attaching clean Digree instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DegreeDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (DegreeDAOImpl) ctx.getBean("DigreeDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Degree object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Degree> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Degree> findAll(Pager pager, Degree object) {
		// TODO Auto-generated method stub
		return null;
	}
}
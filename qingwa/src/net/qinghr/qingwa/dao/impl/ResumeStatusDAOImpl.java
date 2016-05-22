package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.ResumeStatusDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.ResumeStatus;

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
 * Resumestatus entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.ResumeStatus
 * @author MyEclipse Persistence Tools
 */
@Repository("resumeStatusDAO")
public class ResumeStatusDAOImpl implements ResumeStatusDAO{
	private static final Logger log = LoggerFactory
			.getLogger(ResumeStatusDAOImpl.class);
	// property constants
	public static final String STATUS = "status";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(ResumeStatus transientInstance) {
		log.debug("saving Resumestatus instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ResumeStatus persistentInstance) {
		log.debug("deleting Resumestatus instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ResumeStatus findById(java.lang.Integer id) {
		log.debug("getting Resumestatus instance with id: " + id);
		try {
			ResumeStatus instance = (ResumeStatus) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Resumestatus", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ResumeStatus instance) {
		log.debug("finding Resumestatus instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Resumestatus")
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
		log.debug("finding Resumestatus instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Resumestatus as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Resumestatus instances");
		try {
			String queryString = "from Resumestatus";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ResumeStatus merge(ResumeStatus detachedInstance) {
		log.debug("merging Resumestatus instance");
		try {
			ResumeStatus result = (ResumeStatus) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ResumeStatus instance) {
		log.debug("attaching dirty Resumestatus instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ResumeStatus instance) {
		log.debug("attaching clean Resumestatus instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ResumeStatusDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ResumeStatusDAOImpl) ctx.getBean("ResumestatusDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ResumeStatus object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ResumeStatus> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResumeStatus> findAll(Pager pager, ResumeStatus object) {
		// TODO Auto-generated method stub
		return null;
	}
}
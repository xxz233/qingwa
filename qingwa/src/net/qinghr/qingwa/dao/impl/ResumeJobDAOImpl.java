package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.ResumeJobDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.ResumeJob;

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
 * ResumeJob entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.ResumeJob
 * @author MyEclipse Persistence Tools
 */
@Repository("resumeJobDAO")
public class ResumeJobDAOImpl implements ResumeJobDAO{
	private static final Logger log = LoggerFactory
			.getLogger(ResumeJobDAOImpl.class);
	// property constants
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(ResumeJob transientInstance) {
		log.debug("saving ResumeJob instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ResumeJob persistentInstance) {
		log.debug("deleting ResumeJob instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ResumeJob findById(java.lang.Integer id) {
		log.debug("getting ResumeJob instance with id: " + id);
		try {
			ResumeJob instance = (ResumeJob) getCurrentSession().get(
					"net.qinghr.qingwa.vo.ResumeJob", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ResumeJob instance) {
		log.debug("finding ResumeJob instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.ResumeJob")
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
		log.debug("finding ResumeJob instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ResumeJob as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all ResumeJob instances");
		try {
			String queryString = "from ResumeJob";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ResumeJob merge(ResumeJob detachedInstance) {
		log.debug("merging ResumeJob instance");
		try {
			ResumeJob result = (ResumeJob) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ResumeJob instance) {
		log.debug("attaching dirty ResumeJob instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ResumeJob instance) {
		log.debug("attaching clean ResumeJob instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ResumeJobDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (ResumeJobDAOImpl) ctx.getBean("ResumeJobDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ResumeJob object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ResumeJob> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResumeJob> findAll(Pager pager, ResumeJob object) {
		// TODO Auto-generated method stub
		return null;
	}
}
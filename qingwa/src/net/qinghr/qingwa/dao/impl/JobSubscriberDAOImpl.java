package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.JobSubscriberDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.JobSubscriber;

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
 * Jobsubscriber entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.JobSubscriber
 * @author MyEclipse Persistence Tools
 */
@Repository("jobSubscriberDAO")
public class JobSubscriberDAOImpl implements JobSubscriberDAO{
	private static final Logger log = LoggerFactory
			.getLogger(JobSubscriberDAOImpl.class);
	// property constants
	public static final String EMAIL = "email";
	public static final String CYCLE = "cycle";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(JobSubscriber transientInstance) {
		log.debug("saving Jobsubscriber instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(JobSubscriber persistentInstance) {
		log.debug("deleting Jobsubscriber instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JobSubscriber findById(java.lang.Integer id) {
		log.debug("getting Jobsubscriber instance with id: " + id);
		try {
			JobSubscriber instance = (JobSubscriber) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Jobsubscriber", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(JobSubscriber instance) {
		log.debug("finding Jobsubscriber instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Jobsubscriber")
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
		log.debug("finding Jobsubscriber instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Jobsubscriber as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByCycle(Object cycle) {
		return findByProperty(CYCLE, cycle);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Jobsubscriber instances");
		try {
			String queryString = "from Jobsubscriber";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public JobSubscriber merge(JobSubscriber detachedInstance) {
		log.debug("merging Jobsubscriber instance");
		try {
			JobSubscriber result = (JobSubscriber) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(JobSubscriber instance) {
		log.debug("attaching dirty Jobsubscriber instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JobSubscriber instance) {
		log.debug("attaching clean Jobsubscriber instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JobSubscriberDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (JobSubscriberDAOImpl) ctx.getBean("JobsubscriberDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(JobSubscriber object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<JobSubscriber> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSubscriber> findAll(Pager pager, JobSubscriber object) {
		// TODO Auto-generated method stub
		return null;
	}
}
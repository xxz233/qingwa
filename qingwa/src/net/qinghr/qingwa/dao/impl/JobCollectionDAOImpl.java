package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.JobCollectionDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.JobCollection;

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
 * Jobcollection entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.JobCollection
 * @author MyEclipse Persistence Tools
 */
@Repository("jobCollectionDAO")
public class JobCollectionDAOImpl implements JobCollectionDAO{
	private static final Logger log = LoggerFactory
			.getLogger(JobCollectionDAOImpl.class);
	// property constants
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(JobCollection transientInstance) {
		log.debug("saving Jobcollection instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(JobCollection persistentInstance) {
		log.debug("deleting Jobcollection instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JobCollection findById(java.lang.Integer id) {
		log.debug("getting Jobcollection instance with id: " + id);
		try {
			JobCollection instance = (JobCollection) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Jobcollection", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(JobCollection instance) {
		log.debug("finding Jobcollection instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Jobcollection")
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
		log.debug("finding Jobcollection instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Jobcollection as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Jobcollection instances");
		try {
			String queryString = "from Jobcollection";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public JobCollection merge(JobCollection detachedInstance) {
		log.debug("merging Jobcollection instance");
		try {
			JobCollection result = (JobCollection) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(JobCollection instance) {
		log.debug("attaching dirty Jobcollection instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JobCollection instance) {
		log.debug("attaching clean Jobcollection instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JobCollectionDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (JobCollectionDAOImpl) ctx.getBean("JobcollectionDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(JobCollection object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<JobCollection> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobCollection> findAll(Pager pager, JobCollection object) {
		// TODO Auto-generated method stub
		return null;
	}
}
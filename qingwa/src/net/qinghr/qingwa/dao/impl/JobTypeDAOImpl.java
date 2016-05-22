package net.qinghr.qingwa.dao.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.JobTypeDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.JobType;

import org.hibernate.Hibernate;
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
 * Jobtype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.JobType
 * @author MyEclipse Persistence Tools
 */
@Repository("jobTypeDAO")
public class JobTypeDAOImpl implements JobTypeDAO{
	private static final Logger log = LoggerFactory.getLogger(JobTypeDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String SORT = "sort";
	public static final String IS_HOT = "isHot";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(JobType transientInstance) {
		log.debug("saving Jobtype instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(JobType persistentInstance) {
		log.debug("deleting Jobtype instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JobType findById(java.lang.Integer id) {
		log.debug("getting Jobtype instance with id: " + id);
		try {
			JobType instance = (JobType) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Jobtype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(JobType instance) {
		log.debug("finding Jobtype instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Jobtype")
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
		log.debug("finding Jobtype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Jobtype as model where model."
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

	public List findByIsHot(Object isHot) {
		return findByProperty(IS_HOT, isHot);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List<JobType> findAll() {
		log.debug("查询所有职位");
		try {
			String queryString = "from JobType jt where jt.enable = true and jt.jobType = null";
			Query queryObject = getCurrentSession().createQuery(queryString);
			List<JobType> jobTypes =  queryObject.list();
			for (JobType jobType : jobTypes) {
				Set<JobType> sec = (Set<JobType>)jobType.getJobTypes();
				for (JobType jobType2 : sec) {
						Hibernate.initialize(jobType2.getJobTypes());
					}
			}
			return jobTypes;
		} catch (RuntimeException re) {
			log.error("查询所有职位失败", re);
			throw re;
		}
	}

	public JobType merge(JobType detachedInstance) {
		log.debug("merging Jobtype instance");
		try {
			JobType result = (JobType) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(JobType instance) {
		log.debug("attaching dirty Jobtype instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JobType instance) {
		log.debug("attaching clean Jobtype instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JobTypeDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (JobTypeDAOImpl) ctx.getBean("JobtypeDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(JobType object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<JobType> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobType> findAll(Pager pager, JobType object) {
		// TODO Auto-generated method stub
		return null;
	}
}
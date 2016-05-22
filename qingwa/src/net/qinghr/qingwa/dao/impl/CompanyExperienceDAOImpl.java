package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.CompanyExperienceDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyExperience;

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
 * Companyexperience entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.CompanyExperience
 * @author MyEclipse Persistence Tools
 */
@Repository("companyExperienceDAO")
public class CompanyExperienceDAOImpl implements CompanyExperienceDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CompanyExperienceDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String MIN_TIME = "minTime";
	public static final String MAX_TIME = "maxTime";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(CompanyExperience transientInstance) {
		log.debug("saving Companyexperience instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompanyExperience persistentInstance) {
		log.debug("deleting Companyexperience instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompanyExperience findById(java.lang.Integer id) {
		log.debug("getting Companyexperience instance with id: " + id);
		try {
			CompanyExperience instance = (CompanyExperience) getCurrentSession()
					.get("net.qinghr.qingwa.vo.Companyexperience", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompanyExperience instance) {
		log.debug("finding Companyexperience instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Companyexperience")
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
		log.debug("finding Companyexperience instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Companyexperience as model where model."
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

	public List findByMinTime(Object minTime) {
		return findByProperty(MIN_TIME, minTime);
	}

	public List findByMaxTime(Object maxTime) {
		return findByProperty(MAX_TIME, maxTime);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Companyexperience instances");
		try {
			String queryString = "from Companyexperience";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyExperience merge(CompanyExperience detachedInstance) {
		log.debug("merging Companyexperience instance");
		try {
			CompanyExperience result = (CompanyExperience) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompanyExperience instance) {
		log.debug("attaching dirty Companyexperience instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompanyExperience instance) {
		log.debug("attaching clean Companyexperience instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyExperienceDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyExperienceDAOImpl) ctx.getBean("CompanyexperienceDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CompanyExperience object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CompanyExperience> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyExperience> findAll(Pager pager, CompanyExperience object) {
		// TODO Auto-generated method stub
		return null;
	}
}
package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.CompanyTemptationDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyTemptation;

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
 * Companytemptation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.CompanyTemptation
 * @author MyEclipse Persistence Tools
 */
@Repository("companyTemptationDAO")
public class CompanyTemptationDAOImpl implements CompanyTemptationDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CompanyTemptationDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	@Resource()
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(CompanyTemptation transientInstance) {
		log.debug("saving Companytemptation instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompanyTemptation persistentInstance) {
		log.debug("deleting Companytemptation instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompanyTemptation findById(java.lang.Integer id) {
		log.debug("getting Companytemptation instance with id: " + id);
		try {
			CompanyTemptation instance = (CompanyTemptation) getCurrentSession()
					.get("net.qinghr.qingwa.vo.Companytemptation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompanyTemptation instance) {
		log.debug("finding Companytemptation instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Companytemptation")
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
		log.debug("finding Companytemptation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Companytemptation as model where model."
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

	public List findAll() {
		log.debug("finding all Companytemptation instances");
		try {
			String queryString = "from Companytemptation";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyTemptation merge(CompanyTemptation detachedInstance) {
		log.debug("merging Companytemptation instance");
		try {
			CompanyTemptation result = (CompanyTemptation) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompanyTemptation instance) {
		log.debug("attaching dirty Companytemptation instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompanyTemptation instance) {
		log.debug("attaching clean Companytemptation instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyTemptationDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyTemptationDAOImpl) ctx.getBean("CompanytemptationDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CompanyTemptation object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CompanyTemptation> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyTemptation> findAll(Pager pager, CompanyTemptation object) {
		// TODO Auto-generated method stub
		return null;
	}
}
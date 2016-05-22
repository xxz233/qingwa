package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.CompanyInvestorDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyInvestor;

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
 * Companyinvestor entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.CompanyInvestor
 * @author MyEclipse Persistence Tools
 */
@Repository("companyInvestorDAO")
public class CompanyInvestorDAOImpl implements CompanyInvestorDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CompanyInvestorDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(CompanyInvestor transientInstance) {
		log.debug("saving Companyinvestor instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompanyInvestor persistentInstance) {
		log.debug("deleting Companyinvestor instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompanyInvestor findById(java.lang.Integer id) {
		log.debug("getting Companyinvestor instance with id: " + id);
		try {
			CompanyInvestor instance = (CompanyInvestor) getCurrentSession()
					.get("net.qinghr.qingwa.vo.Companyinvestor", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompanyInvestor instance) {
		log.debug("finding Companyinvestor instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Companyinvestor")
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
		log.debug("finding Companyinvestor instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Companyinvestor as model where model."
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

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Companyinvestor instances");
		try {
			String queryString = "from Companyinvestor";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyInvestor merge(CompanyInvestor detachedInstance) {
		log.debug("merging Companyinvestor instance");
		try {
			CompanyInvestor result = (CompanyInvestor) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompanyInvestor instance) {
		log.debug("attaching dirty Companyinvestor instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompanyInvestor instance) {
		log.debug("attaching clean Companyinvestor instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyInvestorDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyInvestorDAOImpl) ctx.getBean("CompanyinvestorDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CompanyInvestor object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CompanyInvestor> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyInvestor> findAll(Pager pager, CompanyInvestor object) {
		// TODO Auto-generated method stub
		return null;
	}
}
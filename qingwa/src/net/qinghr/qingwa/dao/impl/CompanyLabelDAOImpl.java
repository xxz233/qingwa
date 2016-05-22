package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.CompanyLabelDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyLabel;

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
 * Companylabel entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.CompanyLabel
 * @author MyEclipse Persistence Tools
 */
@Repository("companyLabelDAO")
public class CompanyLabelDAOImpl implements CompanyLabelDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CompanyLabelDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(CompanyLabel transientInstance) {
		log.debug("saving Companylabel instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompanyLabel persistentInstance) {
		log.debug("deleting Companylabel instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompanyLabel findById(java.lang.Integer id) {
		log.debug("getting Companylabel instance with id: " + id);
		try {
			CompanyLabel instance = (CompanyLabel) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Companylabel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompanyLabel instance) {
		log.debug("finding Companylabel instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Companylabel")
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
		log.debug("finding Companylabel instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Companylabel as model where model."
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
		log.debug("finding all Companylabel instances");
		try {
			String queryString = "from Companylabel";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyLabel merge(CompanyLabel detachedInstance) {
		log.debug("merging Companylabel instance");
		try {
			CompanyLabel result = (CompanyLabel) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompanyLabel instance) {
		log.debug("attaching dirty Companylabel instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompanyLabel instance) {
		log.debug("attaching clean Companylabel instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyLabelDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyLabelDAOImpl) ctx.getBean("CompanylabelDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CompanyLabel object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CompanyLabel> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyLabel> findAll(Pager pager, CompanyLabel object) {
		// TODO Auto-generated method stub
		return null;
	}
}
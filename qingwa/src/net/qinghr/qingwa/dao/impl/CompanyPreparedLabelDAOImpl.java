package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.CompanyPreparedLabelDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyPreparedLabel;

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
 * Companypreparedlabel entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.CompanyPreparedLabel
 * @author MyEclipse Persistence Tools
 */
@Repository("companyPreparedLabelDAO")
public class CompanyPreparedLabelDAOImpl implements CompanyPreparedLabelDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CompanyPreparedLabelDAOImpl.class);
	// property constants
	public static final String SORT = "sort";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(CompanyPreparedLabel transientInstance) {
		log.debug("saving Companypreparedlabel instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompanyPreparedLabel persistentInstance) {
		log.debug("deleting Companypreparedlabel instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompanyPreparedLabel findById(java.lang.String id) {
		log.debug("getting Companypreparedlabel instance with id: " + id);
		try {
			CompanyPreparedLabel instance = (CompanyPreparedLabel) getCurrentSession()
					.get("net.qinghr.qingwa.vo.Companypreparedlabel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompanyPreparedLabel instance) {
		log.debug("finding Companypreparedlabel instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Companypreparedlabel")
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
		log.debug("finding Companypreparedlabel instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Companypreparedlabel as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySort(Object sort) {
		return findByProperty(SORT, sort);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Companypreparedlabel instances");
		try {
			String queryString = "from Companypreparedlabel";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyPreparedLabel merge(CompanyPreparedLabel detachedInstance) {
		log.debug("merging Companypreparedlabel instance");
		try {
			CompanyPreparedLabel result = (CompanyPreparedLabel) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompanyPreparedLabel instance) {
		log.debug("attaching dirty Companypreparedlabel instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompanyPreparedLabel instance) {
		log.debug("attaching clean Companypreparedlabel instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyPreparedLabelDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyPreparedLabelDAOImpl) ctx.getBean("CompanypreparedlabelDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CompanyPreparedLabel object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CompanyPreparedLabel findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyPreparedLabel> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyPreparedLabel> findAll(Pager pager,
			CompanyPreparedLabel object) {
		// TODO Auto-generated method stub
		return null;
	}
}
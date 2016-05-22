package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.AdminLogDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.AdminLog;

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
 * Adminlog entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.AdminLog
 * @author MyEclipse Persistence Tools
 */
@Repository("adminLogDAO")
public class AdminLogDAOImpl implements AdminLogDAO{
	private static final Logger log = LoggerFactory
			.getLogger(AdminLogDAOImpl.class);
	// property constants
	public static final String LOGIN_IP = "loginIp";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(AdminLog transientInstance) {
		log.debug("saving Adminlog instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdminLog persistentInstance) {
		log.debug("deleting Adminlog instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdminLog findById(java.lang.Integer id) {
		log.debug("getting Adminlog instance with id: " + id);
		try {
			AdminLog instance = (AdminLog) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Adminlog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AdminLog instance) {
		log.debug("finding Adminlog instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Adminlog")
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
		log.debug("finding Adminlog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Adminlog as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLoginIp(Object loginIp) {
		return findByProperty(LOGIN_IP, loginIp);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Adminlog instances");
		try {
			String queryString = "from Adminlog";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdminLog merge(AdminLog detachedInstance) {
		log.debug("merging Adminlog instance");
		try {
			AdminLog result = (AdminLog) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdminLog instance) {
		log.debug("attaching dirty Adminlog instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdminLog instance) {
		log.debug("attaching clean Adminlog instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdminLogDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (AdminLogDAOImpl) ctx.getBean("AdminlogDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AdminLog object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AdminLog> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminLog> findAll(Pager pager, AdminLog object) {
		// TODO Auto-generated method stub
		return null;
	}
}
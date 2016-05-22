package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.AttachmenResumeDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.AttachmenResume;

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
 * Attachmenresume entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.AttachmenResume
 * @author MyEclipse Persistence Tools
 */
@Repository("attachmenResumeDAO")
public class AttachmenResumeDAOImpl implements AttachmenResumeDAO{
	private static final Logger log = LoggerFactory
			.getLogger(AttachmenResumeDAOImpl.class);
	// property constants
	public static final String FILE_PATH = "filePath";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(AttachmenResume transientInstance) {
		log.debug("saving Attachmenresume instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AttachmenResume persistentInstance) {
		log.debug("deleting Attachmenresume instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AttachmenResume findById(java.lang.Integer id) {
		log.debug("getting Attachmenresume instance with id: " + id);
		try {
			AttachmenResume instance = (AttachmenResume) getCurrentSession()
					.get("net.qinghr.qingwa.vo.Attachmenresume", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AttachmenResume instance) {
		log.debug("finding Attachmenresume instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.AttachmenResume")
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
		log.debug("finding Attachmenresume instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Attachmenresume as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFilePath(Object filePath) {
		return findByProperty(FILE_PATH, filePath);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Attachmenresume instances");
		try {
			String queryString = "from Attachmenresume";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AttachmenResume merge(AttachmenResume detachedInstance) {
		log.debug("merging Attachmenresume instance");
		try {
			AttachmenResume result = (AttachmenResume) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AttachmenResume instance) {
		log.debug("attaching dirty Attachmenresume instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AttachmenResume instance) {
		log.debug("attaching clean Attachmenresume instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AttachmenResumeDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AttachmenResumeDAOImpl) ctx.getBean("AttachmenresumeDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AttachmenResume object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AttachmenResume> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttachmenResume> findAll(Pager pager, AttachmenResume object) {
		// TODO Auto-generated method stub
		return null;
	}
}
package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.EducationalBackgroundDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.EducationalBackground;

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
 * Educationalbackground entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.EducationalBackground
 * @author MyEclipse Persistence Tools
 */
@Repository("educationalBackgroundDAO")
public class EducationalBackgroundDAOImpl implements EducationalBackgroundDAO{
	private static final Logger log = LoggerFactory
			.getLogger(EducationalBackgroundDAOImpl.class);
	// property constants
	public static final String SCHOOL = "school";
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

	public void save(EducationalBackground transientInstance) {
		log.debug("saving Educationalbackground instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EducationalBackground persistentInstance) {
		log.debug("deleting Educationalbackground instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EducationalBackground findById(java.lang.Integer id) {
		log.debug("getting Educationalbackground instance with id: " + id);
		try {
			EducationalBackground instance = (EducationalBackground) getCurrentSession()
					.get("net.qinghr.qingwa.vo.Educationalbackground", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EducationalBackground instance) {
		log.debug("finding Educationalbackground instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria(
							"net.qinghr.qingwa.vo.Educationalbackground")
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
		log.debug("finding Educationalbackground instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Educationalbackground as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySchool(Object school) {
		return findByProperty(SCHOOL, school);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Educationalbackground instances");
		try {
			String queryString = "from Educationalbackground";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EducationalBackground merge(EducationalBackground detachedInstance) {
		log.debug("merging Educationalbackground instance");
		try {
			EducationalBackground result = (EducationalBackground) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EducationalBackground instance) {
		log.debug("attaching dirty Educationalbackground instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EducationalBackground instance) {
		log.debug("attaching clean Educationalbackground instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EducationalBackgroundDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (EducationalBackgroundDAOImpl) ctx
				.getBean("EducationalbackgroundDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EducationalBackground object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EducationalBackground> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EducationalBackground> findAll(Pager pager,
			EducationalBackground object) {
		// TODO Auto-generated method stub
		return null;
	}
}
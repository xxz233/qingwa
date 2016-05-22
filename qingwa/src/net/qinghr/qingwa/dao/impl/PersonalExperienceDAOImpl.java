package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.PersonalExperienceDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.PersonalExperience;

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
 * Personalexperience entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.PersonalExperience
 * @author MyEclipse Persistence Tools
 */
@Repository("personalExperienceDAO")
public class PersonalExperienceDAOImpl implements PersonalExperienceDAO{
	private static final Logger log = LoggerFactory
			.getLogger(PersonalExperienceDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
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

	public void save(PersonalExperience transientInstance) {
		log.debug("saving Personalexperience instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PersonalExperience persistentInstance) {
		log.debug("deleting Personalexperience instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PersonalExperience findById(java.lang.Integer id) {
		log.debug("getting Personalexperience instance with id: " + id);
		try {
			PersonalExperience instance = (PersonalExperience) getCurrentSession()
					.get("net.qinghr.qingwa.vo.Personalexperience", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PersonalExperience instance) {
		log.debug("finding Personalexperience instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Personalexperience")
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
		log.debug("finding Personalexperience instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Personalexperience as model where model."
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

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}
	/**
	 * 宋建伟
	 * 查找工作经验以sort排序
	 */
	public List findAll() {
		try {
			String queryString = "from PersonalExperience where enable = true order by sort";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public PersonalExperience merge(PersonalExperience detachedInstance) {
		log.debug("merging Personalexperience instance");
		try {
			PersonalExperience result = (PersonalExperience) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PersonalExperience instance) {
		log.debug("attaching dirty Personalexperience instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PersonalExperience instance) {
		log.debug("attaching clean Personalexperience instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PersonalExperienceDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (PersonalExperienceDAOImpl) ctx.getBean("PersonalexperienceDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PersonalExperience object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonalExperience> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonalExperience> findAll(Pager pager,
			PersonalExperience object) {
		// TODO Auto-generated method stub
		return null;
	}
}

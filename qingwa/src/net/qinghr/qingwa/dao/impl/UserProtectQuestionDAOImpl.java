package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.UserProtectQuestionDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.UserProtectQuestion;

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
 * Userprotectquestion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.UserProtectQuestion
 * @author MyEclipse Persistence Tools
 */
@Repository("userProtectQuestionDAO")
public class UserProtectQuestionDAOImpl implements UserProtectQuestionDAO{
	private static final Logger log = LoggerFactory
			.getLogger(UserProtectQuestionDAOImpl.class);
	// property constants
	public static final String ANSWER = "answer";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(UserProtectQuestion transientInstance) {
		log.debug("saving Userprotectquestion instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserProtectQuestion persistentInstance) {
		log.debug("deleting Userprotectquestion instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserProtectQuestion findById(java.lang.Integer id) {
		log.debug("getting Userprotectquestion instance with id: " + id);
		try {
			UserProtectQuestion instance = (UserProtectQuestion) getCurrentSession()
					.get("net.qinghr.qingwa.vo.Userprotectquestion", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserProtectQuestion instance) {
		log.debug("finding Userprotectquestion instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Userprotectquestion")
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
		log.debug("finding Userprotectquestion instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Userprotectquestion as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Userprotectquestion instances");
		try {
			String queryString = "from Userprotectquestion";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserProtectQuestion merge(UserProtectQuestion detachedInstance) {
		log.debug("merging Userprotectquestion instance");
		try {
			UserProtectQuestion result = (UserProtectQuestion) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserProtectQuestion instance) {
		log.debug("attaching dirty Userprotectquestion instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserProtectQuestion instance) {
		log.debug("attaching clean Userprotectquestion instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserProtectQuestionDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserProtectQuestionDAOImpl) ctx.getBean("UserprotectquestionDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserProtectQuestion object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserProtectQuestion> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserProtectQuestion> findAll(Pager pager,
			UserProtectQuestion object) {
		// TODO Auto-generated method stub
		return null;
	}

}
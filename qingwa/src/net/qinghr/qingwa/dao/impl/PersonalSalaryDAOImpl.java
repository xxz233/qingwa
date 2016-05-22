package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.action.PersonalSalaryAction;
import net.qinghr.qingwa.dao.PersonalSalaryDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.PersonalSalary;

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
 * Personalsalary entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.PersonalSalary
 * @author MyEclipse Persistence Tools
 */
@Repository("personalSalaryDAO")
public class PersonalSalaryDAOImpl implements PersonalSalaryDAO{
	private static final Logger log = LoggerFactory
			.getLogger(PersonalSalaryDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String MIN_SALARY = "minSalary";
	public static final String MAX_SALARY = "maxSalary";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(PersonalSalary transientInstance) {
		log.debug("saving Personalsalary instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PersonalSalary persistentInstance) {
		log.debug("deleting Personalsalary instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PersonalSalary findById(java.lang.Integer id) {
		log.debug("getting Personalsalary instance with id: " + id);
		try {
			PersonalSalary instance = (PersonalSalary) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Personalsalary", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PersonalSalary instance) {
		log.debug("finding Personalsalary instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Personalsalary")
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
		log.debug("finding Personalsalary instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Personalsalary as model where model."
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

	public List findByMinSalary(Object minSalary) {
		return findByProperty(MIN_SALARY, minSalary);
	}

	public List findByMaxSalary(Object maxSalary) {
		return findByProperty(MAX_SALARY, maxSalary);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}
/**
 * 宋建伟
 * 查找薪水范围以sort排序
 */
	public List<PersonalSalary> findAll() {
		try {
			String queryString = "from PersonalSalary where enable = true order by id";
			Query queryObject = getCurrentSession().createQuery(queryString);
			List<PersonalSalary> list = queryObject.list();
			for (PersonalSalary personalSalary : list) {
				System.out.println(personalSalary.getTitle());
			}
			return list;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public PersonalSalary merge(PersonalSalary detachedInstance) {
		log.debug("merging Personalsalary instance");
		try {
			PersonalSalary result = (PersonalSalary) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PersonalSalary instance) {
		log.debug("attaching dirty Personalsalary instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PersonalSalary instance) {
		log.debug("attaching clean Personalsalary instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PersonalSalaryDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (PersonalSalaryDAOImpl) ctx.getBean("PersonalsalaryDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PersonalSalary object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonalSalary> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonalSalary> findAll(Pager pager, PersonalSalary object) {
		// TODO Auto-generated method stub
		return null;
	}
}

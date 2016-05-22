package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.CompanyJobDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyJob;

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
 * Companyjob entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.CompanyJob
 * @author MyEclipse Persistence Tools
 */
@Repository("companyJobDAO")
public class CompanyJobDAOImpl implements CompanyJobDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CompanyJobDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String DEPARTMENT = "department";
	public static final String MIN_SALARY = "minSalary";
	public static final String MAX_SALARY = "maxSalary";
	public static final String DIRECTION = "direction";
	public static final String VIEW = "view";
	public static final String RESUME_COUNT = "resumeCount";
	public static final String IS_DOWN = "isDown";
	public static final String IS_VALIDATE = "isValidate";
	public static final String ADRESS = "adress";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(CompanyJob transientInstance) {
		log.debug("saving Companyjob instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompanyJob persistentInstance) {
		log.debug("deleting Companyjob instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompanyJob findById(java.lang.Integer id) {
		log.debug("getting Companyjob instance with id: " + id);
		try {
			CompanyJob instance = (CompanyJob) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Companyjob", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompanyJob instance) {
		log.debug("finding Companyjob instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Companyjob")
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
		log.debug("finding Companyjob instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Companyjob as model where model."
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

	public List findByDepartment(Object department) {
		return findByProperty(DEPARTMENT, department);
	}

	public List findByMinSalary(Object minSalary) {
		return findByProperty(MIN_SALARY, minSalary);
	}

	public List findByMaxSalary(Object maxSalary) {
		return findByProperty(MAX_SALARY, maxSalary);
	}

	public List findByDirection(Object direction) {
		return findByProperty(DIRECTION, direction);
	}

	public List findByView(Object view) {
		return findByProperty(VIEW, view);
	}

	public List findByResumeCount(Object resumeCount) {
		return findByProperty(RESUME_COUNT, resumeCount);
	}

	public List findByIsDown(Object isDown) {
		return findByProperty(IS_DOWN, isDown);
	}

	public List findByIsValidate(Object isValidate) {
		return findByProperty(IS_VALIDATE, isValidate);
	}

	public List findByAdress(Object adress) {
		return findByProperty(ADRESS, adress);
	}

	public List findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Companyjob instances");
		try {
			String queryString = "from Companyjob";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyJob merge(CompanyJob detachedInstance) {
		log.debug("merging Companyjob instance");
		try {
			CompanyJob result = (CompanyJob) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompanyJob instance) {
		log.debug("attaching dirty Companyjob instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompanyJob instance) {
		log.debug("attaching clean Companyjob instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyJobDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (CompanyJobDAOImpl) ctx.getBean("CompanyjobDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CompanyJob object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CompanyJob> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyJob> findAll(Pager pager, CompanyJob object) {
		// TODO Auto-generated method stub
		return null;
	}
}
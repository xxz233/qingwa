package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.ResumeDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Result;
import net.qinghr.qingwa.vo.Resume;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
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
 * Resume entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.Resume
 * @author MyEclipse Persistence Tools
 */
@Repository("resumeDAO")
public class ResumeDAOImpl implements ResumeDAO{
	private static final Logger log = LoggerFactory.getLogger(ResumeDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String USER_NAME = "userName";
	public static final String PIC = "pic";
	public static final String SEX = "sex";
	public static final String TEL = "tel";
	public static final String EMAIL = "email";
	public static final String DIRECTION = "direction";
	public static final String VIEW = "view";
	public static final String EXPECTED_JOB = "expectedJob";
	public static final String MIN_SALARY = "minSalary";
	public static final String MAX_SALARY = "maxSalary";
	public static final String DOWN_COUNT = "downCount";
	public static final String IS_RELEASE = "isRelease";
	public static final String IS_DEFAULT = "isDefault";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Resume transientInstance) {
		log.debug("saving Resume instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Resume persistentInstance) {
		log.debug("deleting Resume instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Resume findById(java.lang.Integer id) {
		log.debug("getting Resume instance with id: " + id);
		try {
			Resume instance = (Resume) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Resume", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Resume instance) {
		log.debug("finding Resume instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Resume")
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
		log.debug("finding Resume instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Resume as model where model."
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

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByPic(Object pic) {
		return findByProperty(PIC, pic);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByDirection(Object direction) {
		return findByProperty(DIRECTION, direction);
	}

	public List findByView(Object view) {
		return findByProperty(VIEW, view);
	}

	public List findByExpectedJob(Object expectedJob) {
		return findByProperty(EXPECTED_JOB, expectedJob);
	}

	public List findByMinSalary(Object minSalary) {
		return findByProperty(MIN_SALARY, minSalary);
	}

	public List findByMaxSalary(Object maxSalary) {
		return findByProperty(MAX_SALARY, maxSalary);
	}

	public List findByDownCount(Object downCount) {
		return findByProperty(DOWN_COUNT, downCount);
	}

	public List findByIsRelease(Object isRelease) {
		return findByProperty(IS_RELEASE, isRelease);
	}

	public List findByIsDefault(Object isDefault) {
		return findByProperty(IS_DEFAULT, isDefault);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Resume instances");
		try {
			String queryString = "from Resume";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Resume merge(Resume detachedInstance) {
		log.debug("merging Resume instance");
		try {
			Resume result = (Resume) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Resume instance) {
		log.debug("attaching dirty Resume instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Resume instance) {
		log.debug("attaching clean Resume instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ResumeDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (ResumeDAOImpl) ctx.getBean("ResumeDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Resume object) {
		this.getCurrentSession().update(object);
	}

	@Override
	public List<Resume> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resume> findAll(Pager pager, Resume object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resume findByUserId(Integer id) {
		Resume resume;
		try {
			String hql = "from Resume r where r.id = :id and r.enable=true";
			Query query = getCurrentSession().createQuery(hql);
			query.setInteger("id", id);
			resume = (Resume) query.uniqueResult();
			Hibernate.initialize(resume.getArea());
			Hibernate.initialize(resume.getDegree());
			Hibernate.initialize(resume.getUser());
			Hibernate.initialize(resume.getCurrent());
			Hibernate.initialize(resume.getPersonalExperience());
			Hibernate.initialize(resume.getResumeJobs());
			Hibernate.initialize(resume.getEducationalBackgrounds());
			Hibernate.initialize(resume.getProjects());
			Hibernate.initialize(resume.getResults());
			Hibernate.initialize(resume.getCompanyJobNature());
			return resume;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.AdvertisementCompanyDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.AdvertisementCompany;

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
 * Advertisementcompany entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.AdvertisementCompany
 * @author MyEclipse Persistence Tools
 */
@Repository("advertisementCompanyDAO")
public class AdvertisementCompanyDAOImpl implements AdvertisementCompanyDAO{
	private static final Logger log = LoggerFactory
			.getLogger(AdvertisementCompanyDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String URL = "url";
	public static final String TARGET = "target";
	public static final String PIC = "pic";
	public static final String PHONE = "phone";
	public static final String QQ = "qq";
	public static final String EMAIL = "email";
	public static final String COUNT = "count";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(AdvertisementCompany transientInstance) {
		log.debug("saving Advertisementcompany instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdvertisementCompany persistentInstance) {
		log.debug("deleting Advertisementcompany instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdvertisementCompany findById(java.lang.Integer id) {
		log.debug("getting Advertisementcompany instance with id: " + id);
		try {
			AdvertisementCompany instance = (AdvertisementCompany) getCurrentSession()
					.get("net.qinghr.qingwa.vo.Advertisementcompany", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AdvertisementCompany instance) {
		log.debug("finding Advertisementcompany instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Advertisementcompany")
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
		log.debug("finding Advertisementcompany instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Advertisementcompany as model where model."
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

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByTarget(Object target) {
		return findByProperty(TARGET, target);
	}

	public List findByPic(Object pic) {
		return findByProperty(PIC, pic);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByCount(Object count) {
		return findByProperty(COUNT, count);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Advertisementcompany instances");
		try {
			String queryString = "from Advertisementcompany";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdvertisementCompany merge(AdvertisementCompany detachedInstance) {
		log.debug("merging Advertisementcompany instance");
		try {
			AdvertisementCompany result = (AdvertisementCompany) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdvertisementCompany instance) {
		log.debug("attaching dirty Advertisementcompany instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdvertisementCompany instance) {
		log.debug("attaching clean Advertisementcompany instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdvertisementCompanyDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdvertisementCompanyDAOImpl) ctx.getBean("AdvertisementcompanyDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AdvertisementCompany object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AdvertisementCompany> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdvertisementCompany> findAll(Pager pager,
			AdvertisementCompany object) {
		// TODO Auto-generated method stub
		return null;
	}
}
package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.AdvertisementPositionDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.AdvertisementPosition;

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
 * Advertisementposition entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.AdvertisementPosition
 * @author MyEclipse Persistence Tools
 */
@Repository("advertisementPositionDAO")
public class AdvertisementPositionDAOImpl implements AdvertisementPositionDAO{
	private static final Logger log = LoggerFactory
			.getLogger(AdvertisementPositionDAOImpl.class);
	// property constants
	public static final String POSITION = "position";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(AdvertisementPosition transientInstance) {
		log.debug("saving Advertisementposition instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdvertisementPosition persistentInstance) {
		log.debug("deleting Advertisementposition instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdvertisementPosition findById(java.lang.Integer id) {
		log.debug("getting Advertisementposition instance with id: " + id);
		try {
			AdvertisementPosition instance = (AdvertisementPosition) getCurrentSession()
					.get("net.qinghr.qingwa.vo.Advertisementposition", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AdvertisementPosition instance) {
		log.debug("finding Advertisementposition instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria(
							"net.qinghr.qingwa.vo.Advertisementposition")
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
		log.debug("finding Advertisementposition instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Advertisementposition as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPosition(Object position) {
		return findByProperty(POSITION, position);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Advertisementposition instances");
		try {
			String queryString = "from Advertisementposition";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdvertisementPosition merge(AdvertisementPosition detachedInstance) {
		log.debug("merging Advertisementposition instance");
		try {
			AdvertisementPosition result = (AdvertisementPosition) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdvertisementPosition instance) {
		log.debug("attaching dirty Advertisementposition instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdvertisementPosition instance) {
		log.debug("attaching clean Advertisementposition instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdvertisementPositionDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdvertisementPositionDAOImpl) ctx
				.getBean("AdvertisementpositionDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AdvertisementPosition object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AdvertisementPosition> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdvertisementPosition> findAll(Pager pager,
			AdvertisementPosition object) {
		// TODO Auto-generated method stub
		return null;
	}
}
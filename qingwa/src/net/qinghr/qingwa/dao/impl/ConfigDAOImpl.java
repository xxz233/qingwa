package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.ConfigDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Config;

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
 * Config entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.Config
 * @author MyEclipse Persistence Tools
 */
@Repository("configDAO")
public class ConfigDAOImpl implements ConfigDAO{
	private static final Logger log = LoggerFactory.getLogger(ConfigDAOImpl.class);
	// property constants
	public static final String CONFIG_KEY = "configKey";
	public static final String CONFIG_VALUE = "configValue";
	public static final String CONFIG_DESCRIPTION = "configDescription";
	public static final String ENABLE = "enable";
	@Resource()
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Config transientInstance) {
		log.debug("saving Config instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Config persistentInstance) {
		log.debug("deleting Config instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Config findById(java.lang.Integer id) {
		log.debug("getting Config instance with id: " + id);
		try {
			Config instance = (Config) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Config", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Config instance) {
		log.debug("finding Config instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Config")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public Config findByProperty(String propertyName, Object value) {
		log.debug("姝ｅ湪鎸夊睘鎬у悕鏌ヨ閰嶇疆淇℃伅: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Config as model where model.enable=true and model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (Config)queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("鏍规嵁灞炴�鍚嶆煡鎵惧け璐�, re");
			throw re;
		}
	}

	public Config findByConfigKey(Object configKey) {
		return findByProperty(CONFIG_KEY, configKey);
	}

	public List findAll() {
		log.debug("finding all Config instances");
		try {
			String queryString = "from Config";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Config merge(Config detachedInstance) {
		log.debug("merging Config instance");
		try {
			Config result = (Config) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Config instance) {
		log.debug("attaching dirty Config instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Config instance) {
		log.debug("attaching clean Config instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ConfigDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (ConfigDAOImpl) ctx.getBean("ConfigDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Config object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Config> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Config> findAll(Pager pager, Config object) {
		// TODO Auto-generated method stub
		return null;
	}
}

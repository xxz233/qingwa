package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.PersonalMenuDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.PersonalMenu;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * Personalmenu entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.PersonalMenu
 * @author MyEclipse Persistence Tools
 */
@Repository("personalMenuDAO")
public class PersonalMenuDAOImpl implements PersonalMenuDAO{
	private static final Logger log = LoggerFactory
			.getLogger(PersonalMenuDAOImpl.class);
	// property constants
	public static final String TYPE = "type";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(PersonalMenu transientInstance) {
		log.debug("saving Personalmenu instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PersonalMenu persistentInstance) {
		log.debug("deleting Personalmenu instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PersonalMenu findById(java.lang.Integer id) {
		log.debug("getting PersonalMenu instance with id: " + id);
		try {
			PersonalMenu instance = (PersonalMenu) getCurrentSession().get(
					"net.qinghr.qingwa.vo.PersonalMenu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * 查询前台界面个人菜单 by zhang
	 * @param propertyName 属性名称
	 * @param value 属性值
	 * @return PersonalMenu集合
	 */
	@SuppressWarnings("unchecked")
	public List<PersonalMenu> findByProperty(String propertyName, Object value) {
		log.debug("正在根据属性查询个人菜单: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PersonalMenu as model where model."
					+ propertyName + "= ? and model.enable = true order by model.sort";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("根据属性查找失败", re);
			throw re;
		}
	}
	/**
	 * 根据type来查找菜单 by zhang
	 * @param type
	 * @return
	 */
	public List<PersonalMenu> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	@SuppressWarnings("unchecked")
	public List<PersonalMenu> findAll() {
		log.debug("finding all PersonalMenu instances");
		try {
			String queryString = "from PersonalMenu";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PersonalMenu merge(PersonalMenu detachedInstance) {
		log.debug("merging PersonalMenu instance");
		try {
			PersonalMenu result = (PersonalMenu) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PersonalMenu instance) {
		log.debug("attaching dirty PersonalMenu instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PersonalMenu instance) {
		log.debug("attaching clean PersonalMenu instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PersonalMenuDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (PersonalMenuDAOImpl) ctx.getBean("PersonalmenuDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PersonalMenu object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonalMenu> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonalMenu> findAll(Pager pager, PersonalMenu object) {
		// TODO Auto-generated method stub
		return null;
	}
}
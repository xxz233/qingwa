package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.WebMenuDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.WebMenu;

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
 * Webmenu entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.WebMenu
 * @author MyEclipse Persistence Tools
 */
@Repository("webMenuDAO")
public class WebMenuDAOImpl implements WebMenuDAO{
	private static final Logger log = LoggerFactory.getLogger(WebMenuDAOImpl.class);
	// property constants
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(WebMenu transientInstance) {
		log.debug("saving Webmenu instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(WebMenu persistentInstance) {
		log.debug("deleting Webmenu instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WebMenu findById(java.lang.Integer id) {
		log.debug("getting Webmenu instance with id: " + id);
		try {
			WebMenu instance = (WebMenu) getCurrentSession().get(
					"net.qinghr.qingwa.vo.Webmenu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * 根据用户类型和菜单位置取出菜单
	 * @param type 用户类型
	 * @param position 菜单位置
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WebMenu> findByTypeAndPosition(Object type,Object position){
		log.debug("正在根据用户类型type和菜单位置position");
		try {
			String hql = "from WebMenu w where w.type=:type and w.position=:position and w.enable=true order by w.sort";
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("type", type);
			query.setParameter("position", position);
			return query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<WebMenu> findByPosition(Object position){
		log.debug("正在根据用户类型type和菜单位置position");
		try {
			String hql = "from WebMenu w where w.position=:position and w.enable=true order by w.sort";
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("position", position);
			return query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebMenu merge(WebMenu detachedInstance) {
		log.debug("merging Webmenu instance");
		try {
			WebMenu result = (WebMenu) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(WebMenu instance) {
		log.debug("attaching dirty Webmenu instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WebMenu instance) {
		log.debug("attaching clean Webmenu instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WebMenuDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (WebMenuDAOImpl) ctx.getBean("WebmenuDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(WebMenu object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<WebMenu> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebMenu> findAll(Pager pager, WebMenu object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebMenu> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
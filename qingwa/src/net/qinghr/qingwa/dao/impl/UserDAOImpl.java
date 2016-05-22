package net.qinghr.qingwa.dao.impl;

import java.awt.image.RescaleOp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.UserDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.User;
import net.sf.ehcache.search.expression.Criteria;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.User
 * @author MyEclipse Persistence Tools
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	// property constants
	public static final String ACCOUNT = "account";
	public static final String PASSWORD = "password";
	public static final String USER_NAME = "userName";
	public static final String TYPE = "type";
	public static final String COUNT = "count";
	public static final String LOGIN_IP = "loginIp";
	public static final String CODE = "code";
	public static final String ENABLE = "enable";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getCurrentSession().delete(persistentInstance);

			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getCurrentSession().get(
					"net.qinghr.qingwa.vo.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.User")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<User> findByProperty(String propertyName, Object value) {
		log.debug("正在查找用户实例: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("根据属性名称查找失败", re);
			throw re;
		}
	}
	/**
	 * 
	 * @param account 帐号(邮箱)，查找邮箱是否已经被注册
	 * @return
	 */
	public List<User> findByAccount(Object account) {
		return findByProperty(ACCOUNT, account);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByCount(Object count) {
		return findByProperty(COUNT, count);
	}

	public List findByLoginIp(Object loginIp) {
		return findByProperty(LOGIN_IP, loginIp);
	}

	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User where type=false and enable=true";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (UserDAOImpl) ctx.getBean("UserDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		try {
			System.out.println("dao要删除的id为"+user.getId());
			String queryString = "update User a set a.enable=true where a.id="+user.getId();
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<User> findAll(Pager pager) {
		// TODO Auto-generated method stub
		try {
			String queryString = "from User where type=false and enable=true";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setFirstResult((pager.getPageNo()-1)*10);
			queryObject.setMaxResults(pager.getPageSize());
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	@Override
	public List<User> findAll(Pager pager, User user) {
		// TODO Auto-generated method stub
		try {
			String flag = (String) ServletActionContext.getRequest().getSession().getAttribute("flag");
			Date startDate = (Date) ServletActionContext.getRequest().getSession().getAttribute("startDate");
			Date endDate = (Date) ServletActionContext.getRequest().getSession().getAttribute("endDate");
			System.out.println("dao中startDate的值为"+startDate);
			org.hibernate.Criteria cr= getCurrentSession().createCriteria(User.class);
			cr.add(Restrictions.like("userName",user.getUserName(),MatchMode.ANYWHERE));
			if(flag.equals("all"));
			if(flag.equals("0"))cr.add(Restrictions.like("enable",false));
			if(flag.equals("1"))cr.add(Restrictions.like("enable", true));
			cr.add(Restrictions.like("account", user.getAccount(), MatchMode.ANYWHERE));
			cr.add(Restrictions.like("type",false));
			if(startDate!=null&&endDate!=null)cr.add(Restrictions.between("inputTime",startDate,endDate));
			if(startDate!=null&&endDate==null)cr.add(Restrictions.gt("inputTime", startDate));
			if(startDate==null&&endDate!=null)cr.add(Restrictions.lt("inputTime", endDate));
			pager.setDataCount(cr.list().size());
			ServletActionContext.getRequest().setAttribute("pager", pager);
			cr.setFirstResult((pager.getPageNo()-1)*10);
			cr.setMaxResults(pager.getPageSize());
			return cr.list(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Override
	public User findByAccountAndpassword(String account, String password) {
		try {
			String hql = "from User u where u.enable=true and u.account=:account and u.password=:password";
			Query query = getCurrentSession().createQuery(hql);
			query.setString("account", account);
			query.setString("password", password);
			return (User)query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(String ids) {
		// TODO Auto-generated method stub
		try {
			System.out.println("dao要删除的id为"+ids);
			String queryString = "update User a set a.enable=false where a.id in("+ids+")";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

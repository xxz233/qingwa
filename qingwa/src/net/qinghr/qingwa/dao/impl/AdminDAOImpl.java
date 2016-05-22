package net.qinghr.qingwa.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.AdminDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Admin;
import net.qinghr.qingwa.vo.ManageMenu;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 * A data access object (DAO) providing persistence and search support for Admin
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.Admin
 * @author MyEclipse Persistence Tools
 */
@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO{
	private static final Logger log = LoggerFactory.getLogger(AdminDAOImpl.class);
	// property constants
	public static final String ACCOUNT = "account";
	public static final String PASSWORD = "password";
	public static final String LOGIN_IP = "loginIp";
	public static final String IS_SUPER = "isSuper";
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

	public void save(Admin transientInstance) {
		log.debug("saving Admin instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Admin persistentInstance) {
		log.debug("deleting Admin instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Admin findById(java.lang.Integer id) {
		
		Admin admin = null;
		String hql = "from Admin a left join fetch a.manageMenus  where a.id=:id";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setInteger("id", id);
		admin = (Admin) query.uniqueResult();
		return admin;
	}
	/**
	 * 可以设置不同的条件来筛选结果集合
	 * @param instance
	 * @return
	 */ 
	@SuppressWarnings("unchecked")
	public List<Admin> findByExample(Admin admin,Pager pager) {
		log.debug("正在执行例子查询");
		try {
			List<Admin> admins = getCurrentSession()
					.createCriteria(Admin.class)
//					.addOrder(Order.desc("id"))
					.setFirstResult((pager.getPageNo()-1)*pager.getPageSize())
					.setMaxResults(pager.getPageSize())
					.add(Example.create(admin)).list();
			log.debug("查询成功, 结果数量: "
					+ admins.size());
			return admins;
		} catch (RuntimeException re) {
			log.error("例子查询失败", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Admin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Admin as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAccount(Object account) {
		return findByProperty(ACCOUNT, account);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByLoginIp(Object loginIp) {
		return findByProperty(LOGIN_IP, loginIp);
	}

	public List findByIsSuper(Object isSuper) {
		return findByProperty(IS_SUPER, isSuper);
	}

	public List findByCount(Object count) {
		return findByProperty(COUNT, count);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all Admin instances");
		try {
			String queryString = "from Admin";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Admin merge(Admin detachedInstance) {
		log.debug("merging Admin instance");
		try {
			Admin result = (Admin) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Admin instance) {
		log.debug("attaching dirty Admin instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Admin instance) {
		log.debug("attaching clean Admin instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdminDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (AdminDAOImpl) ctx.getBean("AdminDAO");
	}

	/**
	 * 获得ID，删除单选行
	 * 陈先顺
	 */
	@Override
	public void delete(Integer id) {

		String hql = "update Admin admin set admin.enable=0 where id=:id ";

		Query query = this.getCurrentSession().createQuery(hql);
		System.out.println(id);
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@Override
	public void update(Admin object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> findAll(Pager pager) {
		
		List<Admin> admins = null;
		String hql = "from Admin where enable=true";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setFirstResult((pager.getPageNo()-1)*pager.getPageSize());
		query.setMaxResults(pager.getPageSize());
		admins = query.list();
		return admins;
	}

	@Override
	public List<Admin> findAll(Pager pager, Admin object) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据帐号，密码查询有无此用户
	 * 陈先顺
	 */
	@Override
	public Admin findByAccountAndpassword(String account, String password) {
		
		Admin admin = null;

		String hql = "from Admin where account=:account and password=:password";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setString("account", account);
		query.setString("password", password);
		
		admin = (Admin) query.uniqueResult();
		
		return admin;
	}
	/**
	 * 批量删除(更新)管理员，注意变量名 admin-->admins复数形式
	 */
	@Override
	public void update(String ids) {
		try {
			String Hql = "update Admin a set a.enable=false where a.id in ("+ids+")";
			
			Query query = this.getCurrentSession().createQuery(Hql);
			query.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAll(Admin admin,Boolean flag) {
		try {
			Criteria criteria = getCurrentSession().createCriteria(Admin.class);
			if(flag){
				criteria.add(Example.create(admin).enableLike(MatchMode.ANYWHERE).excludeProperty("enable"));
			}
			else{
				criteria.add(Example.create(admin).enableLike(MatchMode.ANYWHERE));
			}
			return criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAll(Admin admin, Boolean flag, Timestamp startDate,
			Timestamp endDate) {
		
			try {
				Criteria criterid = getCurrentSession().createCriteria(Admin.class);
				if(flag)
				{
					criterid.add(Example.create(admin).enableLike(MatchMode.ANYWHERE).excludeProperty("enable"));
					if(startDate!=null)
						criterid.add(Restrictions.between("inputTime", startDate, endDate));
					else
						criterid.add(Restrictions.lt("inputTime", endDate));
				}
				else
				{
					criterid.add(Example.create(admin).enableLike(MatchMode.ANYWHERE));
					if(startDate!=null)
						criterid.add(Restrictions.between("inputTime", startDate, endDate));
					else
						criterid.add(Restrictions.lt("inputTime", endDate));
				}
				return criterid.list();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
}

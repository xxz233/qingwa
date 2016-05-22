package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.qinghr.qingwa.dao.CompanyInfoDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.CompanyInfo;

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
 * Companyinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see net.qinghr.qingwa.vo.CompanyInfo
 * @author MyEclipse Persistence Tools
 */
@Repository("companyInfoDAO")
public class CompanyInfoDAOImpl implements CompanyInfoDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CompanyInfoDAOImpl.class);
	// property constants
	public static final String FULL_NAME = "fullName";
	public static final String SHORT_NAME = "shortName";
	public static final String PIC = "pic";
	public static final String URL = "url";
	public static final String ADDRESS = "address";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String DIRECTION = "direction";
	public static final String DETAIL = "detail";
	public static final String ENABLE = "enable";
	public static final String IS_VALIDATE = "isValidate";
	public static final String VALIDATE_PIC = "validatePic";
	public static final String VALIDATE_ADMIN = "validateAdmin";
	public static final String VALIDATE_REASON = "validateReason";
	public static final String COMPANY_EMAIL = "companyEmail";
	public static final String DELEGATE = "delegate";
	public static final String PHONE = "phone";
	public static final String QQ = "qq";
	public static final String EMAIL = "email";
	public static final String DOWNLOAD_COUNT = "downloadCount";
	public static final String CREAT_JOB_COUNT = "creatJobCount";
	public static final String VIEW = "view";
	public static final String IS_TOP = "isTop";
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(CompanyInfo transientInstance) {
		log.debug("saving Companyinfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompanyInfo persistentInstance) {
		log.debug("deleting Companyinfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * 关联查询显示公司全部信息
	 * 陈文
	 */
	public CompanyInfo findById(java.lang.Integer id) {
		CompanyInfo companyInfo  = null;
		
		String hql = " from CompanyInfo c "
				+ "  left join fetch c.companyStage "
				+ "  left join fetch c.area "
				+ "  left join fetch c.industry "
				+ "  left join fetch c.companyScale "
				+ " where c.enable=true and c.id=:id";
		
		Query query = this.getCurrentSession().createQuery(hql);	
		query.setInteger("id", id);
		
		companyInfo = (CompanyInfo) query.uniqueResult();
		return companyInfo;

	}

	public List findByExample(CompanyInfo instance) {
		log.debug("finding Companyinfo instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("net.qinghr.qingwa.vo.Companyinfo")
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
		log.debug("finding Companyinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Companyinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFullName(Object fullName) {
		return findByProperty(FULL_NAME, fullName);
	}

	public List findByShortName(Object shortName) {
		return findByProperty(SHORT_NAME, shortName);
	}

	public List findByPic(Object pic) {
		return findByProperty(PIC, pic);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List findByDirection(Object direction) {
		return findByProperty(DIRECTION, direction);
	}

	public List findByDetail(Object detail) {
		return findByProperty(DETAIL, detail);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findByIsValidate(Object isValidate) {
		return findByProperty(IS_VALIDATE, isValidate);
	}

	public List findByValidatePic(Object validatePic) {
		return findByProperty(VALIDATE_PIC, validatePic);
	}

	public List findByValidateAdmin(Object validateAdmin) {
		return findByProperty(VALIDATE_ADMIN, validateAdmin);
	}

	public List findByValidateReason(Object validateReason) {
		return findByProperty(VALIDATE_REASON, validateReason);
	}

	public List findByCompanyEmail(Object companyEmail) {
		return findByProperty(COMPANY_EMAIL, companyEmail);
	}

	public List findByDelegate(Object delegate) {
		return findByProperty(DELEGATE, delegate);
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

	public List findByDownloadCount(Object downloadCount) {
		return findByProperty(DOWNLOAD_COUNT, downloadCount);
	}

	public List findByCreatJobCount(Object creatJobCount) {
		return findByProperty(CREAT_JOB_COUNT, creatJobCount);
	}

	public List findByView(Object view) {
		return findByProperty(VIEW, view);
	}

	public List findByIsTop(Object isTop) {
		return findByProperty(IS_TOP, isTop);
	}


	public List findAll()
	{
		log.debug("finding all CompanyInfo instances");
		try {
			String queryString = "from CompanyInfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyInfo merge(CompanyInfo detachedInstance) {
		log.debug("merging Companyinfo instance");
		try {
			CompanyInfo result = (CompanyInfo) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompanyInfo instance) {
		log.debug("attaching dirty Companyinfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompanyInfo instance) {
		log.debug("attaching clean Companyinfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyInfoDAOImpl) ctx.getBean("CompanyinfoDAO");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 审核通过
	 * 陈文
	 */
	@Override
	public void update(CompanyInfo object) {
		Session session=this.getCurrentSession();
	
		String hql="update  CompanyInfo c  set c.isValidate=true where c.id = ?  ";
		
		Query query=session.createQuery(hql);
		query.setInteger(0, object.getId());
        query.executeUpdate();
	}
	
	/**
	 * 设置分页
	 * 关联查询公司部分信息
	 * 陈文
	 */
	@Override
	public List<CompanyInfo> findAll(Pager pager) {
		// TODO Auto-generated method stub
		List<CompanyInfo> companyInfos = null;
		
		String hql = " from CompanyInfo c "
				+ "  left join fetch c.companyStage "
				+ "  left join fetch c.area "
				+ "  left join fetch c.industry "
				+ "  left join fetch c.companyScale "
				+ " where c.enable=true ";
		
		Query query = this.getCurrentSession().createQuery(hql);	
		
		query.setFirstResult((pager.getPageNo()-1)*pager.getPageSize());
		query.setMaxResults(pager.getPageSize());
		
		companyInfos = query.list();
		
		return companyInfos;
	}

	@Override
	public List<CompanyInfo> findAll(Pager pager, CompanyInfo object) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public long getResultCount() {
		// TODO Auto-generated method stub
		long count;
		String hql = "select count(*) from CompanyInfo where enable=true";
		Query query = this.getCurrentSession().createQuery(hql);
		count = (int)((Long)query.uniqueResult()).longValue();
		
		return count;
	}

	@Override
	public long getResultCount(CompanyInfo object) {
		// TODO Auto-generated method stub
		return 0;
	}
}

package net.qinghr.qingwa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.qinghr.qingwa.dao.CurrentDAO;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Current;
@Repository("currentDAO")
public class CurrentDAOImpl implements CurrentDAO {
	@Resource
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void save(Current object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Current object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Current object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Current findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Current> findAll() {
		try {
			String queryString = "from Current where enable = true order by sort";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<Current> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Current> findAll(Pager pager, Current object) {
		// TODO Auto-generated method stub
		return null;
	}
}

package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.WebMenuDAO;
import net.qinghr.qingwa.service.WebMenuService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.WebMenu;
@Transactional
@Service("webMenuService")
public class WebMenuServiceImpl implements WebMenuService {
	@Resource
	private WebMenuDAO webMenuDAO;

	@Override
	public void save(WebMenu object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(WebMenu object) {
		// TODO Auto-generated method stub

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
	public WebMenu findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebMenu> findAll() {
		// TODO Auto-generated method stub
		return null;
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
	public List<WebMenu> findByTypeAndPosition(Object type, Object position) {
		return webMenuDAO.findByTypeAndPosition(type, position);
	}

	@Override
	public List<WebMenu> findByPosition(Object position) {
		// TODO Auto-generated method stub
		return webMenuDAO.findByPosition(position);
	}

}

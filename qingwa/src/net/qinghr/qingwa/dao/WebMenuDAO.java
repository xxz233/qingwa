package net.qinghr.qingwa.dao;

import java.util.List;

import net.qinghr.qingwa.common.CommonDAO;
import net.qinghr.qingwa.vo.WebMenu;

public interface WebMenuDAO extends CommonDAO<WebMenu> {
	List<WebMenu> findByTypeAndPosition(Object type,Object position);
	List<WebMenu> findByPosition(Object position);
}

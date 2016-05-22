package net.qinghr.qingwa.service;

import java.util.List;

import net.qinghr.qingwa.vo.WebMenu;

public interface WebMenuService extends CommonService<WebMenu> {
	List<WebMenu> findByTypeAndPosition(Object type,Object position);
	List<WebMenu> findByPosition(Object position);
}

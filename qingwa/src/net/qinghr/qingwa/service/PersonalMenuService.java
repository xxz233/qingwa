package net.qinghr.qingwa.service;

import java.util.List;

import net.qinghr.qingwa.vo.PersonalMenu;

public interface PersonalMenuService extends CommonService<PersonalMenu> {
	List<PersonalMenu> findByType(Object type);
}

package net.qinghr.qingwa.dao;

import java.util.List;

import net.qinghr.qingwa.common.CommonDAO;
import net.qinghr.qingwa.vo.PersonalMenu;

public interface PersonalMenuDAO extends CommonDAO<PersonalMenu> {
	List<PersonalMenu> findByType(Object type);
}

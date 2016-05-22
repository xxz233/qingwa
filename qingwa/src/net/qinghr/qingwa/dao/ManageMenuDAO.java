package net.qinghr.qingwa.dao;

import java.util.List;

import net.qinghr.qingwa.common.CommonDAO;
import net.qinghr.qingwa.vo.ManageMenu;

public interface ManageMenuDAO extends CommonDAO<ManageMenu> {
	List<ManageMenu> findByAdminId(Integer id);
}

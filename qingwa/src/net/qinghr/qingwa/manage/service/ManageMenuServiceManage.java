package net.qinghr.qingwa.manage.service;

import java.util.List;

import net.qinghr.qingwa.common.CommonService;
import net.qinghr.qingwa.vo.ManageMenu;

public interface ManageMenuServiceManage extends CommonService<ManageMenu> {
	List<ManageMenu> findByAdminId(Integer id);
}

package net.qinghr.qingwa.dao;

import java.util.List;

import net.qinghr.qingwa.common.CommonDAO;
import net.qinghr.qingwa.vo.Config;

public interface ConfigDAO extends CommonDAO<Config> {
	Config findByConfigKey(Object configKey);
}

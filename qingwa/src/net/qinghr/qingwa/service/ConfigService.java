package net.qinghr.qingwa.service;

import java.util.List;

import net.qinghr.qingwa.vo.Config;

public interface ConfigService extends CommonService<Config> {
	Config findByConfigKey(Object configKey);
}

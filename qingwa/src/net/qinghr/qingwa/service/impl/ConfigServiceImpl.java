package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.ConfigDAO;
import net.qinghr.qingwa.service.ConfigService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Config;
@Transactional
@Service("configService")
public class ConfigServiceImpl implements ConfigService {
	@Resource
	private ConfigDAO configDAO;

	@Override
	public void save(Config object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Config object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Config object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Config findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Config> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Config> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Config> findAll(Pager pager, Config object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Config findByConfigKey(Object configKey) {
		// TODO Auto-generated method stub
		return configDAO.findByConfigKey(configKey);
	}

}

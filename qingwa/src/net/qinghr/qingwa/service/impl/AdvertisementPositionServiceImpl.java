package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.AdvertisementPositionDAO;
import net.qinghr.qingwa.service.AdvertisementPositionService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.AdvertisementPosition;
@Transactional
@Service("advertisementPositionService")
public class AdvertisementPositionServiceImpl implements
		AdvertisementPositionService {
	@Resource
	private AdvertisementPositionDAO advertisementPositionDAO;

	@Override
	public void save(AdvertisementPosition object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(AdvertisementPosition object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AdvertisementPosition object) {
		// TODO Auto-generated method stub

	}

	@Override
	public AdvertisementPosition findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdvertisementPosition> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdvertisementPosition> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdvertisementPosition> findAll(Pager pager,
			AdvertisementPosition object) {
		// TODO Auto-generated method stub
		return null;
	}

}

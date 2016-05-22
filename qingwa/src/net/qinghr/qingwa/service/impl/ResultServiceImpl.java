package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.ResultDAO;
import net.qinghr.qingwa.service.ResultService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.Result;
@Transactional
@Service("resultService")
public class ResultServiceImpl implements ResultService {
	@Resource
	private ResultDAO resultDAO;

	@Override
	public void save(Result object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Result object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Result object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Result findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> findAll(Pager pager, Result object) {
		// TODO Auto-generated method stub
		return null;
	}

}

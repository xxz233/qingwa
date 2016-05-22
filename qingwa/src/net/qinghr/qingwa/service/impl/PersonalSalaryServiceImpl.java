package net.qinghr.qingwa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.qinghr.qingwa.dao.PersonalSalaryDAO;
import net.qinghr.qingwa.service.PersonalSalaryService;
import net.qinghr.qingwa.util.Pager;
import net.qinghr.qingwa.vo.PersonalSalary;
@Transactional
@Service("personalSalaryService")
public class PersonalSalaryServiceImpl implements PersonalSalaryService {
	@Resource
	private PersonalSalaryDAO personalSalaryDAO;

	@Override
	public void save(PersonalSalary object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(PersonalSalary object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(PersonalSalary object) {
		// TODO Auto-generated method stub

	}

	@Override
	public PersonalSalary findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonalSalary> findAll() {
		List<PersonalSalary> personalSalarys = personalSalaryDAO.findAll();
		return personalSalarys;
	}

	@Override
	public List<PersonalSalary> findAll(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonalSalary> findAll(Pager pager, PersonalSalary object) {
		// TODO Auto-generated method stub
		return null;
	}

}

package net.qinghr.qingwa.test;

import java.util.List;

import net.qinghr.qingwa.service.PersonalSalaryService;
import net.qinghr.qingwa.util.SpringUtil;
import net.qinghr.qingwa.vo.PersonalSalary;

import org.junit.Before;
import org.junit.Test;

public class PresonalSalaryTest {
	private PersonalSalaryService p;
	@Before
	public void setUp() throws Exception {
		p = SpringUtil.getBean("personalSalaryService", PersonalSalaryService.class);
	}

	@Test
	public void test() {
		List<PersonalSalary> list = p.findAll();
		for (PersonalSalary personalSalary : list) {
			System.out.println(personalSalary.getTitle());
		}
	}

}

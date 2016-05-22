package net.qinghr.qingwa.test;

import java.util.List;

import net.qinghr.qingwa.service.PersonalExperienceService;
import net.qinghr.qingwa.util.SpringUtil;
import net.qinghr.qingwa.vo.PersonalExperience;

import org.junit.Before;
import org.junit.Test;

public class personalExperienceTest {
	private PersonalExperienceService p;
	@Before
	public void setUp() throws Exception {
		p = SpringUtil.getBean("personalExperienceService", PersonalExperienceService.class);
	}

	@Test
	public void test() {
		List<PersonalExperience> list = p.findAll();
		for (PersonalExperience per : list) {
			System.out.println(per.getTitle());
		}
	}

}

package net.qinghr.qingwa.test;

import java.util.List;

import net.qinghr.qingwa.service.CompanyJobNatureService;
import net.qinghr.qingwa.util.SpringUtil;
import net.qinghr.qingwa.vo.CompanyJobNature;

import org.junit.Before;
import org.junit.Test;

public class CompantJobNatureTest {
	
	private CompanyJobNatureService companyJobNatureService;
	@Before
	public void setUp() throws Exception {
		companyJobNatureService = SpringUtil.getBean("companyJobNatureService", CompanyJobNatureService.class);
	}

	@Test
	public void test() {
		List<CompanyJobNature> list = companyJobNatureService.findAll();
		for (CompanyJobNature companyJobNature : list) {
			System.out.println(companyJobNature.getTitle());
		}
	}

}

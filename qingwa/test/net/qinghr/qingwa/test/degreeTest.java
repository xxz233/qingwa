package net.qinghr.qingwa.test;

import java.util.List;

import net.qinghr.qingwa.service.DegreeService;
import net.qinghr.qingwa.util.SpringUtil;
import net.qinghr.qingwa.vo.Degree;

import org.junit.Before;
import org.junit.Test;

public class degreeTest {
	private DegreeService degreeService;
	@Before
	public void setUp() throws Exception {
		degreeService = new SpringUtil().getBean("degreeService", DegreeService.class);
	}

	@Test
	public void test() {
		List<Degree> degrees = degreeService.findAll();
		for (Degree degree : degrees) {
			System.out.println(degree.getTitle());
		}
	}

}

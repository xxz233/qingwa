package net.qinghr.qingwa.test;

import java.util.List;

import net.qinghr.qingwa.service.CurrentService;
import net.qinghr.qingwa.util.SpringUtil;
import net.qinghr.qingwa.vo.Current;

import org.junit.Before;
import org.junit.Test;

public class CurrentTest {
	private CurrentService currentService;
	@Before
	public void setUp() throws Exception {
		currentService = SpringUtil.getBean("currentService", CurrentService.class);
	}
	@Test
	public void test() {
		List<Current> currents = currentService.findAll();
		for (Current current : currents) {
			System.out.println(current.getTitle());
		}
	}
}

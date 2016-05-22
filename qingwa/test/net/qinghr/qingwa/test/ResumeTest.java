package net.qinghr.qingwa.test;

import java.util.Set;

import net.qinghr.qingwa.service.ResumeService;
import net.qinghr.qingwa.util.SpringUtil;
import net.qinghr.qingwa.vo.Result;
import net.qinghr.qingwa.vo.Resume;

import org.junit.Before;
import org.junit.Test;

public class ResumeTest {
	private ResumeService resumeService;
	@Before
	public void setUp() throws Exception {
		resumeService = SpringUtil.getBean("resumeService", ResumeService.class);
	}

	@Test
	public void test() {
		Resume resume = resumeService.findByUserId(1);
		System.out.println(resume.getTitle());
	}

}

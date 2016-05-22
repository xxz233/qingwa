package net.qinghr.qingwa.service;

import net.qinghr.qingwa.vo.Resume;

public interface ResumeService extends CommonService<Resume> {
	Resume findByUserId(Integer id);
}

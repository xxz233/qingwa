package net.qinghr.qingwa.dao;

import net.qinghr.qingwa.common.CommonDAO;
import net.qinghr.qingwa.vo.Resume;

public interface ResumeDAO extends CommonDAO<Resume> {
	Resume findByUserId(Integer id);
}

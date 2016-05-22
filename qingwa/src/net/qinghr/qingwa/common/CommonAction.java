package net.qinghr.qingwa.common;

import java.io.IOException;

public interface CommonAction {
	String findAll();
	String findById();
	String delete();
	String update();
	String save() throws IOException;
	String batchDelete();
	String findPage();
}

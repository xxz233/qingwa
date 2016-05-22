package net.qinghr.qingwa.util;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {

	public static ApplicationContext getApplicationContext()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		return ac;
	}
	public static <T> T getBean(String beanId,Class<T> c)
	{
		return SpringUtil.getApplicationContext().getBean(beanId,c);
	}
	public static Object getBean(String beanId)
	{
		return SpringUtil.getApplicationContext().getBean(beanId);
	}
}

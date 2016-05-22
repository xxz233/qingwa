package net.qinghr.qingwa.common;

import java.lang.reflect.ParameterizedType;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ServletRequestAware,
ServletContextAware, ServletResponseAware,ModelDriven<T> {

private Class<T> clazz;
@SuppressWarnings("unchecked")
private Class<T> getClazz() {
if(clazz==null)
	clazz = (Class<T>)((ParameterizedType)this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
return clazz;
}
private T model;
public BaseAction()
{
 try {
	model = this.getClazz().newInstance();
} catch (InstantiationException e) {
	
	e.printStackTrace();
} catch (IllegalAccessException e) {
	
	e.printStackTrace();
}
}

@Override
public T getModel() {
return model;
}

@Override
public void setServletRequest(HttpServletRequest request) {
this.request = request;

}
@Override
public void setServletResponse(HttpServletResponse response) {
this.response = response;
}

public HttpServletRequest getRequest() {
return request;
}

public ServletContext getServletContext() {
	return servletContext;
}
public HttpSession getSession()
{
	return this.request.getSession();
}

@Override
public void setServletContext(ServletContext servletContext) {
	this.servletContext = servletContext;
}

public HttpServletResponse getResponse() {
return response;
}
private HttpServletRequest request;
private HttpServletResponse response;
private ServletContext servletContext;



}

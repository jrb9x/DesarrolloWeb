package interceptores;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import controlador.LoginAction;

public class SimpleInterceptor extends AbstractInterceptor {
	
	public String intercept(ActionInvocation invocation) throws Exception {
		LoginAction action = (LoginAction) invocation.getAction();
		return invocation.invoke();
	}
	
}
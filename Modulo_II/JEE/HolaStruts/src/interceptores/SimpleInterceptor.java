package interceptores;

import java.time.LocalDate;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import ejemplo.LoginAction;

public class SimpleInterceptor extends AbstractInterceptor {
	
	public String intercept(ActionInvocation invocation) throws Exception {
		LoginAction action = (LoginAction) invocation.getAction();
		action.setHoy(LocalDate.now());
		return invocation.invoke();
	}
	
}
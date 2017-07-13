/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spec.javaee.ejb;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import ru.spec.javaee.aop.LogTime;
import ru.spec.javaee.aop.LogTimeInterceptor;

import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class NewSessionBean implements EchoService {

	/* (non-Javadoc)
	 * @see ru.spec.javaee.ejb.EchoService#echo(java.lang.String)
	 */
	@Override
//	@Interceptors(LogTimeInterceptor.class)
	@LogTime
	public String echo(String msg) {
		return "re:" + msg;
	}
	
	@Override
	@LogTime(printResult = true)
	public String echo2(String msg) {
		return "re2:" + msg;
	}
}

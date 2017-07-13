/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spec.javaee.ejb;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import ru.spec.javaee.aop.LogTime;
import ru.spec.javaee.aop.LogTimeInterceptor;

import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class NewSessionBean implements EchoService {

	@Inject
	Event<UserDto> bus;
	
	@Override
//	@Interceptors(LogTimeInterceptor.class)
	@LogTime
	public String echo(String msg) {
		UserDto userDto = new UserDto();
		bus.fire(userDto);
		/*processUser(userDto);
		checkuser(userDto);*/
		return "re:" + msg;
	}
	
	@Override
	@LogTime(printResult = true)
	public String echo2(String msg) {
		return "re2:" + msg;
	}
	
	@LogTime
	public void processUser(@Observes UserDto user) {
		
	}
	
	@LogTime
	public void checkuser(@Observes(during = TransactionPhase.BEFORE_COMPLETION) UserDto user) {
		
	}
}

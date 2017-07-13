package ru.spec.javaee.ejb;

import javax.interceptor.Interceptors;

public interface EchoService {

	//	@LogTime
	String echo(String msg);

	String echo2(String msg);

}
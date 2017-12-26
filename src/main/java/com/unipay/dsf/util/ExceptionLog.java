package com.unipay.dsf.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * Filename:ExceptionLog.java
 * Description: 异常捕获日志记录
 * @author litong
 * @date 2017年3月20日 上午10:01:11
 */
@Component
@Aspect
public class ExceptionLog{

	private static Logger expLog = Logger.getLogger("errorException_asyncLog");

	@Pointcut("execution(* com.unipay.dsf.dao..*(..))")
	
	private void pointcut() {
	}

	/**
	 * @param method
	 * @param args
	 * @param target
	 * @param throwable
	 */
	@AfterThrowing(pointcut = "pointcut()", throwing = "e")
	public void afterThrowing(Throwable e) {
		/*
		 * System.out.println("产生异常的方法名称：  " + method.getName()); for(Object
		 * o:args){ System.out.println("方法的参数：   " + o.toString()); }
		 * System.out.println("代理对象：   " + target.getClass().getName());
		 * System.out.println("抛出的异常:    " + throwable.getMessage()+">>>>>>>" +
		 * throwable.getCause());
		 * System.out.println("异常详细信息：　　　"+throwable.fillInStackTrace());
		 */
		System.out.println("异常-------------------------------------------------------");
		expLog.info(e.getMessage() + ">>>>>>>" + e.getCause());
		expLog.info(e.fillInStackTrace());
	}
}

package com.unipay.dsf.util;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

/**
 * Filename:AopAdvice.java
 * Description: 切面
 * @author litong
 * @date 2017年3月17日 上午9:50:36
 */
@Component
@Aspect
public class AopAdvice implements ThrowsAdvice {
	
	private static Logger baseLog =  Logger.getLogger("base_asyncLog");
	private static Logger serLog;
	private static int count = 0;
	//配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	@Pointcut("execution(* com.unipay.dsf.service..check*(..))")
	public void aspect(){	}

	@Before("aspect()")
	public void checkBefore(JoinPoint joinPoint){
		//System.out.println("开始执行aop--参数为：" + Arrays.toString(joinPoint.getArgs())+"---------------"+joinPoint.getSignature().getDeclaringType()+joinPoint.getSignature().getModifiers()+"-------------");
		//根据方法名拼接异步日志
		serLog = Logger.getLogger(StringUtil.captureName(joinPoint.getSignature().getName().replace("check", ""))+"_asyncLog");
		baseLog.info("req|第"+(++count)+"次查询|"+Arrays.toString(joinPoint.getArgs())+"|"+joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		serLog.info("req|"+Arrays.toString(joinPoint.getArgs())+"|"+joinPoint.getSignature().getName() +"." +joinPoint.getSignature().getDeclaringTypeName());
	}
	
	@AfterReturning(pointcut="aspect()",returning="returnValue")
    public void log(JoinPoint joinPoint, Object returnValue) {
		serLog.info("res|"+Arrays.toString(joinPoint.getArgs())+"|"+returnValue);
        //System.out.println("@AfterReturning：返回值为：" + returnValue);
    }

}

package com.voicecall_springboot.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggedCallAspect {

	private Logger LOGGER = Logger.getLogger(getClass().getName());
	// setup pointcut declaration
	@Pointcut("execution(* com.voicecall_springboot.controller.*.*(....)")
	private void forControllerPackage() {
		LOGGER.info("LoggedCallController class is being executed");
	}
	@Pointcut("com.voicecall_springboot.service.*.*(....)")
	private void forServicePackage() {
		LOGGER.info("LoggedCallService class is being executed");
	}
	@Pointcut("com.voicecall_springboot.repository.*.*(....)")
	private void forRepositoryPackage() {
		LOGGER.info("LoggedCallRepository class is being executed");
	}
	@Pointcut("forControllerPackage()||forServicePackage()||forRepositoryPackage()")
	private void forAppFlow() {
		LOGGER.info("============ Executed ============");
	}
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		LOGGER.info(" ======> In @Before: calling method:"+method);
		Object[] args = joinPoint.getArgs();
		for(Object  tempArg: args) {
			LOGGER.info("=========> argument:"+args);
		}
		
	}
	
	public void afterReturning(JoinPoint joinPoint,Object theResult) {
	// display method we are returning from
		String method = joinPoint.getSignature().toLongString();
		LOGGER.info("=====> In AfterReturning: from method:"+method);
		LOGGER.info("====> Result:"+theResult);
	}
	
	
	
}

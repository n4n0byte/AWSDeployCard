package com.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class Tracer
{
    private static Logger logger = LoggerFactory.getLogger(Tracer.class);


    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable
	{
		logger.info("------------------> Entering...." + pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName() + "()");
		Object retVal = pjp.proceed();
		logger.info("------------------>   Leaving...." + pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName() + "()");
		return retVal;
	}
}

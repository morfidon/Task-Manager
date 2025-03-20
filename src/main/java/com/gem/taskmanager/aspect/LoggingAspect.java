package com.gem.taskmanager.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect
{
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    //pointcut
    @Before("execution(* com.gem.taskmanager.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint)
    {
        logger.info("executing method: {}", joinPoint.getSignature().getName());
    }
    // calculus

    @AfterReturning(pointcut = "execution(* com.gem.taskmanager.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("method executed: {}, returned: {}", joinPoint.getSignature().getName(), result);
    }


}

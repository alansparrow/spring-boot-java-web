package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
  private Logger logger = Logger.getLogger(getClass().getName());

  @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
  private void forControllerPackage() {}

  @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
  private void forServicePackage() {}

  @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
  private void forDaoPackage() {}

  @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
  private void forAppFlow() {}

  @Before("forAppFlow()")
  public void before(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().toString();
    logger.info("in @Before: calling method: " + method);

    Object[] args = joinPoint.getArgs();

    for (Object arg : args) {
      logger.info("arg: " + arg);
    }
  }
}

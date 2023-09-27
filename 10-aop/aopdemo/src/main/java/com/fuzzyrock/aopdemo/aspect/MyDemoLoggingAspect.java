package com.fuzzyrock.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

  @Pointcut("execution(* com.fuzzyrock.aopdemo.dao.*.*(..))")
  private void forDaoPackage() {}

  // @Before("execution(public void add*())")
  // Match any class in the package, any method, any params
  @Before("forDaoPackage()")
  public void beforeAddAccountAdvice() {
    System.out.println("\n===> Executing @Before advice on addAccount()");
  }
}

package com.fuzzyrock.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
  // @Before("execution(public void add*())")
  // Match any class in the package, any method, any params
  @Before("execution(* com.fuzzyrock.aopdemo.dao.*.*(..))")
  public void beforeAddAccountAdvice() {
    System.out.println("\n===> Executing @Before advice on addAccount()");
  }
}

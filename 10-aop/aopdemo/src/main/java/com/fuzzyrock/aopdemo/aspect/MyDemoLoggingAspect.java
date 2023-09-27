package com.fuzzyrock.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

  // @Before("execution(public void add*())")
  // Match any class in the package, any method, any params
  @Before("com.fuzzyrock.aopdemo.aspect.CommonAspect.forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice() {
    System.out.println("===> Executing @Before advice on method");
  }
}

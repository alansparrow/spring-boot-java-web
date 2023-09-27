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

  @Pointcut("execution(* com.fuzzyrock.aopdemo.dao.*.get*(..))")
  private void getter() {}

  @Pointcut("execution(* com.fuzzyrock.aopdemo.dao.*.set*(..))")
  private void setter() {}

  @Pointcut("forDaoPackage() && !(getter() || setter())")
  private void forDaoPackageNoGetterSetter() {}

  // @Before("execution(public void add*())")
  // Match any class in the package, any method, any params
  @Before("forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice() {
    System.out.println("===> Executing @Before advice on method");
  }

  @Before("forDaoPackageNoGetterSetter()")
  public void performApiAnalytics() {
    System.out.println("===> Performing API analytics");
  }
}

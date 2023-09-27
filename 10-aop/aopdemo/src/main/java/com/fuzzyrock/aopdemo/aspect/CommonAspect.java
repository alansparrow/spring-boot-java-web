package com.fuzzyrock.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonAspect {
  @Pointcut("execution(* com.fuzzyrock.aopdemo.dao.*.*(..))")
  public void forDaoPackage() {}

  @Pointcut("execution(* com.fuzzyrock.aopdemo.dao.*.get*(..))")
  public void getter() {}

  @Pointcut("execution(* com.fuzzyrock.aopdemo.dao.*.set*(..))")
  public void setter() {}

  @Pointcut("forDaoPackage() && !(getter() || setter())")
  public void forDaoPackageNoGetterSetter() {}
}

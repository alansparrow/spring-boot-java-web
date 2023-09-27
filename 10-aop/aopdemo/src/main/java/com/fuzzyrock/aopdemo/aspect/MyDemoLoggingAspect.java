package com.fuzzyrock.aopdemo.aspect;

import com.fuzzyrock.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

  // @Before("execution(public void add*())")
  // Match any class in the package, any method, any params
  @Before("com.fuzzyrock.aopdemo.aspect.CommonAspect.forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice(JoinPoint joinPoint) {
    System.out.println("===> Executing @Before advice on method");

    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    System.out.println("Method: " + methodSignature);

    Object[] args = joinPoint.getArgs();

    for (Object arg : args) {
      System.out.println(arg);
      if (arg instanceof Account) {
        Account account = (Account) arg;
        System.out.println("Account: " + account);
      }
    }
  }
}

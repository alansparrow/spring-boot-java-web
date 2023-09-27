package com.fuzzyrock.aopdemo.aspect;

import com.fuzzyrock.aopdemo.Account;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

  @AfterReturning(
      pointcut = "execution(* com.fuzzyrock.aopdemo.dao.AccountDAO.findAccounts(..))",
      returning = "result")
  public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
    String method = joinPoint.getSignature().toString();
    System.out.println("Executing @AfterReturning on method: " + method);

    System.out.println("result is: " + result);
  }

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
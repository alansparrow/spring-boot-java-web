package com.fuzzyrock.aopdemo.aspect;

import com.fuzzyrock.aopdemo.Account;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

  @Around("execution(* com.fuzzyrock.aopdemo.service.*.getFortune(..))")
  public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    String method = proceedingJoinPoint.getSignature().toString();
    System.out.println("Executing @Around on method: " + method);

    long begin = System.currentTimeMillis();

    Object result = null;
    try {
      result = proceedingJoinPoint.proceed();
    } catch (Exception e) {
      System.out.println("Log exception: " + e);

      throw e;
    }

    long end = System.currentTimeMillis();

    long duration = end - begin;
    System.out.println("Duration: " + duration / 1000.0 + " seconds");

    return result;
  }

  @After("execution(* com.fuzzyrock.aopdemo.dao.AccountDAO.findAccounts(..))")
  public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().toString();
    System.out.println("Executing @After (finally) on method: " + method);
  }

  @AfterThrowing(
      pointcut = "execution(* com.fuzzyrock.aopdemo.dao.AccountDAO.findAccounts(..))",
      throwing = "ex")
  public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, Throwable ex) {
    String method = joinPoint.getSignature().toString();
    System.out.println("Executing @AfterThrowing on method: " + method);
    System.out.println("Exception is: " + ex);
  }

  @AfterReturning(
      pointcut = "execution(* com.fuzzyrock.aopdemo.dao.AccountDAO.findAccounts(..))",
      returning = "result")
  public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
    String method = joinPoint.getSignature().toString();
    System.out.println("Executing @AfterReturning on method: " + method);
    System.out.println("result is: " + result);

    convertNamesToUpperCase(result);
  }

  private void convertNamesToUpperCase(List<Account> result) {
    for (Account account : result) {
      account.setName(account.getName().toUpperCase());
    }
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

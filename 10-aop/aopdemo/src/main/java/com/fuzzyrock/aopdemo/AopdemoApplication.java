package com.fuzzyrock.aopdemo;

import com.fuzzyrock.aopdemo.dao.AccountDAO;
import com.fuzzyrock.aopdemo.dao.MembershipDAO;
import com.fuzzyrock.aopdemo.service.TrafficFortuneService;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(AopdemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(
      AccountDAO accountDAO,
      MembershipDAO membershipDAO,
      TrafficFortuneService trafficFortuneService) {
    return runner -> {
      //      demoTheBeforeAdvice(accountDAO, membershipDAO);
      //      demoTheAfterReturningAdvice(accountDAO);
      //      demoTheAfterThrowingAdvice(accountDAO);
      //      demoTheAfterAdvice(accountDAO);
      demoTheAroundAdvice(trafficFortuneService);
    };
  }

  private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
    System.out.println("Main program: calling getFortune()");

    String data = trafficFortuneService.getFortune();

    System.out.println("Main program: My fortune is: " + data);
    System.out.println("Main program: Done!");
  }

  private void demoTheAfterAdvice(AccountDAO accountDAO) {
    List<Account> accounts = null;

    try {
      boolean tripWire = false;
      accounts = accountDAO.findAccounts(tripWire);
    } catch (Exception e) {
      System.out.println("Main program: " + e);
    }

    System.out.println("Main program: ");
    System.out.println(accounts);
    System.out.println("\n");
  }

  private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
    List<Account> accounts = null;

    try {
      boolean tripWire = true;
      accounts = accountDAO.findAccounts(tripWire);
    } catch (Exception e) {
      System.out.println("Main program: " + e);
    }

    System.out.println("Main program: ");
    System.out.println(accounts);
    System.out.println("\n");
  }

  private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
    List<Account> accounts = accountDAO.findAccounts();

    System.out.println("Main program: ");
    System.out.println(accounts);
    System.out.println("\n");
  }

  private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
    accountDAO.addAccount(new Account("Fuzzy", "L9"), true);
    accountDAO.charge();
    accountDAO.setName("foobar");
    accountDAO.setServiceCode("diamond");
    accountDAO.getName();
    accountDAO.getServiceCode();

    membershipDAO.addMember();
    membershipDAO.doWork();
  }
}

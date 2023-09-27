package com.fuzzyrock.aopdemo;

import com.fuzzyrock.aopdemo.dao.AccountDAO;
import com.fuzzyrock.aopdemo.dao.MembershipDAO;
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
  public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
    return runner -> {
      demoTheBeforeAdvice(accountDAO, membershipDAO);
    };
  }

  private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
    accountDAO.addAccount(new Account("Fuzzy", "L9"), true);
    accountDAO.charge();

    membershipDAO.addMember();
    membershipDAO.doWork();
  }
}

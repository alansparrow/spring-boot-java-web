package com.fuzzyrock.aopdemo.dao;

import com.fuzzyrock.aopdemo.Account;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
  private String name;
  private String serviceCode;

  @Override
  public boolean addAccount(Account account, boolean isAdmin) {
    System.out.println(getClass() + ": adding an account " + account + " isAdmin: " + isAdmin);
    return true;
  }

  @Override
  public void charge() {
    System.out.println(getClass() + ": charge money");
  }

  @Override
  public String getName() {
    System.out.println(getClass() + ": getName");
    return name;
  }

  @Override
  public void setName(String name) {
    System.out.println(getClass() + ": setName");
    this.name = name;
  }

  @Override
  public String getServiceCode() {
    System.out.println(getClass() + ": getServiceCode");
    return serviceCode;
  }

  @Override
  public void setServiceCode(String serviceCode) {
    System.out.println(getClass() + ": setServiceCode");
    this.serviceCode = serviceCode;
  }

  @Override
  public List<Account> findAccounts() {
    List<Account> accounts = new ArrayList<>();

    Account account1 = new Account("Moon", "L1");
    Account account2 = new Account("Butter", "L2");
    accounts.add(account1);
    accounts.add(account2);

    return accounts;
  }
}

package com.fuzzyrock.aopdemo.dao;

import com.fuzzyrock.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
  @Override
  public boolean addAccount(Account account, boolean isAdmin) {
    System.out.println(getClass() + ": adding an account " + account + " isAdmin: " + isAdmin);
    return true;
  }

  @Override
  public void charge() {
    System.out.println(getClass() + ": charge money");
  }
}

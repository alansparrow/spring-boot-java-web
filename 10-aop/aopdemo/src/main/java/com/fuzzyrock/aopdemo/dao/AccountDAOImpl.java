package com.fuzzyrock.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
  @Override
  public boolean addAccount() {
    System.out.println(getClass() + ": adding an account");
    return true;
  }
}

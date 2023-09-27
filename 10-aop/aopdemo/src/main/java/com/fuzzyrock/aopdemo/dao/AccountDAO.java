package com.fuzzyrock.aopdemo.dao;

import com.fuzzyrock.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
  boolean addAccount(Account account, boolean isAdmin);

  void charge();

  String getName();

  void setName(String name);

  String getServiceCode();

  void setServiceCode(String serviceCode);

  List<Account> findAccounts();
}

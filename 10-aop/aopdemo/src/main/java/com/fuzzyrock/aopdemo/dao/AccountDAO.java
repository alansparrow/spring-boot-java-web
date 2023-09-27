package com.fuzzyrock.aopdemo.dao;

import com.fuzzyrock.aopdemo.Account;

public interface AccountDAO {
    boolean addAccount(Account account, boolean isAdmin);
}

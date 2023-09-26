package com.fuzzyrock.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
  @Override
  public void addMember() {
    System.out.println(getClass() + ": adding a member");
  }
}

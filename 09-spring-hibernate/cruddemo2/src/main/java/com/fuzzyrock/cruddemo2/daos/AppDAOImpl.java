package com.fuzzyrock.cruddemo2.daos;

import com.fuzzyrock.cruddemo2.entities.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

  private EntityManager entityManager;

  @Autowired
  public AppDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void save(Instructor instructor) {
    entityManager.persist(instructor);
  }
}

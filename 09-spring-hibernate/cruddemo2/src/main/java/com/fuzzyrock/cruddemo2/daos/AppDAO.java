package com.fuzzyrock.cruddemo2.daos;

import com.fuzzyrock.cruddemo2.entities.Instructor;

public interface AppDAO {
  void save(Instructor instructor);

  Instructor findInstructorById(int id);

  void deleteInstructorById(int id);
}

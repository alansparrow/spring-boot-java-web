package com.fuzzyrock.cruddemo2.daos;

import com.fuzzyrock.cruddemo2.entities.Course;
import com.fuzzyrock.cruddemo2.entities.Instructor;
import com.fuzzyrock.cruddemo2.entities.InstructorDetail;

import java.util.List;

public interface AppDAO {
  void save(Instructor instructor);

  Instructor findInstructorById(int id);

  void deleteInstructorById(int id);

  InstructorDetail findInstructorDetailById(int id);

  void deleteInstructorDetailById(int id);

  List<Course> findCoursesByInstructorId(int id);

  Instructor findInstructorByIdJoinFetch(int id);

  void update(Instructor instructor);

  void update(Course course);

  Course findCourseById(int id);

  void deleteCourseById(int id);

  void save(Course course);

  Course findCourseWithReviewsByCourseId(int id);

}

package com.fuzzyrock.cruddemo2.daos;

import com.fuzzyrock.cruddemo2.entities.Course;
import com.fuzzyrock.cruddemo2.entities.Instructor;
import com.fuzzyrock.cruddemo2.entities.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
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

  @Override
  public Instructor findInstructorById(int id) {
    return entityManager.find(Instructor.class, id);
  }

  @Override
  @Transactional
  public void deleteInstructorById(int id) {
    Instructor instructor = entityManager.find(Instructor.class, id);

    entityManager.remove(instructor);
  }

  @Override
  public InstructorDetail findInstructorDetailById(int id) {
    return entityManager.find(InstructorDetail.class, id);
  }

  @Override
  @Transactional
  public void deleteInstructorDetailById(int id) {
    InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

    instructorDetail.getInstructor().setInstructorDetail(null);

    entityManager.remove(instructorDetail);
  }

  @Override
  public List<Course> findCoursesByInstructorId(int id) {
    TypedQuery<Course> query =
        entityManager.createQuery("from Course where instructor.id = :data", Course.class);

    query.setParameter("data", id);

    List<Course> courseList = query.getResultList();

    return courseList;
  }
}

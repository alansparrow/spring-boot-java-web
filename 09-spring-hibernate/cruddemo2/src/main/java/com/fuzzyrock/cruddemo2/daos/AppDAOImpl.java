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

    for (Course course : instructor.getCourseList()) {
      course.setInstructor(null);
    }

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

  @Override
  public Instructor findInstructorByIdJoinFetch(int id) {
    // Even with Instructor @OneToMany - FetchType.LAZY
    // the code will still retrieve Instructor and Courses
    // The JOIN FETCH is similar to EAGER loading.
    TypedQuery<Instructor> query =
        entityManager.createQuery(
            "select i from Instructor i "
                + "JOIN FETCH i.courseList "
                + "JOIN FETCH i.instructorDetail "
                + "where i.id = :data",
            Instructor.class);

    query.setParameter("data", id);

    return query.getSingleResult();
  }

  @Override
  @Transactional
  public void update(Instructor instructor) {
    entityManager.merge(instructor);
  }

  @Override
  @Transactional
  public void update(Course course) {
    entityManager.merge(course);
  }

  @Override
  public Course findCourseById(int id) {
    return entityManager.find(Course.class, id);
  }

  @Override
  @Transactional // modify the DB
  public void deleteCourseById(int id) {
    Course course = entityManager.find(Course.class, id);

    entityManager.remove(course);
  }

  @Override
  @Transactional
  public void save(Course course) {
    entityManager.persist(course);
  }

  @Override
  public Course findCourseWithReviewsByCourseId(int id) {
    TypedQuery<Course> query =
        entityManager.createQuery(
            "select c from Course c " + "JOIN FETCH c.reviews " + "where c.id = :data",
            Course.class);
    query.setParameter("data", id);

    Course course = query.getSingleResult();

    return course;
  }
}

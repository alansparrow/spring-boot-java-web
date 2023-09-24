package com.fuzzyrock.cruddemo2;

import com.fuzzyrock.cruddemo2.daos.AppDAO;
import com.fuzzyrock.cruddemo2.entities.*;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cruddemo2Application {

  public static void main(String[] args) {
    SpringApplication.run(Cruddemo2Application.class, args);
  }

  @Bean
  // With @Bean, the deps will be injected automatically, no need for @Autowired
  public CommandLineRunner commandLineRunner(AppDAO appDAO) {
    return runner -> {
      //            createInstructor(appDAO);
      //      findInstructor(appDAO);
      //            deleteInstructor(appDAO);
      //      findInstructorDetail(appDAO);
      //      deleteInstructorDetail(appDAO);
      //      createInstructorWithCourses(appDAO);
      //      findInstructorWithCourses(appDAO);
      //      findCoursesForInstructor(appDAO);
      //      findInstructorWithCoursesJoinFetch(appDAO);
      //      updateInstructor(appDAO);
      //      updateCourse(appDAO);
      //      deleteCourse(appDAO);
      //      createCourseAndReviews(appDAO);
      //      retrieveCourseWithReviews(appDAO);
      //      deleteCourseWithReviews(appDAO);
      //      createCourseAndStudents(appDAO);
      //      findCourseWithStudents(appDAO);
      findStudentWithCourses(appDAO);
    };
  }

  private void findStudentWithCourses(AppDAO appDAO) {
    int id = 1;
    Student student = appDAO.findStudentWithCoursesByStudentId(id);

    System.out.println("Loaded student: " + student);
    System.out.println("Courses: " + student.getCourses());

    System.out.println("Done!");
  }

  private void findCourseWithStudents(AppDAO appDAO) {
    int id = 10;
    Course course = appDAO.findCourseWithStudentsByCourseId(id);

    System.out.println("Loaded course: " + course);
    System.out.println("Students: " + course.getStudents());

    System.out.println("Done!");
  }

  private void createCourseAndStudents(AppDAO appDAO) {
    Course course = new Course("Maths");

    Student student1 = new Student("Moon", "Sparrow", "moon@gmail.com");
    Student student2 = new Student("Butter", "Eagle", "butter@gmail.com");

    course.addStudent(student1);
    course.addStudent(student2);

    System.out.println("Saving the course: " + course);
    System.out.println("Associated students: " + course.getStudents());

    appDAO.save(course);

    System.out.println("Done!");
  }

  private void deleteCourseWithReviews(AppDAO appDAO) {
    int id = 10;

    System.out.println("Deleting course id: " + id);

    // This will also delete associated reviews thanks to CascadeType.ALL
    appDAO.deleteCourseById(id);

    System.out.println("Done!");
  }

  private void retrieveCourseWithReviews(AppDAO appDAO) {
    int id = 10;
    Course course = appDAO.findCourseWithReviewsByCourseId(id);

    System.out.println(course);

    System.out.println(course.getReviews());

    System.out.println("Done!");
  }

  private void createCourseAndReviews(AppDAO appDAO) {
    Course course = new Course("Batman - The Dark Knight");

    course.addReview(new Review("Great course!"));
    course.addReview(new Review("Epic!"));
    course.addReview(new Review("It's just.. so so :<"));

    System.out.println("Saving the course..");
    System.out.println(course);
    System.out.println(course.getReviews());

    appDAO.save(course);

    System.out.println("Done!");
  }

  private void deleteCourse(AppDAO appDAO) {
    int id = 10;

    System.out.println("Deleting course with id: " + id);

    appDAO.deleteCourseById(id);

    System.out.println("Done!");
  }

  private void updateCourse(AppDAO appDAO) {
    int id = 10;

    System.out.println("Finding course with id: " + id);
    Course course = appDAO.findCourseById(id);

    System.out.println("Updating course with id: " + id);
    course.setTitle("Cat Understanding");

    appDAO.update(course);

    System.out.println("Done!");
  }

  private void updateInstructor(AppDAO appDAO) {
    int id = 1;

    System.out.println("Finding instructor with id: " + id);
    Instructor instructor = appDAO.findInstructorById(id);

    System.out.println("Updating instructor with id: " + id);
    instructor.setLastName("TESTER");

    appDAO.update(instructor);

    System.out.println("Done!");
  }

  private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
    int id = 1;

    System.out.println("Finding instructor with id: " + id);

    Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

    System.out.println("Instructor: " + instructor);
    System.out.println("Associated courses: " + instructor.getCourseList());

    System.out.println("Done!");
  }

  private void findCoursesForInstructor(AppDAO appDAO) {
    int id = 1;

    System.out.println("Finding instructor with id: " + id);
    Instructor instructor = appDAO.findInstructorById(id);
    System.out.println("Instructor: " + instructor);

    System.out.println("Finding courses for instructor with id: " + id);
    List<Course> courseList = appDAO.findCoursesByInstructorId(id);
    System.out.println("Associated courses: " + courseList);

    System.out.println("Done!");
  }

  private void findInstructorWithCourses(AppDAO appDAO) {
    int id = 1;

    System.out.println("Finding instructor with id: " + id);

    Instructor instructor = appDAO.findInstructorById(id);

    System.out.println("Instructor: " + instructor);
    System.out.println("Associated courses: " + instructor.getCourseList());

    System.out.println("Done!");
  }

  private void createInstructorWithCourses(AppDAO appDAO) {
    Instructor instructor = new Instructor("Susan", "Rock", "susan@gmail.com");
    InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com", "Mafia");

    instructor.setInstructorDetail(instructorDetail);

    Course course1 = new Course("Maths");
    Course course2 = new Course("Chemistry");
    instructor.add(course1);
    instructor.add(course2);

    System.out.println("Saving instructor: " + instructor);
    System.out.println("Courses: " + instructor.getCourseList());
    appDAO.save(instructor);
    System.out.println("Done!");
  }

  private void deleteInstructorDetail(AppDAO appDAO) {
    int id = 4;
    System.out.println("Deleting instructor detail with id: " + id);

    appDAO.deleteInstructorDetailById(id);

    System.out.println("Done!");
  }

  private void findInstructorDetail(AppDAO appDAO) {
    int id = 3;
    System.out.println("Finding instructor detail with id: " + id);

    InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

    System.out.println("InstructorDetail: " + instructorDetail);
    System.out.println("Instructor: " + instructorDetail.getInstructor());
  }

  private void deleteInstructor(AppDAO appDAO) {
    int id = 1;
    System.out.println("Deleting instructor with id " + id);
    appDAO.deleteInstructorById(id);

    System.out.println("Done!");
  }

  private void findInstructor(AppDAO appDAO) {
    int id = 1;
    System.out.println("Find instructor with id: " + id);

    Instructor instructor = appDAO.findInstructorById(id);

    System.out.println("Found instructor: " + instructor);
    System.out.println("Associated details: " + instructor.getInstructorDetail());
  }

  private void createInstructor(AppDAO appDAO) {
    Instructor instructor = new Instructor("Fuzzy", "Rock", "fuzzyrock@gmail.com");
    InstructorDetail instructorDetail = new InstructorDetail("http://google.com", "AoE 2");

    instructor.setInstructorDetail(instructorDetail);

    System.out.println("Saving instructor: " + instructor);

    // This will also save the details object because of CascadeType.ALL in
    // {@link Instructor#instructorDetail}
    appDAO.save(instructor);

    System.out.println("Done!");
  }
}

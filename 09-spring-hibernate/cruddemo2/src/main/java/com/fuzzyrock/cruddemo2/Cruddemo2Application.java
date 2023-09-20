package com.fuzzyrock.cruddemo2;

import com.fuzzyrock.cruddemo2.daos.AppDAO;
import com.fuzzyrock.cruddemo2.entities.Instructor;
import com.fuzzyrock.cruddemo2.entities.InstructorDetail;
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
      //      createInstructor(appDAO);
      //      findInstructor(appDAO);
      //      deleteInstructor(appDAO);
      //      findInstructorDetail(appDAO);
      deleteInstructorDetail(appDAO);
    };
  }

  private void deleteInstructorDetail(AppDAO appDAO) {
    int id = 3;
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
    int id = 2;
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

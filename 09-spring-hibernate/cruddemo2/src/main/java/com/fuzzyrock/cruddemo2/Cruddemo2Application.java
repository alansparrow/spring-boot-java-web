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
    return runner -> createInstructor(appDAO);
  }

  private void createInstructor(AppDAO appDAO) {
    Instructor instructor = new Instructor("Fuzzy", "Rock", "fuzzyrock@gmail.com");
    InstructorDetail instructorDetail = new InstructorDetail("http://google.com", "AoE 2");

    instructor.setInstructorDetail(instructorDetail);

    System.out.println("Saving instructor: " + instructor);

    // This will also save the details object because of CascadeType.ALL in
    // {@link Instructor#instructorDetail}
    appDAO.save(instructor);

    System.out.println("Saved!");
  }
}

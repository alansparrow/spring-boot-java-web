package com.fuzzyrock.cruddemo;

import com.fuzzyrock.cruddemo.dao.StudentDAO;
import com.fuzzyrock.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    // Executed after the Spring Beans have been loaded
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        // Create the student object
        System.out.println("Creating a new student object...");
        Student student = new Student("Alan", "Sparrow", "alan@gmail.com");

        // Save the student object
        System.out.println("Saving new student...");
        studentDAO.save(student);

        // Display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());
    }

}

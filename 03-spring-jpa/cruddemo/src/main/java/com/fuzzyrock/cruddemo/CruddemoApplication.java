package com.fuzzyrock.cruddemo;

import com.fuzzyrock.cruddemo.dao.StudentDAO;
import com.fuzzyrock.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    // Executed after the Spring Beans have been loaded
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
            updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        Integer studentId = createStudent(studentDAO);

        Student student = studentDAO.findById(studentId);

        student.setFirstName("Moonie");
        student.setLastName("Luna");

        studentDAO.update(student);

        System.out.println("Updated student: " + student);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Lovegood");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        Integer studentId = createStudent(studentDAO);

        Student student = studentDAO.findById(studentId);

        System.out.println("Found the student: " + student);
    }

    private void createStudents(StudentDAO studentDAO) {
        for (int i = 0; i < 3; i++) {
            // Create the student object
            System.out.println("Creating a new student object...");
            Student student = new Student("Luna" + i, "Lovegood", "alan" + i + "@gmail.com");

            // Save the student object
            System.out.println("Saving new student...");
            studentDAO.save(student);

            // Display id of the saved student
            System.out.println("Saved student. Generated id: " + student.getId());
        }
    }

    private Integer createStudent(StudentDAO studentDAO) {
        // Create the student object
        System.out.println("Creating a new student object...");
        Student student = new Student("Alan", "Sparrow", "alan@gmail.com");

        // Save the student object
        System.out.println("Saving new student...");
        studentDAO.save(student);

        // Display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());

        return student.getId();
    }

}

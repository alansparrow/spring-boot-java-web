package com.fuzzyrock.cruddemo2.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  // instructor_detail_id defined in instructor table
  // In DB, foreign key is configured to reference id field in instructor_detail table
  //  `instructor_detail_id` int DEFAULT NULL,
  //  PRIMARY KEY (`id`),
  //  KEY `FK_DETAIL_idx` (`instructor_detail_id`),
  //  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail`
  // (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "instructor_detail_id")
  private InstructorDetail instructorDetail;

  @OneToMany(
      mappedBy = "instructor",
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
  private List<Course> courseList;

  public Instructor() {}

  public Instructor(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public InstructorDetail getInstructorDetail() {
    return instructorDetail;
  }

  public void setInstructorDetail(InstructorDetail instructorDetail) {
    this.instructorDetail = instructorDetail;
  }

  public List<Course> getCourseList() {
    return courseList;
  }

  public void setCourseList(List<Course> courseList) {
    this.courseList = courseList;
  }

  // Convenient method for bi-directional relationship
  public void add(Course course) {
    if (courseList == null) {
      courseList = new ArrayList<>();
    }

    courseList.add(course);

    course.setInstructor(this);
  }

  @Override
  public String toString() {
    return "Instructor{"
        + "id="
        + id
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", email='"
        + email
        + '\''
        + ", instructorDetail="
        + instructorDetail
        + ", courseList="
        + courseList
        + '}';
  }
}

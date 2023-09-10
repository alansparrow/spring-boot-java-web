package com.fuzzyrock.spring.mvc.validationdemo;

import com.fuzzyrock.spring.mvc.validationdemo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
  private String firstName;

  @NotNull(message = "is required")
  @Size(min = 1, message = "is required")
  private String lastName;

  @NotNull(message = "is required")
  @Min(value = 1, message = "Min value is 1")
  @Max(value = 10, message = "Max value is 10")
  private Integer freePasses;

  @CourseCode(value = "ROCK", message = "must start with ROCK")
  private String courseCode;

  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  private String postalCode;

  public Integer getFreePasses() {
    return freePasses;
  }

  public void setFreePasses(Integer freePasses) {
    this.freePasses = freePasses;
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
}

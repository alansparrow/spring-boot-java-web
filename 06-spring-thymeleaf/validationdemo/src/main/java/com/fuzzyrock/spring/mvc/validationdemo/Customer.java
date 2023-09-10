package com.fuzzyrock.spring.mvc.validationdemo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
  private String firstName;

  @NotNull(message = "is required")
  @Size(min = 1, message = "is required")
  private String lastName;

  @Min(value = 1, message = "Min value is 1")
  @Max(value = 10, message = "Max value is 10")
  private int freePasses;

  public int getFreePasses() {
    return freePasses;
  }

  public void setFreePasses(int freePasses) {
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

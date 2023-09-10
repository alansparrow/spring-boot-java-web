package com.fuzzyrock.spring.mvc.validationdemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

  private String coursePrefix;

  @Override
  public void initialize(CourseCode constraintAnnotation) {
    coursePrefix = constraintAnnotation.value();
  }

  // Spring MVC will call this
  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
      return s != null && s.startsWith(coursePrefix);
  }
}

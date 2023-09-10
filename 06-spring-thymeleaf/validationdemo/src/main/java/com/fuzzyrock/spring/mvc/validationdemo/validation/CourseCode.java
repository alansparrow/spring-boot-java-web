package com.fuzzyrock.spring.mvc.validationdemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    String value() default "FUZZY";
    String message() default  "must start with FUZZY";

    // Can group related constraints ?
    Class<?>[] groups() default {};

    // Provide custom details about validation failure (severity level, error code, etc)
    Class<? extends Payload>[] payload() default {};
}

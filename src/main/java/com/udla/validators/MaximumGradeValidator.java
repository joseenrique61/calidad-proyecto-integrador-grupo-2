package com.udla.validators;

import com.udla.model.Student;

/**
 * Validates that a student's grade does not exceed a maximum threshold.
 *
 * <p>SRP: This class has a single responsibility — enforcing a maximum
 * grade constraint.
 *
 * <p>OCP: Implements StudentValidator so it can be plugged into
 * StudentManager without modifying the manager's source code.
 */
public class MaximumGradeValidator implements StudentValidator {

  // Upper bound for acceptable grades
  private final double maximumGrade;

  /**
   * Creates a validator with the specified maximum grade.
   *
   * @param maximumGrade the maximum acceptable grade (inclusive)
   */
  public MaximumGradeValidator(double maximumGrade) {
    this.maximumGrade = maximumGrade;
  }

  /**
   * Validates that the student's grade is at or below the maximum.
   *
   * @param student the student to validate
   * @throws IllegalArgumentException if the grade exceeds the maximum
   */
  @Override
  public void validate(Student student) {
    if (student.getGrade() > maximumGrade) {
      throw new IllegalArgumentException(
          "Grade " + student.getGrade()
              + " exceeds the maximum allowed: " + maximumGrade
      );
    }
  }
}

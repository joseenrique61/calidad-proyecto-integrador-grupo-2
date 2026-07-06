package com.udla.validators;

import com.udla.model.Student;

/**
 * Validates that a student's grade meets a minimum threshold.
 *
 * <p>SRP: This class has a single responsibility — enforcing a minimum
 * grade constraint.
 *
 * <p>OCP: Implements StudentValidator so it can be plugged into
 * StudentManager without modifying the manager's source code.
 */
public class MinimumGradeValidator implements StudentValidator {

  // Lower bound for acceptable grades
  private final double minimumGrade;

  /**
   * Creates a validator with the specified minimum grade.
   *
   * @param minimumGrade the minimum acceptable grade (inclusive)
   */
  public MinimumGradeValidator(double minimumGrade) {
    this.minimumGrade = minimumGrade;
  }

  /**
   * Validates that the student's grade is at or above the minimum.
   *
   * @param student the student to validate
   * @throws IllegalArgumentException if the grade is below the minimum
   */
  @Override
  public void validate(Student student) {
    if (student.getGrade() < minimumGrade) {
      throw new IllegalArgumentException(
          "Grade " + student.getGrade()
              + " is below the minimum allowed: " + minimumGrade
      );
    }
  }
}

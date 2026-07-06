package com.udla.validators;

import com.udla.model.Student;

/**
 * Contract for student validation strategies.
 *
 * <p>ISP: Clients that only need validation depend on this single-method
 * interface instead of a large class with unrelated responsibilities.
 *
 * <p>OCP: New validation rules can be added by creating new implementations
 * without modifying existing validators or the StudentManager.
 */
public interface StudentValidator {

  /**
   * Validates a student against a specific rule.
   *
   * @param student the student to validate
   * @throws IllegalArgumentException if the student fails the validation rule
   */
  void validate(Student student);
}

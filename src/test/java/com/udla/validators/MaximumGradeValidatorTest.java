package com.udla.validators;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.udla.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for MaximumGradeValidator.
 */
class MaximumGradeValidatorTest {

  @Test
  @DisplayName("Should pass when grade equals the maximum threshold")
  void shouldPassWhenGradeEqualsMaximum() {
    // Boundary: grade == maximum should be accepted
    MaximumGradeValidator validator = new MaximumGradeValidator(100.0);
    Student student = new Student("Alice", 100.0);

    assertDoesNotThrow(
        () -> validator.validate(student),
        "A grade equal to the maximum should not throw"
    );
  }

  @Test
  @DisplayName("Should pass when grade is below the maximum threshold")
  void shouldPassWhenGradeBelowMaximum() {
    MaximumGradeValidator validator = new MaximumGradeValidator(100.0);
    Student student = new Student("Bob", 75.0);

    assertDoesNotThrow(
        () -> validator.validate(student),
        "A grade below the maximum should not throw"
    );
  }

  @Test
  @DisplayName("Should throw when grade exceeds the maximum threshold")
  void shouldThrowWhenGradeExceedsMaximum() {
    MaximumGradeValidator validator = new MaximumGradeValidator(100.0);
    Student student = new Student("Charlie", 105.0);

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> validator.validate(student),
        "A grade above the maximum should throw IllegalArgumentException"
    );

    // Verify the error message contains useful context
    assertEquals(
        "Grade 105.0 exceeds the maximum allowed: 100.0",
        exception.getMessage()
    );
  }
}

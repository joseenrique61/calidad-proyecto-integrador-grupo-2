package com.udla.validators;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.udla.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for MinimumGradeValidator.
 */
class MinimumGradeValidatorTest {

  @Test
  @DisplayName("Should pass when grade equals the minimum threshold")
  void shouldPassWhenGradeEqualsMinimum() {
    // Boundary: grade == minimum should be accepted
    MinimumGradeValidator validator = new MinimumGradeValidator(60.0);
    Student student = new Student("Alice", 60.0);

    assertDoesNotThrow(
        () -> validator.validate(student),
        "A grade equal to the minimum should not throw"
    );
  }

  @Test
  @DisplayName("Should pass when grade is above the minimum threshold")
  void shouldPassWhenGradeAboveMinimum() {
    MinimumGradeValidator validator = new MinimumGradeValidator(60.0);
    Student student = new Student("Bob", 85.0);

    assertDoesNotThrow(
        () -> validator.validate(student),
        "A grade above the minimum should not throw"
    );
  }

  @Test
  @DisplayName("Should throw when grade is below the minimum threshold")
  void shouldThrowWhenGradeBelowMinimum() {
    MinimumGradeValidator validator = new MinimumGradeValidator(60.0);
    Student student = new Student("Charlie", 30.0);

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> validator.validate(student),
        "A grade below the minimum should throw IllegalArgumentException"
    );

    // Verify the error message contains useful context
    assertEquals(
        "Grade 30.0 is below the minimum allowed: 60.0",
        exception.getMessage()
    );
  }
}

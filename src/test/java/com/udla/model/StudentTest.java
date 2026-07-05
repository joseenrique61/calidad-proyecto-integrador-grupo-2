package com.udla.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentTest {

  @Test
  @DisplayName("Should assign name and grade correctly when Student is instantiated")
  void shouldAssignNameAndGradeWhenInstantiated() {

    String expectedName = "John Doe";
    double expectedGrade = 95.5;


    Student student = new Student(expectedName, expectedGrade);


    assertEquals(expectedName, student.getName(), "The name should match the one passed in constructor");
    assertEquals(expectedGrade, student.getGrade(), "The grade should match the one passed in constructor");
  }

  @Test
  @DisplayName("Should return correctly formatted string when toString is called")
  void shouldReturnCorrectlyFormattedStringWhenToStringIsCalled() {

    String name = "Jane Smith";
    double grade = 88.0;
    Student student = new Student(name, grade);
    String expectedString = "Student: Jane Smith, Grade: 88.0";


    String result = student.toString();


    assertEquals(expectedString, result, "The toString method should format the student details correctly");
  }
}

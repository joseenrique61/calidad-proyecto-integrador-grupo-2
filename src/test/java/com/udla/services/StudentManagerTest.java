package com.udla.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.udla.model.Student;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentManagerTest {

  private StudentManager studentManager;

  @BeforeEach
  void setUp() {
    studentManager = new StudentManager();
  }

  @Test
  @DisplayName("Should return empty list when no students have been added")
  void shouldReturnEmptyListWhenNoStudentsAdded() {

    List<Student> students = studentManager.getStudents();

    assertTrue(students.isEmpty(), "The initial student list should be empty");
  }

  @Test
  @DisplayName("Should add student correctly to the list")
  void shouldAddStudentCorrectly() {

    String name = "Alice";
    double grade = 90.0;


    studentManager.addStudent(name, grade);
    List<Student> students = studentManager.getStudents();


    assertEquals(1, students.size(), "There should be 1 student in the list");
    assertEquals(name, students.get(0).getName(), "The student's name should match");
    assertEquals(grade, students.get(0).getGrade(), "The student's grade should match");
  }

  @Test
  @DisplayName("Should return an unmodifiable list of students")
  void shouldReturnUnmodifiableList() {

    studentManager.addStudent("Bob", 85.0);
    List<Student> students = studentManager.getStudents();

    assertThrows(
        UnsupportedOperationException.class,
        () -> students.add(new Student("Charlie", 92.0)),
        "Modifying the returned list should throw UnsupportedOperationException"
    );
  }
}

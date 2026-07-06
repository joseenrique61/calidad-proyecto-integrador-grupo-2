package com.udla.services;

import com.udla.model.Student;
import com.udla.validators.StudentValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Gestiona la coleccion de estudiantes.
 *
 * <p>SRP: Esta clase tiene una unica responsabilidad: administrar
 * la lista de estudiantes (agregar, consultar). No realiza
 * operaciones de entrada/salida (System.out), esa responsabilidad
 * se delega a la clase que consume este manager.
 *
 * <p>OCP: Al trabajar con objetos Student en lugar de listas
 * paralelas de tipos primitivos, el manager esta abierto a
 * extension (nuevos campos en Student) sin necesidad de
 * modificar esta clase. Los validadores se inyectan como
 * dependencias, permitiendo agregar nuevas reglas sin
 * modificar esta clase.
 *
 * <p>DIP: StudentManager depende de la abstraccion
 * StudentValidator, no de implementaciones concretas.
 */
public class StudentManager {

  // Typed list of students (OCP: replaces raw parallel lists)
  private final List<Student> students = new ArrayList<>();

  // Pluggable validators executed before adding a student (OCP + DIP)
  private final List<StudentValidator> validators = new ArrayList<>();

  /**
   * Registers a validator to be applied on every addStudent call.
   *
   * <p>OCP: New validation rules are added here without modifying
   * existing code — simply register a new StudentValidator implementation.
   *
   * @param validator the validation strategy to register
   */
  public void addValidator(StudentValidator validator) {
    validators.add(validator);
  }

  /**
   * Agrega un nuevo estudiante a la coleccion.
   *
   * <p>SRP: Solo gestiona la logica de agregar. No imprime mensajes
   * en consola; la responsabilidad de presentacion queda fuera.
   *
   * <p>Runs all registered validators before persisting the student.
   *
   * @param name  nombre del estudiante
   * @param grade calificacion del estudiante
   * @throws IllegalArgumentException if any validator rejects the student
   */
  public void addStudent(String name, double grade) {
    // Create the student object
    Student student = new Student(name, grade);

    // Run every registered validator (OCP: loop is closed for modification)
    for (StudentValidator validator : validators) {
      validator.validate(student);
    }

    // Persist the student after all validations pass
    students.add(student);
  }

  /**
   * Retorna una copia no modificable de la lista de estudiantes.
   *
   * <p>SRP: Solo provee acceso a los datos. La forma de presentarlos
   * (consola, archivo, UI) es responsabilidad de quien consuma esta lista.
   *
   * @return lista inmutable de estudiantes
   */
  public List<Student> getStudents() {
    // Retorna copia inmutable para proteger el estado interno
    return Collections.unmodifiableList(students);
  }
}

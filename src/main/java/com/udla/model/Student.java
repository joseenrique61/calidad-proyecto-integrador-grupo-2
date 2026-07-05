package com.udla.model;

/**
 * Modelo de datos que representa a un estudiante.
 *
 * <p>SRP: Esta clase tiene una unica responsabilidad: encapsular
 * los datos de un estudiante (nombre y calificacion).
 *
 * <p>OCP: Al centralizar los atributos del estudiante en un objeto,
 * se pueden agregar nuevos campos (email, id, etc.) sin modificar
 * las clases que consumen este modelo.
 */
public class Student {
  // Nombre del estudiante
  private final String name;

  // Calificacion del estudiante
  private final double grade;

  /**
   * Crea una nueva instancia de Student.
   *
   * @param name  nombre del estudiante
   * @param grade calificacion del estudiante
   */
  public Student(String name, double grade) {
    this.name = name;
    this.grade = grade;
  }

  /**
   * Obtiene el nombre del estudiante.
   *
   * @return nombre del estudiante
   */
  public String getName() {
    return name;
  }

  /**
   * Obtiene la calificacion del estudiante.
   *
   * @return calificacion del estudiante
   */
  public double getGrade() {
    return grade;
  }

  /**
   * Representacion en texto del estudiante.
   *
   * @return cadena con formato "Student: nombre, Grade: calificacion"
   */
  @Override
  public String toString() {
    return "Student: " + name + ", Grade: " + grade;
  }
}

package com.udla.services;

import com.udla.model.Student;
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
 * modificar esta clase.
 */
public class StudentManager {

  // Lista tipada de estudiantes (OCP: reemplaza las listas raw paralelas)
  private final List<Student> students = new ArrayList<>();

  /**
   * Agrega un nuevo estudiante a la coleccion.
   *
   * <p>SRP: Solo gestiona la logica de agregar. No imprime mensajes
   * en consola; la responsabilidad de presentacion queda fuera.
   *
   * @param name  nombre del estudiante
   * @param grade calificacion del estudiante
   */
  public void addStudent(String name, double grade) {
    // Crea el objeto Student y lo agrega a la lista
    Student student = new Student(name, grade);
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

package com.udla;

import com.udla.model.Student;
import com.udla.services.StudentManager;
import com.udla.validators.MaximumGradeValidator;
import com.udla.validators.MinimumGradeValidator;

/**
 * Punto de entrada de la aplicacion.
 *
 * <p>SRP: Esta clase tiene una unica responsabilidad: orquestar
 * la ejecucion y manejar la presentacion en consola. La logica
 * de negocio (gestion de estudiantes) se delega a StudentManager.
 *
 * <p>DIP: Main inyecta las implementaciones concretas de
 * StudentValidator en el manager, actuando como punto de
 * composicion (Composition Root).
 */
public class Main {

  /**
   * Metodo principal que ejecuta la aplicacion.
   *
   * @param args argumentos de linea de comandos
   */
  public static void main(String[] args) {
    // Crea el gestor de estudiantes (logica de negocio)
    StudentManager manager = new StudentManager();

    // DIP: Inject validators — allowed grade range [0, 100]
    manager.addValidator(new MinimumGradeValidator(0.0));
    manager.addValidator(new MaximumGradeValidator(100.0));

    // Agrega estudiantes a traves del manager (now validated)
    manager.addStudent("John Doe", 85.5);

    // SRP: La presentacion en consola se maneja aqui, no en StudentManager
    System.out.println("Estudiante agregado.");

    // Itera la lista y muestra cada estudiante en consola
    for (Student student : manager.getStudents()) {
      System.out.println(student);
    }
  }
}

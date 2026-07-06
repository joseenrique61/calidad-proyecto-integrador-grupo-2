package com.udla;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Main class.
 *
 * <p>Covers the main() entry point to achieve 100% JaCoCo instruction
 * and branch coverage on the com.udla package.
 */
class MainTest {

  // Saves the original System.out to restore it after each test
  private PrintStream originalOut;

  // Captures console output produced by Main.main()
  private ByteArrayOutputStream capturedOutput;

  /** Redirects System.out to a buffer before each test. */
  @BeforeEach
  void setUp() {
    originalOut = System.out;
    capturedOutput = new ByteArrayOutputStream();
    System.setOut(new PrintStream(capturedOutput));
  }

  /** Restores the original System.out after each test. */
  @AfterEach
  void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  @DisplayName("Should execute main() without throwing any exception")
  void shouldExecuteMainWithoutException() {
    // Execute main() via its public entry point
    assertDoesNotThrow(
        () -> Main.main(new String[]{}),
        "Main.main() should not throw any exception during normal execution"
    );
  }

  @Test
  @DisplayName("Should print student info to console when main() runs")
  void shouldPrintStudentInfoToConsole() {
    // Run the application entry point
    Main.main(new String[]{});

    // Capture and normalise the console output
    String output = capturedOutput.toString();

    // Verify the expected lines are present in the output
    org.junit.jupiter.api.Assertions.assertTrue(
        output.contains("Estudiante agregado."),
        "Output should contain the 'Estudiante agregado.' message"
    );
    org.junit.jupiter.api.Assertions.assertTrue(
        output.contains("Student: John Doe, Grade: 85.5"),
        "Output should contain the formatted student line"
    );
  }

  @Test
  @DisplayName("Should instantiate Main without errors (covers implicit default constructor)")
  void shouldInstantiateMainClass() throws Exception {
    // Instantiate Main via reflection to hit the compiler-generated default constructor,
    // which JaCoCo counts as a separate instruction block.
    java.lang.reflect.Constructor<Main> constructor =
        Main.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    Main instance = constructor.newInstance();
    org.junit.jupiter.api.Assertions.assertNotNull(instance, "Main instance should not be null");
  }
}

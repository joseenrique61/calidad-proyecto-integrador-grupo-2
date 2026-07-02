package src;
public class Main {
  public static void main(String[] args) {
    StudentManager sm = new StudentManager();
    sm.addStudent("John Doe", 85.5);
    sm.listStudents();
  }
}

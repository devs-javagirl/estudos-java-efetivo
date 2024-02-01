package Cap3.clone;

public class StackTest {

  public static void main(String[] args) throws CloneNotSupportedException {
    testStackOriginal();
    //testStackRefactored();

  }

  private static void testStackOriginal() throws CloneNotSupportedException {
    StackOriginal stackOriginal = new StackOriginal();
    stackOriginal.push(1);
    stackOriginal.push(2);
    stackOriginal.push(3);

    System.out.println(stackOriginal);

    StackOriginal stackClone = stackOriginal.clone();
    System.out.println(stackClone);

    stackOriginal.pop();
    System.out.println("Stack original (após pop): " + stackOriginal);
    System.out.println("Stack clone (após pop): " + stackClone);
  }

  private static void testStackRefactored() throws CloneNotSupportedException {
    StackRefactored stackRefactored = new StackRefactored();
    stackRefactored.push(1);
    stackRefactored.push(2);
    stackRefactored.push(3);

    System.out.println(stackRefactored);

    StackRefactored stackClone = stackRefactored.clone();
    System.out.println(stackClone);

    stackRefactored.pop();
    System.out.println("Stack refactored (após pop): " + stackRefactored);
    System.out.println("Stack clone (após pop): " + stackClone);
  }
}

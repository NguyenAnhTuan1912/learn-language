import java.util.ArrayList;

import org.openjdk.jol.info.ClassLayout;

import MyClass.Person;

public class Main {

  public String name = "Java variables lesson";
  final public String version = System.getProperty("java.version");

  public static void main(String[] args) {
    Main m = new Main();

    // Run first example
    m.runExampleOne();
    m.runExampleTwo();
    m.runExampleThree();
    m.runExampleFour();
    m.runExampleFive();
  }

  /**
   * Run example `Simple declarations` of variables lesson
   */
  public void runExampleOne() {
    System.out.println("Run example 1 - Simple declarations");
    System.out.println("==============================");

    // String must be placed between ""
    String title = "Learn about variables in Java";

    System.out.println(title);

    // Declare variables
    byte randomByteValue = 23;
    int randomIntValue = 1912;
    // When declare a float value, we must add f behind the value.
    float randomFloatValue = 231.422f;
    boolean isEqual = randomIntValue == 1912;
    // Character must be placed between ''
    char c = 't';

    // We can use printf to format output string like this
    System.out.printf("Random byte value: %d\n", randomByteValue);
    System.out.printf("Random integer value: %d\n", randomIntValue);
    System.out.printf("Random float value: %f\n", randomFloatValue);
    System.out.printf("Is randomIntValue equal to 1912? %b\n", isEqual);
    System.out.printf("Is randomIntValue equal to 1234? %b\n", randomFloatValue == 1234);
    System.out.printf("c value: %c\n", c);

    System.out.println("==============================");
  }

  /**
   * Run example `Final variables` of variables lesson
   */
  public void runExampleTwo() {
    System.out.println("Run example 2 - Final variables");
    System.out.println("==============================");

    final String HOST = "localhost";
    final int PORT = 8080;

    System.out.printf("Value of HOST: %s\n", HOST);
    System.out.printf("Value of PORT: %d\n", PORT);

    // Remove comment to see error message
    // HOST = "Hello";
    System.out.println("==============================");
  }

  /**
   * Run example `Complex variables` of variables lesson
   */
  public void runExampleThree() {
    System.out.println("Run example 3 - Complex variables");
    System.out.println("==============================");

    Person p1 = new Person("Tuan", "Nguyen Anh");
    p1.age = 23;
    p1.job = "Fullstack Engineer";

    Person p2 = new Person("Lan", "Nguyen Van", (short) 24, "Marketing");

    System.out.printf("Person 1: %s\n", p1);
    System.out.printf("Person 2: %s\n", p2);

    System.out.println("==============================");
  }

  /**
   * Run example `List` of variables lesson
   */
  public void runExampleFour() {
    System.out.println("Run example 4 - List");
    System.out.println("==============================");

    String[] lines = {
        "Hello world!",
        "I am learning Java"
    };

    System.out.println("Element of lines:");
    for (String str : lines) {
      System.out.printf("\t%s\n", str);
    }
    System.out.println();

    String[] lines2 = new String[2];
    lines2[0] = "Hello world!";
    lines2[1] = "I am learning Java";

    System.out.println("Element of lines2:");
    for (String str : lines2) {
      System.out.printf("\t%s\n", str);
    }
    System.out.println();

    ArrayList<String> lines3 = new ArrayList<>();
    lines3.add("Hello world!");
    lines3.add("I am learning Java");

    System.out.println("Element of lines3:");
    for (String str : lines3) {
      System.out.printf("\t%s\n", str);
    }

    System.out.println("==============================");
  }

  /**
   * Run example `Size of variables` of variables lesson
   */
  public void runExampleFive() {
    System.out.println("Run example 5 - Size of variables");
    System.out.println("==============================");

    Person p = new Person("Lan", "Nguyen Van", (short) 23, "FullStack Engineer");
    String[] lines = {
        "Hello world!",
        "I am learning Java"
    };
    String[] lines2 = new String[2];
    ArrayList<String> lines3 = new ArrayList<>();

    System.out.println("Size of types:");
    System.out.printf("\tSize of byte: %d bytes.\n", Byte.BYTES);
    System.out.printf("\tSize of short: %d bytes.\n", Short.BYTES);
    System.out.printf("\tSize of int: %d bytes.\n", Integer.BYTES);
    System.out.printf("\tSize of long: %d bytes.\n", Long.BYTES);
    System.out.printf("\tSize of char: %d bytes.\n", Character.BYTES);
    System.out.printf("\tSize of float: %d bytes.\n", Float.BYTES);
    System.out.printf("\tSize of double: %d bytes.\n", Double.BYTES);

    System.out.println("Size of objects:");
    System.out.printf("\tSize of p: %d bytes\n", ClassLayout.parseInstance(p).instanceSize());
    System.out.printf("\tSize of lines: %d bytes\n", ClassLayout.parseInstance(lines).instanceSize());
    System.out.printf("\tSize of lines2: %d bytes\n", ClassLayout.parseInstance(lines2).instanceSize());
    System.out.printf("\tSize of lines3: %d bytes\n", ClassLayout.parseInstance(lines3).instanceSize());

    System.out.println("==============================");
  }
}

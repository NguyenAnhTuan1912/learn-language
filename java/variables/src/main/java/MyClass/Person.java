package MyClass;

public class Person {
  public String firstName;
  public String lastName;
  public short age;
  public String job;

  // Overload 1: empty constructure
  public Person() {
  };

  // Overload 2: receive firstName and lastName
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // Overload 3: receive firstName, lastName and age
  public Person(String firstName, String lastName, short age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  };

  // Overload 4: receive all
  public Person(String firstName, String lastName, short age, String job) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.job = job;
  };

  @Override
  public String toString() {
    String[] output = {
        String.format("firstName: \"%s\"", this.firstName),
        String.format("lastName: \"%s\"", this.lastName),
        String.format("age: %d", this.age),
        String.format("job: \"%s\"", this.job)
    };

    String result = "Person {";

    for (int i = 0; i < output.length; i++) {
      if (i == output.length - 1) {
        result += String.format("\n  %s\n", output[i]);
      } else {
        result += String.format("\n  %s,", output[i]);
      }
    }

    result += "}";

    return result;
  }
}
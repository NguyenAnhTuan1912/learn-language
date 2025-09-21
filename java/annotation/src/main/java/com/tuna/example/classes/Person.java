package com.tuna.example.classes;

import com.tuna.example.annotations.ClassMarker;
import com.tuna.example.annotations.Max;
import com.tuna.example.annotations.MethodMarker;
import com.tuna.example.annotations.Min;
import com.tuna.example.annotations.NotEmpty;

@ClassMarker(name = "Class_Person")
public class Person {

  @NotEmpty
  private String name;

  @Min(15)
  @Max(100)
  private short age;

  public Person() {
  }

  public Person(String name) {
    this.name = name;
  }

  public Person(String name, short age) {
    this.name = name;
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(short age) {
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public short getAge() {
    return this.age;
  }

  @MethodMarker(name = "Person.printInfo")
  public void printInfo() {
    String output = "Person {";

    output += String.format("  name: %s\n,", this.name);
    output += String.format("  age: %s\n", this.age);

    output += "}";

    System.out.println(output);
  }

}

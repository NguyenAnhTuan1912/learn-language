package com.tuna.example;

import java.lang.reflect.Method;

import com.tuna.example.annotations.AnnotationUtil;
import com.tuna.example.annotations.ClassMarker;
import com.tuna.example.annotations.MethodMarker;
import com.tuna.example.classes.Person;

public class Main {

  public static void main(String args[]) throws Exception {
    Person p = new Person("Nguyen Anh Tuan", (short) 23);
    // Lỗi NotEmpty
    Person p2 = new Person("", (short) 24);
    // Lỗi Min
    Person p3 = new Person("Test User 3", (short) 3);
    // Lỗi Max
    Person p4 = new Person("Test User 4", (short) 101);

    // Proccess annotation for Person
    if (Person.class.isAnnotationPresent(ClassMarker.class)) {
      ClassMarker pcm = Person.class.getAnnotation(ClassMarker.class);

      System.out.println("Class Person (Reading Annotation...) ");
      System.out.printf("Official Name: %s\n", pcm.name());
      System.out.printf("Official Version: %s\n", pcm.version());
    }

    // Process annotation for method
    for (Method method : Person.class.getDeclaredMethods()) {
      if (method.isAnnotationPresent(MethodMarker.class)) {
        MethodMarker pmm = method.getAnnotation(MethodMarker.class);

        System.out.printf("Method %s (Reading Annotation...)\n", method.getName());
        System.out.printf("Official Name: %s\n", pmm.name());
      }
    }

    System.out.println("Process NotEmpty Annotation");
    AnnotationUtil.processNotEmpty(p);
    AnnotationUtil.processNotEmpty(p2);
    AnnotationUtil.processNotEmpty(p3);
    AnnotationUtil.processNotEmpty(p4);

    System.out.println("Process Min Annotation");
    AnnotationUtil.processMin(p);
    AnnotationUtil.processMin(p2);
    AnnotationUtil.processMin(p3);
    AnnotationUtil.processMin(p4);

    System.out.println("Process Max Annotation");
    AnnotationUtil.processMax(p);
    AnnotationUtil.processMax(p2);
    AnnotationUtil.processMax(p3);
    AnnotationUtil.processMax(p4);
  }

}

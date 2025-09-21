package com.tuna.example.annotations;

import java.lang.reflect.Field;

public class AnnotationUtil {

  public static int toInt(Object value) {
    if (value instanceof Number) {
      return ((Number) value).intValue();
    }
    return 0;
  }

  public static void processNotEmpty(Object obj) {
    Class<?> clazz = obj.getClass();

    for (Field field : clazz.getDeclaredFields()) {

      if (field.isAnnotationPresent(NotEmpty.class)) {
        boolean isNotSatisfied = false;
        field.setAccessible(true);

        try {
          Object value = field.get(obj);
          if (value.equals(""))
            isNotSatisfied = true;
        } catch (IllegalAccessException e) {
          isNotSatisfied = true;
        }

        field.setAccessible(false);

        if (isNotSatisfied) {
          String msg = String.format("The field `%s` cannot be empty.\n", field.getName());
          System.out.printf(msg);
        }
      }
    }
  }

  public static void processMin(Object obj) {
    Class<?> clazz = obj.getClass();

    for (Field field : clazz.getDeclaredFields()) {

      if (field.isAnnotationPresent(Min.class)) {
        boolean isNotSatisfied;
        int expectedValue = field.getAnnotation(Min.class).value();
        field.setAccessible(true);

        try {
          int value = AnnotationUtil.toInt(field.get(obj));

          isNotSatisfied = value < expectedValue;
        } catch (IllegalAccessException e) {
          isNotSatisfied = true;
        }

        field.setAccessible(false);

        if (isNotSatisfied) {
          String msg = String.format("The value of `%s` cannot be less than %s.\n", field.getName(), expectedValue);
          System.out.printf(msg);
        }
      }

    }
  }

  public static void processMax(Object obj) {
    Class<?> clazz = obj.getClass();

    for (Field field : clazz.getDeclaredFields()) {

      if (field.isAnnotationPresent(Max.class)) {
        boolean isNotSatisfied;
        int expectedValue = field.getAnnotation(Max.class).value();

        field.setAccessible(true);

        try {
          int value = AnnotationUtil.toInt(field.get(obj));

          isNotSatisfied = value > expectedValue;
        } catch (IllegalAccessException e) {
          isNotSatisfied = true;
        }

        field.setAccessible(false);

        if (isNotSatisfied) {
          String msg = String.format("The value of `%s` cannot be greater than %s.\n", field.getName(), expectedValue);
          System.out.printf(msg);
        }
      }
    }
  }

}

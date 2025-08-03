package br.com.demo.reflexao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;


public class Transformator {

    public <In, Out> Out transform(In input, Class<Out> target) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
       Class<?> source = input.getClass();


       Out targetClass = target.getDeclaredConstructor().newInstance();

       Field[] sourceFields = source.getDeclaredFields();
       Field[] targetFields = target.getDeclaredFields();

       Arrays.stream(sourceFields).forEach(sourceField ->
              Arrays.stream(targetFields).forEach(targetField -> {
                  try {
                      if (validate(sourceField, targetField)) {
                          sourceField.setAccessible(true);
                          targetField.setAccessible(true);
                          targetField.set(targetClass, sourceField.get(input));
                      }
                  } catch (IllegalAccessException e) {
                      e.printStackTrace();
                  }
              }));

       return targetClass;
    }

    private Boolean validate(Field sourceField, Field targetField) {
        return sourceField.getName().equals(targetField.getName()) && sourceField.getType().equals(targetField.getType());
    }

}

package io.vividcode.graalvm.reflection;

import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        Method method = clazz.getDeclaredMethod("toUpperCase");
        String result = (String) method.invoke("Hello World");
        System.out.println(result);
    }
}
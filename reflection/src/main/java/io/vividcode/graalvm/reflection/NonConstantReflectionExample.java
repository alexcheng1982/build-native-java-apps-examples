package io.vividcode.graalvm.reflection;

import java.lang.reflect.Method;

public class NonConstantReflectionExample {

    public static void main(String[] args) throws Exception {
        String className = "java/lang/String".replace("/", ".");
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getDeclaredMethod("toUpperCase");
        String result = (String) method.invoke("Hello World");
        System.out.println(result);
    }
}

package io.vividcode.graalvm.reflection;

import java.lang.reflect.Method;

public class BuildTimeReflection {

    private static Method toUpperCase;

    static {
        try {
            String className = "java/lang/String".replace("/", ".");
            Class<?> clazz = Class.forName(className);
            toUpperCase = clazz.getDeclaredMethod("toUpperCase");
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            System.err.println("Cannot get method");
        }
    }

    public static void main(String[] args) throws Exception {
        String result = (String) toUpperCase.invoke("Hello World");
        System.out.println(result);
    }
}

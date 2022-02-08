package io.vividcode.graalvm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class DynamicProxyExample {

    public static void main(String[] args) throws Exception {
        DynamicProxyExample proxy = new DynamicProxyExample();
        Callable<?> callable = proxy.wrap(() -> "Hello World");
        System.out.println(callable.call());
    }

    public Callable<?> wrap(Callable<?> callable) {
        ClassLoader classLoader = DynamicProxyExample.class.getClassLoader();
        InvocationHandler handler = new LoggingInvocationHandler<Callable<?>>(callable);
        return (Callable<?>) Proxy.newProxyInstance(classLoader, new Class<?>[]{Callable.class},
                handler);
    }

    /**
     * Logging method invocations
     */
    private static class LoggingInvocationHandler<T> implements InvocationHandler {

        private final T wrapped;

        LoggingInvocationHandler(T wrapped) {
            this.wrapped = wrapped;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(
                    "Before invocation of " + method.getName() + ", parameters: " + Arrays.toString(
                            args));
            Object result = method.invoke(wrapped, args);
            System.out.println("After invocation of " + method.getName() + ", result: " + result);
            return result;
        }

    }
}

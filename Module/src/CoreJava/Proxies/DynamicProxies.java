package src.CoreJava.Proxies;

import java.lang.reflect.Proxy;

public class DynamicProxies {

    public static void main(String[] args) {

        Employee emp1 = new Employee("Dhruba","IT");
        ClassLoader classLoader = emp1.getClass().getClassLoader();
        Class[] interfaces = emp1.getClass().getInterfaces();
        Person person = (Person) Proxy.newProxyInstance(classLoader,interfaces,new EmployeeInvocationHandler(emp1));
        person.introduce();
    }

}

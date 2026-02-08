package src.CoreJava.Proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmployeeInvocationHandler implements InvocationHandler {

    private Employee employee;
    public EmployeeInvocationHandler(Employee employee){
        this.employee = employee;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy intercepted the method call");
        method.invoke(employee);
        return null;
    }
}

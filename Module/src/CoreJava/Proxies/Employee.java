package src.CoreJava.Proxies;

public class Employee implements Person{

    private String name;
    private String dept;
    public Employee(String name, String dept){
        this.name=name;
        this.dept=dept;
    }
    @Override
    public void introduce() {
        System.out.println("Hello my name is "+this.name);
    }

    @Override
    public void getDept() {
        System.out.println(this.name+" works in "+this.dept);
    }
}

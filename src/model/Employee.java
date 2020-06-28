package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Employee")
public class Employee extends Person {
    private float salary;
    private int office;

    public Employee() {
    }

    public Employee(float salary, int office) {
        this.salary = salary;
        this.office = office;
    }

    public Employee(String name, Integer age, float salary, int office) {
        super(name, age);
        this.salary = salary;
        this.office = office;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", office=" + office +
                '}';
    }
}

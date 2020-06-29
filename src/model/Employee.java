package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Employee")
public class Employee extends Person {
    private float salary;
    private int office;

    @ManyToOne
    private Departament departament;

    @OneToOne(cascade = CascadeType.ALL)
    private Car car;

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

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", office=" + office +
                '}';
    }
}

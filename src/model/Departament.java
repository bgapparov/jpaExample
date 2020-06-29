package model;

import jdk.internal.dynalink.linker.LinkerServices;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int amountOfEmployees;

    @OneToMany(mappedBy = "departament",cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Departament() {
    }

    public Departament(int amountOfEmployees, String name) {
        this.amountOfEmployees = amountOfEmployees;
        this.name = name;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfEmployees() {
        return amountOfEmployees;
    }

    public void setAmountOfEmployees(int amountOfEmployees) {
        this.amountOfEmployees = amountOfEmployees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "id= " + id +
                ", amountOfEmployees= " + amountOfEmployees + " name = " + name + "," + " employee = "  + getEmployees().get(1) + " " +
                '}';
    }
}

package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int amountOfEmployees;

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

    @Override
    public String toString() {
        return "Departament{" +
                "id=" + id +
                ", amountOfEmployees=" + amountOfEmployees + "name=" + name +
                '}';
    }
}

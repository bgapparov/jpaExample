package model;

import javax.persistence.*;

@Entity
@NamedQuery(name="carName", query ="SELECT c.name FROM Car c")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private Costumer costumer;

    @OneToOne(mappedBy = "car")
    private Employee employee;

    public Car() {
    }

    public Car(String name) {
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

//    public Costumer getCostumer() {
//        return costumer;
//    }
//
//    public void setCostumer(Costumer costumer) {
//        this.costumer = costumer;
//    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

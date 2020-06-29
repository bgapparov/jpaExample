package model;

import javax.persistence.*;
import java.security.PrivateKey;

@Entity
@DiscriminatorValue("Costumer")
public class Costumer extends Person {

    private Integer phone;
    private String zipcode;

    @OneToOne(cascade = CascadeType.ALL)
    private Car car;

    public Costumer() {
    }

    public Costumer(String name, Integer age) {
        super(name, age);
    }


    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        System.out.println();
        return "Costumer: {" +
                "name='" + super.getName() + '\'' +
                ", phone=" + phone +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}

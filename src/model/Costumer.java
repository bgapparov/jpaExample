package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Costumer")
public class Costumer extends Person {

    private Integer phone;
    private String zipcode;

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

    @Override
    public String toString() {
        return "Costumer{" +
                "name='" + super.getName() + '\'' +
                ", phone=" + phone +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}

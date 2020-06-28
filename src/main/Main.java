package main;

import model.Departament;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    static public void main(String args[]){
        System.out.println("test");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr =em.getTransaction();

        Departament dp = new Departament();
        dp.setAmountOfEmployees(20);

        tr.begin();

        em.persist(dp);

        tr.commit();

        em.close();
        emf.close();
    }
}

package main;

import model.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

public class Main {

    static public void main(String args[]){
        System.out.println("test");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr =em.getTransaction();

        Car car1 = new Car();
        car1.setName("car1");


        Car car2 = new Car();
        car2.setName("car2");

        Costumer costumer1 = new Costumer();
        costumer1.setName("Costumer1");
        costumer1.setAge(30);
        costumer1.setPhone(657458935);
        costumer1.setZipcode("43241");
        costumer1.setCar(car1);

        Costumer costumer2 = new Costumer();
        costumer2.setName("Costumer2");
        costumer2.setAge(34);
        costumer2.setPhone(657458935);
        costumer2.setZipcode("43241");
        costumer2.setCar(car2);

        Employee employee1 = new Employee();
        employee1.setName("Employee1");
        employee1.setAge(36);
        employee1.setSalary(3000);
        employee1.setCar(car1);

        Employee employee2 = new Employee();
        employee2.setName("Employee2");
        employee2.setAge(40);
        employee2.setSalary(3000);
        employee2.setCar(car2);

        Departament dp = new Departament();
        dp.setAmountOfEmployees(20);
        dp.setName("Noname");
        dp.getEmployees().add(employee1);
        dp.getEmployees().add(employee2);

        Departament dp2 = new Departament();
        dp2.setAmountOfEmployees(25);
        dp2.setName("IT");
        dp2.getEmployees().add(employee1);

        employee1.setDepartament(dp);
        employee2.setDepartament(dp2);


        tr.begin();

        em.persist(costumer1);
        em.persist(costumer2);
        em.persist(car1);
        em.persist(car2);
        em.persist(employee1);
        em.persist(employee2);
        em.persist(dp);
        em.persist(dp2);

        tr.commit();

        String cos = "Costumer";

        //Dynamic query
        String queryStr = "SELECT c FROM Costumer c ";

        TypedQuery<Costumer> query1 = em.createQuery(queryStr, Costumer.class);
        List<Costumer> costumers = query1.getResultList();
        System.out.println("Result of dynamic query:" + costumers);

        TypedQuery<Employee> query2 = em.createQuery("SELECT e FROM Employee e ", Employee.class);
        List<Employee> employees = query2.getResultList();
        System.out.println("Result of dynamic query: " +  employees);


        //CriteriaBuilder query
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Costumer> criteriaQuery = criteriaBuilder.createQuery(Costumer.class);
        Root<Costumer> rootCostumer = criteriaQuery.from(Costumer.class);
        criteriaQuery.select(rootCostumer);
        TypedQuery<Costumer> query3 =
                em.createQuery(criteriaQuery);
        List<Costumer> costumerList  = query3.getResultList();
        System.out.println("Criteria Query result: " + costumerList);

        CriteriaBuilder criteriaBuilder1 = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery1 = criteriaBuilder1.createQuery(Employee.class);
        Root<Employee> rootEmployee = criteriaQuery1.from(Employee.class);
        criteriaQuery1.select(rootEmployee);
        TypedQuery<Employee> query4 = em.createQuery(criteriaQuery1);
        List<Employee> employeeList = query4.getResultList();
        System.out.println("Criteria Query result: " + employeeList);

        //At least one Criteria query using all three entities (with at least 4 predicates)
        CriteriaBuilder crBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Departament> crQuery = crBuilder.createQuery(Departament.class);

        Root<Departament> rootDepartament = crQuery.from(Departament.class);
        Join<Departament, Employee> joinEmployee = rootDepartament.join("employees");


        Predicate departamentAmounOfEmpPred = crBuilder.equal(rootDepartament.get("amountOfEmployees"), 20);
        Predicate employeeSalaryPred = crBuilder.equal(joinEmployee.get("salary"), 3000);
        Predicate empOfficePred = crBuilder.equal(joinEmployee.get("office"), 0);

        Predicate totalPred = crBuilder.and(departamentAmounOfEmpPred, employeeSalaryPred, empOfficePred);

        crQuery.select(rootDepartament);
        crQuery.where(totalPred);

        TypedQuery<Departament> tQuery = em.createQuery(crQuery);
        List<Departament> departamentList = tQuery.getResultList();

        System.out.println("Critery Query using entities: " + departamentList);

        //NamedQuery
        TypedQuery<Person> namedQuery =  em.createNamedQuery("Person.selectPersonName", Person.class);
        List<Person> personList = namedQuery.getResultList();
        System.out.println(personList);

        TypedQuery<Car> carNamedQuery =  em.createNamedQuery("Car.carName", Car.class);
        List<Car> cars = carNamedQuery.getResultList();
        System.out.println(cars);

        em.close();
        emf.close();
    }
}

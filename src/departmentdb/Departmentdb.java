/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentdb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Department;
import model.Employee;

/**
 *
 * @author AreYouG
 */
public class Departmentdb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Department dep1 = new Department("IT");
        Department dep2 = new Department("HR");
        persist(dep1);
        persist(dep2);
        
        Employee emp1 = new Employee("Abby", "Programmer", 420, dep1);
        Employee emp2 = new Employee("Bobby", "Manager", 300, dep2);
        Employee emp3 = new Employee("Coco", "Tester", 300, dep1);
        Employee emp4 = new Employee("Deedee", "Recruiter", 330, dep2);
        persist(emp1);
        persist(emp2);
        persist(emp3);
        persist(emp4);
                
        
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    
    
}

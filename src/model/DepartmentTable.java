/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author AreYouG
 */
public class DepartmentTable {
    
//    public static Department findDepartmentyById(int id){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
//        EntityManager em = emf.createEntityManager();
//        Department dep = em.find(Department.class, id);
//        em.close();
//        return dep;
//    }
    public static List<Department> findAllDepartment() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Department.findAll");
        List<Department> depList = (List<Department>) query.getResultList();
        em.close();
        return depList;
    }
}

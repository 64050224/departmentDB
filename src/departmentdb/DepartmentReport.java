/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package departmentdb;
import java.util.List;
import model.Department;
import model.DepartmentTable;
import model.Employee;
import model.EmployeeTable;

/**
 *
 * @author AreYouG
 */
public class DepartmentReport {
    public static String line = "---------";
    public static void main(String[] args){
        reportEmpById();
        reportEmpByDepartment();
    }
    private static void reportEmpById(){
        List<Employee> list = EmployeeTable.findAllEmployee();
        System.out.println("All employee by ID");
        System.out.println(line);
        for(Employee emp : list){
            System.out.println("ID: "+emp.getEmployeeid());
            System.out.println("Name: "+emp.getName());
            System.out.println("Job: "+emp.getJob());
            System.out.println("Salary: "+emp.getSalary());
            System.out.println("Department: "+emp.getDepartmentid().getName()); 
            System.out.println(line);
        }
    }
    private static void reportEmpByDepartment(){
        List<Department> list = DepartmentTable.findAllDepartment();
        System.out.println("All employee by Department");
        System.out.println(line);
        for(Department dep: list){
            System.out.println("Department ID: "+dep.getDepartmentid()+" Department Name: "+dep.getName());
            System.out.println(line);
            List<Employee> listEmp = (List<Employee>)dep.getEmployeeCollection();
            for(Employee emp: listEmp){
                System.out.println("ID: "+emp.getEmployeeid());
                System.out.println("Name: "+emp.getName());
                System.out.println("Job: "+emp.getJob());
                System.out.println("Salary: "+emp.getSalary());
                System.out.println(line);
            }
        }
    }
}


package com.kalpana.atyourdoorstep.App;

import com.kalpana.atyourdoorstep.dao.EmployeeDao;
import com.kalpana.atyourdoorstep.entity.Employee;
import com.kalpana.atyourdoorstep.entity.EmployeeType;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private Employee emp;
    private EntityManager em;
    private EmployeeDao dao;
    private EntityManagerFactory emf;
    
    @Before
    public void setUp(){
        emf = Persistence.createEntityManagerFactory("AtYourDoorStep");
        em = emf.createEntityManager();
        dao = new EmployeeDao(em);
    }
    
    @After
    public void tearDown(){
        emp = null;
        dao = null;
        em = null;
        emf = null;
    }
    
    public Long testInsert() {
        emp = dao.insert(getEmployee());
        System.out.println("Employee with employee id ="+emp.getEmployeeId() +" Saved");
        return emp.getEmployeeId();
    }

    
    public Employee testGet() {
        Employee tempEmp = dao.get(emp.getEmployeeId());
        System.out.println("Employee with employee id ="+emp.getEmployeeId() +" Fetched");
        return tempEmp;
    }
    
    
    public void testUpdate() {
        emp.setEmployeeSalary(emp.getEmployeeSalary()+1000);
        System.out.println("Employee with employee id ="+emp.getEmployeeId() +" Updated");
    }
    
   
    
    public void testDelete() {
        dao.delete(emp);
        System.out.println("Employee with employee id ="+emp.getEmployeeId() +" Deleted");
    }
    
    @Test
    public void testEmployeeCrud() {
        
        try {
            em.getTransaction().begin();
            testInsert();
            assertTrue(emp.getEmployeeId() != null);
            
            Employee tempEmp = testGet();
            Assert.assertEquals(emp.getEmployeeId(),tempEmp.getEmployeeId());
            
            Long oldSalary = emp.getEmployeeSalary();
            testUpdate();
            Assert.assertEquals((Long)(oldSalary+1000L), emp.getEmployeeSalary());
            
            testDelete();
            assertTrue(true);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    private Employee getEmployee() {
        Employee emp = new Employee();
        emp.setEmployeeJoiningDate(new Date());
        emp.setEmployeeSalary(11000L);
        emp.setEmployeeType(EmployeeType.PERMANENT);
        return emp;

    }
}

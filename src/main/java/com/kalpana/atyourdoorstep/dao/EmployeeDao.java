package com.kalpana.atyourdoorstep.dao;

import com.kalpana.atyourdoorstep.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Kalpana
 */
public class EmployeeDao implements Dao<Employee, Long> {

    private final EntityManager em;

    public EmployeeDao(final EntityManager em) {
        this.em = em;
    }

    @Override
    public Employee insert(Employee emp) {
        em.persist(emp);
        return emp;
    }

    @Override
    public void delete(Employee emp) {
        em.remove(emp);
    }

    @Override
    public Employee get(Long empId) {
        return em.find(Employee.class, empId);
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

}

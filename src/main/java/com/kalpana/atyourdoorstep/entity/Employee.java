package com.kalpana.atyourdoorstep.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Kalpana
 */
@Entity
@Table(name = "Employee_Details")
public class Employee implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_ID_SEQ_NM")
    @SequenceGenerator(name ="EMP_ID_SEQ_NM", sequenceName = "EMP_ID_SEQ")
    private Long employeeId;
     
    @Column(name = "JOINING_DATE")
    @Temporal(TemporalType.DATE)
    private Date employeeJoiningDate;
    
    @Column(name ="SALARY")
    private Long employeeSalary;
    
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getEmployeeJoiningDate() {
        return employeeJoiningDate;
    }

    public void setEmployeeJoiningDate(Date employeeJoiningDate) {
        this.employeeJoiningDate = employeeJoiningDate;
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
    
}

package com.ionbr.hibernate.model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator =  "course_seq_gen")
    @SequenceGenerator(name = "course_seq_gen",
            sequenceName = "course_sequence")
    private Long Id;
    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="hire_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;

    @Column(name = "salary")
    private Double salary;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

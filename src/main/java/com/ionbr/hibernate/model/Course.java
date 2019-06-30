package com.ionbr.hibernate.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator =  "course_seq_gen")
   @SequenceGenerator(name = "course_seq_gen",
           sequenceName = "course_sequence")
private long id;
    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return description;


    }
}

package com.ionbr.hibernate.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator =  "adress_seq_gen")
    @SequenceGenerator(name = "adress_seq_gen",
            sequenceName = "adress_sequence")
    private Long Id;

    @Column(name="street")
    private String street;

    @Column(name="city")
    private String city;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

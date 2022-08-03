package com.bakh.pp312.models;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Bakhmai Begaev
 */
@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="first_Name")
    private String firstName;
    @Column(name="last_Name")
    private String lastName;
    @Column(name="age")
    private byte age;
}

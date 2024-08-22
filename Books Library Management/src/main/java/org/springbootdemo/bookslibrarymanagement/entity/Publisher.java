package org.springbootdemo.bookslibrarymanagement.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="name",length = 100,nullable = false,unique = true)
    private String name;


    @ManyToMany(mappedBy = "publishers",cascade = {CascadeType.ALL})
    private Set<Book> books = new HashSet<>();


}

package org.springbootdemo.bookslibrarymanagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author") // table name in database
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author  {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name ="description" ,length =2500 ,nullable = false)
    private String description;
    @Column(name ="name" ,length =100 ,nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();





}

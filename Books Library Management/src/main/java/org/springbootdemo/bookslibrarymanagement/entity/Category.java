package org.springbootdemo.bookslibrarymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name ="categories")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="name" ,length =100 ,nullable = false, unique = true)
    private String name;


    @ManyToMany(mappedBy = "categories",cascade = {CascadeType.ALL})
    private Set<Book> books = new HashSet<>();
}

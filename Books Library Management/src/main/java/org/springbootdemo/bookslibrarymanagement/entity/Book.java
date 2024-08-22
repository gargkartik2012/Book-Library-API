package org.springbootdemo.bookslibrarymanagement.entity;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="isbn",length = 100,nullable = false,unique = true)
    private String isbn;

    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @Column(name = "description", length = 2500, nullable = false)
    private String description;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="books_authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name="author_id")})
    private Set<Author> authors = new HashSet<>();


    @ManyToMany(cascade = {CascadeType.ALL}) // this is used for generating related column value(join)
    @JoinTable(name="books_categories",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")})
    private Set<Category> categories = new HashSet<>(); // these are the object type entry


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="books_publishers",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name="publisher_id")})
    private Set<Publisher> publishers = new HashSet<>();
}
//
// https://www.youtube.com/@lightoftechnology8901
// @JsonManagerReference is used with the main(parent) class Book  to avoid calling method again
//@JsonBackReference is used to avoid the content of child class
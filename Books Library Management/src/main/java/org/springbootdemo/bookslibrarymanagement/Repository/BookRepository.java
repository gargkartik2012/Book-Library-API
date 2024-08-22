package org.springbootdemo.bookslibrarymanagement.Repository;

import org.springbootdemo.bookslibrarymanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}

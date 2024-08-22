package org.springbootdemo.bookslibrarymanagement.Service;

import org.springbootdemo.bookslibrarymanagement.Repository.BookRepository;
import org.springbootdemo.bookslibrarymanagement.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {



    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book findBookById(Integer id){
        return bookRepository.findById(id).orElse(null);
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public String deleteBook(Integer id){
        bookRepository.deleteById(id);
        return "Book deleted successfully" + id;
    }

}

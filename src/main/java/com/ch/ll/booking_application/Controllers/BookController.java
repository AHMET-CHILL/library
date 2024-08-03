package com.ch.ll.booking_application.Controllers;

import com.ch.ll.booking_application.Repository.BookRepository;
import com.ch.ll.booking_application.entitites.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    @GetMapping(path = "/{bookId}")
    public Book getBookById(@PathVariable Integer bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @PutMapping(path = "/{bookId}")
    public Book updateBook(@PathVariable Integer bookId, @RequestBody Book newBook) {
        Book existingBook = bookRepository.findById(bookId).orElse(null);
        if (Objects.nonNull(existingBook)) {
            existingBook.setId(newBook.getId());
            existingBook.setName(newBook.getName());
            existingBook.setMenstruation(newBook.getMenstruation());
            existingBook.setPageNumber(newBook.getPageNumber());
            return bookRepository.save(existingBook);

        }else
            System.out.println("Book not found");
            return null;
    }
    @DeleteMapping(path ="/{bookId}")
    public void deleteBook(@PathVariable Integer bookId) {
        bookRepository.deleteById(bookId);
    }


}

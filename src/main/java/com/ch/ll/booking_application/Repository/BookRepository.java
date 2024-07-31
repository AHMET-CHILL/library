package com.ch.ll.booking_application.Repository;

import com.ch.ll.booking_application.entitites.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}

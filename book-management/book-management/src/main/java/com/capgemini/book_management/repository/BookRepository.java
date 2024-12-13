package com.capgemini.book_management.repository;

import com.capgemini.book_management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

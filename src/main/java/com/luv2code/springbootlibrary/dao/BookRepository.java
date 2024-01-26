package com.luv2code.springbootlibrary.dao;

import com.luv2code.springbootlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By dhhaval thakkar on 2024-01-26
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}

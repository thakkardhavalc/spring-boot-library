package com.luv2code.springbootlibrary.controller;

import com.luv2code.springbootlibrary.entity.Book;
import com.luv2code.springbootlibrary.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By dhhaval thakkar on 2024-02-02
 */
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/secure/ischeckedout/byuser")
    public boolean checkoutBookByUser(@RequestParam Long bookId) {
        String userEmail = "testuser@email.com";
        return bookService.checkoutBookByUser(userEmail, bookId);
    }

    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount() {
        String userEmail = "testuser@email.com";
        return bookService.currentLoansCount(userEmail);
    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook(@RequestParam Long bookId) throws Exception {
        String userEmail = "testuser@email.com";
        return bookService.checkoutBook(userEmail, bookId);
    }
}

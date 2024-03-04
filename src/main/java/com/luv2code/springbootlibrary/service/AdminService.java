package com.luv2code.springbootlibrary.service;

import com.luv2code.springbootlibrary.dao.BookRepository;
import com.luv2code.springbootlibrary.entity.Book;
import com.luv2code.springbootlibrary.requestmodels.AddBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created By dhhaval thakkar on 2024-03-04
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {

    private final BookRepository bookRepository;

    public void postBook(AddBookRequest addBookRequest) {
        Book book = new Book();

        book.setTitle(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setDescription(addBookRequest.getDescription());
        book.setCopies(addBookRequest.getCopies());
        book.setCopiesAvailable(addBookRequest.getCopies());
        book.setCategory(addBookRequest.getCategory());
        book.setImg(addBookRequest.getImg());

        bookRepository.save(book);
    }
}

package com.springv.elice_websocket.book.service;

import com.springv.elice_websocket.book.domain.Book;
import com.springv.elice_websocket.book.model.BookRequest;
import com.springv.elice_websocket.repository.book.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Test
    void save_book_test() {
        //given
        BookRequest bookRequest = new BookRequest("책 이름", 10);

        //when
        bookService.saveBook(bookRequest);

        //then
        Optional<Book> savedBook = bookRepository.findById(1L);
        if (savedBook.isPresent()) {
            Book book = savedBook.get();
            assertEquals(bookRequest.getBookName(), book.getName());
            assertEquals(bookRequest.getQuantity(), book.getQuantity());
        } else {
            // If the book was not saved properly, fail the test
            throw new AssertionError("Book was not saved properly");
        }
    }

}
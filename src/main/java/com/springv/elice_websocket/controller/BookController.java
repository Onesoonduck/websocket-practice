package com.springv.elice_websocket.controller;


import com.springv.elice_websocket.book.service.BookService;
import com.springv.elice_websocket.book.model.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class BookController {

    private final BookService bookService;
    /**
     * 책 등록 API
     * @author jhwon
     */
    @PostMapping("/book")
    public String saveBook(@RequestBody BookRequest bookRequest) {
        return bookService.saveBook(bookRequest);
    }
}

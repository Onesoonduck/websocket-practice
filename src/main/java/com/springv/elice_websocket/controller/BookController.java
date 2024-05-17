package com.springv.elice_websocket.controller;


import com.springv.elice_websocket.book.model.BookResponse;
import com.springv.elice_websocket.book.service.BookService;
import com.springv.elice_websocket.book.model.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/book/list")
    public List<BookResponse> getBookList() {
        return bookService.getBookList();
    }
}

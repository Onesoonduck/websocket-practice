package com.springv.elice_websocket.book.service;


import com.springv.elice_websocket.book.domain.Book;
import com.springv.elice_websocket.book.model.BookRequest;
import com.springv.elice_websocket.book.model.BookResponse;
import com.springv.elice_websocket.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public String saveBook(BookRequest bookRequest) {

        Book book = new Book(bookRequest.getBookName(), bookRequest.getQuantity()); //Book 클래스로터 새로운 객체를 인스턴스화하기 위해 생성자를 사용합니다.
        bookRepository.save(book);

        return "책 등록에 성공하였습니다.";
    }

    public List<BookResponse> getBookList() {
        List<Book> bookList = bookRepository.findAll();
        return bookList.stream()
                .map(book -> new BookResponse(book.getBookCode(), book.getName(), book.getQuantity()))
                .collect(Collectors.toList());
    }
}

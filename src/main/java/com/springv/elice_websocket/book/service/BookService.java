package com.springv.elice_websocket.book.service;


import com.springv.elice_websocket.book.domain.Book;
import com.springv.elice_websocket.book.model.BookRequest;
import com.springv.elice_websocket.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public String saveBook(BookRequest bookRequest) {

        Book book = new Book(bookRequest.getBookName(), bookRequest.getQuantity()); //Book 클래스로터 새로운 객체를 인스턴스화하기 위해 생성자를 사용합니다.
        bookRepository.save(book);

        return "책 등록에 성공하였습니다.";
    }
}

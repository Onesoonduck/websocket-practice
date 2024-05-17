package com.springv.elice_websocket.repository.book;

import com.springv.elice_websocket.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByBookCode(String bookCode);
}

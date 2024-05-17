package com.springv.elice_websocket.book.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookCode;
    private String name;
    private long quantity;

    public Book(String bookName, long quantity) {
        this.bookCode = UUID.randomUUID().toString();
        this.name = bookName;
        this.quantity = quantity;
    }
}

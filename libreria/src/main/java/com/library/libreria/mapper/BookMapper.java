package com.library.libreria.mapper;

import com.library.libreria.dto.BookDTO;
import com.library.libreria.entity.Book;

public class BookMapper {
    public static BookDTO toDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getStatus()
        );
    }

    public static Book toEntity(BookDTO dto){
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setStatus(dto.getStatus());
        return book;
    }
}

package com.library.libreria.mapper;

import com.library.libreria.dto.BookDTO;
import com.library.libreria.entity.BookEntity;

public class BookMapper {
    public static BookDTO toDTO(BookEntity book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getStatus()
        );
    }

    public static BookEntity toEntity(BookDTO dto){
        BookEntity book = new BookEntity();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setStatus(dto.getStatus());
        return book;
    }
}

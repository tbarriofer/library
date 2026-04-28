package com.library.libreria.service;

import com.library.libreria.dto.BookDTO;
import com.library.libreria.entity.BookEntity;
import com.library.libreria.exception.BookNotFoundException;
import com.library.libreria.mapper.BookMapper;
import com.library.libreria.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> listBooks() {
        return bookRepository.findAll().stream().map(BookMapper::toDTO).collect(Collectors.toList());
    }

    public BookDTO insertBook(BookDTO dto) {
        BookEntity book = BookMapper.toEntity(dto);
        BookEntity insertedBook = bookRepository.save(book);
        return BookMapper.toDTO(insertedBook);
    }

    public BookDTO updateBook(Long id, BookDTO dto) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(dto.getTitle());
                    book.setAuthor(dto.getAuthor());
                    book.setStatus(dto.getStatus());
                    BookEntity updated = bookRepository.save(book);
                    return BookMapper.toDTO(updated);
                })
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public String deleteBook(Long id){
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return "Libro eliminado correctamente";
        } else {
            return "Libro no encontrado";
        }
    }
}

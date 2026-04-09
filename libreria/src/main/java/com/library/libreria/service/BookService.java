package com.library.libreria.service;

import com.library.libreria.dto.BookDTO;
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
}

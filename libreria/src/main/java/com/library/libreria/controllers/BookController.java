package com.library.libreria.controllers;

import com.library.libreria.dto.BookDTO;
import com.library.libreria.entity.Book;
import com.library.libreria.mapper.BookMapper;
import com.library.libreria.repository.BookRepository;
import com.library.libreria.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/libros")
    public List<BookDTO> consult(){
        return bookService.listBooks();
    }

}

package com.library.libreria.controllers;

import com.library.libreria.dto.BookDTO;
import com.library.libreria.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/libros")
    public List<BookDTO> consult() {
        return bookService.listBooks();
    }

    @PostMapping("/libros")
    public BookDTO insertBook(@RequestBody BookDTO dto) {
        return bookService.insertBook(dto);
    }

    @PutMapping("/libros/{id}")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody BookDTO dto) {
        return bookService.updateBook(id, dto);
    }
}

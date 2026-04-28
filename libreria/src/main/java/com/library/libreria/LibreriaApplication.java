package com.library.libreria;

import com.library.libreria.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.library.libreria.repository.BookRepository;

import java.util.List;

@SpringBootApplication
public class LibreriaApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(LibreriaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Aplicación iniciada correctamente.");
        List<BookEntity> books = bookRepository.findAll();
        books.forEach(System.out::println);
    }
}

package com.library.libreria.repository;

import com.library.libreria.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <BookEntity, Long>{
}

package com.example.demo.repository;
import com.example.demo.model.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Books, Long> {
}

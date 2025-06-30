package com.example.demo.model.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 200)
    @NotNull
    private String title;


    @NotNull
    private String author;

    private Integer publishedYear;

    @Column(unique = true)
    private String isbn;

    private BigDecimal price;


    private Boolean available = true;
}

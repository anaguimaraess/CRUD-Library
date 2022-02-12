package br.com.basicsystem.library.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Book {

    @Id
    private String nameBook;

    private BigDecimal numberPages;
    private String author;
    private BigDecimal price;
}

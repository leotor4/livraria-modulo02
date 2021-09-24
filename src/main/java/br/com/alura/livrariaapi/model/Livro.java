package br.com.alura.livrariaapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    private String title;
    private LocalDate publicationDate;
    private BigDecimal price;
    private int pages;
    private List<Autor> autores;
}

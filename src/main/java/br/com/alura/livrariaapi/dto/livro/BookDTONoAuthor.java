package br.com.alura.livrariaapi.dto.livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTONoAuthor {
    private String title;
    private BigDecimal price;
}
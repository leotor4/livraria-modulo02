package br.com.alura.livrariaapi.dto.livro;

import br.com.alura.livrariaapi.model.Autor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroFormDTO {
    @NotNull
    @Size(min=10)
    private String title;

    @PastOrPresent
    @NotNull
    private LocalDate publicationDate;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Size(min=1)
    private List<String> autores;

    @NotNull
    @Min(value=100)
    private int pages;
}
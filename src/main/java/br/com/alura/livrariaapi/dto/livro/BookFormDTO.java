package br.com.alura.livrariaapi.dto.livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookFormDTO {
    @NotNull
    @Size(min=10)
    private String title;

    @PastOrPresent
    @NotNull
    private LocalDate publicationDate;

    @NotNull
    @Positive
    private BigDecimal price;

    @Size(min=1)
    private List<String> authors;

    @NotNull
    @Min(value=100)
    private int pages;
}
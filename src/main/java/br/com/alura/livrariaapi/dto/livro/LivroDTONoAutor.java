package br.com.alura.livrariaapi.dto.livro;

import br.com.alura.livrariaapi.dto.autor.AutorDTO;
import br.com.alura.livrariaapi.model.Autor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTONoAutor {
    private String title;
    private BigDecimal price;
}
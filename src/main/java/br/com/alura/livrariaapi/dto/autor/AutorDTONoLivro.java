package br.com.alura.livrariaapi.dto.autor;

import br.com.alura.livrariaapi.dto.livro.LivroDTONoAutor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTONoLivro {
    private String name;
    private String email;
    private LocalDate birthday;
    private String curriculum;
}

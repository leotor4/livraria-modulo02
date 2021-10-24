package br.com.alura.livrariaapi.dto.autor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTONoBooks {
    private String name;
    private String email;
    private LocalDate birthday;
    private String curriculum;
}

package br.com.alura.livrariaapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    private String name;
    private String email;
    private LocalDate birthday;
    private String curriculum;
}

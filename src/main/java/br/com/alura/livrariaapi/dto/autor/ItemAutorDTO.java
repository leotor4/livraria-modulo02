package br.com.alura.livrariaapi.dto.autor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemAutorDTO {
    private String name;

    private Integer quantidadeLivro;

    private Double percentual;


}

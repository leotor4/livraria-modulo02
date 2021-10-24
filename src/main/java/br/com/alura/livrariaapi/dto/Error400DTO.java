package br.com.alura.livrariaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Error400DTO {

    private String attribute;
    private String message;
}

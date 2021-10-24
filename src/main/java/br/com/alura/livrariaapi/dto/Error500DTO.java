package br.com.alura.livrariaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Error500DTO {
    private LocalDateTime timestamp;
    private String error;
    private String message;
    private String path;
}

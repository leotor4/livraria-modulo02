package br.com.alura.livrariaapi.dto.autor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorFormDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Past
    private LocalDate birthday;

    private String curriculum;
}

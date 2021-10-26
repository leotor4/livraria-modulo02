package br.com.alura.livrariaapi.service.author;

import br.com.alura.livrariaapi.dto.autor.AuthorDTO;
import br.com.alura.livrariaapi.dto.autor.AuthorFormDTO;
import br.com.alura.livrariaapi.repository.AuthorRepositoryTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    AuthorRepositoryTest authorRepository;

    @InjectMocks
    AuthorService authorService;

    @Test
    void shouldCreateAuthor(){
        LocalDate currentDate = LocalDate.now();
        AuthorFormDTO dto = new AuthorFormDTO(
                "Autor Teste",
                "email@emailteste.com",
                currentDate,
                ""
        );

        AuthorDTO author = authorService.insert(dto);

//        Mockito.verify(authorRepository.save(Mockito.any()));

        assertEquals(author.getName(), dto.getName());
        assertEquals(author.getEmail(), dto.getEmail());
        assertEquals(author.getCurriculum(), dto.getCurriculum());
        assertEquals(author.getBirthday(), dto.getBirthday());
    }

}

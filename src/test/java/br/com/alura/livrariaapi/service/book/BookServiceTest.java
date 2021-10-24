package br.com.alura.livrariaapi.service.book;

import br.com.alura.livrariaapi.dto.autor.AuthorDTO;
import br.com.alura.livrariaapi.dto.autor.AuthorFormDTO;
import br.com.alura.livrariaapi.dto.livro.BookDTO;
import br.com.alura.livrariaapi.dto.livro.BookFormDTO;
import br.com.alura.livrariaapi.model.Author;
import br.com.alura.livrariaapi.repository.AuthorRepository;
import br.com.alura.livrariaapi.repository.BookRepository;
import br.com.alura.livrariaapi.service.author.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @Mock
    AuthorService authorService;

    @Mock
    AuthorRepository authorRepository;

    @InjectMocks
    BookService bookService;

    @Test
    void shouldCreateBook(){
        List<Author> authors = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        Author author = new Author(
                1L,
                "Autor Teste",
                "email@emailteste.com",
                currentDate,
                "",
                null
        );

        authors.add(author);

        List<String> newAuthor = new ArrayList<>();
        newAuthor.add(author.getName());

        BookFormDTO dto = new BookFormDTO(
                "Título teste",
                currentDate,
                new BigDecimal(100.00),
                newAuthor,
                200
        );

        Mockito.when(authorService.getAuthorByName(authors.get(0).getName()))
                .thenReturn(authors);

        BookDTO book = bookService.insert(dto);

//        Mockito.verify(authorService.getAuthorByName(Mockito.any()));
        Mockito.verify(bookRepository.save(Mockito.any()));

        assertEquals(book.getTitle(), dto.getTitle());
        assertEquals(book.getPrice(), dto.getPrice());
        assertEquals(book.getAuthors().get(0).getName(), dto.getAuthors().get(0));
        assertEquals(book.getTitle(), dto.getTitle());


    }
}

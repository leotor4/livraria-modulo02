package br.com.alura.livrariaapi.repository;

import br.com.alura.livrariaapi.model.Author;
import br.com.alura.livrariaapi.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    void shouldReturnBookQuantityByAuthorReport(){
        Author newAuthor = new Author();
        newAuthor.setName("Pedro");
        newAuthor.setEmail("pedro@gmail.com");
        newAuthor.setBirthday(LocalDate.now());
        em.persist(newAuthor);

        Author newAuthor2 = new Author();
        newAuthor2.setName("JK");
        newAuthor2.setEmail("jk@gmail.com");
        newAuthor2.setBirthday(LocalDate.now());
        em.persist(newAuthor2);

        Book newBook = new Book();
        newBook.setPages(250);
        newBook.setPrice(new BigDecimal(900.0));
        newBook.setTitle("A ida dos que não foram.");
        newBook.setAuthors(Arrays.asList(newAuthor));
        newBook.setPublicationDate(LocalDate.now());
        em.persist(newBook);

        Book newBook2 = new Book();
        newBook2.setPages(2500);
        newBook2.setPrice(new BigDecimal(900.0));
        newBook2.setTitle("Taleb");
        newBook2.setAuthors(Arrays.asList(newAuthor2));
        newBook2.setPublicationDate(LocalDate.now());
        em.persist(newBook2);


        List<?> report = this.authorRepository.reportBookQuantityByAuhor();

        Assertions.assertThat(report)
                .hasSize(2);

    }

    @Test
    void shouldReturnAllAuthors(){
        LocalDate currentDate = LocalDate.now();

        Author newAuthor = new Author();
        newAuthor.setName("Pedro");
        newAuthor.setEmail("pedro@gmail.com");
        newAuthor.setBirthday(currentDate);
        em.persist(newAuthor);

        Author newAuthor2 = new Author();
        newAuthor2.setName("JK");
        newAuthor2.setEmail("jk@gmail.com");
        newAuthor2.setBirthday(currentDate);
        em.persist(newAuthor2);

        List<Author> authors =  authorRepository.findAll();

        Assertions.assertThat(authors)
                .hasSize(2)
                .extracting(Author::getName, Author::getEmail, Author::getBirthday, Author::getCurriculum, Author::getBooks)
                .containsExactlyInAnyOrder(
                        Assertions.tuple("Pedro", "pedro@gmail.com", currentDate, null, null),
                        Assertions.tuple("JK", "jk@gmail.com", currentDate, null, null)
                );

    }
}

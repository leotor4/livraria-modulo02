package br.com.alura.livrariaapi.repository;

import br.com.alura.livrariaapi.model.Author;
import br.com.alura.livrariaapi.model.Book;
import org.apache.tomcat.jni.Local;
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

    private Author createAuthor(String name, String email, LocalDate birthday){
        Author newAuthor = new Author();
        newAuthor.setName(name);
        newAuthor.setEmail(email);
        newAuthor.setBirthday(birthday);

        return newAuthor;
    }

    private Book createBook(String title, BigDecimal price, Integer pages, List<Author> authors,
                            LocalDate publicationDate){
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setPrice(price);
        newBook.setPages(pages);
        newBook.setAuthors(authors);
        newBook.setPublicationDate(publicationDate);

        return newBook;
    }

    @Test
    void shouldReturnBookQuantityByAuthorReport(){
        Author newAuthor = this.createAuthor("Pedro", "pedro@gmail.com", LocalDate.now());
        em.persist(newAuthor);

        Author newAuthor2 = this.createAuthor("JK", "jk@gmail.com", LocalDate.now());
        em.persist(newAuthor2);

        Book newBook = this.createBook("A ida dos que não foram.", new BigDecimal(900.0),
                250,Arrays.asList(newAuthor), LocalDate.now());
        em.persist(newBook);

        Book newBook2 = this.createBook("Taleb", new BigDecimal(900.0),
                2500,Arrays.asList(newAuthor2), LocalDate.now());
        em.persist(newBook2);


        List<?> report = this.authorRepository.reportBookQuantityByAuhor();

        Assertions.assertThat(report)
                .hasSize(2);

    }

    @Test
    void shouldReturnAllAuthors(){
        LocalDate currentDate = LocalDate.now();

        Author newAuthor = this.createAuthor("Pedro", "pedro@gmail.com", LocalDate.now());
        em.persist(newAuthor);

        Author newAuthor2 = this.createAuthor("JK", "jk@gmail.com", LocalDate.now());
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

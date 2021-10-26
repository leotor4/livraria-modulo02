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
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    void shouldReturnAllBooks(){
        LocalDate currentDate = LocalDate.now();

        Book newBook = new Book();
        newBook.setTitle("Livro1");
        newBook.setPrice(new BigDecimal(200.0));
        newBook.setPages(290);
        newBook.setPublicationDate(currentDate);
        em.persist(newBook);

        Book newBook2 = new Book();
        newBook2.setTitle("Livro2");
        newBook2.setPrice(new BigDecimal(200.0));
        newBook2.setPages(290);
        newBook2.setPublicationDate(currentDate);
        em.persist(newBook2);

        List<Book> books =  bookRepository.findAll();

        Assertions.assertThat(books)
                .hasSize(2)
                .extracting(Book::getTitle, Book::getPrice, Book::getPages, Book::getPublicationDate, Book::getAuthors)
                .containsExactlyInAnyOrder(
                        Assertions.tuple("Livro1", new BigDecimal(200.0), 290, currentDate, null),
                        Assertions.tuple("Livro2", new BigDecimal(200.0), 290, currentDate, null)
                );

    }
}

package br.com.alura.livrariaapi.repository;

import br.com.alura.livrariaapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

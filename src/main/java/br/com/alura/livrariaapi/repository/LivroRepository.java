package br.com.alura.livrariaapi.repository;

import br.com.alura.livrariaapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}

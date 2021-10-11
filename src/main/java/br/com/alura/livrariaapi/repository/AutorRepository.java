package br.com.alura.livrariaapi.repository;

import br.com.alura.livrariaapi.dto.autor.ItemAutorDTO;
import br.com.alura.livrariaapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByName(String autorName);

//    @Query("select new br.com.alura.livrariaapi.dto.autor.ItemAutorDTO( " +
//            "a.name, " +
//            "count(autor_has_livro.autor_id), " +
//            "count(autor_has_livro.autor_id) * 1.0 / (select count(distinct livro_id) * 1.0 from autor_has_livro)) " +
//            "from Autor a inner join autor_has_livro on a.id = autor_has_livro.autor_id group by a.name")
    @Query(value = "select autores.name, count(autor_has_livro.autor_id), count(autor_has_livro.autor_id) / (select count(distinct livro_id) from autor_has_livro) from autores inner join autor_has_livro on autores.id = autor_has_livro.autor_id group by autores.name", nativeQuery = true)
    List<?> relatorioQuantidadeLivrosPorAutor();

}

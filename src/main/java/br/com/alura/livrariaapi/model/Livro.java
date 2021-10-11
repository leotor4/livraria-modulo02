package br.com.alura.livrariaapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")
@ToString(exclude = "autores")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "publication_date")
    private LocalDate publicationDate;
    private BigDecimal price;
    private int pages;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="autor_has_livro",
            joinColumns = {@JoinColumn(name = "livro_id")} ,
            inverseJoinColumns = {@JoinColumn(name = "autor_id")}
    )
    private List<Autor> autores;
}

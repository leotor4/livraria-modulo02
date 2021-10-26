package br.com.alura.livrariaapi.controller;

import br.com.alura.livrariaapi.dto.autor.AuthorDTO;
import br.com.alura.livrariaapi.dto.livro.BookDTO;
import br.com.alura.livrariaapi.dto.livro.BookFormDTO;
import br.com.alura.livrariaapi.dto.livro.UpdateBookFormDTO;
import br.com.alura.livrariaapi.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/livros")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Page<BookDTO> get(@PageableDefault(size  =5) Pageable paginacao){

        return bookService.search(paginacao);
    }

    @PostMapping
    public void insert(@RequestBody @Valid BookFormDTO bookFormDTO){
        bookService.insert(bookFormDTO);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateBookFormDTO bookFormDTO) {
        bookService.update(bookFormDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Valid Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable @NotNull Long id)
    {
        return bookService.searchById(id);
    }
}

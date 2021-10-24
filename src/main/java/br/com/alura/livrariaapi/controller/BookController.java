package br.com.alura.livrariaapi.controller;

import br.com.alura.livrariaapi.dto.livro.BookDTO;
import br.com.alura.livrariaapi.dto.livro.BookFormDTO;
import br.com.alura.livrariaapi.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Page<BookDTO> lista(@PageableDefault(size  =5) Pageable paginacao){

        return bookService.search(paginacao);
    }

    @PostMapping
    public void cadastra(@RequestBody @Valid BookFormDTO bookFormDTO){
        bookService.insert(bookFormDTO);
    }
}

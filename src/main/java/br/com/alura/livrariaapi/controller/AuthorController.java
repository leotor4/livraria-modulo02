package br.com.alura.livrariaapi.controller;

import br.com.alura.livrariaapi.dto.autor.AuthorDTO;
import br.com.alura.livrariaapi.dto.autor.AuthorFormDTO;
import br.com.alura.livrariaapi.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public Page<AuthorDTO> getAutores(@PageableDefault(size = 5) Pageable paginacao)
    {
        return authorService.search(paginacao);
    }

    @PostMapping
    public void cadastraAutor(@RequestBody @Valid AuthorFormDTO authorFormDTO){
        authorService.insert(authorFormDTO);
    }



}

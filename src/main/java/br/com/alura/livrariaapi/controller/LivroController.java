package br.com.alura.livrariaapi.controller;

import br.com.alura.livrariaapi.dto.livro.LivroDTO;
import br.com.alura.livrariaapi.dto.livro.LivroFormDTO;
import br.com.alura.livrariaapi.service.livro.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<LivroDTO> lista(){
        return livroService.lista();
    }

    @PostMapping
    public void cadastra(@RequestBody @Valid LivroFormDTO livroFormDTO){
        livroService.cadastra(livroFormDTO);
    }
}
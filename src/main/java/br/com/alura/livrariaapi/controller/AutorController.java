package br.com.alura.livrariaapi.controller;

import br.com.alura.livrariaapi.dto.autor.AutorDTO;
import br.com.alura.livrariaapi.dto.autor.AutorFormDTO;
import br.com.alura.livrariaapi.model.Autor;
import br.com.alura.livrariaapi.service.autor.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorService autorService;

    @GetMapping
    public List<AutorDTO> getAutores(){
        return autorService.lista();
    }

    @PostMapping
    public void cadastraAutor(@RequestBody @Valid AutorFormDTO autorFormDTO){
        autorService.cadastra(autorFormDTO);
    }



}

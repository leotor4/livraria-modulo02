package br.com.alura.livrariaapi.controller;

import br.com.alura.livrariaapi.dto.autor.ItemAutorDTO;
import br.com.alura.livrariaapi.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {

    @Autowired
    RelatorioService relatorioService;

    @GetMapping("/autor")
    public List<?> relatorioQuantidadeLivrosPorAutor(){

        List<?> resultado = relatorioService.relatorioQuantidadeLivrosPorAutor();
        System.out.println(resultado.toString());
        return resultado;
    }
}

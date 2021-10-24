package br.com.alura.livrariaapi.controller;

import br.com.alura.livrariaapi.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class ReportsController {

    @Autowired
    ReportService reportService;

    @GetMapping("/autor")
    public List<?> relatorioQuantidadeLivrosPorAutor(){

        List<?> resultado = reportService.reportBookQuantityByAuthor();
        System.out.println(resultado.toString());
        return resultado;
    }
}

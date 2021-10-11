package br.com.alura.livrariaapi.service;

import br.com.alura.livrariaapi.dto.autor.ItemAutorDTO;
import br.com.alura.livrariaapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private AutorRepository autorRepository;

    public List<?> relatorioQuantidadeLivrosPorAutor() {
        return autorRepository.relatorioQuantidadeLivrosPorAutor();
    }
}

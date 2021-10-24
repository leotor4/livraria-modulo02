package br.com.alura.livrariaapi.service;

import br.com.alura.livrariaapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Object> reportBookQuantityByAuthor() {
        List<Object> queryResult = authorRepository.reportBookQuantityByAuhor();

        List<Object> jsonResponse = new ArrayList<>();

        jsonResponse.add("autor: " + queryResult.get(0));
        jsonResponse.add("quantidadeLivros: " + queryResult.get(1));
        return jsonResponse;
    }
}

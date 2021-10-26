package br.com.alura.livrariaapi.service;

import br.com.alura.livrariaapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Object> reportBookQuantityByAuthor() {
        return authorRepository.reportBookQuantityByAuhor();

    }
}

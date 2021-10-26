package br.com.alura.livrariaapi.service;

import br.com.alura.livrariaapi.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {

    @Mock
    AuthorRepository authorRepository;

    @InjectMocks
    ReportService reportService;

    @Test
    void shouldBuildValidBookQuantityByAuthorFormatReport(){
        List<Object> queryResultFormat = new ArrayList<>();
        queryResultFormat.add("Autor teste");
        queryResultFormat.add(10);

        Mockito.when(authorRepository.reportBookQuantityByAuhor()).thenReturn(queryResultFormat);

        List<?> response = reportService.reportBookQuantityByAuthor();

        assertEquals(response.size(), 2);
        assertEquals(response.get(0), "Autor teste");
        assertEquals(response.get(1), 10);
    }
}

package br.com.alura.livrariaapi.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldNotInsertIncompleteBook() throws Exception {
        String json = "{}";

        mockMvc.perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldInsertBook() throws Exception {
        String json = "{\"name\": \"Jojoca\", \"birthday\": \"1995-08-21\", \"email\": \"aloha@gol.com\"}";

        mockMvc.perform(post("/autores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());


        String jsonBook = "{ \"title\": \"Teste Livro 132323\",  \"publicationDate\": \"2021-08-12\"" +
                ", \"price\": 17.80, \"pages\": 110, \"authors\": [\"Jojoca\"]}";

        mockMvc.perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBook))
                .andExpect(status().isOk());

    }
}

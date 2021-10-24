package br.com.alura.livrariaapi.service.author;

import br.com.alura.livrariaapi.dto.autor.AuthorDTO;
import br.com.alura.livrariaapi.dto.autor.AuthorFormDTO;
import br.com.alura.livrariaapi.model.Author;
import br.com.alura.livrariaapi.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public Page<AuthorDTO> search(Pageable paginacao){
        Page<Author> autores = authorRepository.findAll(paginacao);

        return autores
                .map(u -> modelMapper.map(u, AuthorDTO.class));
    }

    @Transactional
    public AuthorDTO insert(AuthorFormDTO authorFormDTO){
        try{
            Author author = modelMapper.map(authorFormDTO, Author.class);
            authorRepository.save(author);

            return modelMapper.map(author, AuthorDTO.class);
        }catch(EntityNotFoundException e){
            throw new IllegalArgumentException("Autor inexistente.");
        }

    }

    public List<Author> getAuthorByName(String autorName){
        return authorRepository.findByName(autorName);
    }
}

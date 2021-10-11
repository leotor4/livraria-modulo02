package br.com.alura.livrariaapi.service.autor;

import br.com.alura.livrariaapi.dto.autor.AutorDTO;
import br.com.alura.livrariaapi.dto.autor.AutorFormDTO;
import br.com.alura.livrariaapi.model.Autor;
import br.com.alura.livrariaapi.repository.AutorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public Page<AutorDTO> lista(Pageable paginacao){
        Page<Autor> autores = autorRepository.findAll(paginacao);

        return autores
                .map(u -> modelMapper.map(u, AutorDTO.class));
    }

    @Transactional
    public void cadastra(AutorFormDTO autorFormDTO){
        Autor autor = modelMapper.map(autorFormDTO, Autor.class);
        autorRepository.save(autor);
    }

    public List<Autor> getAutorByName(String autorName){
        return autorRepository.findByName(autorName);
    }
}

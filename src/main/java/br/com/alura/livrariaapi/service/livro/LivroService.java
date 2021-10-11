package br.com.alura.livrariaapi.service.livro;

import br.com.alura.livrariaapi.dto.livro.LivroDTO;
import br.com.alura.livrariaapi.dto.livro.LivroFormDTO;
import br.com.alura.livrariaapi.model.Autor;
import br.com.alura.livrariaapi.model.Livro;
import br.com.alura.livrariaapi.repository.AutorRepository;
import br.com.alura.livrariaapi.repository.LivroRepository;
import br.com.alura.livrariaapi.service.autor.AutorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorService autorService;
    @Autowired
    private AutorRepository autorRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public Page<LivroDTO> lista(Pageable paginacao){
        Page<Livro> livros = livroRepository.findAll(paginacao);
        return livros
                .map(l -> modelMapper.map(l, LivroDTO.class));
    }

    @Transactional
    public void cadastra(LivroFormDTO livroFormDTO){
        List<Autor> autores = new ArrayList<>();
        autores = livroFormDTO.getAutores()
                        .stream()
                        .map(a -> autorService.getAutorByName(a).get(0))
                        .collect(Collectors.toList());

        Livro livro = modelMapper.map(livroFormDTO, Livro.class);
        livro.getAutores().clear();
        livro.getAutores().addAll(autores);
        Livro teste = livroRepository.save(livro);
    }


}

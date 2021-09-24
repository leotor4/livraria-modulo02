package br.com.alura.livrariaapi.service.livro;

import br.com.alura.livrariaapi.dto.livro.LivroDTO;
import br.com.alura.livrariaapi.dto.livro.LivroFormDTO;
import br.com.alura.livrariaapi.model.Autor;
import br.com.alura.livrariaapi.model.Livro;
import br.com.alura.livrariaapi.service.autor.AutorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    private List<Livro> livros = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public List<LivroDTO> lista(){
        return livros
                .stream()
                .map(l -> modelMapper.map(l, LivroDTO.class))
                .collect(Collectors.toList());
    }

    public void cadastra(LivroFormDTO livroFormDTO){
        AutorService autorService = new AutorService();
        Livro livro = modelMapper.map(livroFormDTO, Livro.class);

        List<Autor> autores = livroFormDTO.getAutores()
                                .stream()
                                .map(a -> autorService.getAutorByName(a))
                                .collect(Collectors.toList());

        livro.setAutores(autores);
        livros.add(livro);
    }


}

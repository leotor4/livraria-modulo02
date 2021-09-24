package br.com.alura.livrariaapi.service.autor;

import br.com.alura.livrariaapi.dto.autor.AutorDTO;
import br.com.alura.livrariaapi.dto.autor.AutorFormDTO;
import br.com.alura.livrariaapi.model.Autor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {
    private static List<Autor> autores = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public List<AutorDTO> lista(){
        return autores
                .stream()
                .map(u -> modelMapper.map(u, AutorDTO.class))
                .collect(Collectors.toList());
    }

    public void cadastra(AutorFormDTO autorFormDTO){
        Autor autor = modelMapper.map(autorFormDTO, Autor.class);
        autores.add(autor);
    }

    public Autor getAutorByName(String autorName){
        return autores
                .stream()
                .filter(a -> a.getName().compareToIgnoreCase(autorName) == 0)
                .collect(Collectors.toList()).get(0);
    }
}

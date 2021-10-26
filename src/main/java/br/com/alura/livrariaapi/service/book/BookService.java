package br.com.alura.livrariaapi.service.book;

import br.com.alura.livrariaapi.dto.livro.BookDTO;
import br.com.alura.livrariaapi.dto.livro.BookFormDTO;
import br.com.alura.livrariaapi.dto.livro.UpdateBookFormDTO;
import br.com.alura.livrariaapi.model.Author;
import br.com.alura.livrariaapi.model.Book;
import br.com.alura.livrariaapi.repository.BookRepository;
import br.com.alura.livrariaapi.service.author.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    private ModelMapper modelMapper = new ModelMapper();

    public Page<BookDTO> search(Pageable paginacao){
        Page<Book> livros = bookRepository.findAll(paginacao);
        return livros
                .map(l -> modelMapper.map(l, BookDTO.class));
    }

    @Transactional
    public BookDTO insert(BookFormDTO bookFormDTO){
        try{
            List<Author> autores = new ArrayList<>();
            autores = bookFormDTO.getAuthors()
                    .stream()
                    .map(a -> authorService.getAuthorByName(a).get(0))
                    .collect(Collectors.toList());

            Book book = modelMapper.map(bookFormDTO, Book.class);
            if(book.getAuthors().size() > 0)
                book.getAuthors().clear();
            book.getAuthors().addAll(autores);
            bookRepository.save(book);
            return modelMapper.map(book, BookDTO.class);
        }catch(EntityNotFoundException e){
            throw new IllegalArgumentException("Livro inexistente.");
        }



    }

    @Transactional
    public void update(UpdateBookFormDTO bookFormDTO) {
        Book book = bookRepository.getById(bookFormDTO.getId());
        book.setPublicationDate(bookFormDTO.getPublicationDate());
        List<Author>  authors = bookFormDTO.getAuthors()
                .stream()
                .map(a -> authorService.getAuthorByName(a).get(0))
                .collect(Collectors.toList());
        book.setAuthors(authors);
        book.setPages(bookFormDTO.getPages());
        book.setTitle(bookFormDTO.getTitle());
        bookRepository.saveAndFlush(book);
    }

    @Transactional
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public BookDTO searchById(Long id) {
        Book book = bookRepository.getById(id);

        return modelMapper.map(book, BookDTO.class);
    }
}

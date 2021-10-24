package br.com.alura.livrariaapi.infra;

import br.com.alura.livrariaapi.dto.Error400DTO;
import br.com.alura.livrariaapi.dto.Error404DTO;
import br.com.alura.livrariaapi.dto.Error500DTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus( code = HttpStatus.BAD_REQUEST)
    public List<Error400DTO> handler400(MethodArgumentNotValidException e){
        return e.getFieldErrors()
                .stream()
                .map(error -> new Error400DTO(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Error500DTO handler500(Exception e, HttpServletRequest req){
        return new Error500DTO(
                LocalDateTime.now(),
                e.getClass().toString(),
                e.getMessage(),
                req.getRequestURI());
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Error404DTO handler400(NoHandlerFoundException e){
        return new Error404DTO("OPS! Recurso não encontrado :/");
    }
}
